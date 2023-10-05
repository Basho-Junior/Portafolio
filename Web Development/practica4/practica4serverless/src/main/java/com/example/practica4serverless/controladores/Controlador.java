package com.example.practica4serverless.controladores;

import com.example.practica4serverless.entidades.Laboratorio;
import com.example.practica4serverless.entidades.Reserva;
import com.example.practica4serverless.servicios.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class Controlador {
    @Autowired
    ReservasService servicio;

    @RequestMapping("/")
    public String inicio(Model model) {
        model.addAttribute("reservas", servicio.reservasActuales());
        return "index";
    }

    @RequestMapping("/pasados")
    public String pasados (Model model){
        model.addAttribute("reservas", servicio.reservasAntes());
        return "pasados";
    }

    @RequestMapping("/laboratorio")
    public String laboratorio (Model model){
        model.addAttribute("laboratorios", servicio.misLaboratorios());
        return "laboratorio";
    }

    @RequestMapping("/reservas")
    public String reservas (Model model){
        model.addAttribute("laboratorios", servicio.misLaboratorios());
        return "reservas";
    }

    // Funciones para consultar
    @PostMapping("/agregarreserva")
    public String aregarReserva(@RequestParam String idestudiante, @RequestParam String nombre,
                                @RequestParam String carrera, @RequestParam String lab,
                                @RequestParam String fecha, @RequestParam String hora) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date miFecha = null;
        try {
            miFecha = format.parse(fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(miFecha);
            calendar.add(Calendar.HOUR, Integer.parseInt(hora));

            Reserva nueva = new Reserva(idestudiante, nombre, carrera, lab, calendar.getTime());
            if (servicio.agregarReserva(nueva)) {
                return "redirect:/";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/reservas";
    }

    @PostMapping("/eliminarreserva")
    public String eliminarReserva(@RequestParam String id) {
        Reserva reserva = servicio.buscarReserva(Integer.parseInt(id));
        if (reserva != null) {
            servicio.eliminarReserva(reserva);
        }
        return "redirect:/";
    }

    @PostMapping("/agregarlaboratorio")
    public String agregarLaboratorio(@RequestParam String laboratorio,
                                     @RequestParam int cantidad) {
        Laboratorio lab = new Laboratorio(laboratorio,cantidad);
        servicio.agregarLaboratorio(lab);
        return "redirect:/laboratorio";
    }

    @PostMapping("/eliminarlaboratorio")
    public String eliminarLaboratorio(@RequestParam String id) {
        Laboratorio lab = servicio.buscarLaboratorio(Integer.parseInt(id));
        if (lab != null) {
            servicio.eliminarLaboratorio(lab);
        }
        return "redirect:/laboratorio";
    }

    @PostMapping("/buscarpasados")
    public String buscarPasados(Model model, @RequestParam String inicio, @RequestParam String fin) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date miInicio = null, miFin = null;
        try {
            miInicio = format.parse(inicio);
            miFin = format.parse(fin);

            if (miInicio.after(miFin)) {
                return "redirect:/pasados";
            }
            List<Reserva> reservas = servicio.reservasTimed(miInicio, miFin);
            model.addAttribute("reservas", reservas);
            return "pasados";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
