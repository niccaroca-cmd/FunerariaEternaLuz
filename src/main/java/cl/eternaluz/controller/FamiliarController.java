package cl.eternaluz.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FamiliarController {

    @FXML
    public void seleccionarSepultura() {
        abrirRegistro("Sepultura");
    }

    @FXML
    public void seleccionarCremacion() {
        abrirRegistro("Cremación");
    }


    private void abrirRegistro(String tipoServicio) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/solicitud-familiar-view.fxml")
            );

            Scene escena = new Scene(loader.load());

            SolicitudFamiliarController controlador = loader.getController();
            controlador.establecerTipoServicio(tipoServicio);

            Stage ventana = new Stage();
            ventana.setTitle("Eterna Luz - Solicitud de servicio");
            ventana.setScene(escena);
            ventana.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void volverInicio() {
        Stage ventana = (Stage) javafx.stage.Window.getWindows()
                .stream()
                .filter(w -> w.isFocused())
                .findFirst()
                .orElse(null);

        if (ventana != null) {
            ventana.close();
        }
    }
}
