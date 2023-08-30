package com.example.practica1;

import com.example.practica1.entidades.Estudiante;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Practica1Application {
	public static List<Estudiante> misEstudiantes = new ArrayList<>();
	public static void main(String[] args) {SpringApplication.run(Practica1Application.class, args);}

}
