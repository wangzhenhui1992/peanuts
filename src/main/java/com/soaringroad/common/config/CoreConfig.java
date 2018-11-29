package com.soaringroad.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.soaringroad.common.BrowseControlFilter;
/**
 * <pre>
 * Configuration of Core
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/12
 */
@Configuration
public class CoreConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("browse-control",
                new BrowseControlFilter());
        objectMapper.setFilterProvider(filterProvider);
        return objectMapper;
    }
}
