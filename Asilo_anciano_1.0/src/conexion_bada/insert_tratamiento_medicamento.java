/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_bada;

import java.sql.ResultSet;
import clases.FichaAlergia;
import clases.Tratamiento_MedicamentoClase;
import clases.alergias;
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
//
//    public List<alergias> Listaalergias(int cod_ficha) {
//        String sqls = "SELECT aler_nombre_,aler_codigo FROM alergias,ficha_alergia where fa_codigo_alergia=aler_codigo and fa_codigo_ficha=" + cod_ficha + ";";
//        ResultSet rs = cone.selectConsulta(sqls);
//        List<alergias> aler = new ArrayList<>();
//        try {
//            while (rs.next()) {
//                alergias mialergia = new alergias();
//                mialergia.setCodigo_alergia(rs.getInt("aler_codigo"));
//                mialergia.setNombre_alergia(rs.getString("aler_nombre_"));
//
//                aler.add(mialergia);
//            }
////            rs.close();
//            return aler;
//        } catch (SQLException ex) {
//            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
}
