package co.edu.uniquindio.tiendamascotas.model.empelados;

import co.edu.uniquindio.tiendamascotas.model.builder.Productos.MascotaBuilder;
import co.edu.uniquindio.tiendamascotas.model.builder.empleados.VendedorBilder;

public class Vendedor extends Empleado {

    public Vendedor(String cedula, String nombre, String apellido, String cargo, String edad) {
        super(cedula, nombre, apellido, cargo, edad);
    }

    public static VendedorBilder builder(){
        return new VendedorBilder();
    }
}
