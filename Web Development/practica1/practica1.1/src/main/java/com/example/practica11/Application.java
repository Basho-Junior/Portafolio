package com.example.practica11;

import com.example.practica11.servicio.SecurityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		// Crear administrador por defecto
		SecurityService seguridadServices = (SecurityService) applicationContext.getBean("securityService");
		seguridadServices.crearUsuarioAdmin();
	}

}
