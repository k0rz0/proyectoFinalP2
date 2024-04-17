package co.edu.uniquindio.tiendamascotas.controller;

import co.edu.uniquindio.tiendamascotas.factory.ModelFactory;
import co.edu.uniquindio.tiendamascotas.model.Mascota;
import javafx.fxml.FXML;

import java.util.List;

public class MascotaController {

    ModelFactory modelFactory;

    public MascotaController() {

        modelFactory = ModelFactory.getInstance();

    }

    public List<Mascota> obtenerMascotas() {

        return modelFactory.obtenerMascotas();
    }

    public boolean crearMascota(Mascota mascota) {
        return modelFactory.crearMascota(mascota);
    }

    public boolean actualizarMascota(Mascota mascota) {
        return modelFactory.actualizarMascota(mascota);
    }

    public boolean eliminarMascota(Mascota mascota) {
        return modelFactory.eliminarMascota(mascota);
    }

    public List<Mascota> obtenerMascotasPorEdad(String edad) {
        return modelFactory.obtenerMascotasPorEdad(edad);
    }

    public List<Mascota> obtenerMascotasPorRaza(String raza) {
        return modelFactory.obtenerMascotasPorRaza(raza);
    }
}
