/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.modificadores.constructores;

/**
 *
 * @author vacax
 */
public class ModificarConstructores {
    
    public ModificarConstructores(){
        
    }
    
    ModificarConstructores(String predeterminado){
        System.out.println("Constructor predeterminado");
    }
    
    private ModificarConstructores(String privado, boolean ok){
        System.out.println("Constructor Privado");
    }
    
    protected ModificarConstructores(String protegido, int i){
        System.out.println("Constructor Protegido");
    }
}
