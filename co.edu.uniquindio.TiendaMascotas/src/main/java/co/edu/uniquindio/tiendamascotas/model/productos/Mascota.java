package co.edu.uniquindio.tiendamascotas.model.productos;

import co.edu.uniquindio.tiendamascotas.model.Producto;
import co.edu.uniquindio.tiendamascotas.model.builder.Productos.MascotaBuilder;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

public class Mascota extends Producto {
    //Atributos
    private String raza;
    private int edad;
    private TipoMascota tipoMascota;

    //Constructor


    public Mascota(int cantidad, boolean disponible, Double valor, String nombre, String raza, int edad, TipoMascota tipoMascota) {
        super(nombre, cantidad, disponible, valor);
        this.raza = raza;
        this.edad = edad;
        this.tipoMascota = tipoMascota;
    }

    public static MascotaBuilder builder(){
        return new MascotaBuilder();
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
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", tipoMascota=" + tipoMascota +
                '}';
    }

    public void mostrarHistorial(){

    }
}
