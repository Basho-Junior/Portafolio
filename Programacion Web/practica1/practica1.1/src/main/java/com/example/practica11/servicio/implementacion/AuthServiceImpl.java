package com.example.practica11.servicio.implementacion;

import com.example.practica11.entidades.Rol;
import com.example.practica11.entidades.Usuario;
import com.example.practica11.entidades.repositorios.UsuarioRepo;
import com.example.practica11.servicio.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UsuarioRepo usuarioRepository;
    public Boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    public Usuario getUserAuthenticated() {
        if (isAuthenticated()) {
            Usuario actual = usuarioRepository.findByUsername(
                    SecurityContextHolder.getContext().getAuthentication().getName());
            return actual;
        }
        return null;
    }

    public Boolean containsRole(String rol) {
        Usuario usuario = getUserAuthenticated();
        if (usuario != null) {
            Set<String> data = usuario.getRoles().stream().map(Rol::getRole).collect(Collectors.toSet());
            if (data.contains(rol)) {
                return true;
            }
        }
        return false;
    }
}
