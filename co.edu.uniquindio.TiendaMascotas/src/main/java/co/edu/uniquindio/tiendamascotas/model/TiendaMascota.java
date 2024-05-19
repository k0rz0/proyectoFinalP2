package co.edu.uniquindio.tiendamascotas.model;

import co.edu.uniquindio.tiendamascotas.model.builder.TiendaMascotaBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiendaMascota {
    private String nombre;
    private Map<String, List<Producto>> productosPorTipo;

    //Constructor

    public TiendaMascota(String nombre) {
        this.nombre = nombre;
        productosPorTipo = new HashMap<>();
    }

    //Builder
    public static TiendaMascotaBuilder builder(){
        return new TiendaMascotaBuilder();
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public Producto obtenerProductoPorId(int idProducto) {
        for (List<Producto> listaProductos : productosPorTipo.values()) {
            for (Producto producto : listaProductos) {
                if (producto.getIdProducto() == idProducto) {
                    return producto;
                }
            }
        }
        return null; // Producto no encontrado
    }
    public boolean agregarProducto(Producto nuevoProducto) {
        Producto productoEncontrado = obtenerProductoPorId(nuevoProducto.getIdProducto());
        if (productoEncontrado == null) {
            String tipoProducto = nuevoProducto.getClass().getSimpleName();
            if (!productosPorTipo.containsKey(tipoProducto)) {
                productosPorTipo.put(tipoProducto, new ArrayList<>());
            }
            productosPorTipo.get(tipoProducto).add(nuevoProducto);
            return true;
        }else{
            return  false;
        }
    }

    public boolean eliminarProducto(Producto nuevoProducto) {
        Producto productoEncontrado = obtenerProductoPorId(nuevoProducto.getIdProducto());
        if (productoEncontrado == null) {
            String tipoProducto = nuevoProducto.getClass().getSimpleName();
            if (productosPorTipo.containsKey(tipoProducto)) {
                productosPorTipo.get(tipoProducto).remove(nuevoProducto);
            }
            productosPorTipo.get(tipoProducto).add(nuevoProducto);
            return true;
        }else{
            return  false;
        }
    }
    public boolean actualizarProducto(Producto productoActualizado) {
        String tipoProducto = productoActualizado.getClass().getSimpleName();
        Producto productoEncontrado = obtenerProductoPorId(productoActualizado.getIdProducto());
        if (productoEncontrado != null) {
            if (productosPorTipo.containsKey(tipoProducto)) {
                List<Producto> listaProductos = productosPorTipo.get(tipoProducto);
                for (int i = 0; i < listaProductos.size(); i++) {
                    Producto producto = listaProductos.get(i);
                    if (producto.getIdProducto() == productoActualizado.getIdProducto()) {
                        listaProductos.set(i, productoActualizado);
                        break;
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }
    public  List<Producto> obtenerProductosPorTipo(String tipoProducto) {
        return productosPorTipo.getOrDefault(tipoProducto,new ArrayList<>());
    }
    public Map<String, List<Producto>> obtenerProductos() {
        return productosPorTipo;
    }

}
