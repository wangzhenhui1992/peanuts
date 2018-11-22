package com.peanuts.community.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * <pre>
 * Connection Information of redis
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@Data
@Component
@ConfigurationProperties("peanuts.data.redis")
public class RedisConnectionInfo {

    private boolean enabled; 
    private String host;
    private Integer port;
    private Integer database;
    private Long timeout;
    private String password;
}
