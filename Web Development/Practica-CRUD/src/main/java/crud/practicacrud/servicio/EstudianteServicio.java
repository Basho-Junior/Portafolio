package crud.practicacrud.servicio;

import crud.practicacrud.encapsulaciones.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteServicio {

    private List<Estudiante> list = new ArrayList<Estudiante>();

    public List<Estudiante> getAllEstudiantes() {
        return list;
    }

    public Estudiante findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMatricula() == (id)) {
                return list.get(i);
            }
        }

        /*Perdon no se que devolver que no sea null de esta parte :c*/
        return null;
    }

    public List<Estudiante> search(String name) {
        return list.stream().filter(x -> x.getNombre().startsWith(name)).collect(Collectors.toList());
    }

    public Estudiante save(Estudiante p) {
        Estudiante Estudiante = new Estudiante(p.getMatricula(),p.getNombre(),p.getApellido(),p.getTelefono());
        list.add(Estudiante);
        return Estudiante;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getMatricula() == (id));
        return "";
    }

    public Estudiante update(Estudiante Estudiante) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMatricula() == (Estudiante.getMatricula())) {
                id = Estudiante.getMatricula();
                idx = i;
                break;
            }
        }

        Estudiante Estudiante1 = new Estudiante(id,Estudiante.getNombre(),Estudiante.getApellido(),Estudiante.getTelefono());
        list.set(idx, Estudiante);
        return Estudiante1;
    }
}
