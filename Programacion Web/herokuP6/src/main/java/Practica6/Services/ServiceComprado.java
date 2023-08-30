package Practica6.Services;

import Practica6.Entidades.Comprado;
import Practica6.Entidades.Producto;

import java.util.ArrayList;
import java.util.List;

public class ServiceComprado extends ServicioDBS<Comprado>{

    private static ServiceComprado instance;

    private ServiceComprado(){ super(Comprado.class);}

    public static ServiceComprado getInstance(){
        if(instance == null){
            instance = new ServiceComprado();
        }
        return instance;
    }

    public List<Comprado> convertProd(List<Producto> productos, long venta){
        List<Comprado> list = new ArrayList<Comprado>();
        for (Producto prod:productos) {
            Comprado temp = new Comprado(prod.getId(),venta,prod.getCantidad(),prod.getPrecio(),prod.getNombre());
            getInstance().create(temp);
            list.add(temp);
        }
        return list;
    }

}
