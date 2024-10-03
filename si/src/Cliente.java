public class Cliente {
    private String nombre;
    private String cedula;
    private String tarjeta;
    private String contraseña;

    public Cliente(String nombre, String cedula, String tarjeta, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tarjeta = tarjeta;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public String getContraseña() {
        return contraseña;
    }
}
