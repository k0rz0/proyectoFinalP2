package co.edu.uniquindio.tiendamascotas.model;

import co.edu.uniquindio.tiendamascotas.model.builder.TiendaMascotaBuilder;

import java.util.ArrayList;
import java.util.List;

public class TiendaMascota {
    private String nombre;
    private List<Mascota> listaMascotas = new ArrayList<>();

    //Constructor

    public TiendaMascota(String nombre, List<Mascota> listaMascotas) {
        this.nombre = nombre;
        this.listaMascotas = listaMascotas;
    }

    //Builder
    public static TiendaMascotaBuilder builder(){
        return new TiendaMascotaBuilder();
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    private Mascota obtenerCliente(String idMascota) {
        Mascota mascota = null;
        for (Mascota mascota1: getListaMascotas()) {
            if(mascota1.getIdMascota().equalsIgnoreCase(idMascota)){
                mascota = mascota1;
                break;
            }
        }

        return mascota;
    }

    public boolean crearMascota(Mascota nuevaMascota) {

        Mascota mascotaEncontrada = obtenerCliente(nuevaMascota.getIdMascota());
        if(mascotaEncontrada == null){
            getListaMascotas().add(nuevaMascota);
            return true;
        }else{
            return  false;
        }

    }

    public boolean actualizarMascota(Mascota nuevaMascota) {

        Mascota mascotaEncontrada = obtenerCliente(nuevaMascota.getIdMascota());
        if(mascotaEncontrada != null){
            getListaMascotas().remove(mascotaEncontrada);
            getListaMascotas().add(nuevaMascota);
            return true;
        }else{
            return  false;
        }
    }

    public boolean eliminarMascota(Mascota mascotaEliminar) {

        Mascota mascotaEncontrada = obtenerCliente(mascotaEliminar.getIdMascota());
        if(mascotaEncontrada != null){
            getListaMascotas().remove(mascotaEncontrada);
            return true;
        }else{
            return  false;
        }
    }
}
