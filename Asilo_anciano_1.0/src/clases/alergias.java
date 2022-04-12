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
public class alergias {
    private String nombre_alergia;
    private int codigo_alergia;

    public alergias() {
    }

    public alergias(String nombre_alergia, int codigo_alergia) {
        this.nombre_alergia = nombre_alergia;
        this.codigo_alergia = codigo_alergia;
    }


    public String getNombre_alergia() {
        return nombre_alergia;
    }

    public void setNombre_alergia(String nombre_alergia) {
        this.nombre_alergia = nombre_alergia;
    }

    public int getCodigo_alergia() {
        return codigo_alergia;
    }

    public void setCodigo_alergia(int codigo_alergia) {
        this.codigo_alergia = codigo_alergia;
    }


    
}
