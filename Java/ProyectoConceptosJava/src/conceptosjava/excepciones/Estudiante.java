/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.excepciones;

/**
 *
 * @author vacax
 */
public class Estudiante {

    private String matricula;
    private String nombre;

    public Estudiante(String matricula, String nombre) 
            throws MatriculaInvalidaPucmmException{

        validarMatricula(matricula);

        this.matricula = matricula;
        this.nombre = nombre;
    }

    /**
     * Metodo para validar la matricula..
     * @param matricula1
     * @throws MatriculaInvalidaPucmmException 
     */
    private void validarMatricula(String matricula1) 
            throws MatriculaInvalidaPucmmException {
        if (matricula1.length() != 8) {
            throw new MatriculaInvalidaPucmmException("Formato no valido...");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) 
            throws MatriculaInvalidaPucmmException {
        validarMatricula(matricula);
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
