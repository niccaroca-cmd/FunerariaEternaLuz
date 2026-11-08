package cl.eternaluz.model;

public class Fallecido extends Persona {

    // Atributos
    private String fechaFallecimiento;
    private String lugarFallecimiento;

    // Constructor con parametros
    public Fallecido(String rut, String nombre, String apellido,
                     String telefono, String fechaFallecimiento,
                     String lugarFallecimiento) {

        super(rut, nombre, apellido, telefono);

        this.fechaFallecimiento = fechaFallecimiento;
        this.lugarFallecimiento = lugarFallecimiento;
    }

    // Constructor sin parametros
    public Fallecido() {
        super();
    }

    // Getters y Setters
    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getLugarFallecimiento() {
        return lugarFallecimiento;
    }

    public void setLugarFallecimiento(String lugarFallecimiento) {
        this.lugarFallecimiento = lugarFallecimiento;
    }

    // toString()
    @Override
    public String toString() {
        return "Fallecido{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", fechaFallecimiento='" + fechaFallecimiento + '\'' +
                ", lugarFallecimiento='" + lugarFallecimiento + '\'' +
                '}';
    }
}
