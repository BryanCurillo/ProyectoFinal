/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.alergias;
import clases.medicamentos;
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
public class Insert_medicamento extends medicamentos {

    Conexion cone = new Conexion();

    public boolean InsertarMediacamentos() {
        String sql = "INSERT INTO medicamentos(\n"
                + "	medi_nombre_)\n"
                + "	VALUES ('" + getNombre_medicamento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<medicamentos> ListaMedicamentos() {
        String sqls = "select * from medicamentos;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<medicamentos> medicamento = new ArrayList<>();
        try {
            while (rs.next()) {
                medicamentos mi_medica = new medicamentos();
                mi_medica.setCodigo_medicamento(rs.getInt("medi_codigo"));
                mi_medica.setNombre_medicamento(rs.getString("medi_nombre_"));
                medicamento.add(mi_medica);
            }
            rs.close();
            return medicamento;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(medi_codigo) from medicamentos;";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("max") + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
}
