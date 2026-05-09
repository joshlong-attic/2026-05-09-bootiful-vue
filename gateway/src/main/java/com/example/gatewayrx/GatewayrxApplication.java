package com.example.gatewayrx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class GatewayrxApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayrxApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(rs -> rs
                        .path("/api/**")
                        .filters(f -> f.rewritePath("/api", "/"))
                        .uri("http://localhost:8081")
                )
                .route(rs -> rs
                        .path("/**")
                        .uri("http://localhost:5173")
                )
                .build();
    }


   }
