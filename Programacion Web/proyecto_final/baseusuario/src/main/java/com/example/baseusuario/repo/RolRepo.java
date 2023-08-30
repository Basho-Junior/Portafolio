package com.example.baseusuario.repo;

import com.example.baseusuario.objects.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}
