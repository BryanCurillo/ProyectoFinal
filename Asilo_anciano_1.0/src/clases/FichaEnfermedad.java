/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Bryan
 */
public class FichaEnfermedad {

    private int codigoFe;
    private int codigo_enfermedad;
    private int codigo_ficha;

    public FichaEnfermedad() {
    }

    public FichaEnfermedad(int codigoFe, int codigo_enfermedad, int codigo_ficha) {
        this.codigoFe = codigoFe;
        this.codigo_enfermedad = codigo_enfermedad;
        this.codigo_ficha = codigo_ficha;
    }

    public int getCodigoFe() {
        return codigoFe;
    }

    public void setCodigoFe(int codigoFe) {
        this.codigoFe = codigoFe;
    }

    public int getCodigo_enfermedad() {
        return codigo_enfermedad;
    }

    public void setCodigo_enfermedad(int codigo_enfermedad) {
        this.codigo_enfermedad = codigo_enfermedad;
    }

    public int getCodigo_ficha() {
        return codigo_ficha;
    }

    public void setCodigo_ficha(int codigo_ficha) {
        this.codigo_ficha = codigo_ficha;
    }


    
}
