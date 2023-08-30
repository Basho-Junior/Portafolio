package Proyecto.Services;

import Proyecto.Entidades.Visitante;

public class ServiceVisitante extends ServicioDBS<Visitante> {

    private static ServiceVisitante instancia;

    public static ServiceVisitante getInstancia(){
        if(instancia==null){
            instancia = new ServiceVisitante();
        }
        return instancia;
    }

    private ServiceVisitante(){
        super(Visitante.class);
    }

}
