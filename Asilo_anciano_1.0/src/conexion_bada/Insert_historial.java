/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.Tratamiento;
import clases.historial_medico;
import clases.paciente;
import clases.persona;
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
                + "	his_codigo_paciente, his_codigo_tratamiento, his_codigo_ficha)\n"
                + "	VALUES ('" + getCodigo_paciente() + "','" + getCodigo_tratamiento() + "','" + getCodigo_ficha() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<historial_medico> lista_historial() {
        String sqls = "select * from historial;";
        ResultSet trata = cone.selectConsulta(sqls);
        List<historial_medico> list_tratamiento = new ArrayList<>();

        try {
            while (trata.next()) {
                historial_medico mi_historial = new historial_medico();
                mi_historial.setCodigo_historial(trata.getInt("his_codigo"));
                mi_historial.setCodigo_paciente(trata.getInt("his_codigo_paciente"));
                mi_historial.setCodigo_tratamiento(trata.getInt("his_codigo_tratamiento"));
                mi_historial.setCodigo_ficha(trata.getInt("his_codigo_ficha"));
                mi_historial.setObservaciones_historial(trata.getString("his_observaciones"));

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

    public int obtenerCodFicha(int codpaci) {
        int codigo = 0;
        String sqls = "select ficha_codigo from ficha where ficha_paci_codigo=" + codpaci + ";";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("ficha_codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public boolean comprobarHistorial(int codpaci) {
        int cant = 0;
        boolean guardar=false;
        String sqls = "select count(*) from historial where his_codigo_paciente=" + codpaci + ";";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                cant = ru.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (cant==0) {
            guardar=true;
        }
        return guardar;
    }
    
        public boolean comprobarTratamiento(int codpaci) {
        int cant = 0;
        boolean guardar=false;
        String sqls = "select count(*) from tratamiento where trat_codigo_paciente=" + codpaci + ";";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                cant = ru.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (cant!=0) {
            guardar=true;
        }
        return guardar;
    }

    public String obtenerObservaciones(int codigo) throws SQLException {

        String observacion = "";
        String sqls = "select ficha_observaciones from ficha where ficha_paci_codigo=" + codigo + ";";
        ResultSet obs = cone.selectConsulta(sqls);
        while (obs.next()) {
            observacion = obs.getString("ficha_observaciones");
        }
        return observacion;
    }

    public List<paciente> ListaPaciente() {
        String sqls = "select * from persona join paciente on persona.per_cedula = paciente.paci_cedula;";
        ResultSet respaci = cone.selectConsulta(sqls);
        List<paciente> paci = new ArrayList<>();

        try {
            while (respaci.next()) {

                paciente mi_paciente = new paciente();
                persona mi_persona = new persona();

                mi_paciente.setCodigo(respaci.getInt("paci_codigo"));
                mi_paciente.setCedula(respaci.getString("paci_cedula"));
                mi_paciente.setSeguro(respaci.getString("paci_seguro"));
                mi_paciente.setFecha_de_ingreso(respaci.getString("paci_fecha_de_ingreso"));

                mi_paciente.setCedula(respaci.getString("per_cedula"));
                mi_paciente.setPri_nomb(respaci.getString("per_primer_nombre"));
                mi_paciente.setSeg_nombre(respaci.getString("per_segundo_nombre"));
                mi_paciente.setPrim_apell(respaci.getString("per_primer_apellido"));
                mi_paciente.setSeg_apelli(respaci.getString("per_segundo_apellido"));
                mi_paciente.setCorreo(respaci.getString("per_correo"));
                mi_paciente.setGenero(respaci.getString("per_genero"));
                mi_paciente.setDireccion(respaci.getString("per_direccion"));
                mi_paciente.setTelefono(respaci.getString("per_telefono"));
                mi_paciente.setTipo_sangre(respaci.getString("per_tipo_sangre"));
                mi_paciente.setFecha_Nacimiento(respaci.getString("per_fecha_nacimiento"));

                paci.add(mi_paciente);

            }
            return paci;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<paciente> ListaPacienteFicha() {
        String sqls = "select * from persona per ,paciente paci ,ficha where per.per_cedula = paci.paci_cedula and paci.paci_codigo=ficha.ficha_paci_codigo;";
        ResultSet respaci = cone.selectConsulta(sqls);
        List<paciente> paci = new ArrayList<>();

        try {
            while (respaci.next()) {

                paciente mi_paciente = new paciente();
                persona mi_persona = new persona();
                mi_paciente.setCodigo(respaci.getInt("paci_codigo"));
                mi_paciente.setCedula(respaci.getString("paci_cedula"));
                mi_paciente.setSeguro(respaci.getString("paci_seguro"));
                mi_paciente.setFecha_de_ingreso(respaci.getString("paci_fecha_de_ingreso"));
                mi_paciente.setCedula(respaci.getString("per_cedula"));
                mi_paciente.setPri_nomb(respaci.getString("per_primer_nombre"));
                mi_paciente.setSeg_nombre(respaci.getString("per_segundo_nombre"));
                mi_paciente.setPrim_apell(respaci.getString("per_primer_apellido"));
                mi_paciente.setSeg_apelli(respaci.getString("per_segundo_apellido"));
                mi_paciente.setCorreo(respaci.getString("per_correo"));
                mi_paciente.setGenero(respaci.getString("per_genero"));
                mi_paciente.setDireccion(respaci.getString("per_direccion"));
                mi_paciente.setTelefono(respaci.getString("per_telefono"));
                mi_paciente.setTipo_sangre(respaci.getString("per_tipo_sangre"));
                mi_paciente.setFecha_Nacimiento(respaci.getString("per_fecha_nacimiento"));

                paci.add(mi_paciente);

            }
            return paci;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
