/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemelegislativo;

/**
 *
 * @author Junior
 */
public class Senador extends Legislador {

    public Senador(String nombre, String cedula, int edad, String genero, String Provincia) {
        super(nombre, cedula, edad, genero, Provincia);
    }
    
    

    @Override
    public void getCamaraEnQueTrabaja() {
        String mensaje = "Pertenece a la camara de senadores";
        System.out.println(mensaje);
    }
    
}
