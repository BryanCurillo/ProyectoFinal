/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.Tratamiento;
import clases.historial_medico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert_historial extends historial_medico {

    Conexion cone = new Conexion();

    public boolean Insertar_historial() {
        String sql = "INSERT INTO historial(\n"
                + "	his_codigo, his_codigo_paciente, his_codigo_tratamiento, his_codigo_ficha, his_observaciones)\n"
                + "	VALUES ('" + getCodigo_historial()+ "','" + getCodigo_paciente() + "','" + getCodigo_tratamiento() + "','" + getCodigo_ficha()+ "','" + getObservaciones_historial() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<historial_medico> lista_historial() {
        String sqls = "select * from historial;";
        ResultSet trata = cone.selectConsulta(sqls);
        List<historial_medico> list_tratamiento = new ArrayList<>();

        try {
            while (trata.next()) {
                historial_medico mi_historial = new historial_medico();
                mi_historial.setCodigo_historial("his_codigo");
                mi_historial.setCodigo_paciente("his_codigo_paciente");
                mi_historial.setCodigo_tratamiento("his_codigo_tratamiento");
                mi_historial.setCodigo_ficha("his_codigo_ficha");
                mi_historial.setObservaciones_historial("his_observaciones");
                
                list_tratamiento.add(mi_historial);

            }
            return list_tratamiento;
        } catch (Exception ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(his_codigo) from historial;";
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
