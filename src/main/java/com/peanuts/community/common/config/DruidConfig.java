package com.peanuts.community.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * <pre>
 * Configuration of Druid
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@ConditionalOnProperty(name = "peanuts.data.druid.enable", havingValue = "true")
@Configuration
public class DruidConfig {

    @Autowired
    private DruidInfo druidInfo;

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        // TODO Add more parameter to DruidInfo.class
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(
                new StatViewServlet(), "/druid/*");
        // servletRegistrationBean.addInitParameter("allow","*");
        // servletRegistrationBean.addInitParameter("deny","");
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
