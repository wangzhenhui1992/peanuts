package com.soaringroad.data.es;

import lombok.Data;

/**
 * <pre>
 * Definition of Elasticsearch index
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class ElasticsearchIndexDefine {

    public static final String DEFAULT_TYPE = "all";
    public static final int DEFAULT_SHARDS = 3;
    public static final int REPLICAS = 1;

    private String indexName;
    private String type = DEFAULT_TYPE;
    private int shards = DEFAULT_SHARDS;
    private int replicas = REPLICAS;
}
