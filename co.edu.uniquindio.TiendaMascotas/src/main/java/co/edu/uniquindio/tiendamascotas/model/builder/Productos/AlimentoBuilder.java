package co.edu.uniquindio.tiendamascotas.model.builder.Productos;

import co.edu.uniquindio.tiendamascotas.model.builder.ProductoBuilder;
import co.edu.uniquindio.tiendamascotas.model.productos.Alimento;

public class AlimentoBuilder extends ProductoBuilder<AlimentoBuilder> {

    protected Double peso;
    protected String descripcion;

    public AlimentoBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
    public AlimentoBuilder peso(Double peso) {
        this.peso = peso;
        return this;
    }

    @Override
    protected AlimentoBuilder self() {
        return this;
    }

    public Alimento build() {
        return new Alimento(nombre,cantidad,disponible,valor,peso,descripcion);
    }

}
