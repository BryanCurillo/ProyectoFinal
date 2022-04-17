
package clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class cita_medica {
    private int codigo_citas;
    private int codigo_paciente;
    private int codigo_medico;
    private String fecha_chequeoActual;
    private String horaChequeo;
    private String estado;
    private String check;

    public cita_medica() {
    }

    public cita_medica(int codigo_citas, int codigo_paciente, int codigo_medico, String fecha_chequeoActual, String horaChequeo, String estado, String check) {
        this.codigo_citas = codigo_citas;
        this.codigo_paciente = codigo_paciente;
        this.codigo_medico = codigo_medico;
        this.fecha_chequeoActual = fecha_chequeoActual;
        this.horaChequeo = horaChequeo;
        this.estado = estado;
        this.check = check;
    }

    public int getCodigo_citas() {
        return codigo_citas;
    }

    public void setCodigo_citas(int codigo_citas) {
        this.codigo_citas = codigo_citas;
    }

    public int getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public int getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(int codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public String getFecha_chequeoActual() {
        return fecha_chequeoActual;
    }

    public void setFecha_chequeoActual(String fecha_chequeoActual) {
        this.fecha_chequeoActual = fecha_chequeoActual;
    }

    public String getHoraChequeo() {
        return horaChequeo;
    }

    public void setHoraChequeo(String horaChequeo) {
        this.horaChequeo = horaChequeo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

}
