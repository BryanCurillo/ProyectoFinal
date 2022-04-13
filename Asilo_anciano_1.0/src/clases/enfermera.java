package clases;

public class enfermera extends persona{
    
    private String anio_experiencia;
    private int cod_usuario;

    public enfermera() {
        super();
    }

    public enfermera(String anio_experiencia, int cod_usuario) {
        this.anio_experiencia = anio_experiencia;
        this.cod_usuario = cod_usuario;
    }

    public enfermera(String anio_experiencia, int cod_usuario, int codigo, String cedula, String pri_nomb, String seg_nombre, String prim_apell, String seg_apelli, String correo, String genero, String fecha_Nacimiento, String direccion, String telefono, String tipo_sangre) {
        super(codigo, cedula, pri_nomb, seg_nombre, prim_apell, seg_apelli, correo, genero, fecha_Nacimiento, direccion, telefono, tipo_sangre);
        this.anio_experiencia = anio_experiencia;
        this.cod_usuario = cod_usuario;
    }



    public String getAnio_experiencia() {
        return anio_experiencia;
    }

    public void setAnio_experiencia(String anio_experiencia) {
        this.anio_experiencia = anio_experiencia;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

}
