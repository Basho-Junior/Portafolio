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
public abstract class Legislador extends Persona{
    private String  provinciaQueRepresenta;
    
    public abstract void getCamaraEnQueTrabaja();
    public Legislador(String nombre, String cedula, int edad, String genero, String Provincia) {
        super(nombre, cedula, edad, genero);
        this.provinciaQueRepresenta = Provincia;
    }
    public String getProvincia() {
        return provinciaQueRepresenta;
    }

    public void setProvincia(String Provincia) {
        this.provinciaQueRepresenta = Provincia;
    }
    public static void main(String[] args) {
        Senador p1 = new Senador("Junior Hernandez", "406-58413-6",35,"Masculino", "Independencia");
        Diputado p2 = new Diputado("Nicol Cristal", "331-48413-6",56,"Femenino","Azua");
        
        System.out.println(p1.getNombre());
        System.out.println(p1.getProvincia());
        p1.getCamaraEnQueTrabaja();
        System.out.println(p2.getNombre());
        System.out.println(p2.getProvincia());
        p2.getCamaraEnQueTrabaja();
    }
    
    
    
}
