package Practica6.Services;

import Practica6.main;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioDBS <T>{
    private static EntityManagerFactory emf;
    private static ServicioDBS instance;
    private Class<T> clase;

    private ServicioDBS(){
        regDriver();
    }

    public static ServicioDBS getInstance() {
        if(instance == null){
            instance = new ServicioDBS();
        }
        return instance;
    }
    public ServicioDBS(Class<T> clase){
        if(emf == null) {
            if(main.getModoConexion().equalsIgnoreCase("Heroku")){
                emf = getConfiguracionBaseDatosHeroku();
            }else{
                emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
            }
        }
        this.clase = clase;

    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    private EntityManagerFactory getConfiguracionBaseDatosHeroku(){
        //Leyendo la información de la variable de ambiente de Heroku
        String databaseUrl = System.getenv("DATABASE_URL");
        StringTokenizer st = new StringTokenizer(databaseUrl, ":@/");
        //Separando las información del conexión.
        String dbVendor = st.nextToken();
        String userName = st.nextToken();
        String password = st.nextToken();
        String host = st.nextToken();
        String port = st.nextToken();
        String databaseName = st.nextToken();
        //creando la jbdc String
        String jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s?sslmode=require", host, port, databaseName);
        //pasando las propiedades.
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", jdbcUrl );
        properties.put("jakarta.persistence.jdbc.user", userName );
        properties.put("jakarta.persistence.jdbc.password", password );
        //
        return Persistence.createEntityManagerFactory("Heroku", properties);
    }

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
    public T find(Object id) throws PersistenceException{
        EntityManager em = getEntityManager();

        try {
            return em.find(clase,id);
        }finally {
            em.close();
        }

    }

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

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://free-tier14.aws-us-east-1.cockroachlabs.cloud:26257/defaultdb?options=--cluster%3Driver-horse-3391", "junior", "kU9gcOp-aitRftCbvYLsNQ");
        } catch (SQLException exception){
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, exception);
        }
        return connection;
    }

    public void testConnection() {
        try {
            getConnection().close();
            System.out.println("Conexión realizado con exito...");
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void regDriver() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException exception){
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, exception);

        }
    }
}


