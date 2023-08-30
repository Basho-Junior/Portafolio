/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.excepciones;

/**
 * Validar que sea una matricula valida...
 * @author vacax
 */
public class MatriculaInvalidaPucmmException extends Exception{ 
 
    public MatriculaInvalidaPucmmException(String mensaje){
        super(mensaje);
    }
}
