package com.soaringroad.data.es;

import lombok.Data;

/**
 * <pre>
 * ElasticSearch Node 
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class EsNode {
    private String host;
    private Integer port;
    private String scheme;
}
