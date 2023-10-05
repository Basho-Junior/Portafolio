package Proyecto.Services;

import Proyecto.Entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ServiceUsuario extends ServicioDBS<Usuario> {

    private static ServiceUsuario instancia;

    private ServiceUsuario(){
        super(Usuario.class);
    }

    public static ServiceUsuario getInstancia(){
        if(instancia==null){
            instancia = new ServiceUsuario();
        }
        return instancia;
    }

    public  Usuario autentificacion(String user, String pass){
        EntityManager em = getEntityManager();

        Query query = em.createNamedQuery("Usuario.autentificacion");
        query.setParameter("user", user);
        query.setParameter("pass", pass);

        List<Usuario> lista =  query.getResultList();
        return lista.isEmpty() ? null : lista.get(0);
    }

    public List<Usuario> findAllByUsuario(String user){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Usuario.findAllByUsuario");
        query.setParameter("user", user);
        List<Usuario> lista = query.getResultList();
        return lista;

    }

    public List<Usuario> getUsuarios(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from USUARIO ", Usuario.class);
        List<Usuario> lista = query.getResultList();
        return lista;
    }
}
