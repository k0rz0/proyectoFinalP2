package co.edu.uniquindio.tiendamascotas.model.productos;

import co.edu.uniquindio.tiendamascotas.model.Producto;
import co.edu.uniquindio.tiendamascotas.model.builder.Productos.AccesorioBuilder;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

public class Accesorio extends Producto {
    private TipoMascota tipoMascota;
    private String descripcion;

    public Accesorio(String nombre, int cantidad, boolean disponible, Double valor, TipoMascota tipoMascota, String descripcion) {
        super(nombre, cantidad, disponible, valor);
        this.tipoMascota = tipoMascota;
        this.descripcion = descripcion;
    }
    public static AccesorioBuilder builder(){
        return new AccesorioBuilder();
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

