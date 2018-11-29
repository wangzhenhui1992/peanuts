package com.soaringroad.data.es;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;

/**
 * <pre>
 * Interface which defines methods for Elasticsearch client
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public interface ElasticsearchClient {

    IndexResponse index(IndexRequest indexRequest) throws IOException;

    SearchResponse search(SearchRequest searchRequest) throws IOException;

    CreateIndexResponse createIndex(CreateIndexRequest createIndexRequest) throws IOException;

    boolean indexExists(String indexName) throws IOException;
    
    DeleteResponse delete(DeleteRequest deleteRequest) throws IOException;

    public static ElasticsearchClient adapt(TransportClient transportClient) {
        return ElasticsearchTransportClientAdapter.of(transportClient);
    }

    public static ElasticsearchClient adapt(RestHighLevelClient restClient) {
        return ElasticsearchRestClientAdapter.of(restClient);
    }
}
