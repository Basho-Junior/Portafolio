package Practica2;

import Practica2.Entidades.Carrito;
import Practica2.Entidades.Producto;
import Practica2.Entidades.Venta;
import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa las rutas para manejar las operaciones de petición - respuesta.
 */
public class CrudTradicionalControlador extends Base {

    FakeServices service = FakeServices.getInstancia();

    public CrudTradicionalControlador(Javalin app) {
        super(app);
    }

    /**
     * Las clases que implementan el sistema de plantilla están agregadas en PlantillasControlador.
     * http://localhost:7000/crud-simple/listar
     */
    @Override
    public void aplicarRutas(){
        /*Si el carrito no existe dentro de la sesion entonces se crea y se agrega como un atributo*/
        app.before(ctx -> {
            Carrito carro = ctx.sessionAttribute("carrito");
            if(carro == null){
                carro = new Carrito(service.getCarrito());
            }
            ctx.sessionAttribute("carrito",carro);

        });
        /*Ruta raiz
         * Muesta los productos disponibles para agragar al carrito*/
        app.get("/", ctx -> {
            Carrito carro = ctx.sessionAttribute("carrito");
            if( ctx.cookie("usuario") == null || ctx.cookie("password") == null || !ctx.cookie("usuario").equalsIgnoreCase("admin") || !ctx.cookie("password").equalsIgnoreCase("admin")) {
                if(ctx.sessionAttribute("usuario") == null){
                    ctx.sessionAttribute("usuario","visitante");
                }
                if(ctx.sessionAttribute("usuario").equals("admin")){
                    ctx.sessionAttribute("usuario","admin");
                }else{
                    ctx.sessionAttribute("usuario","visitante");
                }
                List<Producto> productos = service.getListaProductos();
                Map<String, Object> modelo = new HashMap<>();
                modelo.put("productos",productos);
                modelo.put("usuario",ctx.sessionAttribute("usuario"));
                modelo.put("cantidad",carro.getProductos().size());
                ctx.render("/publico/listadoProductos.html", modelo);
            }else {
                List<Producto> productos = service.getListaProductos();
                Map<String, Object> modelo = new HashMap<>();
                modelo.put("productos", productos);
                modelo.put("usuario", ctx.cookie("usuario"));
                modelo.put("cantidad", carro.getProductos().size());
                ctx.render("/publico/listadoProductos.html", modelo);
            }
        });

        /*Peticion que agrega un producto al carrito del usuario
         * Si el producto ya está en el carrito entonces se aumenta la cantidad que se quiere*/
        app.post("/comprar", ctx -> {
            Carrito carro = ctx.sessionAttribute("carrito");

            Producto temp = carro.getProductosID(ctx.formParamAsClass("id",Integer.class).get());
            if(temp == null){
                temp = service.getProductosID(ctx.formParamAsClass("id",Integer.class).get());
                temp.setCantidad(ctx.formParamAsClass("cantidad",Integer.class).get() );
                carro.agregarProducto(temp);
                ctx.sessionAttribute("carrito",carro);
                ctx.redirect("/comprar");
            }else{
                int pos = carro.posicion(ctx.formParamAsClass("id",Integer.class).get());
                temp.setCantidad(ctx.formParamAsClass("cantidad",Integer.class).get() + temp.getCantidad());
                carro.cambiarProducto(temp,pos);
            }
            System.out.println(temp.getId());
            ctx.sessionAttribute("carrito",carro);
            ctx.redirect("/comprar");
        });

        app.get("/comprar", ctx -> {
            ctx.redirect("/");
        });

        /*Carga la pestaña con todas las ventas realizadas
         * Si el usuario no se ha logeado entonces se redirige al log-in*/
        app.get("/ventas", ctx -> {

            if( ctx.cookie("usuario") == null || ctx.cookie("password") == null || !ctx.cookie("usuario").equalsIgnoreCase("admin") || !ctx.cookie("password").equalsIgnoreCase("admin")) {
                ctx.redirect("/autenti/ventas");
                return;
            }
            Carrito carro = ctx.sessionAttribute("carrito");
            List<Venta> ventas = service.getVentas();
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("ventas",ventas);
            modelo.put("cantidad",carro.getProductos().size());

            ctx.render("/publico/ventas.html",modelo);
        });

        /*Carga la ventana para hacer crud de los productos*/
        app.get("/productos", ctx -> {
            if( ctx.cookie("usuario") == null || ctx.cookie("password") == null || !ctx.cookie("usuario").equalsIgnoreCase("admin") || !ctx.cookie("password").equalsIgnoreCase("admin")) {
                ctx.redirect("/autenti/productos");
                return;
            }
            List<Producto> productos = service.getListaProductos();
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("productos",productos);
            Carrito carrito = ctx.sessionAttribute("carrito");
            modelo.put("cantidad",carrito.getProductos().size());
            ctx.render("/publico/administrarProductosV.html",modelo);
        });

        /*Carga la ventana para registrar un nuevo producto en el sistema
         * Envia un string accion para poder especificar lo que se va a realizar al momento de hacer post en el formulario
         * ya que se utiliza la misma vista que para editar un producto*/
        app.get("/registrar", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("accion","/registrar");
            Carrito carro = ctx.sessionAttribute("carrito");
            modelo.put("cantidad",carro.getProductos().size());
            ctx.render("/publico/productoCE.html",modelo);
        });

