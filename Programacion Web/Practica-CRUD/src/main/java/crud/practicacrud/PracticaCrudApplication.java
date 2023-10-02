package crud.practicacrud;

import crud.practicacrud.encapsulaciones.Estudiante;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication()
public class PracticaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaCrudApplication.class, args);
    }

}
