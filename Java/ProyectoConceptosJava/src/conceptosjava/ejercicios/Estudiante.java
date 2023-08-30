/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.ejercicios;

/**
 * Las clases inician en Mayuscula
 *
 * @author vacax
 */
public class Estudiante {

    //minuscula
    private int matricula;
    private String nombre;
    private String direccion;

    /**
     * primer minuscula y luego mayuscula la cambinación de palabras. Realizando
     * un metodo para cambiar el valor de la propiedad.
     *
     * @param matricula
     */
    public void cambiarMatricula(int matricula) {
        this.matricula = matricula;
    }

    // set
    public void setMatricula(int matricula) {
        if (matricula < 0) {
            System.out.println("no puede asignar matrícula");
            return;
        }
        
        //
        System.out.println(String.format("Cambio de valor matrícula "
                + "- anterior: %d , nuevo: %d", this.matricula, matricula));
        this.matricula = matricula;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //
    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
