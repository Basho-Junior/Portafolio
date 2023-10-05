package Practica2;

import Practica2.Entidades.Producto;
import Practica2.Entidades.Usuario;
import Practica2.Entidades.Venta;

import java.util.ArrayList;
import java.util.List;

public class FakeServices {
    private static FakeServices instancia;

    private List<Usuario> listaUsuarios;
    private List<Producto> listaProductos;

    private long carrito;
    private List<Venta> ventas;
    private int contador;

    private FakeServices(){
        //anadiendo los usuarios.
        listaUsuarios = new ArrayList<>();
        listaProductos = new ArrayList<>();
        carrito = 0;
        ventas = new ArrayList<>();
        contador = 0;
        //listaUsuarios.add(new Usuario("admin", "admin", "admin"));
    }
    public static FakeServices getInstancia(){
        if(instancia==null){
            instancia = new FakeServices();
        }
        return instancia;
    }

    public Usuario autheticarUsuario(String usuario, String password){
        //simulando la busqueda en la base de datos.
        return new Usuario(usuario, "Practica2.Entidades.Usuario "+usuario, password);
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setInstancia(FakeServices instancia) {
        FakeServices.instancia = instancia;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public long getCarrito() {
        return carrito;
    }

    public void setCarrito(long carrito) {
        this.carrito = carrito;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Producto getProductosID(int id) {
        return listaProductos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void agregarVentas(Venta venta) {
        ventas.add(venta);
    }

    public Producto actualizarProducto(Producto producto){
        Producto temp = getProductosID(producto.getId());
        if(temp == null){
            throw new RuntimeException("No Existe el estudiante: "+producto.getId());
        }
        temp.actualizar(producto);
        return temp;
    }

    public boolean eliminarProducto(int id){
        Producto temp = getProductosID(id);
        return listaProductos.remove(temp);
    }

    public Producto registrarProducto(Producto producto){
        producto.setId(contador++);
        listaProductos.add(producto);
        return producto;
    }


}
