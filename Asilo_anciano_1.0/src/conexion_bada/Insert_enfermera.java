package conexion_bada;

import clases.enfermera;
import clases.usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert_enfermera extends enfermera {

    Conexion cone = new Conexion();

    public boolean InsertarPersona() {
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_primer_nombre,per_segundo_nombre, per_primer_apellido,per_segundo_apellido, per_correo, per_genero, per_direccion,per_tipo_sangre,per_telefono,per_fecha_nacimiento)\n"
                + "	VALUES ('" + getCedula() + "', '" + getPri_nomb() + "', '" + getSeg_nombre() + "', '" + getPrim_apell() + "', '" + getSeg_apelli() + "', '" + getCorreo() + "', '" + getGenero() + "', '" + getDireccion() + "', '" + getTipo_sangre() + "','" + getTelefono() + "','" + getFecha_Nacimiento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public boolean InsertarEnfermera() {
        String sql = "INSERT INTO enfermera(\n"
                + "	enfer_cedula,enfer_anio_experiencia,enfer_codigo_usuario)\n"
                + "	VALUES ('" + getCedula() + "','" + getAnio_experiencia() + "','" + getCod_usuario() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<enfermera> ListaEnfermera() {
        String sqls = "select * from persona per, enfermera enfer, usuario us where per.per_cedula= enfer.enfer_cedula and  us.us_codigo = enfer_codigo_usuario;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<enfermera> enfer = new ArrayList<>();
        try {
            while (rs.next()) {
                enfermera mi_enfer = new enfermera();
                mi_enfer.setCodigo(rs.getInt("enfer_codigo"));
                mi_enfer.setCedula(rs.getString("enfer_cedula"));
                mi_enfer.setAnio_experiencia(rs.getString("enfer_anio_experiencia"));
                mi_enfer.setCod_usuario(rs.getInt("enfer_codigo_usuario"));
                mi_enfer.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_enfer.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_enfer.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_enfer.setSeg_apelli(rs.getString("per_segundo_apellido"));
                mi_enfer.setCorreo(rs.getString("per_correo"));
                mi_enfer.setGenero(rs.getString("per_genero"));
                mi_enfer.setFecha_Nacimiento(rs.getString("per_fecha_nacimiento"));
                mi_enfer.setDireccion(rs.getString("per_direccion"));
                mi_enfer.setTelefono(rs.getString("per_telefono"));
                mi_enfer.setTipo_sangre(rs.getString("per_tipo_sangre"));

                enfer.add(mi_enfer);
            }
            rs.close();
            return enfer;
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
        String sqls = "select max(enfer_codigo) from enfermera;";
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

    public List<enfermera> ListaEnfermeraAcargo(int codigoenfermera) {
        String sqls = "select per_primer_nombre,per_segundo_nombre,per_primer_apellido,per_segundo_apellido from persona,enfermera where enfer_cedula=per_cedula and enfer_codigo=" + codigoenfermera + ";";
        ResultSet rs = cone.selectConsulta(sqls);
        List<enfermera> usu = new ArrayList<>();
        try {
            while (rs.next()) {
                enfermera mi_enferA = new enfermera();
                mi_enferA.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_enferA.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_enferA.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_enferA.setSeg_apelli(rs.getString("per_segundo_apellido"));
                usu.add(mi_enferA);
            }
//            rs.close();
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigoUSER(String cedula) {
        int codigo = 0;
        String sqls = "select enfer_codigo_usuario from enfermera where enfer_cedula ='" + cedula + "';";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("enfer_codigo_usuario");//admin_codigo_usuario
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
}
