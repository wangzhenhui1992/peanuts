package com.peanuts.community.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <pre>
 * Spring Configuration for RDB
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@Configuration
@AutoConfigureAfter(CoreConfig.class)
public class RdbConfig {

    @Autowired
    private RdbConnectionInfo rdbConnectionInfo;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(rdbConnectionInfo.getDriverClassName());
        dataSource.setUrl(rdbConnectionInfo.getUrl());
        dataSource.setUsername(rdbConnectionInfo.getUsername());
        dataSource.setPassword(rdbConnectionInfo.getPassword());
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(30000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(30000);
        dataSource.setValidationQuery("select '1' from dual");
        dataSource.setMaxOpenPreparedStatements(20);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }
    
}
