package org.example;

import io.javalin.Javalin;
import io.javalin.http.Handler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ZonaAdminClasica extends Base {

    public ZonaAdminClasica(Javalin app) {
        super(app);
    }
    FakeServices fakeServices = FakeServices.getInstancia();


    @Override
    public void aplicarRutas() {

        /**
         * Ejemplo para agrupar path según su contexto, ejemplo.
         * http://localhost:7000/zona-admin-clasica/
         *
         * Las sesiones pueden ser vulnerables por el robo se sesiones:
         * https://es.wikipedia.org/wiki/Secuestro_de_sesi%C3%B3n
         */

        app.routes(() -> {
            path("/zona-admin-clasica", () -> {

                /**
                 * Validando que exista el usuario por el filtro.
                 */
                before(ctx -> {
                    //recuperando el usuario de la sesión,en caso de no estar, redirecciona la pagina 401.
                    Usuario usuario = ctx.sessionAttribute("usuario");
                    if(usuario == null){// usuario no existe
                        ctx.redirect("/401.html");
                    }

                    //continuando con la consulta del endpoint solicitado.
                });

                //Respuesta del index.
                get("/", ctx ->{
                    Usuario usuario = ctx.sessionAttribute("usuario");
                    for(Usuario user:fakeServices.getListaUsuarios())
                    {
                        if(user.getUsuario().equals(usuario.getUsuario())&&!(user.getPassword().equals(usuario.getPassword()))){
                            ctx.redirect("/error1.html");
                        }else if(user.getUsuario().equals(usuario.getUsuario())&&user.getPassword().equals(usuario.getPassword())){
                            ctx.redirect("/index.html");
                        }
                    }
                } );

                //controlado por el filtro...
                //http://localhost:7000/zona-admin-clasica/otro-zona/otra/
                get("/otro-zona/otra/", ctx -> {
                    ctx.result("El filtro controla todas los path por debajo del grupo....");
                });
            });
        });


    }
}

