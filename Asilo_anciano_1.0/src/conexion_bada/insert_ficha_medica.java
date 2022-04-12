/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.FichaMedica;
import clases.paciente;
import clases.persona;
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
public class insert_ficha_medica extends FichaMedica {

    Conexion cone = new Conexion();

    public boolean InsertarFichaMedica() {
        String sql = "INSERT INTO ficha(ficha_paci_codigo,ficha_enfermera_acargo,ficha_observaciones)\n"
                + "VALUES (" + getCodigo_paciente() + "," + getCodigo_enfermera() + ",'" + getObservaciones() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<FichaMedica> ListaFichaMedica() {
        String sqls = "select * from ficha;";
        ResultSet resficha = cone.selectConsulta(sqls);
        List<FichaMedica> ficha = new ArrayList<>();

        try {
            while (resficha.next()) {

                FichaMedica mificha = new FichaMedica();

                mificha.setCodigo_ficha_medica(resficha.getInt("ficha_codigo"));
                mificha.setObservaciones(resficha.getString("ficha_observaciones"));
                mificha.setCodigo_paciente(resficha.getInt("ficha_paci_codigo"));
                mificha.setCodigo_enfermera(resficha.getInt("ficha_enfermera_acargo"));

                ficha.add(mificha);
            }
            return ficha;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(ficha_codigo) from ficha;";
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

    public int obtenerFicha() {
        int codigo = 0;
        String sqls = "select max(ficha_codigo) from ficha;";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
}
