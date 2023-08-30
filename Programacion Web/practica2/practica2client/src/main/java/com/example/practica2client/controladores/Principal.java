package com.example.practica2client.controladores;

import com.example.practica2client.Practica2clientApplication;
import com.example.practica2client.objetos.Cliente;
import com.example.practica2client.objetos.TipoCola;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Principal {
    @Value("${app.server}")
    private String serverAddress;
    @Value("${app.nombrecola}")
    private String nombreCola;
    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:"+serverAddress;
    }

    @RequestMapping("/clientes")
    private String clientes(Model model) {
        model.addAttribute("listaClientes", Practica2clientApplication.getMisClientes());
        return "clientes";
    }

    @PostMapping("/agregarCliente")
    private String agregaCliente(Model model) {
        // Crear cliente random...
        Cliente nuevo = new Cliente(Practica2clientApplication.getCounter(),
                nombreCola, TipoCola.TOPIC);
        // Agregar nuevo cliente
        Practica2clientApplication.getMisClientes().add(nuevo);
        // Próximo id.
        Practica2clientApplication.setCounter(Practica2clientApplication.getCounter() + 1);
        return "redirect:/clientes";
    }

    @PostMapping("/eliminarCliente")
    private String eliminarCliente(Model model,
                                   @RequestParam String id) {
        long idCliente = Long.valueOf(id);
        int idLista = -1;
        // Ver su Id.
        for (int i = 0; i < Practica2clientApplication.getMisClientes().size(); i++) {
            if (idCliente == Practica2clientApplication
                    .getMisClientes().get(i).getIdCliente()) {
                idLista = i;
                i+=Practica2clientApplication.getMisClientes().size();
            }
        }
        // Remover cliente.
        if (idLista < Practica2clientApplication.getMisClientes().size() &&
                idLista >= 0) {
            Practica2clientApplication.getMisClientes().remove(
                    Practica2clientApplication.getMisClientes().get(idLista));
        }
        return "redirect:/clientes";
    }

    @RequestMapping("/graficos")
    private String graficos(Model model) {
        return "redirect:"+serverAddress+"/graficos";
    }
}
