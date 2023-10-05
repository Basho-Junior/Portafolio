package com.example.baseusuario.repo;

import com.example.baseusuario.objects.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
