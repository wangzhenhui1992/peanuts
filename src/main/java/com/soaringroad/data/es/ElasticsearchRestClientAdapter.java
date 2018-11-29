package com.soaringroad.data.es;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * <pre>
 * Adpater for RestClient
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class ElasticsearchRestClientAdapter implements ElasticsearchClient {

    private RestHighLevelClient client;

    private ElasticsearchRestClientAdapter(RestHighLevelClient client) {
        this.client = client;
    }

    public static final ElasticsearchRestClientAdapter of(@NotNull RestHighLevelClient client) {
        return new ElasticsearchRestClientAdapter(client);
    }

    @Override
    public IndexResponse index(IndexRequest indexRequest) throws IOException {
        return this.client.index(indexRequest, RequestOptions.DEFAULT);
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) throws IOException {
        return this.client.search(searchRequest, RequestOptions.DEFAULT);
    }

    @Override
    public CreateIndexResponse createIndex(CreateIndexRequest createIndexRequest) throws IOException {
        return this.client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    @Override
    public boolean indexExists(String indexName) throws IOException {
        return this.client.indices().exists(new GetIndexRequest().indices(indexName), RequestOptions.DEFAULT);
    }

    @Override
    public DeleteResponse delete(DeleteRequest deleteRequest) throws IOException {
        return this.client.delete(deleteRequest, RequestOptions.DEFAULT);
    }
}
