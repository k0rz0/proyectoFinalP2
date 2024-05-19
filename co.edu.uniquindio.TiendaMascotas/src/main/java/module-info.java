module co.edu.uniquindio.tiendamascotas.tiendamascotas {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.tiendamascotas to javafx.fxml;
    exports co.edu.uniquindio.tiendamascotas;

    opens co.edu.uniquindio.tiendamascotas.viewController;
    exports co.edu.uniquindio.tiendamascotas.viewController;

    opens co.edu.uniquindio.tiendamascotas.model;
    exports co.edu.uniquindio.tiendamascotas.model;
    exports co.edu.uniquindio.tiendamascotas.model.productos;
    opens co.edu.uniquindio.tiendamascotas.model.productos;
}