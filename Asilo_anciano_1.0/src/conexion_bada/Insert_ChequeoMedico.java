package conexion_bada;

import clases.cita_medica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert_ChequeoMedico extends cita_medica {

    Conexion cone = new Conexion();

    public boolean InsertarChequeoMedico() {
        String sql = "INSERT INTO cita(\n"
                + "	cita_codigo_paciente, cita_codigo_doctor,cita_fecha, cita_hora,cita_proxima_fecha)\n"
                + "	VALUES ('" + getCodigo_paciente() + "', '" + getCodigo_medico() + "', '" + getFecha_chequeoActual() + "', '" + getHoraChequeo() + "', '" + getFecha_Proximochequeo() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<cita_medica> ListaChequeo() {
        String sqls = "select * from cita;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<cita_medica> chequeo = new ArrayList<>();
        try {
            while (rs.next()) {
                cita_medica mi_chequeo = new cita_medica();

                mi_chequeo.setCodigo_citas(rs.getString("cita_codigo"));
                mi_chequeo.setCodigo_paciente(rs.getString("cita_codigo_paciente"));
                mi_chequeo.setCodigo_medico(rs.getString("cita_codigo_doctor"));
                mi_chequeo.setFecha_chequeoActual(rs.getString("cita_fecha"));
                mi_chequeo.setHoraChequeo(rs.getString("cita_hora"));
                mi_chequeo.setFecha_Proximochequeo(rs.getString("cita_proxima_fecha"));

                chequeo.add(mi_chequeo);
            }
            rs.close();
            return chequeo;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(cita_codigo) from cita;";
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
