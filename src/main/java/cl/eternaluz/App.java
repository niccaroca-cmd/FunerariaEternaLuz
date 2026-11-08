package cl.eternaluz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage escenario) throws Exception {

        // Cargar la vista principal
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/main-view.fxml")
        );

        // Crear la escena
        Scene escena = new Scene(fxmlLoader.load());

        // Configurar ventana
        escenario.setTitle("Eterna Luz - Servicios Funerarios");
        escenario.setScene(escena);
        escenario.setWidth(1000);
        escenario.setHeight(700);
        escenario.show();
    }
    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
