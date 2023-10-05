package com.example.practica2client.objetos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.jms.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cliente {
    /*
    * El cliente funciona como un productor.
    */
    private long idCliente;
    private String cola;
    private TipoCola tipoCola;

    public Cliente (long idCliente, String cola, TipoCola tipoCola) {
        this.idCliente = idCliente;
        this.cola = cola;
        this.tipoCola = tipoCola;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public TipoCola getTipoCola() {
        return tipoCola;
    }

    public void setTipoCola(TipoCola tipoCola) {
        this.tipoCola = tipoCola;
    }

    public void enviarObjeto(Info objetoEnviar) throws JMSException, IOException {
        System.out.println("Enviando Mensaje - Cola: " + cola.toString());

        //Connection factory
        String brokerUrl=System.getenv("BROKER_CONNECTION");
        if(brokerUrl == null)
            brokerUrl="tcp://localhost:61616";
        else
            brokerUrl="tcp://"+brokerUrl;
        System.out.printf("Broker URL: %s\n",brokerUrl);
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        //Crea un nuevo hilo
        Connection connection = factory.createConnection("admin", "admin");
        connection.start();

        // Creando una sesión no transaccional y automatica.
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Evitar creacion de producer por defecto.
        MessageProducer producer =  null;

        if(tipoCola == TipoCola.QUEUE){
            Queue queue = session.createQueue(cola);
            producer = session.createProducer(queue);
        } else{
            Topic topic = session.createTopic(cola);
            producer = session.createProducer(topic);
        }

        ObjectMapper mapper = new ObjectMapper();

        // Convertir objeto a string json.
        String mensaje = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objetoEnviar);

        // Creando un simple mensaje de texto y enviando.
        TextMessage message = session.createTextMessage(mensaje);
        producer.send(message);

        //Desconectando la referencia.
        producer.close();
        session.close();
        connection.stop();

        //System.exit(0);
    }
}
