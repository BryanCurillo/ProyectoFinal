package clases;


public class paciente extends persona{
    
    private String fecha_de_ingreso;
    private String Seguro;
    

    public paciente() {
        super();
    }

    public paciente(String fecha_de_ingreso, String Seguro) {
        this.fecha_de_ingreso = fecha_de_ingreso;
        this.Seguro = Seguro;
    }



    public String getFecha_de_ingreso() {
        return fecha_de_ingreso;
    }

    public void setFecha_de_ingreso(String fecha_de_ingreso) {
        this.fecha_de_ingreso = fecha_de_ingreso;
    }

    public String getSeguro() {
        return Seguro;
    }

    public void setSeguro(String Seguro) {
        this.Seguro = Seguro;
    }

    @Override
    public String toString() {
        return "paciente{" + "fecha_de_ingreso=" + fecha_de_ingreso + ", Seguro=" + Seguro + '}';
    }
    
}
