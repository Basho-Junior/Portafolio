package Parcial2.util;


import io.javalin.core.security.RouteRole;

/**
 * Enum para manejar los roles de la aplicacion.
 */
public enum RolesApp implements RouteRole {
    CUALQUIERA,
    LOGUEADO,
    ROLE_USUARIO,
    ROLE_ADMIN;
}
