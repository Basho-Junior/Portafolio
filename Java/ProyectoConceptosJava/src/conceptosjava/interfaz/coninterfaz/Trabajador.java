/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.interfaz.coninterfaz;


/**
 *
 * @author vacax
 */
public class Trabajador extends Ciudadano implements ISoldado, ITrabajor{
    
    private String ocupacion;
    private String horarioTrabajo;
    
    
    
    public void producir(){
        System.out.println("Producir...");
    }
    
    @Override
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

    @Override
    public void pelear() {
        System.out.println("Peleando...");
    }

    @Override
    public void marchar() {
        System.out.println("Marcheando... Clase: "+getClass().getSimpleName());
    }

    @Override
    public void entrenar() {
        System.out.println("Entrenando....");
    }

    @Override
    public void metodo() {
        System.out.println("Otro metodo....");
    }
    
}
