package com.peanuts.community.common.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.peanuts.community.common.util.CommonUtils;

/**
 * <pre>
 * Configuration of Druid
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@ConditionalOnProperty(name = "peanuts.data.druid.enabled", havingValue = "true")
@Configuration
public class DruidConfig {

    @Autowired
    private DruidInfo druidInfo;

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        // TODO Add more parameter to DruidInfo.class
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(
                new StatViewServlet(), "/druid/*");
        String allowed = Optional.ofNullable(druidInfo.getAllow()).map(allow -> {
            if (CommonUtils.isArrayEmpty(allow)) {
                return null;
            } else {
                return String.join(",", allow);
            }
        }).orElse("*");
        String denied = Optional.ofNullable(druidInfo.getDeny()).map(deny -> {
            if (CommonUtils.isArrayEmpty(deny)) {
                return null;
            } else {
                return String.join(",", deny);
            }
        }).orElse("");
        servletRegistrationBean.addInitParameter("allow", allowed);
        servletRegistrationBean.addInitParameter("deny", denied);
        servletRegistrationBean.addInitParameter("loginUsername", druidInfo.getUsername());
        servletRegistrationBean.addInitParameter("loginPassword", druidInfo.getPassword());
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        // TODO Add more parameter to DruidInfo.class
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(
                new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
