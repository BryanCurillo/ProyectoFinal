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
public class FichaMedica extends persona {
    private int codigo_ficha_medica;
    private int codigo_paciente;
    private int codigo_enfermera;
    private String observaciones;



    public FichaMedica() {
    }

    public FichaMedica(int codigo_ficha_medica, int codigo_paciente, int codigo_enfermera, String observaciones) {
        this.codigo_ficha_medica = codigo_ficha_medica;
        this.codigo_paciente = codigo_paciente;
        this.codigo_enfermera = codigo_enfermera;
        this.observaciones = observaciones;
    }

    public FichaMedica(int codigo_ficha_medica, int codigo_paciente, int codigo_enfermera, String observaciones, String codigo, String cedula, String pri_nomb, String seg_nombre, String prim_apell, String seg_apelli, String correo, String genero, String fecha_Nacimiento, String direccion, String telefono, String tipo_sangre) {
        super(codigo, cedula, pri_nomb, seg_nombre, prim_apell, seg_apelli, correo, genero, fecha_Nacimiento, direccion, telefono, tipo_sangre);
        this.codigo_ficha_medica = codigo_ficha_medica;
        this.codigo_paciente = codigo_paciente;
        this.codigo_enfermera = codigo_enfermera;
        this.observaciones = observaciones;
    }

    public int getCodigo_enfermera() {
        return codigo_enfermera;
    }

    public void setCodigo_enfermera(int codigo_enfermera) {
        this.codigo_enfermera = codigo_enfermera;
    }


    public int getCodigo_ficha_medica() {
        return codigo_ficha_medica;
    }

    public void setCodigo_ficha_medica(int codigo_ficha_medica) {
        this.codigo_ficha_medica = codigo_ficha_medica;
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