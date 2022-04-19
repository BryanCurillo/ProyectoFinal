package conexion_bada;

import clases.paciente;
import clases.persona;
import java.math.BigInteger;
//import conexion_bada.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import clases.validaciones;
import com.sun.jdi.connect.spi.Connection;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import ventanas.Agregar_paciente;

public class Insert extends paciente {

    Conexion cone = new Conexion();
    private Statement st;
    private ResultSet rs;

    public boolean InsertarPersona() {
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_primer_nombre,per_segundo_nombre, per_primer_apellido,per_segundo_apellido, per_correo, per_genero, per_direccion,per_tipo_sangre,per_telefono,per_fecha_nacimiento)\n"
                + "	VALUES ('" + getCedula() + "', '" + getPri_nomb() + "', '" + getSeg_nombre() + "', '" + getPrim_apell() + "', '" + getSeg_apelli() + "', '" + getCorreo() + "', '" + getGenero() + "', '" + getDireccion() + "', '" + getTipo_sangre() + "','" + getTelefono() + "','" + getFecha_Nacimiento() + "');";
        return cone.InsertUpdateDeleteAcciones(sql);
    }

//    public boolean InsertarPaciente() {
//        String sql = "INSERT INTO paciente(\n"
//                + "	paci_cedula,paci_seguro,paci_fecha_de_ingreso)\n"
//                + "	VALUES ('" + getCedula() + "','" + getSeguro() + "','" + getFecha_de_ingreso() + "');";
//        return cone.InsertUpdateDeleteAcciones(sql);
//    }
//    public boolean InsertarPaciente() {
//        String sql = "INSERT INTO paciente(\n"
//                + "	paci_cedula,paci_seguro,paci_fecha_de_ingreso)\n"
//                + "	VALUES ('" + getCedula() + "','" + getSeguro() + "','" + getFecha_de_ingreso() + "');";
//        return cone.InsertUpdateDeleteAcciones(sql);
//    }

    public boolean InsertarPaciente(String fecha, FileInputStream foto) {//int longitud,
        Date date = new Date();
        Boolean inserto = false;
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formatofecha.format(date);
        java.sql.Date fechasql = java.sql.Date.valueOf(fecha);
        String sql = "INSERT INTO \"paciente\"(paci_cedula, paci_seguro, paci_fecha_de_ingreso, paci_foto) VALUES (?, ?, ?,?)";
        try {
//            String sql = "INSERT INTO \"paciente\"(paci_cedula, paci_seguro, paci_fecha_de_ingreso, paci_foto) VALUES (?, ?, ?,?)";

            PreparedStatement ps = cone.getCon().prepareStatement(sql);
            // ps.setInt(1,co);

            ps.setString(1, getCedula());
            ps.setString(2, getSeguro());
            ps.setDate(3, fechasql);
            ps.setBinaryStream(4, foto);//,longitud
            ps.execute();
            ps.close();

            System.out.println("Guardado Exitosamente");
            inserto = true;
            return inserto;
        } catch (SQLException | NumberFormatException | HeadlessException x) {
            System.out.println("No ha registrado nada" + x.getLocalizedMessage());
        }           // TODO add your handling code here:
        inserto = false;
        return cone.InsertUpdateDeleteAcciones(sql);

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public boolean InsertarPaciente(String a, String b, String c, FileInputStream foto) {
//
//        Boolean inserto = false;
//        try {
//            String sql = "INSERT INTO \"paciente\"(paci_cedula, paci_seguro, paci_fecha_de_ingreso, paci_foto) VALUES (?, ?, ?,?)";
//
//            PreparedStatement ps = cone.getCon().prepareStatement(sql);
//            // ps.setInt(1,co);
//
//            ps.setString(1, a);
//            ps.setString(2, b);
//            ps.setString(3, c);
//            ps.setBinaryStream(4, foto);
//            ps.execute();
//            ps.close();
//
//            System.out.println("Guardado Exitosamente");
//            inserto = true;
//            return inserto;
//        } catch (SQLException | NumberFormatException | HeadlessException x) {
//            System.out.println("No ha registrado nada" + x.getLocalizedMessage());
//        }           // TODO add your handling code here:
//        inserto = false;
//        return inserto;
//
//    }

    public void ConsultarFoto(String cod, JLabel fotoL) {
        cone.getCon();
        String sql = "select paci_foto from \"paciente\" where paci_codigo = " + cod + ";";
        ImageIcon foto;
        InputStream is;

        try {
            ResultSet rs = cone.selectConsulta(sql);
            while (rs.next()) {
                System.out.println("si entra");
                is = rs.getBinaryStream(1);
                // nombre = rs.getString(2);

                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);

                Image img = foto.getImage();
//                Image newimg = img.getScaledInstance(Agregar_pacienteLabelFoto.getWidth(), LabelFoto.getHeight(), Image.SCALE_DEFAULT);
                Image newimg = img.getScaledInstance(118, 139, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon = new ImageIcon(newimg);

                fotoL.setIcon(newicon);
                //  txtnombre.setText(nombre);
            }
        } catch (Exception ex) {
            // JOptionPane.showMessageDialog(rootPane,"exception: "+ex);
//            System.out.println(cone.InsertUpdateDeleteAcciones(sql));
            System.out.println(ex.getSuppressed());

        }
        
    }

    public List<paciente> ListaPaciente() {
        String sqls = "select * from persona join paciente on persona.per_cedula = paciente.paci_cedula;";
        ResultSet respaci = cone.selectConsulta(sqls);
        List<paciente> paci = new ArrayList<>();

        try {
            while (respaci.next()) {

                paciente mi_paciente = new paciente();
                persona mi_persona = new persona();

//                        System.out.println("coninciden");
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
//                        resper.close();

            }
//            respaci.close();
            return paci;
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int cargarcodigo() {
        int codigo = 0;
        String sqls = "select max(paci_codigo) from paciente;";
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

//    public boolean validarduplicado(String cedula) throws SQLException {
//        boolean validar = false;
//        int codigo = 0;
//        String sqls = "select count(*) from paciente where paci_cedula='"+cedula+"';";
//        ResultSet dup = cone.selectConsulta(sqls);
////        try {catch
//            while (dup.next()) {
//                codigo = dup.getInt("count");
//            }
//        if (codigo==0) {
//            validar = true;
//        }
//        System.out.println("repetido="+codigo);
//        return validar;
//    }
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
//        System.out.println("repetido="+codigo);
//        System.out.println(codigo);
        return validar;
    }

//    public boolean validarduplicado(String cedula) {
//        boolean validar = true;
//        List<paciente> com = ListaPaciente();
//        for (int i = 0; i < com.size(); i++) {
////            System.out.println("validacionduplicado"+com.get(i).getCedula() + "===" + cedula);
//            if (com.get(i).getCedula().equalsIgnoreCase(cedula)) {
//                validar = false;
//                System.out.println(validar);
//            }
//
//        }
//
//        return validar;
//    }
}
