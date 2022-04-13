
package clases;


public class administrador extends persona {

    
    private String nivel_educacion;
    private int cod_usuario;
    
    public administrador() {
        super();
    }

    public administrador(String nivel_educacion, int cod_usuario) {
        this.nivel_educacion = nivel_educacion;
        this.cod_usuario = cod_usuario;
    }

   


    public String getNivel_educacion() {
        return nivel_educacion;
    }

    public void setNivel_educacion(String nivel_educacion) {
        this.nivel_educacion = nivel_educacion;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

}
