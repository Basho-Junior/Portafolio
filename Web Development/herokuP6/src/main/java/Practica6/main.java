package Practica6;

import Practica6.Controladores.CrudTradicionalControlador;
import Practica6.Entidades.Foto;
import Practica6.Entidades.Producto;
import Practica6.Services.BootStrapServices;
import Practica6.Services.ServiceProducto;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.staticfiles.Location;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {
    private static String modoConexion = "";
    public static void main(String[] args) {
        //Ejemplo hola mundo
        String mensaje = "Hola Mundo en Javalin :-D";
        System.out.println(mensaje);

        if(args.length >= 1){
            modoConexion = args[0];
            System.out.println("Modo de Operacion: "+modoConexion);
        }

        //Iniciando la base de datos.
        if(modoConexion.isEmpty()) {
            BootStrapServices.getInstancia().init();
        }

        crearProductos();


        //Creando la instancia del servidor.
        Javalin app = Javalin.create(config ->{
            config.addStaticFiles(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/publico";
                staticFileConfig.location = Location.CLASSPATH;
            });
            config.registerPlugin(new RouteOverviewPlugin("/rutas")); //aplicando plugins de las rutas
            config.enableCorsForAllOrigins();
        }).start(getHerokuAssignedPort());

        //creando el manejador
        //app.get("/", ctx -> ctx.redirect("/listadoProductos.html"));

        new CrudTradicionalControlador(app).aplicarRutas();


        //Endpoint ejemplos html5.
        app.get("/fecha", ctx -> {
            ctx.result(""+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        });

        //Filtro para enviar el header de validación
        app.after(ctx -> {
            //System.out.println("Enviando el header de seguridad para el Service Worker");
            ctx.header("Service-Worker-Allowed", "/");
        });
    }

    /**
     * Metodo para indicar el puerto en Heroku
     * @return
     */
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 7000; //Retorna el puerto por defecto en caso de no estar en Heroku.
    }

    private static void crearProductos(){
        String nombre;
        int precio;
        String desc;
        List<Foto> fotos = new ArrayList<Foto>();
        for(int i = 0 ; i < 29; i++){
            nombre = "producto "+ i;
            precio = 10 * i;
            desc = "Este es el producto "+i;
            Producto temp = new Producto(nombre,precio,desc);
            temp.setFotos(fotos);
            ServiceProducto.getInstance().create(temp);
        }
    }

    public static String getModoConexion(){
        return modoConexion;
    }

}
