package clases;

/**
 *
 * @author Bryan
 */
public class usuario {

    private String usuario;
    private String contraseña;
    private int codigo_usuario;

    public usuario() {
    }

    public usuario(String usuario, String contraseña, int codigo_usuario) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codigo_usuario = codigo_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }
}
