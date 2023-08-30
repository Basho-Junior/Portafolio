package Practica6.Services;

import Practica6.Entidades.Venta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ServiceVenta extends ServicioDBS<Venta>{
    private static ServiceVenta instance;

    private ServiceVenta(){ super(Venta.class);}

    public static ServiceVenta getInstance(){
        if(instance == null){
            instance = new ServiceVenta();
        }
        return instance;
    }

    public List<Venta> getVentas(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from VENTA ", Venta.class);
        List<Venta> lista = query.getResultList();
        return lista;
    }
}
