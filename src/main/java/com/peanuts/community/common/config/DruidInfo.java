package com.peanuts.community.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * <pre>
 * Druid settings
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@Data
@Component
@ConfigurationProperties("peanuts.data.druid")
public class DruidInfo {

    private boolean enable;
    private String username;
    private String password;
}
