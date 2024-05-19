package co.edu.uniquindio.tiendamascotas.model.builder.Productos;

import co.edu.uniquindio.tiendamascotas.model.builder.ProductoBuilder;
import co.edu.uniquindio.tiendamascotas.model.productos.Mascota;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

public class MascotaBuilder extends ProductoBuilder<MascotaBuilder> {
    protected String raza;
    protected int edad;
    protected TipoMascota tipoMascota;

    public MascotaBuilder raza(String raza) {
        this.raza = raza;
        return this;
    }

    public MascotaBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }
    public MascotaBuilder tipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
        return this;
    }
    @Override
    protected MascotaBuilder self() {
        return this;
    }

    public Mascota build() {
        return new Mascota(cantidad,disponible,valor,nombre,raza,edad,tipoMascota);
    }

}
