module cl.materialjava.farmacia {
    requires javafx.controls;
    requires javafx.fxml;

    exports cl.materialjava.farmacia;
    exports cl.materialjava.farmacia.modelo;
    opens cl.materialjava.farmacia.controlador to javafx.fxml;
    opens cl.materialjava.farmacia.vista to javafx.fxml;
}