package com.peanuts.community.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * <pre>
 * Connection Information of RDB
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@Data
@Component
@ConfigurationProperties("peanuts.data.rdb")
public class RdbConnectionInfo {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String druidViewUsername;
    private String druidViewPassowrd;
}
