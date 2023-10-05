package com.example.baseusuario.repositories;

import com.example.baseusuario.object.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
}
