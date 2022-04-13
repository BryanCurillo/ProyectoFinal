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
public class visita_familiar extends persona {
    private int cod_visita;
    private int cod_paciente_visita;
    private int cod_familiar_visita;
    private String horario_visita;
    private String fecha_visita;
    private int cod_registro_familiar;

    public visita_familiar() {
       super();
    }

    public visita_familiar(int cod_visita, int cod_paciente_visita, int cod_familiar_visita, String horario_visita, String fecha_visita, int cod_registro_familiar) {
        this.cod_visita = cod_visita;
        this.cod_paciente_visita = cod_paciente_visita;
        this.cod_familiar_visita = cod_familiar_visita;
        this.horario_visita = horario_visita;
        this.fecha_visita = fecha_visita;
        this.cod_registro_familiar = cod_registro_familiar;
    }

    public int getCod_visita() {
        return cod_visita;
    }

    public void setCod_visita(int cod_visita) {
        this.cod_visita = cod_visita;
    }

    public int getCod_paciente_visita() {
        return cod_paciente_visita;
    }

    public void setCod_paciente_visita(int cod_paciente_visita) {
        this.cod_paciente_visita = cod_paciente_visita;
    }

    public int getCod_familiar_visita() {
        return cod_familiar_visita;
    }

    public void setCod_familiar_visita(int cod_familiar_visita) {
        this.cod_familiar_visita = cod_familiar_visita;
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

    public int getCod_registro_familiar() {
        return cod_registro_familiar;
    }

    public void setCod_registro_familiar(int cod_registro_familiar) {
        this.cod_registro_familiar = cod_registro_familiar;
    }

    
}
