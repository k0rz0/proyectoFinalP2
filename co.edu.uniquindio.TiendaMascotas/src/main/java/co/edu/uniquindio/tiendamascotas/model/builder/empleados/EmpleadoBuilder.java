package co.edu.uniquindio.tiendamascotas.model.builder.empleados;


public class EmpleadoBuilder <T extends EmpleadoBuilder<T>>{

    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String cargo;
    protected String edad;

    public T cedula(String cedula){
        this.cedula = cedula;
        return self();
    }

    public T nombre(String nombre){
        this.nombre = nombre;
        return self();
    }

    public T apellido(String apellido){
        this.apellido = apellido;
        return self();
    }

    public T cargo(String cargo){
        this.cargo = cargo;
        return self();
    }

    public T edad(String edad){
        this.edad = edad;
        return self();
    }
    protected T self() {
        return (T) this;
    }
}
