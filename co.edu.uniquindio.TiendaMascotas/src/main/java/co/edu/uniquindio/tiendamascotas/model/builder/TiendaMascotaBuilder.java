package co.edu.uniquindio.tiendamascotas.model.builder;

import co.edu.uniquindio.tiendamascotas.model.Mascota;
import co.edu.uniquindio.tiendamascotas.model.TiendaMascota;

import java.util.ArrayList;
import java.util.List;

public class TiendaMascotaBuilder {
    protected String nombre;
    protected List<Mascota> listaMascotas = new ArrayList<>();


    public TiendaMascotaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public TiendaMascotaBuilder listaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
        return this;
    }

    public TiendaMascota build() {
        return new TiendaMascota(nombre, listaMascotas);
    }

}
