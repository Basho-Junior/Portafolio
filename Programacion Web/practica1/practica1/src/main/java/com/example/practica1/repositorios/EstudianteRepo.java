package com.example.practica1.repositorios;

import com.example.practica1.entidades.Estudiante;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {
    Estudiante findEstudianteByMatricula(int matricula);
    Estudiante findEstudianteByMatriculaAndNombre(int matricula, String nombre);
    List<Estudiante> findEstudianteByNombreStartingWith(String nombre);
    List<Estudiante> findAllByNombreStartingWithIgnoreCase(String nombre);
    List<Estudiante> findAllByNombre(String nombre, Pageable pageable);
    List<Estudiante> findAllByOrderByNombre();
    List<Estudiante> findAllByOrderByMatricula();
    List<Estudiante> findAllByTelefono(String telefono);
    List<Estudiante> findAllByTelefono(String telefono, Pageable pageable);
}
