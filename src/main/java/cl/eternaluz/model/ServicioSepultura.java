package cl.eternaluz.model;

public class ServicioSepultura extends ServicioFunerario implements Contratable {

    // Atributos
    private String cementerio;
    private String tipoSepultura;
    private double costoSepultura;

    // Constructor con parametros
    public ServicioSepultura(String codigoServicio, String descripcion,
                             String fechaServicio, double precioBase,
                             String cementerio, String tipoSepultura,
                             double costoSepultura) {

        super(codigoServicio, descripcion, fechaServicio, precioBase);

        this.cementerio = cementerio;
        this.tipoSepultura = tipoSepultura;
        this.costoSepultura = costoSepultura;
    }

    // Constructor sin parametros
    public ServicioSepultura() {
        super();
    }

    // Metodo para calcular el costo
    @Override
    public double calcularCosto() {
        return getPrecioBase() + costoSepultura;
    }

    // Getters y Setters
    public String getCementerio() {
        return cementerio;
    }

    public void setCementerio(String cementerio) {
        this.cementerio = cementerio;
    }

    public String getTipoSepultura() {
        return tipoSepultura;
    }

    public void setTipoSepultura(String tipoSepultura) {
        this.tipoSepultura = tipoSepultura;
    }

    public double getCostoSepultura() {
        return costoSepultura;
    }

    public void setCostoSepultura(double costoSepultura) {
        this.costoSepultura = costoSepultura;
    }

    // toString()
    @Override
    public String toString() {
        return "ServicioSepultura{" +
                "codigoServicio='" + getCodigoServicio() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", cementerio='" + cementerio + '\'' +
                ", tipoSepultura='" + tipoSepultura + '\'' +
                ", costoTotal=" + calcularCosto() +
                '}';
    }

    // Implementacion de la interfaz Contratable
    @Override
    public void contratar() {
        System.out.println("Servicio de sepultura contratado.");
    }

    @Override
    public void cancelar() {
        System.out.println("Servicio de sepultura cancelado.");
    }
}
