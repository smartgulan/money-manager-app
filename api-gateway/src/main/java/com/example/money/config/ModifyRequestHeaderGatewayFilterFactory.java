package com.example.money.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class ModifyRequestHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<ModifyRequestHeaderGatewayFilterFactory.Config> {

    public ModifyRequestHeaderGatewayFilterFactory() {
        super(Config.class);
    }

    public static class Config {
        // no conf
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            ServerWebExchange mutatedExchange = (authHeader != null)
                    ? exchange.mutate()
                    .request(builder -> builder.header("Authorization", authHeader))
                    .build()
                    : exchange;

            return chain.filter(mutatedExchange);
        };
    }

}
