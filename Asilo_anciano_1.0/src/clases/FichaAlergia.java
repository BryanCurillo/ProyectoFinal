/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Bryan
 */
public class FichaAlergia {

    private int codigoFA;
    private int codigo_alergia;
    private int codigo_ficha;

    public FichaAlergia(int codigoFA, int codigo_alergia, int codigo_ficha) {
        this.codigoFA = codigoFA;
        this.codigo_alergia = codigo_alergia;
        this.codigo_ficha = codigo_ficha;
    }

    public FichaAlergia() {
    }

    public int getCodigoFA() {
        return codigoFA;
    }

    public void setCodigoFA(int codigoFA) {
        this.codigoFA = codigoFA;
    }

    public int getCodigo_alergia() {
        return codigo_alergia;
    }

    public void setCodigo_alergia(int codigo_alergia) {
        this.codigo_alergia = codigo_alergia;
    }

    public int getCodigo_ficha() {
        return codigo_ficha;
    }

    public void setCodigo_ficha(int codigo_ficha) {
        this.codigo_ficha = codigo_ficha;
    }
    
    
    
    
}
