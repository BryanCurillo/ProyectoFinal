/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.enfermedades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class insert_enfermedad extends enfermedades {

    Conexion cone = new Conexion();

    public boolean insert_enfermedad() {
        String sql = "INSERT INTO enfermedad(\n"
                + "enfermedad_nombre_)\n"
                + "VALUES ('" + getNombre_enfermedad() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);

    }

    public List<enfermedades> ListEnfermedad() {
        String sqls = "select * from enfermedad;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<enfermedades> enfer = new ArrayList<>();
        try {
            while (rs.next()) {
                enfermedades mienfer = new enfermedades();
                mienfer.setCodigo_enfermedad(rs.getInt("enfermedad_codigo"));
                mienfer.setNombre_enfermedad(rs.getString("enfermedad_nombre_"));
                enfer.add(mienfer);

            }
            rs.close();
            return enfer;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
        public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(enfermedad_codigo) from enfermedad;";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("max")+1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
}
