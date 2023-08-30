package com.example.apigatewaybalanceador.components;

import com.example.apigatewaybalanceador.utilidades.RouteRoles;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtGatewayFilterConfig {
    private Map<String, Set<String>> routesRoles;

    public JwtGatewayFilterConfig(List<RouteRoles> routesRoles) {
        this.routesRoles = new HashMap<>();
        for (RouteRoles routeRoles:
                routesRoles) {
            Set<String> tempset = new HashSet<>();
            tempset.addAll(routeRoles.getRoles());
            this.routesRoles.put(routeRoles.getRoute(), tempset);
        }
    }

    public Map<String, Set<String>> getRoutesRoles() {
        return routesRoles;
    }

    public JwtGatewayFilterConfig() {
        this.routesRoles = new HashMap<>();
    }

    public void setRoutesRoles(List<RouteRoles> routesRoles) {
        for (RouteRoles routeRoles:
                routesRoles) {
            Set<String> tempset = new HashSet<>();
            tempset.addAll(routeRoles.getRoles());
            this.routesRoles.put(routeRoles.getRoute(), tempset);
        }
    }
}
