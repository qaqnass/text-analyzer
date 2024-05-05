package com.example.textanalyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig class for Cross-Origin Resource Sharing (CORS) configuration.
 * This class implements the {@code WebMvcConfigurer} interface to provide custom CORS configuration
 * for the Spring MVC framework.
 * CORS allows web servers to specify which origins are allowed to access resources on the server,
 * preventing Cross-Origin Request Blocked errors in web applications.
 * The {@code @Configuration} annotation indicates that this class provides bean definitions to the Spring application context.
 */
@Configuration
public class CorsOriginConfig {

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name())
                        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION);
            }
        };
    }
}
