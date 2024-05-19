package co.edu.uniquindio.tiendamascotas.model.productos;

import co.edu.uniquindio.tiendamascotas.model.Producto;
import co.edu.uniquindio.tiendamascotas.model.builder.Productos.AlimentoBuilder;

public class Alimento extends Producto {
    private double peso;
    private String descripcion;

    public Alimento(String nombre, int cantidad, boolean disponible, Double valor, double peso, String descripcion) {
        super(nombre, cantidad, disponible, valor);
        this.peso = peso;
        this.descripcion = descripcion;
    }
    public static AlimentoBuilder builder(){
        return new AlimentoBuilder();
    }

    public double getPeso() {
        return peso;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
