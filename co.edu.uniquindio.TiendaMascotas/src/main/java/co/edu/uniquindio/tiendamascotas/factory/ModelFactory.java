package co.edu.uniquindio.tiendamascotas.factory;
import co.edu.uniquindio.tiendamascotas.model.empelados.Empleado;
import co.edu.uniquindio.tiendamascotas.model.empelados.Vendedor;
import co.edu.uniquindio.tiendamascotas.model.productos.Accesorio;
import co.edu.uniquindio.tiendamascotas.model.productos.Alimento;
import co.edu.uniquindio.tiendamascotas.model.productos.Mascota;
import co.edu.uniquindio.tiendamascotas.model.productos.Producto;
import co.edu.uniquindio.tiendamascotas.model.TiendaMascota;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;

import java.util.List;
import java.util.Map;

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
                .valor(2.000000)
                .disponible(true)
                .cantidad(1)
                .build();

        Mascota mascota2 = Mascota.builder()
                .nombre("Ronald")
                .tipoMascota(TipoMascota.AVE)
                .raza("Loro")
                .edad(2)
                .valor(150.000)
                .disponible(true)
                .cantidad(1)
                .build();

        Mascota mascota3 = Mascota.builder()
                .nombre("Coco")
                .tipoMascota(TipoMascota.PERRO)
                .raza("Pincher")
                .edad(5)
                .valor(150.000)
                .disponible(true)
                .cantidad(1)
                .build();

        Accesorio accesorio2 = Accesorio.builder()
                .nombre("shampu")
                .tipoMascota(TipoMascota.PERRO)
                .descripcion("Para perro")
                .valor(50.000)
                .disponible(true)
                .cantidad(2)
                .build();

        Accesorio accesorio3 = Accesorio.builder()
                .nombre("collar")
                .tipoMascota(TipoMascota.PERRO)
                .descripcion("Para perro")
                .valor(250.000)
                .disponible(true)
                .cantidad(4)
                .build();
        Alimento alimento1 = Alimento.builder()
                .nombre("Pedigri")
                .peso(500.0)
                .descripcion("Para perro")
                .valor(100.000)
                .disponible(true)
                .cantidad(4)
                .build();

        tiendaMascota.agregarProducto(mascota1);
        tiendaMascota.agregarProducto(mascota2);
        tiendaMascota.agregarProducto(mascota3);
        tiendaMascota.agregarProducto(accesorio3);
        tiendaMascota.agregarProducto(accesorio2);
        tiendaMascota.agregarProducto(alimento1);

        /*Creacion de Empleados*/

        Vendedor vendedor1 = Vendedor.builder()
                .cedula("12")
                .nombre("Jaime")
                .apellido("Garcia")
                .cargo("Vendedor")
                .edad("35")
                .build();

        Vendedor vendedor2 = Vendedor.builder()
                .cedula("13")
                .nombre("Norbey")
                .apellido("Casas")
                .cargo("Vendedor")
                .edad("50")
                .build();


        Vendedor vendedor3 = Vendedor.builder()
                .cedula("14")
                .nombre("Tom")
                .apellido("Talavera")
                .cargo("Vendedor")
                .edad("18")
                .build();

        Vendedor vendedor4 = Vendedor.builder()
                .cedula("15")
                .nombre("ALL")
                .apellido("Song")
                .cargo("Vendedor")
                .edad("21")
                .build();

        tiendaMascota.getListaEmpleados().add(vendedor1);
        tiendaMascota.getListaEmpleados().add(vendedor2);
        tiendaMascota.getListaEmpleados().add(vendedor3);
        tiendaMascota.getListaEmpleados().add(vendedor4);

    }

    /*Productos*/
    public Map<String, List<Producto>> obtenerProductos() { return tiendaMascota.obtenerProductos(); }
    public List<Producto> obtenerProductosPorTipo(String tipoProducto) { return tiendaMascota.obtenerProductosPorTipo(tipoProducto); }
    public boolean crearProducto(Producto producto) { return tiendaMascota.agregarProducto(producto); }
    public boolean actualizarProducto(Producto producto) { return tiendaMascota.actualizarProducto(producto); }
    public boolean eliminarProducto(Producto producto) {return tiendaMascota.eliminarProducto(producto);}

    /*Empleados*/
    public List<Empleado> obtenerEmpleados() {
        return tiendaMascota.getListaEmpleados();
    }

    public boolean agregarEmpleado(Empleado empleado) {
        return tiendaMascota.agregarEmpleado(empleado);
    }

    public boolean actualizarEmpleado(Empleado empleado, String cedulaAntigua) {
        return tiendaMascota.actualizarEmpleado(empleado, cedulaAntigua);
    }

    public boolean eliminarEmpleado(String cedula) {
        return tiendaMascota.eliminarEmpleado(cedula);
    }
}
