package co.edu.uniquindio.tiendamascotas.model.builder.Productos;

import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;
import co.edu.uniquindio.tiendamascotas.model.productos.Accesorio;

public class AccesorioBuilder extends ProductoBuilder<AccesorioBuilder> {

    protected TipoMascota tipoMascota;
    protected String descripcion;

    public AccesorioBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public AccesorioBuilder tipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
        return this;
    }
    @Override
    protected AccesorioBuilder self() {
        return this;
    }

    public Accesorio build() {
        return new Accesorio(nombre,cantidad,disponible,valor,tipoMascota,descripcion);
    }

}
