/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;
import java.sql.SQLException;
import clases.Tratamiento;
import clases.claseFichaMedica;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Insert_tratamiento extends Tratamiento{
    
    Conexion cone = new Conexion();
    
//    public boolean Insertar_tratamiento() {
//        String sql = "INSERT INTO tratamiento(\n"
//                + "	trar_codigo, trat_descripcion ,trat_fecha_inicio, trat_fecha_fin,trat_codigo_paciente   , his_observaciones)\n"
//                + "	VALUES ('" + getCodigo_tratamiento()+ "', '" + getDescripcion_tratamiento()+ "', '" + getFecha_inicio()+ "', '" + getFecha_fin()+ "', '" + getCodigo_paciente()+ "', '" + getTra_observaciones()+  "');";
//        return cone.InsertUpdateDeleteAcciones(sql);
//    }
    
    public  List<Tratamiento> lista_tratamiento(){
       String sqls = "select * from tratamiento join paciente on tratamiento.trat_codigo = paciente.paci_codigo;";
       ResultSet trata = cone.selectConsulta(sqls);
       List<Tratamiento> list_tratamiento=new ArrayList<>();
       
       try {
            while (trata.next()) {
                Tratamiento mi_trata=new Tratamiento();
                mi_trata.setCodigo_tratamiento(trata.getString("trat_codigo"));
                mi_trata.setDescripcion_tratamiento(trata.getString("trat_descripcion"));
                mi_trata.setFecha_inicio(trata.getDate("trat_fecha_inicio"));
                mi_trata.setFecha_fin(trata.getDate("trat_fecha_fin"));
                mi_trata.setCodigo_paciente(trata.getString("trat_codigo_paciente"));
//                mi_trata.setTra_observaciones(trata.getString("his_observaciones"));
                
                list_tratamiento.add(mi_trata);
                
            }
            return list_tratamiento;
       } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(trat_codigo) from tratamiento;";
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
