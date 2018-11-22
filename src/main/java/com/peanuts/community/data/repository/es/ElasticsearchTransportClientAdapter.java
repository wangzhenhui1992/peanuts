package com.peanuts.community.data.repository.es;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;

/**
 * <pre>
 * Adapt for TransportClient
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class ElasticsearchTransportClientAdapter implements ElasticsearchClient {

    private TransportClient client;

    private ElasticsearchTransportClientAdapter(TransportClient client) {
        this.client = client;
    }

    public static final ElasticsearchTransportClientAdapter of(@NotNull TransportClient client) {
        return new ElasticsearchTransportClientAdapter(client);
    }

    @Override
    public IndexResponse index(IndexRequest indexRequest) throws IOException {
        return this.client.index(indexRequest).actionGet(30000);
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) throws IOException {
        return this.client.search(searchRequest).actionGet(30000);
    }

    @Override
    public CreateIndexResponse createIndex(CreateIndexRequest createIndexRequest) throws IOException {
        return this.client.admin().indices().create(createIndexRequest).actionGet(30000);
    }

    @Override
    public boolean indexExists(String indexName) throws IOException {
        return this.client.admin().indices().exists(new IndicesExistsRequest().indices(indexName)).actionGet(30000)
                .isExists();
    }

    @Override
    public DeleteResponse delete(DeleteRequest deleteRequest) throws IOException {
        return this.client.delete(deleteRequest).actionGet(30000);
    }
}
