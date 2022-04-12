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
public class enfermedades {
    private String nombre_enfermedad;
    private int codigo_enfermedad;

    public enfermedades() {
    }

    public enfermedades(String nombre_enfermedad, int codigo_enfermedad) {
        this.nombre_enfermedad = nombre_enfermedad;
        this.codigo_enfermedad = codigo_enfermedad;
    }



    public String getNombre_enfermedad() {
        return nombre_enfermedad;
    }

    public void setNombre_enfermedad(String nombre_enfermedad) {
        this.nombre_enfermedad = nombre_enfermedad;
    }

    public int getCodigo_enfermedad() {
        return codigo_enfermedad;
    }

    public void setCodigo_enfermedad(int codigo_enfermedad) {
        this.codigo_enfermedad = codigo_enfermedad;
    }


    
}
