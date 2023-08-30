package com.example.practica11.entidades.repositorios;

import com.example.practica11.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, String> {
    Usuario findByUsername(String username);
}
