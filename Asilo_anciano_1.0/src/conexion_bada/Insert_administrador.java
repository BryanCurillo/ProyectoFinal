package conexion_bada;

import clases.administrador;
import clases.usuario;
//import clases.usuario;
//import conexion_bada.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert_administrador extends administrador {

    Conexion cone = new Conexion();

    public boolean InsertarPersona() {
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_primer_nombre,per_segundo_nombre, per_primer_apellido,per_segundo_apellido, per_correo, per_genero, per_direccion,per_tipo_sangre,per_telefono,per_fecha_nacimiento)\n"
                + "	VALUES ('" + getCedula() + "', '" + getPri_nomb() + "', '" + getSeg_nombre() + "', '" + getPrim_apell() + "', '" + getSeg_apelli() + "', '" + getCorreo() + "', '" + getGenero() + "', '" + getDireccion() + "', '" + getTipo_sangre() + "','" + getTelefono() + "','" + getFecha_Nacimiento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

//    usuario miusuario = new usuario();
//    public boolean InsertarUsuario() {
//        String sql = "INSERT INTO usuario(\n"
//                + "	us_usuario,us_contraseña)\n"
//                + "	VALUES ('" + miusuario.getUsuario() + "', '" + miusuario.getContraseña() + "');";
//        return cone.InsertUpdateDeleteAcciones(sql);
//    }
    public boolean InsertarAdministrador() {
        String sql = "INSERT INTO administrador(\n"
                + "     admin_cedula, admin_nivel_educacion,admin_codigo_usuario)\n"
                + "	VALUES ('" + getCedula() + "','" + getNivel_educacion() + "','" + getCod_usuario() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<administrador> ListaAdministrador() {
        String sqls = "select * from persona per, administrador admi, usuario us where per.per_cedula= admi.admin_cedula and  us.us_codigo = admin_codigo_usuario;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<administrador> admin = new ArrayList<>();
        try {
            while (rs.next()) {
                administrador mi_admin = new administrador();
                mi_admin.setCodigo(rs.getInt("admin_codigo"));
                mi_admin.setCedula(rs.getString("admin_cedula"));
                mi_admin.setNivel_educacion(rs.getString("admin_nivel_educacion"));
                mi_admin.setCod_usuario(rs.getInt("admin_codigo_usuario"));

                mi_admin.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_admin.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_admin.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_admin.setSeg_apelli(rs.getString("per_segundo_apellido"));
                mi_admin.setCorreo(rs.getString("per_correo"));
                mi_admin.setGenero(rs.getString("per_genero"));
                mi_admin.setFecha_Nacimiento(rs.getString("per_fecha_nacimiento"));
                mi_admin.setDireccion(rs.getString("per_direccion"));
                mi_admin.setTelefono(rs.getString("per_telefono"));
                mi_admin.setTipo_sangre(rs.getString("per_tipo_sangre"));

                admin.add(mi_admin);
            }
            rs.close();
            return admin;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(admin_codigo) from administrador;";
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

    public int cargarcodigoUSER(String cedula) {
        int codigo = 0;
        String sqls = "select admin_codigo_usuario from administrador where admin_cedula ='" + cedula + "';";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("admin_codigo_usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

}
