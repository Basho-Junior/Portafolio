package crud.practicacrud.controlador;

import crud.practicacrud.encapsulaciones.Estudiante;
import crud.practicacrud.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping(path = "/")
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio service;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("misEstudiantes", service.getAllEstudiantes());
        return "index";
    }

    @RequestMapping("/crearestudiante")
    public String crearEstudiante(@RequestParam("matri") int matricula,
                                  @RequestParam("nombre") String nombre,
                                  @RequestParam("apellido") String apellido,
                                  @RequestParam("telefono") String telefono) {
        service.save(new Estudiante(matricula, nombre, apellido, telefono));
        return "redirect:/";
    }

    @RequestMapping("/modificar")
    public String modificar(Model model, @RequestParam("matricula") int matricula) {
        model.addAttribute("modificar", service.findById(matricula));
        model.addAttribute("misEstudiantes", service.getAllEstudiantes());
        return "index";
    }

    @RequestMapping("/modificarestudiante")
    public String modificarEstudiante(@RequestParam("matriculas") int matricula,
                                      @RequestParam("nombres") String nombre,
                                      @RequestParam("apellidos") String apellido,
                                      @RequestParam("telefonos") String telefono) {
        service.update(new Estudiante(matricula, nombre, apellido, telefono));
        return "redirect:/";
    }

    @RequestMapping("/eliminarestudiante")
    public String eliminarEstudiante(@RequestParam("matricula") int matricula) {
        service.delete(matricula);
        return "redirect:/";
    }
}
