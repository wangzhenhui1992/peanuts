package com.soaringroad.data.es;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import com.soaringroad.common.PeanutsException;
import com.soaringroad.common.entity.ElasticSearchEntity;
import com.soaringroad.common.query.Query;
import com.soaringroad.common.repository.ElasticSearchRepository;
import com.soaringroad.common.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Abstract repository for Elasticsearch
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/20
 */
@Slf4j
@ConditionalOnBean(ElasticsearchClient.class)
@Component
public abstract class AbstractEsRepository<T extends ElasticSearchEntity, E extends Serializable>
        implements ElasticSearchRepository<T, E> {

    @Autowired
    private ElasticsearchClient client;

    @Override
    public <S extends T> S index(S entity) {
        String source = CommonUtils.parseToJsonString(entity);
        if (source == null) {
            return null;
        }
        IndexRequest request = new IndexRequest().index(entity.entityName()).type(define().getType())
                .id(entity.getId().toString()).source(source, XContentType.JSON);
        IndexResponse response = null;
        try {
            response = this.client.index(request);
        } catch (IOException e) {
            log.error("Can not index the entity. json=" + source, e);
            throw new PeanutsException("Can not index the entity. json=" + source, e);
        }
        DocWriteResponse.Result result = response.getResult();
        if (!DocWriteResponse.Result.CREATED.equals(result) && !DocWriteResponse.Result.UPDATED.equals(result)) {
            log.error("Elasticsearch failed to index this entity. json=" + source);
            throw new PeanutsException("Can not index the entity. json=" + source);
        }
        return entity;
    }

    @Override
    public List<T> search(Query entity) {
        SearchSourceBuilder sourceBuilder = new EsQueryBuilder(entity).build();
        SearchRequest searchRequest = new SearchRequest();
        ElasticsearchIndexDefine indexDefine = define();
        searchRequest.indices(indexDefine.getIndexName()).types(indexDefine.getType()).source(sourceBuilder);
        SearchResponse response = null;
        try {
            response = this.client.search(searchRequest);
        } catch (IOException e) {
            log.error("无法完成Search请求", e);
            return null;
        }
        List<T> result = buildSearchResult(response);
        return result;
    }

    @Override
    public void delete(E id) {
        ElasticsearchIndexDefine indexDefine = define();
        DeleteRequest deleteRequest = new DeleteRequest().index(indexDefine.getIndexName()).type(indexDefine.getType()).id(id.toString());
        try {
            this.client.delete(deleteRequest);
        } catch (IOException e) {
            log.error("无法完成Delete请求", e);
        }
    }

    @PostConstruct
    public void init() throws IOException {
        ElasticsearchIndexDefine esIndexDefination = define();
        String indexName = esIndexDefination.getIndexName();
        log.info("Initializing es index repository : " + indexName);
        boolean isExist = this.client.indexExists(indexName);
        if (isExist) {
            return;
        }
        log.info("Creating es index : " + indexName);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest().index(indexName)
                .settings(Settings.builder().put("index.number_of_shards", esIndexDefination.getShards())
                        .put("index.number_of_replicas", esIndexDefination.getReplicas()));
        this.client.createIndex(createIndexRequest);
        log.info("Finishing creating es index : " + indexName);
        log.info("Finishing initializing es index repository : " + indexName);
    }

    private List<T> buildSearchResult(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        if (searchHits == null || searchHits.totalHits == 0) {
            return null;
        }
        SearchHit[] hits = searchHits.getHits();
        if (CommonUtils.isArrayEmpty(hits)) {
            return null;
        }
        final Class<T> entityClass = getEntityClass();
        List<T> result = Arrays.asList(hits).stream()
                .map(hit -> CommonUtils.parseToObject(hit.getSourceAsString(), entityClass))
                .collect(Collectors.toList());
        return result;
    }

    protected abstract ElasticsearchIndexDefine define();

    @SuppressWarnings("unchecked")
    private final Class<T> getEntityClass() {
        Class<T> entityClass = (Class<T>) ParameterizedType.class.cast(this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        return entityClass;
    }
}
