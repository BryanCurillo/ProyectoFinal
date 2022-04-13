/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;


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

    public boolean InsertarVisitaFamiliar() {
        String sql = "INSERT INTO visita(\n"
                + "	 vis_codigo_familiar,vis_codigo_paciente, vis_fecha,vis_horario_visita)\n"
                + "	VALUES ('" + getCod_familiar_visita()+ "', '" + getCod_paciente_visita()+ "', '" + getFecha_visita()+ "', '" + getHorario_visita()+"');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }
    
    public List<visita_familiar>ListaVisita(){
      String sqls = "select * from visita;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<visita_familiar> visitante = new ArrayList<>();  
        try{
            while (rs.next()){
                visita_familiar mi_familiar =  new visita_familiar();
                mi_familiar.setCod_visita(rs.getInt("vis_codigo"));
                mi_familiar.setCod_familiar_visita(rs.getInt("vis_codigo_familiar"));
                mi_familiar.setCod_paciente_visita(rs.getInt("vis_codigo_paciente"));
                mi_familiar.setFecha_visita(rs.getString("vis_fecha"));
                mi_familiar.setHorario_visita(rs.getString("vis_horario_visita"));
                mi_familiar.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_familiar.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_familiar.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_familiar.setSeg_apelli(rs.getString("per_segundo_apellido"));
                
                visitante.add(mi_familiar);
                
            }
             rs.close();
            return visitante;
        }catch (SQLException ex) {
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
