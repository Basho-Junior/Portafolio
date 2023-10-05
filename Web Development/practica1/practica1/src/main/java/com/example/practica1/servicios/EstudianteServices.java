package com.example.practica1.servicios;

import com.example.practica1.Practica1Application;
import com.example.practica1.entidades.Estudiante;
import com.example.practica1.repositorios.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudianteServices {
    @Autowired
    private EstudianteRepo estudianteRepo;

    public long cantidadEstudiantes() {
        return estudianteRepo.count();
    }

    public List<Estudiante> getEstudiantes() {
        //return estudianteRepo.findAll();
        return Practica1Application.misEstudiantes;
    }

    public Estudiante buscarMatricula(int matricula) {
        //return estudianteRepo.findEstudianteByMatricula(matricula);
        Estudiante result = null;
        for (int i = 0; i < Practica1Application.misEstudiantes.size(); i ++) {
            if (Practica1Application.misEstudiantes.get(i).getMatricula() == matricula) {
                result = Practica1Application.misEstudiantes.get(i);
            }
        }
        return result;
    }

    @Transactional()
    public Estudiante creacionEstudiante(Estudiante estudiante) {
        Practica1Application.misEstudiantes.add(estudiante);
        //estudianteRepo.save(estudiante);
        return estudiante;
    }

    @Transactional()
    public Estudiante modificacionEstudiante(Estudiante estudiante) {
        /*Estudiante modificado = estudianteRepo.findEstudianteByMatricula(estudiante.getMatricula());
        if (modificado != null) {
            modificado.setNombre(estudiante.getNombre());
            modificado.setTelefono(estudiante.getTelefono());
            estudianteRepo.save(modificado);
            return modificado;
        }*/
        for (int i = 0; i < Practica1Application.misEstudiantes.size(); i++) {
            if (Practica1Application.misEstudiantes.get(i).getMatricula() == estudiante.getMatricula()) {
                Practica1Application.misEstudiantes.get(i).setNombre(estudiante.getNombre());
                Practica1Application.misEstudiantes.get(i).setTelefono(estudiante.getTelefono());
            }
        }
        return null;
    }

    @Transactional()
    public boolean eliminarEstudiante(int matricula) {
        /*Estudiante aEliminar = estudianteRepo.findEstudianteByMatricula(matricula);
        if (aEliminar != null) {
            estudianteRepo.delete(aEliminar);
            return true;
        }*/
        int toDelete = -1;
        for (int i = 0; i < Practica1Application.misEstudiantes.size(); i ++) {
            if (Practica1Application.misEstudiantes.get(i).getMatricula() == matricula) {
                toDelete = i;
            }
        }
        if (toDelete != -1) {
            Practica1Application.misEstudiantes.remove(toDelete);
            return true;
        }
        return false;
    }
}
