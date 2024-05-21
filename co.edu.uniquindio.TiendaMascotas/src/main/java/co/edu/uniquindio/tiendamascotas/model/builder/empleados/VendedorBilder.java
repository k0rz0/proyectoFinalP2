package co.edu.uniquindio.tiendamascotas.model.builder.empleados;


import co.edu.uniquindio.tiendamascotas.model.empelados.Vendedor;

public class VendedorBilder extends EmpleadoBuilder<VendedorBilder> {

    @Override
    public VendedorBilder self() {
        return this;
    }
    public Vendedor build() {
        return new Vendedor(cedula, nombre, apellido, cargo, edad);
    }
}
