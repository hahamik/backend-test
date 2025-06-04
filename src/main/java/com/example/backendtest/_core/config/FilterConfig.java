package com.example.backendtest._core.config;

import com.example.backendtest._core.filter.LogFilter;
import com.example.backendtest._core.filter.UriFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<UriFilter> specialCharFilter() {
        FilterRegistrationBean<UriFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UriFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<LogFilter> loggingFilter() {
        FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
