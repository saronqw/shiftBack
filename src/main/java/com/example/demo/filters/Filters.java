package com.example.demo.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Класс фильтров, необходимый для CORS фильтра
 */
@Configuration
public class Filters {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean() {
        FilterRegistrationBean<CorsFilter> corsFilter = new FilterRegistrationBean<>();
        corsFilter.setOrder(Ordered.LOWEST_PRECEDENCE);
        corsFilter.setFilter(new CorsFilter());
        corsFilter.addUrlPatterns("/*");
        return corsFilter;
    }
}
