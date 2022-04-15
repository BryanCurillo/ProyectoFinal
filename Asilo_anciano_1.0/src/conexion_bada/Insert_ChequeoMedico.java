package conexion_bada;

import clases.cita_medica;
import clases.doctor;
import clases.paciente;
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
                + "	cita_codigo_paciente, cita_codigo_doctor,cita_fecha, cita_hora,cita_estado,cita_check)\n"
                + "	VALUES ('" + getCodigo_paciente() + "', '" + getCodigo_medico() + "', '" + getFecha_chequeoActual() + "', '" + getHoraChequeo() + "', '" + getEstado() + "','" + getCheck() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    //LISTAR RECEPCIONISTA
    public List<cita_medica> ListaChequeo() {
        String sqls = "Select * from cita where cita_estado = 'Si' ORDER BY cita_codigo;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<cita_medica> chequeo = new ArrayList<>();
        try {
            while (rs.next()) {
                cita_medica mi_chequeo = new cita_medica();

                mi_chequeo.setCodigo_citas(rs.getInt("cita_codigo"));
                mi_chequeo.setCodigo_paciente(rs.getInt("cita_codigo_paciente"));
                mi_chequeo.setCodigo_medico(rs.getInt("cita_codigo_doctor"));
                mi_chequeo.setFecha_chequeoActual(rs.getString("cita_fecha"));
                mi_chequeo.setHoraChequeo(rs.getString("cita_hora"));
                mi_chequeo.setEstado(rs.getString("cita_estado"));
                mi_chequeo.setCheck(rs.getString("cita_check"));

                chequeo.add(mi_chequeo);
            }
            rs.close();
            return chequeo;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<doctor> ListaChequeoDoctor(int codCita) {
        String sqls = "Select per.per_cedula, per.per_primer_nombre,per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido,doc.doc_especialidad from cita cit,doctor doc,persona per where cit.cita_estado = 'Si' and cit.cita_codigo_doctor = doc.doc_codigo and doc.doc_cedula = per.per_cedula and cit.cita_codigo = '" + codCita + "';";
        ResultSet rescheckdoctor = cone.selectConsulta(sqls);
        List<doctor> checkdoctor = new ArrayList<>();

        try {
            while (rescheckdoctor.next()) {

                doctor mi_checkdoc = new doctor();

                //mi_checkdoc.setCodigo(rescheckdoctor.getInt("doc_codigo"));
                mi_checkdoc.setCedula(rescheckdoctor.getString("per_cedula"));
                mi_checkdoc.setPri_nomb(rescheckdoctor.getString("per_primer_nombre"));
                mi_checkdoc.setSeg_nombre(rescheckdoctor.getString("per_segundo_nombre"));
                mi_checkdoc.setPrim_apell(rescheckdoctor.getString("per_primer_apellido"));
                mi_checkdoc.setSeg_apelli(rescheckdoctor.getString("per_segundo_apellido"));

                mi_checkdoc.setEspecialidad(rescheckdoctor.getString("doc_especialidad"));

                checkdoctor.add(mi_checkdoc);
            }
            return checkdoctor;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public List<paciente> ListaChequeoPaciente(int codCita) {
        String sqls = "Select per.per_cedula, per.per_primer_nombre,per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido from cita cit,paciente pac,persona per where cit.cita_estado = 'Si' and cit.cita_codigo_paciente = pac.paci_codigo and pac.paci_cedula = per.per_cedula and cit.cita_codigo = '" + codCita + "';";
        ResultSet rescheckpaciente = cone.selectConsulta(sqls);
        List<paciente> checkpaciente = new ArrayList<>();

        try {
            while (rescheckpaciente.next()) {

                paciente mi_checkpaci = new paciente();

                //mi_checkpaci.setCodigo(rescheckpaciente.getInt("paci_codigo"));
                mi_checkpaci.setCedula(rescheckpaciente.getString("per_cedula"));
                mi_checkpaci.setPri_nomb(rescheckpaciente.getString("per_primer_nombre"));
                mi_checkpaci.setSeg_nombre(rescheckpaciente.getString("per_segundo_nombre"));
                mi_checkpaci.setPrim_apell(rescheckpaciente.getString("per_primer_apellido"));
                mi_checkpaci.setSeg_apelli(rescheckpaciente.getString("per_segundo_apellido"));

                checkpaciente.add(mi_checkpaci);
            }
            return checkpaciente;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //LISTAR DOCTOR
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<doctor> ListaChequeoDoctor() {
        String sqls = "Select doc.doc_codigo,per.per_cedula,per.per_primer_nombre,per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido,doc.doc_especialidad from persona per,doctor doc,cita cit where doc.doc_cedula = per.per_cedula and doc.doc_codigo = cit.cita_codigo_doctor and cit.cita_estado = 'Si';";
        ResultSet rescheckdoctor = cone.selectConsulta(sqls);
        List<doctor> checkdoctor = new ArrayList<>();

        try {
            while (rescheckdoctor.next()) {

                doctor mi_checkdoc = new doctor();

                mi_checkdoc.setCodigo(rescheckdoctor.getInt("doc_codigo"));
                mi_checkdoc.setCedula(rescheckdoctor.getString("per_cedula"));
                mi_checkdoc.setPri_nomb(rescheckdoctor.getString("per_primer_nombre"));
                mi_checkdoc.setSeg_nombre(rescheckdoctor.getString("per_segundo_nombre"));
                mi_checkdoc.setPrim_apell(rescheckdoctor.getString("per_primer_apellido"));
                mi_checkdoc.setSeg_apelli(rescheckdoctor.getString("per_segundo_apellido"));

                mi_checkdoc.setEspecialidad(rescheckdoctor.getString("doc_especialidad"));

                checkdoctor.add(mi_checkdoc);
            }
            return checkdoctor;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<paciente> ListaChequeoPacienteDos(int codigoDoc) {
        String sqls = "Select cit.cita_codigo,pac.paci_cedula,per.per_primer_nombre,per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido,cit.cita_fecha,cit.cita_hora from cita cit, doctor doc, paciente pac, persona per where cit.cita_codigo_paciente = pac.paci_codigo and pac.paci_cedula = per.per_cedula and doc.doc_codigo = cit.cita_codigo_doctor and cit.cita_estado = 'Si' and cit.cita_check = 'Si' and cit.cita_codigo_doctor = '" + codigoDoc + "' ORDER BY cit.cita_codigo;";
        ResultSet rescheckpaciente = cone.selectConsulta(sqls);
        List<paciente> checkpaciente = new ArrayList<>();

        try {
            while (rescheckpaciente.next()) {

                paciente mi_checkpaci = new paciente();
                mi_checkpaci.setCedula(rescheckpaciente.getString("paci_cedula"));
                mi_checkpaci.setPri_nomb(rescheckpaciente.getString("per_primer_nombre"));
                mi_checkpaci.setSeg_nombre(rescheckpaciente.getString("per_segundo_nombre"));
                mi_checkpaci.setPrim_apell(rescheckpaciente.getString("per_primer_apellido"));
                mi_checkpaci.setSeg_apelli(rescheckpaciente.getString("per_segundo_apellido"));

                checkpaciente.add(mi_checkpaci);
            }
            return checkpaciente;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<cita_medica> ListaChequeoDos(int codigoDoc) {
        String sqls = "Select cit.cita_codigo,pac.paci_cedula,per.per_primer_nombre,per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido,cit.cita_fecha,cit.cita_hora from cita cit, doctor doc, paciente pac, persona per where cit.cita_codigo_paciente = pac.paci_codigo and pac.paci_cedula = per.per_cedula and doc.doc_codigo = cit.cita_codigo_doctor and cit.cita_estado = 'Si' and cit.cita_check = 'Si' and cit.cita_codigo_doctor = '" + codigoDoc + "' ORDER BY cit.cita_codigo;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<cita_medica> chequeo = new ArrayList<>();
        try {
            while (rs.next()) {
                cita_medica mi_chequeo = new cita_medica();

                mi_chequeo.setCodigo_citas(rs.getInt("cita_codigo"));
                mi_chequeo.setFecha_chequeoActual(rs.getString("cita_fecha"));
                mi_chequeo.setHoraChequeo(rs.getString("cita_hora"));

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
