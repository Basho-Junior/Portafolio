package Parcial2.servicios;


import Parcial2.encapsulaciones.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceEstudiante extends ServicioDBS<Estudiante>{
    private static ServiceEstudiante instance;

    private ServiceEstudiante(){
        super(Estudiante.class);
    }

    public static ServiceEstudiante getInstance(){
        if(instance == null){
            instance = new ServiceEstudiante();
        }
        return instance;
    }

    public void deleteEstudiante(Object id){
        Estudiante entity = find(id);
        entity.setEstado(false);
        entity = edit(entity);
    }

    public void eliminarEstudiante(int id){
        EntityManager em = getEntityManager();
        String updateQuery = "UPDATE Estudiante e SET e.estado = false WHERE e.id = " + id;
        em.getTransaction().begin();
        Query query = em.createNativeQuery(updateQuery, Estudiante.class);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    public Estudiante buscarEstudiante(int id){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from ESTUDIANTE WHERE ESTADO = true AND ID = "+id, Estudiante.class);
        Estudiante lista = (Estudiante) query.getSingleResult();
        return lista;
    }


    public List<Estudiante> getEstudiante(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from ESTUDIANTE WHERE ESTADO = true", Estudiante.class);
        List<Estudiante> lista = query.getResultList();
        return lista;
    }
}
