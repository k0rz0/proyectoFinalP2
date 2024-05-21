package co.edu.uniquindio.tiendamascotas.model;

import co.edu.uniquindio.tiendamascotas.model.builder.TiendaMascotaBuilder;
import co.edu.uniquindio.tiendamascotas.model.empelados.Empleado;
import co.edu.uniquindio.tiendamascotas.model.productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiendaMascota {
    private String nombre;
    private Map<String, List<Producto>> productosPorTipo;
    private List<Empleado> listaEmpleados = new ArrayList<>();



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

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
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
        if (productoEncontrado != null) {
            String tipoProducto = nuevoProducto.getClass().getSimpleName();
            if (productosPorTipo.containsKey(tipoProducto)) {
                productosPorTipo.get(tipoProducto).remove(productoEncontrado);
                return true;
            } else {
                // Añadir alerta para cuando el tipo de producto no existe en el mapa
                return false;
            }
        } else {
            // Alerte para cuando el producto no se encontró
            return false;
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

    public boolean agregarEmpleado(Empleado empleado) {
        boolean bandera = true;

        for (Empleado empleado2 : listaEmpleados){
            if (empleado.getCedula().equalsIgnoreCase(empleado2.getCedula())){
                bandera = false;
                break;
            }
        }

        if (bandera){
            listaEmpleados.add(empleado);
            bandera = true;
        }

        return bandera;
    }

    public boolean actualizarEmpleado(Empleado empleado, String cedulaAntigua) {
        boolean bandera = false;

        for (Empleado empleado2 : listaEmpleados){
            if (cedulaAntigua.equalsIgnoreCase(empleado2.getCedula())){

                listaEmpleados.remove(empleado2);
                listaEmpleados.add(empleado);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    public boolean eliminarEmpleado(String cedula) {
        boolean bandera = false;
        for (Empleado empleado : listaEmpleados){
            if (cedula.equalsIgnoreCase(empleado.getCedula())){
                listaEmpleados.remove(empleado);
                bandera = true;
                break;
            }
        }
        return bandera;
    }
}
