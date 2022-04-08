package clases;

public class familiar extends persona {

    private String parectesco;
    private int codigo_paciente;
    private int cod_usuario;

    public familiar() {
        super();
    }

    public familiar(String parectesco, int cod_usuario) {
        this.parectesco = parectesco;
        this.cod_usuario = cod_usuario;
    }

    public familiar(String parectesco, int codigo_paciente, int cod_usuario) {
        this.parectesco = parectesco;
        this.codigo_paciente = codigo_paciente;
        this.cod_usuario = cod_usuario;
    }




    public String getParectesco() {
        return parectesco;
    }

    public void setParectesco(String parectesco) {
        this.parectesco = parectesco;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }




    
    

}
