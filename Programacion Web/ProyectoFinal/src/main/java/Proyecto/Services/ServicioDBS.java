package Proyecto.Services;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioDBS <T>{
    private static EntityManagerFactory emf;
    private static ServicioDBS instance;
    private Class<T> clase;

    public ServicioDBS(Class<T> clase){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
            this.clase = clase;
        }
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    /**
     *
     * @param entity
     */
    public T create(T entity) throws IllegalArgumentException, EntityExistsException, PersistenceException{
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return entity;
    }

    /**
     *
     * @param entidad
     * @return
     */
    private Object getCampo(T entidad){
        if(entidad == null){
            return null;
        }
        //aplicando la clase de reflexión.
        for(Field f : entidad.getClass().getDeclaredFields()) {  //tomando todos los campos privados.
            if (f.isAnnotationPresent(Id.class)) { //preguntando por la anotación ID.
                try {
                    f.setAccessible(true);
                    Object valorCampo = f.get(entidad);

                    System.out.println("Nombre del campo: "+f.getName());
                    System.out.println("Tipo del campo: "+f.getType().getName());
                    System.out.println("Valor del campo: "+valorCampo );

                    return valorCampo;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     *
     * @param entity
     */
    public T edit(T entity) throws PersistenceException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try{
            em.merge(entity);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return entity;
    }

    /**
     *
     * @param entityID
     */
    public boolean delete(Object entityID) throws PersistenceException{
        boolean ok = false;
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        try{
            T entity = em.find(clase,entityID);
            em.remove(entity);
            em.getTransaction().commit();

            ok = true;
        }finally {
            em.close();
        }
        return ok;
    }
    /**
     *
     * @param id
     * @return
     */
    public T find(Object id) throws PersistenceException {
        EntityManager em = getEntityManager();
        try{
            return em.find(clase, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public List<T> findAll() throws PersistenceException {
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(clase);
            criteriaQuery.select(criteriaQuery.from(clase));
            return em.createQuery(criteriaQuery).getResultList();
        } finally {
            em.close();
        }
    }

}
