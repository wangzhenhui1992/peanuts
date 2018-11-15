package com.peanuts.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Peanuts Application
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
@SpringBootApplication
@PropertySource("application.yaml")
@EnableJpaRepositories(basePackages="com.peanuts.community.data.repository.rdb")
@EnableElasticsearchRepositories(basePackages="com.peanuts.community.data.repository.es")
public class PeanutsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeanutsApplication.class, args);
    }
}
