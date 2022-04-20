/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Bryan
 */
public class Tratamiento_MedicamentoClase {

    private int codigoTM;
    private int codigo_medicamento;
    private int codigo_tratamiento;

    public Tratamiento_MedicamentoClase() {
    }

    public Tratamiento_MedicamentoClase(int codigoTM, int codigo_medicamento, int codigo_tratamiento) {
        this.codigoTM = codigoTM;
        this.codigo_medicamento = codigo_medicamento;
        this.codigo_tratamiento = codigo_tratamiento;
    }

    public int getCodigoTM() {
        return codigoTM;
    }

    public void setCodigoTM(int codigoTM) {
        this.codigoTM = codigoTM;
    }

    public int getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(int codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public int getCodigo_tratamiento() {
        return codigo_tratamiento;
    }

    public void setCodigo_tratamiento(int codigo_tratamiento) {
        this.codigo_tratamiento = codigo_tratamiento;
    }

   
}
