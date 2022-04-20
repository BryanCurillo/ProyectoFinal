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
public class medicamentos {

    private int codigo_medicamento;
    private String nombre_medicamento;

    public medicamentos() {
    }

    public medicamentos(int codigo_medicamento, String nombre_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
        this.nombre_medicamento = nombre_medicamento;
    }

    public int getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(int codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

}
