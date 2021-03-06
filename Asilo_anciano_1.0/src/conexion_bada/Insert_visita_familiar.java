/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.familiar;
import clases.paciente;
import clases.validaciones;
import clases.visita_familiar;
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
public class Insert_visita_familiar extends visita_familiar {

    Conexion cone = new Conexion();
    validaciones misvalidaciones = new validaciones();

    public boolean InsertarVisitaFamiliar() {
        String sql = "INSERT INTO visita(\n"
                + "	 vis_codigo_familiar,vis_codigo_paciente, vis_fecha,vis_horario)\n"
                + "	VALUES ('" + getCod_familiar_visita() + "', '" + getCod_paciente_visita() + "', '" + getFecha_visita() + "', '" + getHorario_visita() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<visita_familiar> ListaVisita() {
        String sqls = "Select * from visita;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<visita_familiar> visitante = new ArrayList<>();
        try {
            while (rs.next()) {
                visita_familiar mi_familiar = new visita_familiar();
                mi_familiar.setCod_visita(rs.getInt("vis_codigo"));
                mi_familiar.setCod_familiar_visita(rs.getInt("vis_codigo_familiar"));
                mi_familiar.setCod_paciente_visita(rs.getInt("vis_codigo_paciente"));

                mi_familiar.setFecha_visita(rs.getString("vis_fecha"));
                mi_familiar.setHorario_visita(rs.getString("vis_horario"));

                visitante.add(mi_familiar);

            }
            rs.close();
            return visitante;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<familiar> ListaFamiliares() {
        String sqls = "Select per.per_primer_nombre,per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido from persona per, visita visi,familiar fam Where fam.fam_codigo = visi.vis_codigo_familiar and fam.fam_cedula = per.per_cedula;";
//                String sqls = "Select * from persona per, visita visi,familiar fam Where fam.fam_codigo = visi.vis_codigo_familiar and fam.fam_cedula = per.per_cedula;";

        ResultSet rs = cone.selectConsulta(sqls);
        List<familiar> famvisitante = new ArrayList<>();
        try {
            while (rs.next()) {
                familiar mi_familiar_reg = new familiar();
                mi_familiar_reg.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_familiar_reg.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_familiar_reg.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_familiar_reg.setSeg_apelli(rs.getString("per_segundo_apellido"));
                famvisitante.add(mi_familiar_reg);
            }
            rs.close();
            return famvisitante;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<paciente> CargarPaciTabla(int cod_paci) {
        String sqls = "Select per_primer_nombre,per_segundo_nombre,per_primer_apellido,per_segundo_apellido from persona per, paciente paci Where paci_cedula = per_cedula and paci_codigo="+cod_paci+";";
//                String sqls = "Select * from persona per, visita visi,familiar fam Where fam.fam_codigo = visi.vis_codigo_familiar and fam.fam_cedula = per.per_cedula;";

        ResultSet rs = cone.selectConsulta(sqls);
        List<paciente> pacicisita = new ArrayList<>();
        try {
            while (rs.next()) {
                paciente mipaciente = new paciente();
                mipaciente.setPri_nomb(rs.getString("per_primer_nombre"));
                mipaciente.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mipaciente.setPrim_apell(rs.getString("per_primer_apellido"));
                mipaciente.setSeg_apelli(rs.getString("per_segundo_apellido"));
                pacicisita.add(mipaciente);
            }
            rs.close();
            return pacicisita;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(vis_codigo) from visita;";
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
