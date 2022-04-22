/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_bada;

import java.sql.ResultSet;
import clases.FichaAlergia;
import clases.Tratamiento_MedicamentoClase;
import clases.alergias;
import clases.enfermedades;
import clases.medicamentos;
//import clases.enfermera;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class insert_tratamiento_medicamento extends Tratamiento_MedicamentoClase {

    Conexion cone = new Conexion();

    public boolean InsertarTratamientoMedicamento() {
        String sql = "INSERT INTO tratamiento_medicamento(tm_codigo_tratamiento,tm_codigo_medicamento)\n"
                + "VALUES (" + getCodigo_tratamiento() + "," + getCodigo_medicamento() + ");";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<Tratamiento_MedicamentoClase> ListaTrataMedica() {
        String sqls = "select * from tratamiento_medicamento;";
        ResultSet resfichaAlerg = cone.selectConsulta(sqls);
        List<Tratamiento_MedicamentoClase> tratamedicament = new ArrayList<>();

        try {
            while (resfichaAlerg.next()) {

                Tratamiento_MedicamentoClase mitratamedi = new Tratamiento_MedicamentoClase();

                mitratamedi.setCodigoTM(resfichaAlerg.getInt("tm_codigo"));
                mitratamedi.setCodigo_medicamento(resfichaAlerg.getInt("tm_codigo_tratamiento"));
                mitratamedi.setCodigo_tratamiento(resfichaAlerg.getInt("tm_codigo_medicamento"));

                tratamedicament.add(mitratamedi);
            }
            return tratamedicament;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigoAlergia(String medicamento) {
        int codigo = 0;
        String sqls = "select medi_codigo from medicamentos where medi_nombre_= '" + medicamento + "';";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("medicamento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public String medicacion(int cod_trata) {
        String medicacion="";
        String sqls = "SELECT medi_codigo,medi_nombre_ FROM medicamentos medi,tratamiento_medicamento tm \n"
                + "where tm.tm_codigo_medicamento=medi.medi_codigo and tm_codigo_tratamiento=" + cod_trata + ";";
        ResultSet rs = cone.selectConsulta(sqls);
//        List<medicamentos> medicamentos = new ArrayList<>();
        try {
            while (rs.next()) {
//                enfermedades mimedicamento = new enfermedades();
                medicamentos mimedicamento = new medicamentos();
                mimedicamento.setCodigo_medicamento(rs.getInt("medi_codigo"));
                mimedicamento.setNombre_medicamento(rs.getString("medi_nombre_"));
                medicacion=medicacion+", "+mimedicamento.getNombre_medicamento();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicacion;
    }

}
