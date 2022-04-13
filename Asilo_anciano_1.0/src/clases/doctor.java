
package clases;


public class doctor extends persona{
    
    private String especialidad;
    private int cod_usuario;
    
    public doctor() {
        super();
    }

    public doctor(String especialidad, int cod_usuario) {
        this.especialidad = especialidad;
        this.cod_usuario = cod_usuario;
    }



    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }
}
