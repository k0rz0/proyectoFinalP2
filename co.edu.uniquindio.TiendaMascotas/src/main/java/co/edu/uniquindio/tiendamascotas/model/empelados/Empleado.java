package co.edu.uniquindio.tiendamascotas.model.empelados;

public abstract class Empleado {

    private String cedula;
    private String nombre;
    private String apellido;
    private String cargo;
    private String edad;

    Empleado(String cedula, String nombre, String apellido, String cargo, String edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cargo='" + cargo + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
