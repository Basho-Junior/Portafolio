package com.example.practica2jms.configuraciones;

import com.example.practica2jms.Practica2jmsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Autowired
    private SimpMessagingTemplate webSocket;
    // Enviar todos los datos.
    @Scheduled(fixedRate = 2000)
    public void fireGreeting() {
        webSocket.convertAndSend("/topic/graficos", Practica2jmsApplication.getDatos());
    }
}
