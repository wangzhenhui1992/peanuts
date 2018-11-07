package com.peanuts.community.common.config;

import lombok.Data;

@Data
public class EsNode {
    private String host;
    private Integer port;
    private String scheme;
}
