package cl.eternaluz.controller;

import cl.eternaluz.repository.ServicioJsonDAO;
import cl.eternaluz.repository.ServicioRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class MainController {

    // Repositorio de servicios
    private ServicioRepository servicioRepository;

    // Constructor
    public MainController() {

        ServicioJsonDAO servicioDAO = new ServicioJsonDAO();

        servicioRepository = new ServicioRepository(servicioDAO);
    }

    // Registrar un servicio

    @FXML
    public void registrarServicio() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/registro-view.fxml")
            );

            Stage ventana = new Stage();
            ventana.setTitle("Eterna Luz - Registrar Servicio");
            ventana.setScene(new javafx.scene.Scene(loader.load()));
            ventana.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Consultar servicios
    @FXML
    public void consultarServicios() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Consultar servicios");
        alerta.setHeaderText(null);
        alerta.setContentText("Módulo para consultar servicios funerarios.");
        alerta.showAndWait();
    }

    // Eliminar un servicio
    @FXML
    public void eliminarServicio() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Eliminar servicio");
        alerta.setHeaderText(null);
        alerta.setContentText("Módulo para eliminar servicios funerarios.");
        alerta.showAndWait();
    }


    @FXML
    public void ingresarFamiliar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/familiar-view.fxml")
            );

            Stage ventana = new Stage();
            ventana.setTitle("Eterna Luz - Atención a familiares");
            ventana.setScene(new javafx.scene.Scene(loader.load()));
            ventana.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void ingresarTrabajador() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Eterna Luz");
        alerta.setHeaderText("Área de trabajadores");
        alerta.setContentText("Bienvenido al sistema de gestión de Eterna Luz.");
        alerta.showAndWait();
    }

}

