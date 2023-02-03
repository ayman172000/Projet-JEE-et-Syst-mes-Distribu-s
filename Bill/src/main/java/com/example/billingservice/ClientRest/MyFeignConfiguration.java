package com.example.billingservice.ClientRest;

import com.example.billingservice.ClientRest.MyRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignConfiguration {
    @Bean
    public MyRequestInterceptor requestInterceptor() {
        return new MyRequestInterceptor();
    }
}
