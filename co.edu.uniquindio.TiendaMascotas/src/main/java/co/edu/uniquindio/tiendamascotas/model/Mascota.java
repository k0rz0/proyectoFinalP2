package co.edu.uniquindio.tiendamascotas.model;

import co.edu.uniquindio.tiendamascotas.model.builder.MascotaBuilder;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

public class Mascota {
    //Atributos
    private String nombre;
    private String raza;
    private int edad;
    private TipoMascota tipoMascota;
    private String idMascota;

    //Constructor
    public Mascota(String nombre, String raza, int edad, TipoMascota tipoMascota, String idMascota) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tipoMascota = tipoMascota;
        this.idMascota = idMascota;
    }

    public static MascotaBuilder builder(){
        return new MascotaBuilder();
    }

    public String getIdMascota() {
        return idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", tipoMascota=" + tipoMascota +
                '}';
    }

    public void mostrarHistorial(){

    }
}
