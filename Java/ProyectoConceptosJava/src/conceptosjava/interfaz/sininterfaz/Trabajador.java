/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.interfaz.sininterfaz;

/**
 *
 * @author vacax
 */
public class Trabajador extends Ciudadano{
    
    private String ocupacion;
    private String horarioTrabajo;
    
    
    
    public void producir(){
        System.out.println("Producir...");
    }
    
    public void trabajar(){
        System.out.println("Trabajando...");
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }
    
}
