/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Tratamiento {

    private int codigo_tratamiento;
    private String diagnostico;
    private int codigo_medicamento;
    private String dosis;
    private String fecha_inicio_trata;
    private String fecha_fin_trata;
    private int codigo_paciente;
    private String observaciones;

    public Tratamiento() {
    }

    public Tratamiento(int codigo_tratamiento, String diagnostico, int codigo_medicamento, String dosis, String fecha_inicio_trata, String fecha_fin_trata, int codigo_paciente, String observaciones) {
        this.codigo_tratamiento = codigo_tratamiento;
        this.diagnostico = diagnostico;
        this.codigo_medicamento = codigo_medicamento;
        this.dosis = dosis;
        this.fecha_inicio_trata = fecha_inicio_trata;
        this.fecha_fin_trata = fecha_fin_trata;
        this.codigo_paciente = codigo_paciente;
        this.observaciones = observaciones;
    }

    public int getCodigo_tratamiento() {
        return codigo_tratamiento;
    }

    public void setCodigo_tratamiento(int codigo_tratamiento) {
        this.codigo_tratamiento = codigo_tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(int codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFecha_inicio_trata() {
        return fecha_inicio_trata;
    }

    public void setFecha_inicio_trata(String fecha_inicio_trata) {
        this.fecha_inicio_trata = fecha_inicio_trata;
    }

    public String getFecha_fin_trata() {
        return fecha_fin_trata;
    }

    public void setFecha_fin_trata(String fecha_fin_trata) {
        this.fecha_fin_trata = fecha_fin_trata;
    }

    public int getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
