package com.fengwenyi.springboot.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Erwin Feng
 * @since 2020-11-12
 */
@SpringBootApplication
public class SpringBootLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogbackApplication.class, args);
    }

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {
        return new FeignClientInterceptor();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
