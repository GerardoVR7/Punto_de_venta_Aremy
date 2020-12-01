package Model;

public class Usuario {

    private int idUsuario;
    private String contrasena;
    private String rol;
    private  String nombre;

    public Usuario(){

    }

    public Usuario(int idUsuario, String nombre, String contrasena, String rol) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
