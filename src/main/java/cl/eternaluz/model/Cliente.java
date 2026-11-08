package cl.eternaluz.model;

public class Cliente extends Persona {

    private String email;
    private String direccion;

    public Cliente(String rut, String nombre, String apellido,
                   String telefono, String email, String direccion) {

        super(rut, nombre, apellido, telefono);

        this.email = email;
        this.direccion = direccion;
    }

    public Cliente() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

