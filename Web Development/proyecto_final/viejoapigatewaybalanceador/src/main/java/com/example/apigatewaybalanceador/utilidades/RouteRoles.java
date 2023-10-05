package com.example.apigatewaybalanceador.utilidades;

import java.util.List;

public class RouteRoles {
    private String route;
    private List<String> roles;

    public RouteRoles(String route, List<String> roles) {
        this.route = route;
        this.roles = roles;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
