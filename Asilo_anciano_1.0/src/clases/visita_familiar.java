/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


/**
 *
 * @author Usuario
 */
public class visita_familiar {
    private String cod_vista;
    private String cod_paciente;
    private String cod_familiar;
    private String horario_visita;
    private String fecha_visita;

    public visita_familiar() {
    }

    public visita_familiar(String cod_vista, String cod_paciente, String cod_familiar, String horario_visita, String fecha_visita) {
        this.cod_vista = cod_vista;
        this.cod_paciente = cod_paciente;
        this.cod_familiar = cod_familiar;
        this.horario_visita = horario_visita;
        this.fecha_visita = fecha_visita;
    }

    public String getCod_vista() {
        return cod_vista;
    }

    public void setCod_vista(String cod_vista) {
        this.cod_vista = cod_vista;
    }

    public String getCod_paciente() {
        return cod_paciente;
    }

    public void setCod_paciente(String cod_paciente) {
        this.cod_paciente = cod_paciente;
    }

    public String getCod_familiar() {
        return cod_familiar;
    }

    public void setCod_familiar(String cod_familiar) {
        this.cod_familiar = cod_familiar;
    }

    public String getHorario_visita() {
        return horario_visita;
    }

    public void setHorario_visita(String horario_visita) {
        this.horario_visita = horario_visita;
    }

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

   
 
    
}
