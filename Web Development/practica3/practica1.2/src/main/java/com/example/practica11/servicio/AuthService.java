package com.example.practica11.servicio;

import com.example.practica11.entidades.Usuario;

public interface AuthService {
    public abstract Boolean isAuthenticated();
    public abstract Usuario getUserAuthenticated();
    public abstract Boolean containsRole(String rol);
   // public abstract Boolean crearNotificacion(String tema, String mensaje);
}
