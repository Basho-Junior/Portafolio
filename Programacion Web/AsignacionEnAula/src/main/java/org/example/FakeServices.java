package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FakeServices {
    private static FakeServices instancia;

    private List<Usuario> listaUsuarios = new ArrayList<>();

    private FakeServices(){
        //anadiendo los usuarios.
        listaUsuarios.add(new Usuario("admin", "admin", "1234"));
        listaUsuarios.add(new Usuario("logueado", "logueado", "logueado"));
        listaUsuarios.add(new Usuario("usuario", "usuario", "usuario"));
    }
    public static FakeServices getInstancia(){
        if(instancia==null){
            instancia = new FakeServices();
        }
        return instancia;
    }

    public Usuario autheticarUsuario(String usuario, String password){
        //simulando la busqueda en la base de datos.
        return new Usuario(usuario, "org.example.Usuario "+usuario, password);
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
