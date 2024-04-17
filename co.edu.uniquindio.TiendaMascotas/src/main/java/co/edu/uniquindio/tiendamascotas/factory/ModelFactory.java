package co.edu.uniquindio.tiendamascotas.factory;
import co.edu.uniquindio.tiendamascotas.model.Mascota;
import co.edu.uniquindio.tiendamascotas.model.TiendaMascota;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private TiendaMascota tiendaMascota = TiendaMascota.builder().nombre("Animals Shop").build();

    private ModelFactory(){
        inicializarDatos();
    }

    public static  ModelFactory getInstance(){
        if (modelFactory == null){
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {

        /*Creacion de Propietarios*/

        Mascota mascota1 = Mascota.builder()
                .nombre("Pepe")
                .tipoMascota(TipoMascota.GATO)
                .raza("Siamés")
                .edad(1)
                .idMascota("001")
                .build();

        Mascota mascota2 = Mascota.builder()
                .nombre("Ronald")
                .tipoMascota(TipoMascota.AVE)
                .raza("Loro")
                .edad(2)
                .idMascota("002")
                .build();

        Mascota mascota3 = Mascota.builder()
                .nombre("Coco")
                .tipoMascota(TipoMascota.PERRO)
                .raza("Pincher")
                .edad(5)
                .idMascota("003")
                .build();

        tiendaMascota.getListaMascotas().add(mascota1);
        tiendaMascota.getListaMascotas().add(mascota2);
        tiendaMascota.getListaMascotas().add(mascota3);
    }


    public List<Mascota> obtenerMascotas() {
        return tiendaMascota.getListaMascotas();
    }

    public boolean crearMascota(Mascota mascota) {
        return tiendaMascota.crearMascota(mascota);
    }

    public boolean actualizarMascota(Mascota mascota) {
        return tiendaMascota.actualizarMascota(mascota);
    }

    public boolean eliminarMascota(Mascota mascota) {
        return tiendaMascota.eliminarMascota(mascota);
    }

    public List<Mascota> obtenerMascotasPorEdad(String edad) { return tiendaMascota.obtenerMascotasPorEdad(edad); }

    public List<Mascota> obtenerMascotasPorRaza(String raza) { return tiendaMascota.obtenerMascotasPorRaza(raza);}
}
