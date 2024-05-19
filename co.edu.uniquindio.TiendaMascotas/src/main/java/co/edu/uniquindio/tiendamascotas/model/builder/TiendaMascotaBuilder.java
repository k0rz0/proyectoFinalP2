package co.edu.uniquindio.tiendamascotas.model.builder;

import co.edu.uniquindio.tiendamascotas.model.TiendaMascota;

public class TiendaMascotaBuilder {
    protected String nombre;

    public TiendaMascotaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TiendaMascota build() {
        return new TiendaMascota(nombre);
    }

}
