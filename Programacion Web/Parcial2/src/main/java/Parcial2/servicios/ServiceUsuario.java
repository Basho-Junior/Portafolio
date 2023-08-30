package Parcial2.servicios;


import Parcial2.encapsulaciones.Estudiante;
import Parcial2.encapsulaciones.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceUsuario extends ServicioDBS<Usuario> {
    private static ServiceUsuario instance;

    private ServiceUsuario(){
        super(Usuario.class);
    }

    public static ServiceUsuario getInstancia(){
        if(instance==null){
            instance = new ServiceUsuario();
        }
        return instance;
    }

    public List<Usuario> getUsuario(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from USUARIO ", Usuario.class);
        List<Usuario> lista = query.getResultList();
        return lista;
    }

    public static String autentificarUsuario(Usuario aux) {
        return "ADM";
    }

}
