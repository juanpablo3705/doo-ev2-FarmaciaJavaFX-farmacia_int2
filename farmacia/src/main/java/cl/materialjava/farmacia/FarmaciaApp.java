package cl.materialjava.farmacia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FarmaciaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                FarmaciaApp.class.getResource(
                        "/cl/materialjava/farmacia/vista/ventana-principal.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Farmacia SaludPlus");
        stage.setScene(scene);
        stage.setMinWidth(760);
        stage.setMinHeight(480);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}