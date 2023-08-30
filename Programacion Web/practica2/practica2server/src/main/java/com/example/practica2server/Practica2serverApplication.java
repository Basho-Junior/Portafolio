package com.example.practica2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.activemq.broker.BrokerService;

import javax.jms.JMSException;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
public class Practica2serverApplication {

	public static void main(String[] args) throws IOException, JMSException  {
		SpringApplication.run(Practica2serverApplication.class, args);
		System.out.println("Inicializando Servidor JMS");
		try {
			//Subiendo la versión embedded de ActiveMQ.
			//http://activemq.apache.org/how-do-i-embed-a-broker-inside-a-connection.html
			BrokerService broker = new BrokerService();
			//configurando el broker.
			broker.addConnector("tcp://0.0.0.0:61616");
			//Inicializando
			broker.start();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
