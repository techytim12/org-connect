package com.orgconnect.config;

import com.orgconnect.filter.OrgContextFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<OrgContextFilter> orgContextFilterFilterRegistrationBean(){
        FilterRegistrationBean<OrgContextFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new OrgContextFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
