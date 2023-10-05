package com.example.apigatewaybalanceador.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@RefreshScope
@Component
public class JwtGatewayFilter implements GatewayFilter {
    private AntPathMatcher antPathMatcher;
    private Map<String, Set<String>> roles;

    public JwtGatewayFilter(JwtGatewayFilterConfig config) {
        this.antPathMatcher = new AntPathMatcher();
        this.roles = config.getRoutesRoles();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().value();
        String pattern;
        try {
            pattern = roles.keySet().stream().filter(key -> antPathMatcher.match(key, path)).findFirst().get();
        } catch (NoSuchElementException e) {
            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }

}
