package com.example.apigatewaybalanceador.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtGatewayFilterConfig> {

    private static final Logger LOG = LoggerFactory.getLogger(JwtGatewayFilterFactory.class);

    public JwtGatewayFilterFactory() {
        super(JwtGatewayFilterConfig.class);
    }

    @Override
    public GatewayFilter apply(JwtGatewayFilterConfig config) {
        return new JwtGatewayFilter(config);
    }

    @Override
    public String name() {
        return super.name();
    }

}
