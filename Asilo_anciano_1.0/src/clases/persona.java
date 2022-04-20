
package clases;


public class persona {
    private int codigo;
    private String cedula;
    private String pri_nomb;
    private String seg_nombre;
    private String prim_apell;
    private String seg_apelli;
    private String correo;
    private String genero;
    private String fecha_Nacimiento;
    private String direccion;
    private String telefono;
    private String tipo_sangre;
    

    public persona() {
        
    }

    public persona(int codigo, String cedula, String pri_nomb, String seg_nombre, String prim_apell, String seg_apelli, String correo, String genero, String fecha_Nacimiento, String direccion, String telefono, String tipo_sangre) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.pri_nomb = pri_nomb;
        this.seg_nombre = seg_nombre;
        this.prim_apell = prim_apell;
        this.seg_apelli = seg_apelli;
        this.correo = correo;
        this.genero = genero;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo_sangre = tipo_sangre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPri_nomb() {
        return pri_nomb;
    }

    public void setPri_nomb(String pri_nomb) {
        this.pri_nomb = pri_nomb;
    }

    public String getSeg_nombre() {
        return seg_nombre;
    }

    public void setSeg_nombre(String seg_nombre) {
        this.seg_nombre = seg_nombre;
    }

    public String getPrim_apell() {
        return prim_apell;
    }

    public void setPrim_apell(String prim_apell) {
        this.prim_apell = prim_apell;
    }

    public String getSeg_apelli() {
        return seg_apelli;
    }

    public void setSeg_apelli(String seg_apelli) {
        this.seg_apelli = seg_apelli;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

}
