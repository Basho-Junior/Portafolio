package com.example.baseusuario.services;

import com.example.baseusuario.objects.Rol;
import com.example.baseusuario.objects.Usuario;

import java.util.List;

public interface UsuarioService {
    // Parte del usuario (Super Admin, Admin)
    Usuario guardarUsuario(Usuario usuario);
    Usuario crearUsuario(String username, String nombre, String apellido, String correo, String clave, String rol);
    Usuario modificarUsuario(Usuario usuario);
    Usuario cambiarUsuario(String username, String nombre, String apellido, String correo, String clave, String rol);
    boolean eliminarUsuario(Usuario usuario);
    Usuario cambiarClave(Usuario usuario);
    // Perfil de usuario (Todos los usuarios
    Usuario perfilUsuarioModificar(Usuario usuario);
    Usuario perfilUsuarioClave(String clave, String nueva);
    Usuario obtenerMiPerfil();
    // Roles (Super Admin, Admin)
    Rol guardarRol(Rol rol);
    void addRolAUsuario(String username, String nombrerol);
    void deleteRolDeUsuario(String username, String nombrerol);
    // Consulta de usuarios (Admin)
    Usuario getUsuario(String username);
    List<Usuario> getUsuarios();
    List<Rol> getRoles();
    // Registro
    boolean registrarCliente(Usuario usuario);
    // Validaciones
    boolean existeUsuario(String username);
    // Email
    String notificarEmpleados(String data);
}
