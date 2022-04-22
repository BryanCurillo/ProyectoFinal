/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_bada;

import clases.FichaEnfermedad;
import clases.alergias;
import clases.enfermedades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class insert_ficha_enfermedad extends FichaEnfermedad {

    Conexion cone = new Conexion();

    public boolean InsertarFichaEnfermedad() {
        String sql = "INSERT INTO ficha_enfermedad(fe_codigo_enfermedad,fe_codigo_ficha)\n"
                + "VALUES (" + getCodigo_enfermedad() + "," + getCodigo_ficha() + ");";
        System.out.println("INSERT=" + getCodigo_enfermedad());
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<FichaEnfermedad> ListaFichaEnfermedad() {
        String sqls = "select * from ficha_alergia;";
        ResultSet resfichaAlerg = cone.selectConsulta(sqls);
        List<FichaEnfermedad> fichaEnfermedad = new ArrayList<>();

        try {
            while (resfichaAlerg.next()) {

                FichaEnfermedad mifichaAler = new FichaEnfermedad();

                mifichaAler.setCodigoFe(resfichaAlerg.getInt("fe_codigo"));
                mifichaAler.setCodigo_enfermedad(resfichaAlerg.getInt("fe_codigo_enfermedad"));
                mifichaAler.setCodigo_ficha(resfichaAlerg.getInt("fe_codigo_ficha"));

                fichaEnfermedad.add(mifichaAler);
            }
            return fichaEnfermedad;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigoEnfermedad(String enfermedad) {
        int codigo = 0;
        String sqls = "select enfermedad_codigo from enfermedad where enfermedad_nombre_= '" + enfermedad + "';";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("enfermedad_codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public List<enfermedades> ListaEnfermedades(int cod_ficha) {
        String sqls = "SELECT enfermedad_nombre_,enfermedad_codigo FROM enfermedad,ficha_enfermedad where fe_codigo_enfermedad=enfermedad_codigo and fe_codigo_ficha=" + cod_ficha + ";";
        ResultSet rs = cone.selectConsulta(sqls);
        List<enfermedades> enfermedad = new ArrayList<>();
        try {
            while (rs.next()) {
                enfermedades mienfermedad = new enfermedades();
                mienfermedad.setCodigo_enfermedad(rs.getInt("enfermedad_codigo"));
                mienfermedad.setNombre_enfermedad(rs.getString("enfermedad_nombre_"));

                enfermedad.add(mienfermedad);
            }
//            rs.close();
            return enfermedad;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
