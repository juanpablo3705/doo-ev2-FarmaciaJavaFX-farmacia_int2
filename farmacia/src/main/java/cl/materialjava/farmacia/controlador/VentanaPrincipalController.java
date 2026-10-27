package cl.materialjava.farmacia.controlador;

import cl.materialjava.farmacia.FarmaciaApp;
import cl.materialjava.farmacia.modelo.Producto;
import cl.materialjava.farmacia.vista.FormularioProductoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaPrincipalController {

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TextField txtBuscar;
    @FXML private Label lblMensaje;

    private FarmaciaController controlador;
    private ObservableList<Producto> productosVisibles;

    @FXML
    private void initialize() {
        controlador = new FarmaciaController();
        productosVisibles = FXCollections.observableArrayList();
        productosVisibles.addAll(controlador.getProductos());
        tablaProductos.setItems(productosVisibles);
    }

    @FXML
    private void buscar() {
        String texto = txtBuscar.getText().trim().toLowerCase();
        productosVisibles.clear();

        for (Producto producto : controlador.getProductos()) {
            if (producto.getNombre().toLowerCase().contains(texto)) {
                productosVisibles.add(producto);
            }
        }

        if (productosVisibles.isEmpty()) {
            mostrarMensaje("No se encontraron productos.", false);
        } else {
            mostrarMensaje("Productos encontrados: " + productosVisibles.size(), true);
        }
    }

    @FXML
    private void mostrarTodos() {
        txtBuscar.clear();
        productosVisibles.setAll(controlador.getProductos());
        mostrarMensaje("Se muestran todos los productos.", true);
    }

    @FXML
    private void abrirFormulario() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    FarmaciaApp.class.getResource(
                            "/cl/materialjava/farmacia/vista/formulario-producto.fxml"));
            Parent raiz = loader.load();

            FormularioProductoController formulario = loader.getController();
            formulario.setControlador(controlador);

            Stage ventana = new Stage();
            ventana.setTitle("Registrar producto");
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(tablaProductos.getScene().getWindow());
            ventana.setScene(new Scene(raiz));
            ventana.showAndWait();

            mostrarTodos();
        } catch (IOException ex) {
            mostrarMensaje("No se pudo abrir el formulario.", false);
        }
    }

    @FXML
    private void eliminarSeleccionado() {
        Producto seleccionado =
                tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensaje("Seleccione un producto para eliminarlo.", false);
            return;
        }
        controlador.eliminar(seleccionado);
        productosVisibles.remove(seleccionado);
        mostrarMensaje("Producto eliminado correctamente.", true);
    }

    private void mostrarMensaje(String texto, boolean correcto) {
        lblMensaje.setText(texto);
        if (correcto) {
            lblMensaje.setStyle(
                    "-fx-text-fill: #247a3b; -fx-font-weight: bold;");
        } else {
            lblMensaje.setStyle(
                    "-fx-text-fill: #b3261e; -fx-font-weight: bold;");
        }
    }
}