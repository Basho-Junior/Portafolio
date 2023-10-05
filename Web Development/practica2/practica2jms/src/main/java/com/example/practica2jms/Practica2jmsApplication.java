package com.example.practica2jms;

import com.example.practica2jms.database.SensorService;
import com.example.practica2jms.objetos.Info;
import com.example.practica2jms.objetos.Servidor;
import com.example.practica2jms.objetos.TipoCola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class Practica2jmsApplication implements ApplicationContextAware {
	private static String nombrecola = "Principal";
	private static List<Info> datos;
	private static ApplicationContext ac;

	//private static List<Info>
	public static void main(String[] args) throws JMSException {
		datos = new ArrayList<>();
		SpringApplication.run(Practica2jmsApplication.class, args);

		Servidor nuevo = new Servidor(nombrecola, TipoCola.TOPIC, (SensorService) ac.getBean("sensorServiceImpl"));
		nuevo.conectar();
	}

	@Override
	public void setApplicationContext(ApplicationContext ac) {
		Practica2jmsApplication.ac = ac;
	}

	public static String getNombrecola() {
		return nombrecola;
	}

	public static void setNombrecola(String nombrecola) {
		Practica2jmsApplication.nombrecola = nombrecola;
	}

	public static List<Info> getDatos() {
		return datos;
	}

	public static void setDatos(List<Info> datos) {
		Practica2jmsApplication.datos = datos;
	}
}
