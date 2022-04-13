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
public class historial_medico extends persona{
    private String codigo_historial;
    private String codigo_enfermera;
    private String codigo_paciente;
    private String observaciones_historial;
    private Date fecha_actualizacion;

    public historial_medico() {
        super();
    }

    public historial_medico(String codigo_historial, String codigo_enfermera, String codigo_paciente, String observaciones_historial, Date fecha_actualizacion) {
        this.codigo_historial = codigo_historial;
        this.codigo_enfermera = codigo_enfermera;
        this.codigo_paciente = codigo_paciente;
        this.observaciones_historial = observaciones_historial;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public historial_medico(String codigo_historial, String codigo_enfermera, String codigo_paciente, String observaciones_historial, Date fecha_actualizacion, int codigo, String cedula, String pri_nomb, String seg_nombre, String prim_apell, String seg_apelli, String correo, String genero, String fecha_Nacimiento, String direccion, String telefono, String tipo_sangre) {
        super(codigo, cedula, pri_nomb, seg_nombre, prim_apell, seg_apelli, correo, genero, fecha_Nacimiento, direccion, telefono, tipo_sangre);
        this.codigo_historial = codigo_historial;
        this.codigo_enfermera = codigo_enfermera;
        this.codigo_paciente = codigo_paciente;
        this.observaciones_historial = observaciones_historial;
        this.fecha_actualizacion = fecha_actualizacion;
    }




    public String getCodigo_historial() {
        return codigo_historial;
    }

    public void setCodigo_historial(String codigo_historial) {
        this.codigo_historial = codigo_historial;
    }

    public String getCodigo_enfermera() {
        return codigo_enfermera;
    }

    public void setCodigo_enfermera(String codigo_enfermera) {
        this.codigo_enfermera = codigo_enfermera;
    }

    public String getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(String codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public String getObservaciones_historial() {
        return observaciones_historial;
    }

    public void setObservaciones_historial(String observaciones_historial) {
        this.observaciones_historial = observaciones_historial;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
    
    
           
}
