package co.edu.uniquindio.tiendamascotas.model.builder.Productos;

public class    ProductoBuilder<T extends ProductoBuilder<T>> {
    protected String nombre;
    protected int cantidad = 0;
    protected boolean disponible;
    protected Double valor;
    public T nombre(String nombre){
        this.nombre = nombre;
        return self();
    }
    public T disponible(boolean disponible){
        this.disponible = disponible;
        return self();
    }

    public T valor(Double valor){
        this.valor = valor;
        return self();
    }
    public T cantidad(int cantidad){
        this.cantidad = cantidad;
        return self();
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }
}
