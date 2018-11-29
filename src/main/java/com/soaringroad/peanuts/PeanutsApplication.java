package com.soaringroad.peanuts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.soaringroad.data.rdb.RdbRepositoryFactoryBean;

/**
 * Peanuts Application
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
@SpringBootApplication(scanBasePackages="com.soaringroad")
@PropertySource("application.yaml")
@EnableJpaRepositories(repositoryFactoryBeanClass = RdbRepositoryFactoryBean.class)
public class PeanutsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeanutsApplication.class, args);
    }
}
