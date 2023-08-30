package com.example.practica1.controladores;

import com.example.practica1.entidades.Estudiante;
import com.example.practica1.servicios.EstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping(path = "/")
public class Principal {

    @Autowired
    private EstudianteServices servicio;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("misEstudiantes", servicio.getEstudiantes());
        return "index";
    }

    @RequestMapping("/crearestudiante")
    public String crearEstudiante(@RequestParam("matricula") int matricula,
                                  @RequestParam("nombre") String nombre,
                                  @RequestParam("telefono") String telefono) {
        servicio.creacionEstudiante(new Estudiante(matricula, nombre, telefono));
        return "redirect:/";
    }

    @RequestMapping("/modificarestudiante")
    public String modificarEstudiante(@RequestParam("matricula") int matricula,
                                  @RequestParam("nombre") String nombre,
                                  @RequestParam("telefono") String telefono) {
        servicio.modificacionEstudiante(new Estudiante(matricula, nombre, telefono));
        return "redirect:/";
    }

    @RequestMapping("/eliminarestudiante")
    public String eliminarEstudiante(@RequestParam("matricula") int matricula) {
        servicio.eliminarEstudiante(matricula);
        return "redirect:/";
    }

    @RequestMapping("/modificar")
    public String modificar(Model model, @RequestParam("matricula") int matricula) {
        model.addAttribute("modificar", servicio.buscarMatricula(matricula));
        model.addAttribute("misEstudiantes", servicio.getEstudiantes());
        return "index";
    }
}
