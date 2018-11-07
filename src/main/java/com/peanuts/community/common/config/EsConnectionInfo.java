package com.peanuts.community.common.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * <pre>
 * Connection Information of ElasticSearch
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@Data
@Component
@ConfigurationProperties("peanuts.data.elasticsearch")
public class EsConnectionInfo {

    private String cluster;
    private List<EsNode> nodes;
    private EsSslInfo ssl;
}
