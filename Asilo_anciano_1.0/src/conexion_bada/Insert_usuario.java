package conexion_bada;

import clases.alergias;
import clases.usuario;
import conexion_bada.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
// Prueba

public class Insert_usuario extends usuario {

    Conexion cone = new Conexion();

    public boolean InsertarUsuario() {
        String sql = "INSERT INTO usuario(\n"
                + "	us_usuario,us_contrasena)\n"
                + "	VALUES ('" + getUsuario() + "','" + getContraseña() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<usuario> ListaUsuarios() {
        String sqls = "select us_usuario,us_contrasena from persona per, administrador admi, usuario us where per.per_cedula= admi.admin_cedula and  us.us_codigo = admin_codigo_usuario;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<usuario> usu = new ArrayList<>();
        try {
            while (rs.next()) {
                usuario mi_usuario = new usuario();
                mi_usuario.setUsuario(rs.getString("us_usuario"));
                mi_usuario.setContraseña(rs.getString("us_contrasena"));
                usu.add(mi_usuario);
            }
//            rs.close();
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int obtenerUsuario() {
        int codigo = 0;
        String sqls = "select max(us_codigo) from usuario;";
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
    
        public List<usuario> ListaUsuariosModi(String cod,String nombreTabla, String prefijoT) {
        int codigo = 0;
        String sqls = "select us_usuario,us_contrasena from "+nombreTabla+" p, usuario us where us.us_codigo = "+prefijoT+"_codigo_usuario and "+prefijoT+"_codigo_usuario='"+cod+"';";
        ResultSet rs = cone.selectConsulta(sqls);
        List<usuario> usu = new ArrayList<>();
        try {
            while (rs.next()) {
                usuario mi_usuario = new usuario();
                mi_usuario.setUsuario(rs.getString("us_usuario"));
                mi_usuario.setContraseña(rs.getString("us_contrasena"));
                usu.add(mi_usuario);
            }
//            rs.close();
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    
        public boolean validarNomduplicado(String usuario) throws SQLException {
        boolean validar = false;
        int codigo = 0;
        String sqls = "select count(*) from usuario where us_usuario='" + usuario + "';";
        ResultSet dup = cone.selectConsulta(sqls);
//        try {catch
        while (dup.next()) {
            codigo = dup.getInt("count");
        }
        if (codigo == 0) {
            validar = true;
        }
//        System.out.println("repetido=" + codigo);
        return validar;
    }
}

