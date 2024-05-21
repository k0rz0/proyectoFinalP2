package co.edu.uniquindio.tiendamascotas.controller;

import co.edu.uniquindio.tiendamascotas.factory.ModelFactory;
import co.edu.uniquindio.tiendamascotas.model.empelados.Empleado;

import java.util.List;

public class EmpleadoController {

    ModelFactory modelFactory;
    public EmpleadoController() {

        modelFactory = ModelFactory.getInstance();
    }
    public List<Empleado> obtenerEmpleados() {
        return modelFactory.obtenerEmpleados();
    }

    public boolean agregarEmpleado(Empleado empleado) {

        return modelFactory.agregarEmpleado(empleado);
    }

    public boolean actualizarEmpleado(Empleado empleado, String cedulaAntigua) {
        return modelFactory.actualizarEmpleado(empleado, cedulaAntigua);
    }

    public boolean eliminarEmpleado(String cedula) {
        return modelFactory.eliminarEmpleado(cedula);
    }
}
