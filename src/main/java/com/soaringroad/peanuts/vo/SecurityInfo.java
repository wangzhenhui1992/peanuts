package com.soaringroad.peanuts.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("peanuts.security")
public class SecurityInfo {

    private String securityKey;
    private long loginTimeout;
}
