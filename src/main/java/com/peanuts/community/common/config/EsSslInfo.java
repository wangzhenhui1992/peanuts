package com.peanuts.community.common.config;

import lombok.Data;

/**
 * <pre>
 * SSL information of Elasticsearch
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@Data
public class EsSslInfo {

    private boolean enable;
    private String username;
    private String password;
    private String token;
    private String keyStoreName;
    private String keyStoreFilePath;
    private String keyStorePassword;
}
