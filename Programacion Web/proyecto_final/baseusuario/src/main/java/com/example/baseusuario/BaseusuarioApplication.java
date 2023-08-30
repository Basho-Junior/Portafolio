package com.example.baseusuario;

import com.example.baseusuario.objects.Rol;
import com.example.baseusuario.objects.Usuario;
import com.example.baseusuario.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
@EnableRetry
public class BaseusuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseusuarioApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UsuarioService usuarioService) {
//        return args -> {
//
//            System.out.println("Iniciando cosas de la BD.");
//            usuarioService.guardarRol(new Rol(null, "ROL_USUARIO"));
//            usuarioService.guardarRol(new Rol(null, "ROL_CLIENTE"));
//            usuarioService.guardarRol(new Rol(null, "ROL_EMPLEADO"));
//            usuarioService.guardarRol(new Rol(null, "ROL_ADMIN"));
//            usuarioService.guardarRol(new Rol(null, "ROL_SUPER_ADMIN"));
//            usuarioService.guardarRol(new Rol(null, "ROL_ROBOT"));
//            usuarioService.guardarUsuario(new Usuario(null, "admin", "admin",
//                    "admin", "admin", "admin", new ArrayList<>()));
//            usuarioService.guardarUsuario(new Usuario(null, "robot", "robot", "robot", "robot",
//                    "3NGTgRRFcp7qJKa4jTJk", new ArrayList<>()));
//            usuarioService.addRolAUsuario("admin", "ROL_ADMIN");
//            usuarioService.addRolAUsuario("admin", "ROL_SUPER_ADMIN");
//            usuarioService.addRolAUsuario("robot", "ROL_ROBOT");
//
//        };
//    }

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}