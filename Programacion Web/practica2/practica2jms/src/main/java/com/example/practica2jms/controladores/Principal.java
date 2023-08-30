package com.example.practica2jms.controladores;

import com.example.practica2jms.Practica2jmsApplication;
import com.example.practica2jms.objetos.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class Principal {
    @Value("${app.client}")
    private String clientAddress;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/clientes")
    public String clientes(Model model) {
        return "redirect:"+clientAddress+"/clientes";
    }

    @RequestMapping("/graficos")
    public String graficos(Model model) {
        return "graficos";
    }

    @MessageMapping("/data")
    @SendTo("/topic/graficos")
    public static List<Info> informacion(List<Info> info) {
        return info;
    }
}
