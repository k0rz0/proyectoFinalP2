package co.edu.uniquindio.tiendamascotas.controller;

import co.edu.uniquindio.tiendamascotas.factory.ModelFactory;
import co.edu.uniquindio.tiendamascotas.model.productos.Mascota;
import co.edu.uniquindio.tiendamascotas.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class MascotaController {

    ModelFactory modelFactory;

    public MascotaController() {

        modelFactory = ModelFactory.getInstance();

    }

    public List<Mascota> obtenerMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        List<Producto> productos = modelFactory.obtenerProductosPorTipo("Mascota");
        for (Producto producto : productos) {
            if (producto instanceof Mascota) {
                mascotas.add((Mascota) producto);
            }
        }
        return mascotas;
    }

    public boolean crearMascota(Mascota mascota) {
        return modelFactory.crearProducto(mascota);
    }

    public boolean actualizarMascota(Mascota mascota) {
        return modelFactory.actualizarProducto(mascota);
    }

    public boolean eliminarMascota(Mascota mascota) {
        return modelFactory.eliminarProducto(mascota);
    }
}
