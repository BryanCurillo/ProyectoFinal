/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.doctor;
import conexion_bada.Insert_familiar;
import clases.familiar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class crud_familiar extends javax.swing.JFrame {

    Insert_familiar inser = new Insert_familiar();

    public crud_familiar() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtRegresarFamiliar = new javax.swing.JButton();
        BtIngresarFamiliar = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        BtBuscarFamiliar = new javax.swing.JButton();
        BtEditarFamiliar = new javax.swing.JButton();
        BtEliminarFamiliar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFamiliar = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtRegresarFamiliar.setText("Regresar");
        BtRegresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtRegresarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        BtIngresarFamiliar.setText("INGRESAR FAMILIAR");
        BtIngresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtIngresarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));
        getContentPane().add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 150, -1));

        BtBuscarFamiliar.setText("BUSCAR FAMILIAR");
        BtBuscarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtBuscarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        BtEditarFamiliar.setText("EDITAR FAMILIAR");
        BtEditarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtEditarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));

        BtEliminarFamiliar.setText("ELIMINAR FAMILIAR");
        BtEliminarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtEliminarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 204));
        jLabel2.setText("LISTA DE FAMILIARES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        TablaFamiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cédula", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "correo", "Sexo", "Dirección", "Tipo de sangre", "Código de paciente", "Hora inicio de visita", "Hora fin de visita", "Celular", "Fecha de nacimiento", "Fecha de visita"
            }
        ));
        jScrollPane1.setViewportView(TablaFamiliar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1260, 290));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo 2.png"))); // NOI18N
        Fondo.setText("jLabel1");
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarFamiliarActionPerformed
        this.dispose();
        new inicio_frame().setVisible(true);
    }//GEN-LAST:event_BtRegresarFamiliarActionPerformed

    private void BtIngresarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarFamiliarActionPerformed
        this.dispose();
        new agregar_familiar().setVisible(true);
    }//GEN-LAST:event_BtIngresarFamiliarActionPerformed

    private void BtEliminarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarFamiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtEliminarFamiliarActionPerformed

    private void BtBuscarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarFamiliarActionPerformed
        buscar_familiar();
    }//GEN-LAST:event_BtBuscarFamiliarActionPerformed
    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaFamiliar.getModel();
        tb.setNumRows(0);
        List<familiar> com = inser.ListaFamiliar();
        com.stream().forEach(p -> {
            String[] cami = {p.getCodigo(), p.getCedula(), p.getPri_nomb(), p.getSeg_nombre(), p.getPrim_apell(), p.getSeg_apelli(), p.getCorreo(), p.getGenero(), p.getDireccion(),p.getTipo_sangre(),p.getCodigo_de_paciente(),p.getTelefono(),p.getFecha_Nacimiento()};
            tb.addRow(cami);
        });
    }
    public void buscar_familiar() {
        String cedula = text_buscar.getText();
        var pacientefiltro = new ArrayList<familiar>();

        inser.ListaFamiliar().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                pacientefiltro.add(e);
            }
        });
        String matriz[][] = new String[pacientefiltro.size()][15];
        for (int j = 0; j < pacientefiltro.size(); j++) {
            matriz[j][0] = pacientefiltro.get(j).getCodigo();
            matriz[j][1] = pacientefiltro.get(j).getCedula();
            matriz[j][2] = pacientefiltro.get(j).getPri_nomb();
            matriz[j][3] = pacientefiltro.get(j).getSeg_nombre();
            matriz[j][4] = pacientefiltro.get(j).getPrim_apell();
            matriz[j][5] = pacientefiltro.get(j).getSeg_apelli();
            matriz[j][6] = pacientefiltro.get(j).getCorreo();
            matriz[j][7] = pacientefiltro.get(j).getGenero();
            matriz[j][8] = pacientefiltro.get(j).getDireccion();
            matriz[j][9] = pacientefiltro.get(j).getTipo_sangre();
            matriz[j][10] = pacientefiltro.get(j).getCodigo_de_paciente();


            matriz[j][13] = pacientefiltro.get(j).getTelefono();
            matriz[j][14] = pacientefiltro.get(j).getFecha_Nacimiento();


        }
        TablaFamiliar.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "codigo", "Nombre", "segundo_nombre", "primer apellido", "segundo apellido", "correo", "genero", "direccion", "telefono", "tipo sangre", "seguro", "fecha nacimiento", "fecha ingreso","hora_inicio","hora_fin","fecha_visita"
                }
        ));
    }
    private void BtEditarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarFamiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtEditarFamiliarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crud_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_familiar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarFamiliar;
    private javax.swing.JButton BtEditarFamiliar;
    private javax.swing.JButton BtEliminarFamiliar;
    private javax.swing.JButton BtIngresarFamiliar;
    private javax.swing.JButton BtRegresarFamiliar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTable TablaFamiliar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
