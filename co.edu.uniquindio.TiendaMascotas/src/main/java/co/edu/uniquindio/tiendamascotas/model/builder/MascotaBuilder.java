package co.edu.uniquindio.tiendamascotas.model.builder;

import co.edu.uniquindio.tiendamascotas.model.Mascota;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

public class MascotaBuilder {

    protected String nombre;
    protected String raza;
    protected int edad;
    protected TipoMascota tipoMascota;
    protected String idMascota;

    public MascotaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

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
    public MascotaBuilder idMascota(String idMascota) {
        this.idMascota = idMascota;
        return this;
    }

    public Mascota build() {
        return new Mascota(nombre, raza, edad, tipoMascota, idMascota);
    }

}
