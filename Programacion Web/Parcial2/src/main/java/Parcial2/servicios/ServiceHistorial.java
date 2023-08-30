package Parcial2.servicios;


import Parcial2.encapsulaciones.Estudiante;
import Parcial2.encapsulaciones.Historial;
import Parcial2.encapsulaciones.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class ServiceHistorial extends ServicioDBS<Historial>{

    private static ServiceHistorial instance;
    private ServiceHistorial(){ super(Historial.class);}

    public static ServiceHistorial getInstance(){
        if(instance == null){
            instance = new ServiceHistorial();
        }
        return instance;
    }

    public Historial buscarHistorial(int id){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from HISTORIAL WHERE IDESTUDIANTE = "+id, Historial.class);
        Historial lista = (Historial) query.getSingleResult();
        return lista;
    }


}
