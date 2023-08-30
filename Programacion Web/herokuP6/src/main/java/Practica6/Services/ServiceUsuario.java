package Practica6.Services;


import Practica6.Entidades.Usuario;

public class ServiceUsuario extends ServicioDBS<Usuario>{
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

    public static String autentificarUsuario(Usuario aux) {
        return "ADM";
    }

}
