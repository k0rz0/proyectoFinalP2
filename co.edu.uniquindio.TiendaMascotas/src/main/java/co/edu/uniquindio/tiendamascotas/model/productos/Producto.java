package co.edu.uniquindio.tiendamascotas.model.productos;

public abstract class Producto {
    private int idProducto = 0;
    private String nombre;
    private int cantidad = 0;
    private boolean disponible;
    private Double valor;
    private static int contador = 0;

    //Contructor
    public Producto(String nombre, int cantidad, boolean disponible, Double valor) {
        this.idProducto = contador++;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.disponible = disponible;
        this.valor = valor;
    }
    //Get
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Double getValor() {
        return valor;
    }

}
