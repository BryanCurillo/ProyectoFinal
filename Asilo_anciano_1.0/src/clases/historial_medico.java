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
public class historial_medico extends persona {

    private int codigo_historial;
    private int codigo_enfermera;
    private int codigo_paciente;
    private String observaciones_historial;
//    private String fecha_actualizacion;
    private int codigo_tratamiento;
    private int codigo_ficha;

    public historial_medico() {
        super();
    }

    public historial_medico(int codigo_historial, int codigo_enfermera, int codigo_paciente, String observaciones_historial, String fecha_actualizacion, int codigo_tratamiento, int codigo_ficha) {
        this.codigo_historial = codigo_historial;
        this.codigo_enfermera = codigo_enfermera;
        this.codigo_paciente = codigo_paciente;
        this.observaciones_historial = observaciones_historial;
//        this.fecha_actualizacion = fecha_actualizacion;
        this.codigo_tratamiento = codigo_tratamiento;
        this.codigo_ficha = codigo_ficha;
    }

    public historial_medico(int codigo_historial, int codigo_enfermera, int codigo_paciente, String observaciones_historial, String fecha_actualizacion, int codigo_tratamiento, int codigo_ficha, int codigo, String cedula, String pri_nomb, String seg_nombre, String prim_apell, String seg_apelli, String correo, String genero, String fecha_Nacimiento, String direccion, String telefono, String tipo_sangre) {
        super(codigo, cedula, pri_nomb, seg_nombre, prim_apell, seg_apelli, correo, genero, fecha_Nacimiento, direccion, telefono, tipo_sangre);
        this.codigo_historial = codigo_historial;
        this.codigo_enfermera = codigo_enfermera;
        this.codigo_paciente = codigo_paciente;
        this.observaciones_historial = observaciones_historial;
//        this.fecha_actualizacion = fecha_actualizacion;
        this.codigo_tratamiento = codigo_tratamiento;
        this.codigo_ficha = codigo_ficha;
    }

    public int getCodigo_historial() {
        return codigo_historial;
    }

    public void setCodigo_historial(int codigo_historial) {
        this.codigo_historial = codigo_historial;
    }

    public int getCodigo_enfermera() {
        return codigo_enfermera;
    }

    public void setCodigo_enfermera(int codigo_enfermera) {
        this.codigo_enfermera = codigo_enfermera;
    }

    public int getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public String getObservaciones_historial() {
        return observaciones_historial;
    }

    public void setObservaciones_historial(String observaciones_historial) {
        this.observaciones_historial = observaciones_historial;
    }

    public int getCodigo_tratamiento() {
        return codigo_tratamiento;
    }

    public void setCodigo_tratamiento(int codigo_tratamiento) {
        this.codigo_tratamiento = codigo_tratamiento;
    }

    public int getCodigo_ficha() {
        return codigo_ficha;
    }

    public void setCodigo_ficha(int codigo_ficha) {
        this.codigo_ficha = codigo_ficha;
    }

}
