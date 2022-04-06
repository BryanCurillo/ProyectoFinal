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
    private String codigo_tratamiento;
    private String descripcion_tratamiento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String codigo_receta;
    private String codigo_paciente;

    public Tratamiento() {
    }

    public Tratamiento(String codigo_tratamiento, String descripcion_tratamiento, Date fecha_inicio, Date fecha_fin, String codigo_receta, String codigo_paciente) {
        this.codigo_tratamiento = codigo_tratamiento;
        this.descripcion_tratamiento = descripcion_tratamiento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.codigo_receta = codigo_receta;
        this.codigo_paciente = codigo_paciente;
    }

    public String getCodigo_tratamiento() {
        return codigo_tratamiento;
    }

    public void setCodigo_tratamiento(String codigo_tratamiento) {
        this.codigo_tratamiento = codigo_tratamiento;
    }

    public String getDescripcion_tratamiento() {
        return descripcion_tratamiento;
    }

    public void setDescripcion_tratamiento(String descripcion_tratamiento) {
        this.descripcion_tratamiento = descripcion_tratamiento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCodigo_receta() {
        return codigo_receta;
    }

    public void setCodigo_receta(String codigo_receta) {
        this.codigo_receta = codigo_receta;
    }

    public String getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(String codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }
   
    

 
    
    
}
