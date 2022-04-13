
package clases;


public class recepcionista extends persona{
    
    private String hora_ingreso;
    private String hora_salida;
     private int cod_usuario;

    public recepcionista() {
        super();
    }

    public recepcionista(String hora_ingreso, String hora_salida, int cod_usuario) {
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.cod_usuario = cod_usuario;
    }

    public recepcionista(String hora_ingreso, String hora_salida, int cod_usuario, int codigo, String cedula, String pri_nomb, String seg_nombre, String prim_apell, String seg_apelli, String correo, String genero, String fecha_Nacimiento, String direccion, String telefono, String tipo_sangre) {
        super(codigo, cedula, pri_nomb, seg_nombre, prim_apell, seg_apelli, correo, genero, fecha_Nacimiento, direccion, telefono, tipo_sangre);
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.cod_usuario = cod_usuario;
    }


    

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

   
}
