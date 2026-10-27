package cl.materialjava.farmacia.vista;

import cl.materialjava.farmacia.controlador.FarmaciaController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormularioProductoController {

    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtStock;
    @FXML private TextField txtPrecio;
    @FXML private Label lblDetalle;
    @FXML private TextField txtDetalle;
    @FXML private CheckBox chkReceta;
    @FXML private Label lblError;

    private FarmaciaController controlador;

    public void setControlador(FarmaciaController controlador) {
        this.controlador = controlador;
    }

    @FXML
    private void initialize() {
        cmbTipo.getItems().addAll("Medicamento", "Cuidado personal");
        cmbTipo.setValue("Medicamento");
        actualizarCampos();
    }

    @FXML
    private void cambiarTipo() {
        actualizarCampos();
    }

    private void actualizarCampos() {
        boolean esMedicamento = "Medicamento".equals(cmbTipo.getValue());
        lblDetalle.setText(esMedicamento
                ? "Principio activo:"
                : "Marca:");
        chkReceta.setVisible(esMedicamento);
        chkReceta.setManaged(esMedicamento);
    }

    @FXML
    private void confirmar() {
        String nombre = txtNombre.getText().trim();
        String textoStock = txtStock.getText().trim();
        String textoPrecio = txtPrecio.getText().trim();
        String detalle = txtDetalle.getText().trim();

        if (nombre.isEmpty()) {
            mostrarError("El nombre es obligatorio.");
            return;
        }

        int stock;
        double precio;
        try {
            stock = Integer.parseInt(textoStock);
            precio = Double.parseDouble(textoPrecio);
        } catch (NumberFormatException ex) {
            mostrarError("Ingrese stock entero y precio numérico válido.");
            return;
        }

        if (stock < 0) {
            mostrarError("El stock no puede ser negativo.");
            return;
        }
        if (precio <= 0) {
            mostrarError("El precio debe ser mayor que cero.");
            return;
        }
        if (detalle.isEmpty()) {
            mostrarError("Complete el campo de detalle.");
            return;
        }

        try {
            if ("Medicamento".equals(cmbTipo.getValue())) {
                controlador.agregarMedicamento(
                        nombre, stock, precio, detalle, chkReceta.isSelected());
            } else {
                controlador.agregarCuidado(
                        nombre, stock, precio, detalle);
            }
            cerrar();
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    @FXML
    private void cancelar() {
        cerrar();
    }

    private void mostrarError(String texto) {
        lblError.setText(texto);
    }

    private void cerrar() {
        ((Stage) txtNombre.getScene().getWindow()).close();
    }
}