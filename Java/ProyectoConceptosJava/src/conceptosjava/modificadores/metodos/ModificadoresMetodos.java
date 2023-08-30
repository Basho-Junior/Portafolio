/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.modificadores.metodos;

/**
 *
 * @author vacax
 */
public class ModificadoresMetodos {
    
    public void publico(){
        System.out.println("Publico");
    }
    
    void predeterminado(){
        System.out.println("Predeterminado");
    }
    
    private void privado(){
        System.out.println("privado");
    }
    
    protected void protegido(){
        System.out.println("Protegido");
        privado();
    }
}
