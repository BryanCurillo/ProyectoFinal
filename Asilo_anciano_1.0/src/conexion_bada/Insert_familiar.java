package conexion_bada;

import clases.familiar;
//import clases.paciente;
//import conexion_bada.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert_familiar extends familiar {

    Conexion cone = new Conexion();

    public boolean InsertarPersona() {
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_primer_nombre,per_segundo_nombre, per_primer_apellido,per_segundo_apellido, per_correo, per_genero, per_direccion,per_tipo_sangre,per_telefono,per_fecha_nacimiento)\n"
                + "	VALUES ('" + getCedula() + "', '" + getPri_nomb() + "', '" + getSeg_nombre() + "', '" + getPrim_apell() + "', '" + getSeg_apelli() + "', '" + getCorreo() + "', '" + getGenero() + "', '" + getDireccion() + "', '" + getTipo_sangre() + "','" + getTelefono() + "','" + getFecha_Nacimiento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public boolean InsertarFamiliar() {
        String sql = "INSERT INTO familiar(\n"
                + "	fam_cedula,fam_parentesco,fam_codigo_usuario)\n"
                + "	VALUES ('" + getCedula() + "', '" + getParectesco() + "', '" + getCod_usuario() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<familiar> ListaFamiliar() {
        String sqls = "select * from persona per, familiar fami, usuario us where per.per_cedula= fami.fam_cedula and  us.us_codigo = fam_codigo_usuario;";
        ResultSet rs = cone.selectConsulta(sqls);
        List<familiar> famili = new ArrayList<>();
        try {
            while (rs.next()) {
                familiar mi_famili = new familiar();
                //mi_famili.setCodigo(rs.getString("fam_codigo_visit"));
                mi_famili.setCodigo(rs.getString("fam_codigo"));
                mi_famili.setCedula(rs.getString("fam_cedula"));
                mi_famili.setParectesco(rs.getString("fam_parentesco"));
                mi_famili.setCod_usuario(rs.getInt("fam_codigo_usuario"));

                mi_famili.setPri_nomb(rs.getString("per_primer_nombre"));
                mi_famili.setSeg_nombre(rs.getString("per_segundo_nombre"));
                mi_famili.setPrim_apell(rs.getString("per_primer_apellido"));
                mi_famili.setSeg_apelli(rs.getString("per_segundo_apellido"));
                mi_famili.setCorreo(rs.getString("per_correo"));
                mi_famili.setGenero(rs.getString("per_genero"));
                mi_famili.setFecha_Nacimiento(rs.getString("per_fecha_nacimiento"));
                mi_famili.setDireccion(rs.getString("per_direccion"));
                mi_famili.setTelefono(rs.getString("per_telefono"));
                mi_famili.setTipo_sangre(rs.getString("per_tipo_sangre"));

                famili.add(mi_famili);
            }
            rs.close();
            return famili;
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
}
