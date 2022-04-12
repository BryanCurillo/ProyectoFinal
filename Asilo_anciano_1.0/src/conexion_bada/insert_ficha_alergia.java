/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_bada;

import java.sql.ResultSet;
import clases.FichaAlergia;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class insert_ficha_alergia extends FichaAlergia {

    Conexion cone = new Conexion();

    public boolean InsertarFichaAlergia() {
        String sql = "INSERT INTO ficha_alergia(fa_codigo_alergia,fa_codigo_ficha)\n"
                + "VALUES (" + getCodigo_alergia() + "," + getCodigo_ficha() + ");";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<FichaAlergia> ListaFichaAlergias() {
        String sqls = "select * from ficha_alergia;";
        ResultSet resfichaAlerg = cone.selectConsulta(sqls);
        List<FichaAlergia> fichaEnfermedad = new ArrayList<>();

        try {
            while (resfichaAlerg.next()) {

                FichaAlergia mifichaAler = new FichaAlergia();

                mifichaAler.setCodigoFA(resfichaAlerg.getInt("fa_codigo"));
                mifichaAler.setCodigo_alergia(resfichaAlerg.getInt("fa_codigo_alergia"));
                mifichaAler.setCodigo_ficha(resfichaAlerg.getInt("fa_codigo_ficha"));

                fichaEnfermedad.add(mifichaAler);
            }
            return fichaEnfermedad;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigoAlergia(String alergia) {
        int codigo = 0;
        String sqls = "select aler_codigo from alergias where aler_nombre_= '" + alergia + "';";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("aler_codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

}
