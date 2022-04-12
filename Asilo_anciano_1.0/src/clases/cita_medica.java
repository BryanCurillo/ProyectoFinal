
package clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class cita_medica {
    private String codigo_citas;
    private String codigo_paciente;
    private String codigo_medico;
    private String fecha_chequeoActual;
    private String horaChequeo;
    private String fecha_Proximochequeo;

    public cita_medica() {
    }

    public cita_medica(String codigo_citas, String codigo_paciente, String codigo_medico, String fecha_chequeoActual, String horaChequeo, String fecha_Proximochequeo) {
        this.codigo_citas = codigo_citas;
        this.codigo_paciente = codigo_paciente;
        this.codigo_medico = codigo_medico;
        this.fecha_chequeoActual = fecha_chequeoActual;
        this.horaChequeo = horaChequeo;
        this.fecha_Proximochequeo = fecha_Proximochequeo;
    }

    public String getCodigo_citas() {
        return codigo_citas;
    }

    public void setCodigo_citas(String codigo_citas) {
        this.codigo_citas = codigo_citas;
    }

    public String getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(String codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(String codigo_medico) {
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

    public String getFecha_Proximochequeo() {
        return fecha_Proximochequeo;
    }

    public void setFecha_Proximochequeo(String fecha_Proximochequeo) {
        this.fecha_Proximochequeo = fecha_Proximochequeo;
    }

    
}
