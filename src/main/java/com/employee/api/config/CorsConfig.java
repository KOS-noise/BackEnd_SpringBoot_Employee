package com.employee.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean<?> corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // credentials=true 일 때는 * 불가 — 브라우저가 CORS 차단. Vite(3000/5173) + Postman 대비
        configuration.setAllowedOriginPatterns(List.of(
                "http://localhost:3000",
                "http://127.0.0.1:3000",
                "http://localhost:5173",
                "http://127.0.0.1:5173"
        ));
        configuration.setAllowCredentials(true);
        // 필요한 헤더만 허용
        configuration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept",
                "Authorization"));
        // 필요한 메소드만 허용
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 특정 경로에만 적용 (예: "/api/**")
        source.registerCorsConfiguration("/api/**", configuration);

        FilterRegistrationBean<?> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

}