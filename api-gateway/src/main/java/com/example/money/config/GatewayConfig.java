package com.example.money.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public ModifyRequestHeaderGatewayFilterFactory modifyRequestHeaderGatewayFilterFactory() {
        return new ModifyRequestHeaderGatewayFilterFactory();
    }

}
