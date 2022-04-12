package conexion_bada;

import clases.doctor;
import clases.usuario;
//import conexion_bada.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Insert_doctor extends doctor {

    Conexion cone = new Conexion();

    public boolean InsertarPersona() {
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_primer_nombre,per_segundo_nombre, per_primer_apellido,per_segundo_apellido, per_correo, per_genero, per_direccion,per_tipo_sangre,per_telefono,per_fecha_nacimiento)\n"
                + "	VALUES ('" + getCedula() + "', '" + getPri_nomb() + "', '" + getSeg_nombre() + "', '" + getPrim_apell() + "', '" + getSeg_apelli() + "', '" + getCorreo() + "', '" + getGenero() + "', '" + getDireccion() + "', '" + getTipo_sangre() + "','" + getTelefono() + "','" + getFecha_Nacimiento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public boolean InsertarDoctor() {
        String sql = "INSERT INTO doctor(\n"
                + "	doc_cedula,doc_especialidad,doc_codigo_usuario)\n"
                + "	VALUES ('" + getCedula() + "','" + getEspecialidad() + "','" + getCod_usuario() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<doctor> ListaDoctor() {
        String sqls = "select * from persona per,doctor doc, usuario us where per.per_cedula= doc.doc_cedula and  us.us_codigo = doc_codigo_usuario;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<doctor> doc = new ArrayList<>();
        try {
            while (rs.next()) {
                doctor mi_doc = new doctor();
                mi_doc.setCodigo(rs.getString("doc_codigo"));
                mi_doc.setCedula(rs.getString("doc_cedula"));
                mi_doc.setEspecialidad(rs.getString("doc_especialidad"));
                mi_doc.setCod_usuario(rs.getInt("doc_codigo_usuario"));

                mi_doc.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_doc.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_doc.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_doc.setSeg_apelli(rs.getString("per_segundo_apellido"));
                mi_doc.setCorreo(rs.getString("per_correo"));
                mi_doc.setGenero(rs.getString("per_genero"));
                mi_doc.setFecha_Nacimiento(rs.getString("per_fecha_nacimiento"));
                mi_doc.setDireccion(rs.getString("per_direccion"));
                mi_doc.setTelefono(rs.getString("per_telefono"));
                mi_doc.setTipo_sangre(rs.getString("per_tipo_sangre"));

                doc.add(mi_doc);
            }
            rs.close();
            return doc;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean validarduplicado(String cedula) throws SQLException {
        boolean validar = false;
        int codigo = 0;
        String sqls = "select count(*) from persona where per_cedula='" + cedula + "';";
        ResultSet dup = cone.selectConsulta(sqls);
//        try {catch
        while (dup.next()) {
            codigo = dup.getInt("count");
        }
        if (codigo == 0) {
            validar = true;
        }
        
        System.out.println("repetido=" + codigo);
        return validar;
    }
    
        
    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(doc_codigo) from doctor;";
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
