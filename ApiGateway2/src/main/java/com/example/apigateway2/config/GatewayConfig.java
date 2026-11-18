
package com.example.apigateway2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {

        return builder.routes()

            // StripPrefix Example
            .route("bank-account", r -> r
                .path("/api/bank/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://BANKING-SERVICE")
            )

            // RewritePath Example
            .route("bank-balance", r -> r
                .path("/api/balance/**")
                .filters(f -> f.rewritePath(
                    "/api/balance/(?<segment>.*)",
                    "/bank/balance/${segment}"
                ))
                .uri("lb://BANKING-SERVICE")
            )

            .build();
    }
}
