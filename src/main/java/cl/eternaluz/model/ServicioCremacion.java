package cl.eternaluz.model;

public class ServicioCremacion extends ServicioFunerario implements Contratable {

    // Atributos
    private String crematorio;
    private String tipoUrna;
    private double costoCremacion;

    // Constructor con parametros
    public ServicioCremacion(String codigoServicio, String descripcion,
                             String fechaServicio, double precioBase,
                             String crematorio, String tipoUrna,
                             double costoCremacion) {

        super(codigoServicio, descripcion, fechaServicio, precioBase);

        this.crematorio = crematorio;
        this.tipoUrna = tipoUrna;
        this.costoCremacion = costoCremacion;
    }

    // Constructor sin parametros
    public ServicioCremacion() {
        super();
    }

    // Metodo para calcular el costo
    @Override
    public double calcularCosto() {
        return getPrecioBase() + costoCremacion;
    }

    // Getters y Setters
    public String getCrematorio() {
        return crematorio;
    }

    public void setCrematorio(String crematorio) {
        this.crematorio = crematorio;
    }

    public String getTipoUrna() {
        return tipoUrna;
    }

    public void setTipoUrna(String tipoUrna) {
        this.tipoUrna = tipoUrna;
    }

    public double getCostoCremacion() {
        return costoCremacion;
    }

    public void setCostoCremacion(double costoCremacion) {
        this.costoCremacion = costoCremacion;
    }

    // toString()
    @Override
    public String toString() {
        return "ServicioCremacion{" +
                "codigoServicio='" + getCodigoServicio() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", crematorio='" + crematorio + '\'' +
                ", tipoUrna='" + tipoUrna + '\'' +
                ", costoTotal=" + calcularCosto() +
                '}';
    }

    // Implementacion de la interfaz Contratable
    @Override
    public void contratar() {
        System.out.println("Servicio de cremacion contratado.");
    }

    @Override
    public void cancelar() {
        System.out.println("Servicio de cremacion cancelado.");
    }
}
