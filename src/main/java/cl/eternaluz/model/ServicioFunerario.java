package cl.eternaluz.model;

public abstract class ServicioFunerario {

    // Atributos
    private String codigoServicio;
    private String descripcion;
    private String fechaServicio;
    private double precioBase;

    // Constructor con parametros
    public ServicioFunerario(String codigoServicio, String descripcion,
                             String fechaServicio, double precioBase) {

        this.codigoServicio = codigoServicio;
        this.descripcion = descripcion;
        this.fechaServicio = fechaServicio;
        this.precioBase = precioBase;
    }

    // Constructor sin parametros
    public ServicioFunerario() {
    }

    // Metodo abstracto
    public abstract double calcularCosto();

    // Getters y Setters
    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    // toString()
    @Override
    public String toString() {
        return "ServicioFunerario{" +
                "codigoServicio='" + codigoServicio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaServicio='" + fechaServicio + '\'' +
                ", precioBase=" + precioBase +
                '}';
    }
}
