package crud.practicacrud.encapsulaciones;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    private int matricula;
    private String nombre;
    private String apellido;
    private String telefono;
}
