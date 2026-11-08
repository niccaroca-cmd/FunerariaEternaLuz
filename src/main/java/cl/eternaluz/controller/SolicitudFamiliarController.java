package cl.eternaluz.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SolicitudFamiliarController {

    @FXML private TextField txtNombreFallecido;
    @FXML private TextField txtRutFallecido;
    @FXML private TextField txtFechaFallecimiento;
    @FXML private TextField txtLugarFallecimiento;

    @FXML private TextField txtNombreFamiliar;
    @FXML private TextField txtRutFamiliar;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEmail;
    @FXML private TextField txtDireccion;

    @FXML private Label lblTipoServicio;

    private String tipoServicio;

    public void establecerTipoServicio(String tipo) {
        tipoServicio = tipo;
        lblTipoServicio.setText(tipo);
    }

    @FXML
    public void solicitarServicio() {

        if (txtNombreFallecido.getText().trim().isEmpty()
                || txtRutFallecido.getText().trim().isEmpty()
                || txtFechaFallecimiento.getText().trim().isEmpty()
                || txtLugarFallecimiento.getText().trim().isEmpty()
                || txtNombreFamiliar.getText().trim().isEmpty()
                || txtRutFamiliar.getText().trim().isEmpty()
                || txtTelefono.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()
                || txtDireccion.getText().trim().isEmpty()) {

            mostrarAlerta("Complete todos los campos para continuar.");
            return;
        }

        // Validar RUT del fallecido
        if (!rutValido(txtRutFallecido.getText())) {
            mostrarAlerta("El RUT del fallecido no es válido.");
            return;
        }

// Validar RUT del familiar
        if (!rutValido(txtRutFamiliar.getText())) {
            mostrarAlerta("El RUT del familiar no es válido.");
            return;
        }

// Validar correo electrónico
        if (!txtEmail.getText().matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            mostrarAlerta("Ingrese un correo electrónico válido.");
            return;
        }

        mostrarAlerta("Datos ingresados correctamente.\n"
                + "Servicio solicitado: " + tipoServicio);
    }

    @FXML
    public void volver() {
        Stage ventana = (Stage) txtNombreFallecido.getScene().getWindow();
        ventana.close();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Eterna Luz");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private boolean rutValido(String rut) {

        rut = rut.replace(".", "")
                .replace("-", "")
                .toUpperCase()
                .trim();

        if (!rut.matches("[0-9]{7,8}[0-9K]")) {
            return false;
        }

        String numero = rut.substring(0, rut.length() - 1);
        char digito = rut.charAt(rut.length() - 1);

        int suma = 0;
        int multiplicador = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(numero.charAt(i))
                    * multiplicador;

            multiplicador++;

            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        int resultado = 11 - (suma % 11);

        char esperado;

        if (resultado == 11) {
            esperado = '0';
        } else if (resultado == 10) {
            esperado = 'K';
        } else {
            esperado = (char) ('0' + resultado);
        }

        return digito == esperado;
    }
}