        /*Registra un producto en el sistema a partir de los valores del formulario*/
        app.post("/registrar", ctx -> {
            String nombre = ctx.formParam("nombre");
            int precio = ctx.formParamAsClass("precio",Integer.class).get();

            Producto temp = new Producto(nombre,precio);
            service.registrarProducto(temp);
            ctx.redirect("/productos");
            System.out.println(temp.getId());
        });

        /*Remueve un articulo de los disponibles a partir de su id*/
        app.get("/remover/{id}", ctx -> {
            service.eliminarProducto(ctx.pathParamAsClass("id",Integer.class).get());
            ctx.redirect("/productos");
        });

        /*Permite editar un producto ya agregado
         * Se envia un string para determinar que se realizará una modificación luego del post*/
        app.get("/editar/{id}", ctx -> {
            Producto temp = service.getProductosID(ctx.pathParamAsClass("id", Integer.class).get());
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("producto",temp);
            modelo.put("accion","/editar/"+ctx.pathParamAsClass("id", Integer.class).get());

            Carrito carro = ctx.sessionAttribute("carrito");
            modelo.put("cantidad",carro.getProductos().size());
            ctx.render("/publico/productoCE.html",modelo);
        });

        /*Post luego del formulario de modificar producto
         * Actualiza los valores a partir de lo enviado en el formulario*/
        app.post("/editar/{id}", ctx -> {
            String nombre = ctx.formParam("nombre");
            int precio = ctx.formParamAsClass("precio",Integer.class).get();

            Producto temp = new Producto(nombre,precio);
            temp.setId(ctx.pathParamAsClass("id",Integer.class).get());
            service.actualizarProducto(temp);

            ctx.redirect("/productos");
        });

        /*Hace render al log-in
         * direc determina a que vista será rediccionado luego de autentificarse correctamente*/
        app.get("/autenti/{direc}", ctx -> {
            String direc = ctx.pathParam("direc");
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("direc",direc);
            ctx.render("/publico/login.html",modelo);
        });

        /*Post de autentificacion
         * redirige a la ventana especificada en el get*/
        app.post("/autenti/{direc}",ctx -> {
            String usuario = ctx.formParam("usuario");
            String pass = ctx.formParam("password");
            String temp = ctx.pathParam("direc");

            if(usuario == null || pass == null){
                ctx.redirect("/autenti/"+temp);
            }
            ctx.cookie("usuario", usuario);
            ctx.cookie("password",pass);

            ctx.redirect("/"+temp);

        });

        /*Carga el carrito pasando la lista de productos que se tiene dentro del carro*/
        app.get("/carrito", ctx -> {
            Carrito carro = ctx.sessionAttribute("carrito");
            if(carro == null){
                carro = new Carrito(service.getCarrito());
            }
            ctx.sessionAttribute("carrito",carro);
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("productos",carro.getProductos());
            modelo.put("cantidad",carro.getProductos().size());
            ctx.render("/publico/carrito.html",modelo);
        });
        /*Elimina un producto del carrito a partir de su id*/
        app.get("/eliminar/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            Carrito carro = ctx.sessionAttribute("carrito");
            carro.eliminarProductoId(id);

            ctx.sessionAttribute("carrito",carro);
            ctx.redirect("/carrito");
        });

        /*Procesa la compra
         * crea un objeto venta
         * Limpia el carrito del usuario*/
        app.post("/procesar",ctx -> {
            Carrito carro = ctx.sessionAttribute("carrito");
            if(carro.getProductos().size() < 1){
                ctx.redirect("/carrito");
            }
            String nombre = ctx.formParam("nombre");
            Venta venta = new Venta(service.getVentas().size()+1,nombre,carro.productos);
            service.agregarVentas(venta);
            carro.eliminarProductos();
            ctx.sessionAttribute("carrito",carro);
            ctx.redirect("/comprar");
        });

        /*Limpia el carrito del usuario*/
        app.get("/limpiar", ctx -> {
            Carrito carro = ctx.sessionAttribute("carrito");
            carro.eliminarProductos();

            ctx.redirect("/comprar");
        });
        /*Sale de sesion*/
        app.get("/invalidarSesion", ctx -> {
            //invalidando la sesion.
            ctx.req.getSession().invalidate();
            ctx.cookie("usuario", "visitante");
            ctx.redirect("/");
        });
    }
}
