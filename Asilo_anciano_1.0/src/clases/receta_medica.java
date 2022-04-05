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
public class receta_medica {
    private String codigo_receta;
    private String dosis_medicamento;
    private String codigo_medicamento;

    public receta_medica() {
    }

    public receta_medica(String codigo_receta, String dosis_medicamento, String codigo_medicamento) {
        this.codigo_receta = codigo_receta;
        this.dosis_medicamento = dosis_medicamento;
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getCodigo_receta() {
        return codigo_receta;
    }

    public void setCodigo_receta(String codigo_receta) {
        this.codigo_receta = codigo_receta;
    }

    public String getDosis_medicamento() {
        return dosis_medicamento;
    }

    public void setDosis_medicamento(String dosis_medicamento) {
        this.dosis_medicamento = dosis_medicamento;
    }

    public String getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(String codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }
    
    
}
