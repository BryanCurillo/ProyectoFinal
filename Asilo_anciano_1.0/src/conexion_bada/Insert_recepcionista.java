package conexion_bada;

import clases.recepcionista;
//import conexion_bada.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert_recepcionista extends recepcionista {

    Conexion cone = new Conexion();

    public boolean InsertarPersona() {
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_primer_nombre,per_segundo_nombre, per_primer_apellido,per_segundo_apellido, per_correo, per_genero, per_direccion,per_tipo_sangre,per_telefono,per_fecha_nacimiento)\n"
                + "	VALUES ('" + getCedula() + "', '" + getPri_nomb() + "', '" + getSeg_nombre() + "', '" + getPrim_apell() + "', '" + getSeg_apelli() + "', '" + getCorreo() + "', '" + getGenero() + "', '" + getDireccion() + "', '" + getTipo_sangre() + "','" + getTelefono() + "','" + getFecha_Nacimiento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public boolean InsertarRecepcionista() {
        String sql = "INSERT INTO recepcionista(\n"
                + "	recep_cedula,recep_hora_ingreso,recep_hora_salida,recep_codigo_usuario)\n"
                + "	VALUES ('" + getCedula() + "', '" + getHora_ingreso() + "', '" + getHora_salida() + "', '" + getCod_usuario() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<recepcionista> ListaRecepcionista() {
        String sqls = "select * from persona per, recepcionista recep, usuario us where per.per_cedula= recep.recep_cedula and  us.us_codigo = recep_codigo_usuario;";
        ResultSet rr = cone.selectConsulta(sqls);
        List<recepcionista> recep = new ArrayList<>();
        try {
            while (rr.next()) {
                recepcionista mi_recepcionista = new recepcionista();
                mi_recepcionista.setCodigo(rr.getInt("recep_codigo"));
                mi_recepcionista.setCedula(rr.getString("recep_cedula"));
                mi_recepcionista.setHora_ingreso(rr.getString("recep_hora_ingreso"));
                mi_recepcionista.setHora_salida(rr.getString("recep_hora_salida"));
                mi_recepcionista.setCod_usuario(rr.getInt("recep_codigo_usuario"));

                mi_recepcionista.setPri_nomb(rr.getString("per_primer_nombre"));
                mi_recepcionista.setSeg_nombre(rr.getString("per_segundo_nombre"));
                mi_recepcionista.setPrim_apell(rr.getString("per_primer_apellido"));
                mi_recepcionista.setSeg_apelli(rr.getString("per_segundo_apellido"));
                mi_recepcionista.setCorreo(rr.getString("per_correo"));
                mi_recepcionista.setGenero(rr.getString("per_genero"));
                mi_recepcionista.setFecha_Nacimiento(rr.getString("per_fecha_nacimiento"));
                mi_recepcionista.setDireccion(rr.getString("per_direccion"));
                mi_recepcionista.setTelefono(rr.getString("per_telefono"));
                mi_recepcionista.setTipo_sangre(rr.getString("per_tipo_sangre"));
                recep.add(mi_recepcionista);
            }
            rr.close();
            return recep;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(recep_codigo) from recepcionista;";
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
        String sqls = "select recep_codigo_usuario from recepcionista where recep_cedula ='" + cedula + "';";
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
