package co.edu.uniquindio.tiendamascotas.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendamascotas.controller.EmpleadoController;
import co.edu.uniquindio.tiendamascotas.model.empelados.Empleado;
import co.edu.uniquindio.tiendamascotas.model.empelados.Vendedor;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;
import co.edu.uniquindio.tiendamascotas.model.productos.Mascota;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EmpleadoViewController {

    EmpleadoController empleadoController;
    Empleado empleadoSeleccionado;
    ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();
    private boolean isUpdatingList = false;

    @FXML
    void initialize() {
        empleadoController = new EmpleadoController();
        initTable();
        initSearch();
    }


    private void initSearch(){

        FilteredList<Empleado> filteredData = new FilteredList<>(listaEmpleados, b->true);
        txtbuscarEmpleado.textProperty().addListener((ObservableList,oldValue,newValue)->{
            filteredData.setPredicate(empleadoSeleccionado ->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String loweCaseFilter = newValue.toLowerCase();
                if (empleadoSeleccionado.getNombre().toLowerCase().contains(loweCaseFilter)) {
                    return true;
                } else if (empleadoSeleccionado.getCedula().toLowerCase().contains(loweCaseFilter)){
                    return true;
                }
                return String.valueOf(empleadoSeleccionado.getCedula()).contains(loweCaseFilter);
            });
        });
        SortedList<Empleado> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableEmpleados.comparatorProperty());
        tableEmpleados.setItems(sortedData);
    }

    private void initTable() {
        initDataBinding();
        obtenerEmpleados();
        tableEmpleados.getItems().clear();
        tableEmpleados.setItems(listaEmpleados);
        listenerSelection();
    }

    private void initDataBinding() {
        colCedula.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCedula())));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        colEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        colCargo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCargo()));
    }


    private void obtenerEmpleados() {
        isUpdatingList = true;
        listaEmpleados.clear();
        listaEmpleados.addAll(empleadoController.obtenerEmpleados());
        isUpdatingList = false;
    }

    private void listenerSelection() {
        tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;

            if (!isUpdatingList) {
                mostrarDatosEmpleado(empleadoSeleccionado);
            }

        });
    }

    private void mostrarDatosEmpleado(Empleado empleado) {
        txtCedulaEmpleado.setText(String.valueOf(empleado.getCedula()));
        txtNombreEmpleado.setText(empleado.getNombre());
        txtApellidoEmpleado.setText(empleado.getApellido());
        txtEdadEmpleado.setText(String.valueOf(empleado.getEdad()));
        txtCargoEmpleado.setText(empleado.getCargo());
    }

    private Empleado construirDatosEmpleado() {
        return Vendedor.builder()
                .cedula(txtCedulaEmpleado.getText())
                .nombre(txtNombreEmpleado.getText())
                .apellido(txtApellidoEmpleado.getText())
                .edad(txtEdadEmpleado.getText())
                .cargo(txtCargoEmpleado.getText())
                .build();
    }
    private boolean validarFormulario() {
        return !txtNombreEmpleado.getText().isEmpty()
                && !txtEdadEmpleado.getText().isEmpty()
                && !colApellido.getText().isEmpty()
                && !txtCedulaEmpleado.getText().isEmpty()
                && !txtCargoEmpleado.getText().isEmpty();
    }

    private void limpiarCampos() {
        txtCedulaEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtApellidoEmpleado.setText("");
        txtEdadEmpleado.setText("");
        txtCargoEmpleado.setText("");
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    protected void agregarEmpleado(){
        if(validarFormulario()){
            Empleado empleado = construirDatosEmpleado();
            if(empleadoController.agregarEmpleado(empleado)){
                obtenerEmpleados();
                mostrarMensaje("Notificación Empleado", "Empleado creado", "El Empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else{
                mostrarMensaje("Notificación Empleado", "Empleado no creado", "El Empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Empleado", "Empleado no creado", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }
    private void actualizarEmpleado() {
        if (validarFormulario()) {
            Empleado empleado = construirDatosEmpleado();
            String cedulaAntigua = String.valueOf(empleadoSeleccionado.getCedula());
            if (empleadoController.actualizarEmpleado(empleado,cedulaAntigua)) {
                obtenerEmpleados();
                limpiarCampos();
                mostrarMensaje("Notificación Empleado", "Empleado actualizado", "El Empleado se ha actualizado con exito", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificación Empleado", "Empleado no actualizado", "El Empleado no se ha actualizado con exito", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Empleado", "Empleado no actualizado", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }


    private void eliminarEmpleado() {
        if (validarFormulario()) {
            String cedula = String.valueOf(empleadoSeleccionado.getCedula());
            if (empleadoController.eliminarEmpleado(cedula)) {
                obtenerEmpleados();
                limpiarCampos();
                mostrarMensaje("Notificación Empleado", "Empleado eliminado", "El Empleado se ha eliminado con exito", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificación Empleado", "Empleado no eliminado", "El Empleado no se ha eliminado con exito", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Empleado", "Empleado no eliminado", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private Button btnCleanSearch;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<Empleado, String> colApellido;

    @FXML
    private TableColumn<Empleado, String> colCargo;

    @FXML
    private TableColumn<Empleado, String> colCedula;

    @FXML
    private TableColumn<Empleado, String> colEdad;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableView<Empleado> tableEmpleados;

    @FXML
    private TextField txtApellidoEmpleado;

    @FXML
    private TextField txtCargoEmpleado;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TextField txtEdadEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtbuscarEmpleado;

    @FXML
    void onActualizarEmpleado(ActionEvent event) {
        actualizarEmpleado();
    }

    @FXML
    void onAgregarEmpleado(ActionEvent event) {
        agregarEmpleado();
    }

    @FXML
    void onCleanSearch(ActionEvent event) {
        txtbuscarEmpleado.setText("");
    }

    @FXML
    void onEliminarEmpleado(ActionEvent event) {
        eliminarEmpleado();
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampos();
    }



}
