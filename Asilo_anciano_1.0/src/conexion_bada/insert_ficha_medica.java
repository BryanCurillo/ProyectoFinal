/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_bada;

import clases.claseFichaMedica;
import clases.paciente;
import clases.persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class insert_ficha_medica extends claseFichaMedica {

    Conexion cone = new Conexion();

    public boolean InsertarFichaMedica() {
        String sql = "INSERT INTO ficha(ficha_paci_codigo,ficha_enfermera_acargo,ficha_observaciones)\n"
                + "VALUES (" + getCodigo_paciente() + "," + getCodigo_enfermera() + ",'" + getObservaciones() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

    public List<claseFichaMedica> ListaFichaMedica() {
        String sqls = "select * from ficha,paciente,persona,enfermera where ficha_paci_codigo=paci_codigo and ficha_enfermera_acargo=enfer_codigo and paci_cedula=per_cedula;";

//        String sqls = "select ficha_enfermera_acargo,ficha_paci_codigo,ficha_observaciones,ficha_codigo from ficha,paciente,persona,enfermera where ficha_paci_codigo=paci_codigo and ficha_enfermera_acargo=enfer_codigo and paci_cedula=per_cedula;";
        ResultSet resficha = cone.selectConsulta(sqls);
        List<claseFichaMedica> ficha = new ArrayList<>();

        try {
            while (resficha.next()) {

                claseFichaMedica mificha = new claseFichaMedica();

                mificha.setCodigo_ficha_medica(resficha.getInt("ficha_codigo"));
                mificha.setObservaciones(resficha.getString("ficha_observaciones"));
                mificha.setCodigo_paciente(resficha.getInt("ficha_paci_codigo"));
                mificha.setCodigo_enfermera(resficha.getInt("ficha_enfermera_acargo"));
                mificha.setCedula(resficha.getString("paci_cedula"));
                mificha.setPri_nomb(resficha.getString("per_primer_nombre"));
                mificha.setSeg_nombre(resficha.getString("per_segundo_nombre"));
                mificha.setPrim_apell(resficha.getString("per_primer_apellido"));
                mificha.setSeg_apelli(resficha.getString("per_segundo_apellido"));
                mificha.setCorreo(resficha.getString("per_correo"));
                mificha.setGenero(resficha.getString("per_genero"));
                mificha.setDireccion(resficha.getString("per_direccion"));
                mificha.setTipo_sangre(resficha.getString("per_tipo_sangre"));
                mificha.setTelefono(resficha.getString("per_telefono"));
                mificha.setFecha_Nacimiento(resficha.getString("per_fecha_nacimiento"));
                mificha.setSeguro(resficha.getString("paci_seguro"));
                mificha.setFecha_de_ingreso(resficha.getString("paci_fecha_de_ingreso"));
                ficha.add(mificha);
            }
            return ficha;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(ficha_codigo) from ficha;";
        ResultSet ru = cone.selectConsulta(sqls);
        try {
            while (ru.next()) {
                codigo = ru.getInt("max") + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(codigo);
        return codigo;
    }

    public int obtenerFicha() {
        int codigo = 0;
        String sqls = "select max(ficha_codigo) from ficha;";
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

    public boolean validarduplicado(int codigo) throws SQLException {
        boolean validar = false;
        int count = 0;
        String sqls = "select count(*) from ficha where ficha_paci_codigo=" + codigo + ";";
        ResultSet dup = cone.selectConsulta(sqls);
//        try {catch
        while (dup.next()) {
            count = dup.getInt("count");
        }
        if (count == 0) {
            validar = true;
        }
        System.out.println("repetido=" + codigo);
        return validar;
    }
    


}
