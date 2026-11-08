package cl.eternaluz.controller;

import cl.eternaluz.model.ServicioCremacion;
import cl.eternaluz.model.ServicioFunerario;
import cl.eternaluz.model.ServicioSepultura;
import cl.eternaluz.repository.ServicioJsonDAO;
import cl.eternaluz.repository.ServicioRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtPrecioBase;

    @FXML
    private ComboBox<String> cbTipoServicio;

    @FXML
    private TextField txtLugar;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtCostoAdicional;

    private ServicioRepository servicioRepository;

    public RegistroController() {
        ServicioJsonDAO servicioDAO = new ServicioJsonDAO();
        servicioRepository = new ServicioRepository(servicioDAO);
    }

    @FXML
    public void initialize() {
        cbTipoServicio.getItems().addAll("Sepultura", "Cremación");
    }

    @FXML
    public void guardarServicio() {

        try {
            String codigo = txtCodigo.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            String fecha = txtFecha.getText().trim();
            String lugar = txtLugar.getText().trim();
            String tipo = txtTipo.getText().trim();
            String seleccion = cbTipoServicio.getValue();

            if (codigo.isEmpty() || descripcion.isEmpty()
                    || fecha.isEmpty() || txtPrecioBase.getText().isEmpty()
                    || lugar.isEmpty() || tipo.isEmpty()
                    || txtCostoAdicional.getText().isEmpty()
                    || seleccion == null) {

                mostrarAlerta("Complete todos los campos.");
                return;
            }

            double precioBase = Double.parseDouble(txtPrecioBase.getText());
            double costoAdicional = Double.parseDouble(txtCostoAdicional.getText());

            if (precioBase < 0 || costoAdicional < 0) {
                mostrarAlerta("Los precios no pueden ser negativos.");
                return;
            }

            if (servicioRepository.buscarServicio(codigo) != null) {
                mostrarAlerta("Ya existe un servicio con ese código.");
                return;
            }

            ServicioFunerario servicio;

            if (seleccion.equals("Sepultura")) {

                servicio = new ServicioSepultura(
                        codigo, descripcion, fecha, precioBase,
                        lugar, tipo, costoAdicional
                );

            } else {

                servicio = new ServicioCremacion(
                        codigo, descripcion, fecha, precioBase,
                        lugar, tipo, costoAdicional
                );
            }

            servicioRepository.guardarServicio(servicio);

            mostrarAlerta("Servicio registrado correctamente.\n"
                    + "Costo total: $" + servicio.calcularCosto());

            limpiarFormulario();

        } catch (NumberFormatException e) {
            mostrarAlerta("Ingrese valores numéricos válidos para los precios.");
        }
    }

    @FXML
    public void volver() {
        Stage ventana = (Stage) txtCodigo.getScene().getWindow();
        ventana.close();
    }

    private void limpiarFormulario() {
        txtCodigo.clear();
        txtDescripcion.clear();
        txtFecha.clear();
        txtPrecioBase.clear();
        txtLugar.clear();
        txtTipo.clear();
        txtCostoAdicional.clear();
        cbTipoServicio.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Eterna Luz");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void seleccionarTipoServicio(String tipoServicio) {
        cbTipoServicio.setValue(tipoServicio);
        cbTipoServicio.setDisable(true);
    }
}
