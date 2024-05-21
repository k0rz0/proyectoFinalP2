package co.edu.uniquindio.tiendamascotas.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.tiendamascotas.controller.MascotaController;
import co.edu.uniquindio.tiendamascotas.model.productos.Mascota;
import co.edu.uniquindio.tiendamascotas.model.enums.TipoMascota;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MascotaViewController {

    MascotaController mascotaController;
    Mascota mascotaSeleccionada;
    ObservableList<Mascota> listaMascotas = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        mascotaController =  new MascotaController();

        initCombo();
        initTableMascota();
        initSearch();

    }

    private void initTableMascota() {

        initDataBinding();
        obtenerMascotas();
        tableMascotas.getItems().clear();
        tableMascotas.setItems(listaMascotas);
        listenerSelection();
    }

    private void initDataBinding() {
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getIdProducto())));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoMascota().toString()));
        colRaza.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaza()));
        colEdad.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getEdad())));
    }
    private void initSearch(){
        FilteredList<Mascota> filteredData = new FilteredList<>(listaMascotas, b->true);
        txtbuscar.textProperty().addListener((ObservableList,oldValue,newValue)->{
            filteredData.setPredicate(mascotaSeleccionada ->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String loweCaseFilter = newValue.toLowerCase();
                if (mascotaSeleccionada.getNombre().toLowerCase().contains(loweCaseFilter)) {
                    return true;
                } else if (mascotaSeleccionada.getRaza().toLowerCase().contains(loweCaseFilter)){
                    return true;
                }
                return String.valueOf(mascotaSeleccionada.getIdProducto()).contains(loweCaseFilter);
            });
        });
        SortedList<Mascota> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableMascotas.comparatorProperty());
        tableMascotas.setItems(sortedData);
    }

    private void obtenerMascotas() {
        listaMascotas.clear();
        listaMascotas.addAll(mascotaController.obtenerMascotas());
    }

    private void listenerSelection() {
        tableMascotas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            mascotaSeleccionada = newSelection;
            mostrarInformacionMascota(mascotaSeleccionada);
        });
    }

    private void mostrarInformacionMascota(Mascota mascotaSeleccionada) {
        if(mascotaSeleccionada != null){
            txtNombreMascota.setText(mascotaSeleccionada.getNombre());
            txtRazaMascota.setText(mascotaSeleccionada.getRaza());
            txtEdadMascota.setText(String.valueOf(mascotaSeleccionada.getEdad()));
            cbTipoMascota.getSelectionModel().select(mascotaSeleccionada.getTipoMascota().toString());

        }
    }
    private void initCombo() {

        ObservableList<String> itemscbTipo = FXCollections.observableArrayList();
        itemscbTipo.addAll("--Seleccione--","PERRO", "GATO", "AVE");

        cbTipoMascota.setItems(itemscbTipo);
        cbTipoMascota.getSelectionModel().select("--Seleccione--");

    }




    private void limpiarCampos() {
        txtRazaMascota.setText("");
        txtEdadMascota.setText("");
        txtNombreMascota.setText("");
        cbTipoMascota.getSelectionModel().select("--Seleccione--");
    }

    @FXML
    void onLimpiar(ActionEvent event) {limpiarCampos();}
    @FXML
    void onCleanSearch(ActionEvent event) {
        txtbuscar.setText("");
    }
    private boolean validarFormulario() {
        return !txtNombreMascota.getText().isEmpty()
                && !txtEdadMascota.getText().isEmpty()
                && !txtRazaMascota.getText().isEmpty()
                && !cbTipoMascota.getValue().equalsIgnoreCase("--Seleccione--");
    }

    private Mascota construirDatosMascota() {
        return Mascota.builder()
                .nombre(txtNombreMascota.getText())
                .tipoMascota(TipoMascota.valueOf(cbTipoMascota.getValue().toUpperCase()))
                .raza(txtRazaMascota.getText())
                .edad(Integer.parseInt(txtEdadMascota.getText()))
                .build();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }


    @FXML
    void onActualizarMascota(ActionEvent event) {actualizarMascota();}

    @FXML
    void onAgregarMascota(ActionEvent event) {agregarMascota();}

    @FXML
    void onEliminarMascota(ActionEvent event) {eliminarMascota();}


    private void agregarMascota() {
        if(validarFormulario()){
            Mascota mascota = construirDatosMascota();
            if(mascotaController.crearMascota(mascota)){
                obtenerMascotas();
                mostrarMensaje("Notificación Mascota", "Mascota creado", "La Mascota se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else{
                mostrarMensaje("Notificación Mascota", "Mascota no creado", "La Mascota no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Mascota", "Mascota no creado", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }



    private void actualizarMascota() {
        if(validarFormulario()){
            Mascota mascota = construirDatosMascota();
            mascota.setIdProducto(mascotaSeleccionada.getIdProducto());
            if(mascotaController.actualizarMascota(mascota)){
                obtenerMascotas();
                mostrarMensaje("Notificación Mascota", "Mascota actualizada", "La Mascota se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else{
                mostrarMensaje("Notificación Mascota", "Mascota no actualizada", "La Mascota no se ha actualizado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Mascota", "Mascota no actualizada", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarMascota() {
        if(validarFormulario()){
            Mascota mascota = construirDatosMascota();
            mascota.setIdProducto(mascotaSeleccionada.getIdProducto());
            if(mascotaController.eliminarMascota(mascota)){
                obtenerMascotas();
                mostrarMensaje("Notificación Mascota", "Mascota eliminada", "La Mascota se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else{
                mostrarMensaje("Notificación Mascota", "Mascota no eliminada", "La Mascota no se ha eliminado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Mascota", "Mascota no eliminada", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarMascota;

    @FXML
    private Button btnAgregarMascota;

    @FXML
    private Button btnEliminarMascota;

    @FXML
    private ComboBox<String> cbTipoMascota;

    @FXML
    private TableColumn<Mascota, String> colCodigo;

    @FXML
    private TableColumn<Mascota, String> colEdad;

    @FXML
    private TableColumn<Mascota, String> colNombre;

    @FXML
    private TableColumn<Mascota, String> colRaza;

    @FXML
    private TableColumn<Mascota, String> colTipo;

    @FXML
    private TableView<Mascota> tableMascotas;

    @FXML
    private TextField txtEdadMascota;

    @FXML
    private TextField txtNombreMascota;

    @FXML
    private TextField txtRazaMascota;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField txtbuscar;

    @FXML
    private Button btnCleanSearch;


}
