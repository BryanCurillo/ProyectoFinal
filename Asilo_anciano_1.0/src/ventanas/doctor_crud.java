/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.doctor;
import conexion_bada.Insert_doctor;
import clases.paciente;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class doctor_crud extends javax.swing.JFrame {

    Insert_doctor inser = new Insert_doctor();

    public doctor_crud() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtIngresarDoctor = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        BtBuscarDoctor = new javax.swing.JButton();
        BtEditarDoctor = new javax.swing.JButton();
        BtEliminarDoctor = new javax.swing.JButton();
        BtRegresarDoctor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDoctor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 232, 158));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 59, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE DOCTORES");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 450, -1));

        BtIngresarDoctor.setText("INGRESAR DOCTOR");
        BtIngresarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(BtIngresarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        text_buscar.setText("Buscar...");
        text_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_buscarMousePressed(evt);
            }
        });
        jPanel1.add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 180, 30));

        BtBuscarDoctor.setText("BUSCAR DOCTOR");
        BtBuscarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        BtEditarDoctor.setText("EDITAR DOCTOR");
        jPanel1.add(BtEditarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        BtEliminarDoctor.setText("ELIMINAR DOCTOR");
        BtEliminarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(BtEliminarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        BtRegresarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        BtRegresarDoctor.setText("Regresar");
        BtRegresarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(BtRegresarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        TablaDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "e-mail", "Sexo", "Dirección", "Celular", "Tipo de sangre", "Especialidad", "Fecha de nacimiento"
            }
        ));
        jScrollPane1.setViewportView(TablaDoctor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1100, 210));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZARTAB.jpeg"))); // NOI18N
        jButton1.setToolTipText("Ver todos");
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtIngresarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarDoctorActionPerformed
        this.dispose();
        new agregar_doctor().setVisible(true);
    }//GEN-LAST:event_BtIngresarDoctorActionPerformed

    private void BtRegresarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarDoctorActionPerformed
        this.dispose();
        new inicio_frame().setVisible(true);
    }//GEN-LAST:event_BtRegresarDoctorActionPerformed

    private void BtEliminarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtEliminarDoctorActionPerformed

    private void BtBuscarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarDoctorActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_doctor();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del administrador");
        }
    }//GEN-LAST:event_BtBuscarDoctorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_buscarMousePressed

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaDoctor.getModel();
        tb.setNumRows(0);
        List<doctor> com = inser.ListaDoctor();
        com.stream().forEach(p -> {
            String[] cami = {p.getCodigo(), p.getCedula(), p.getPri_nomb(), p.getSeg_nombre(), p.getPrim_apell(), p.getSeg_apelli(), p.getCorreo(), p.getGenero(), p.getDireccion(), p.getTelefono(), p.getTipo_sangre(), p.getEspecialidad(), p.getFecha_Nacimiento()};
            tb.addRow(cami);
        });
    }

    public void buscar_doctor() {
        String cedula = text_buscar.getText();
        var docfiltro = new ArrayList<doctor>();
        inser.ListaDoctor().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                docfiltro.add(e);
            }
        });
        if (docfiltro.size() != 0) {

        String matriz[][] = new String[docfiltro.size()][13];
        for (int j = 0; j < docfiltro.size(); j++) {
            matriz[j][0] = docfiltro.get(j).getCodigo();
            matriz[j][1] = docfiltro.get(j).getCedula();
            matriz[j][2] = docfiltro.get(j).getPri_nomb();
            matriz[j][3] = docfiltro.get(j).getSeg_nombre();
            matriz[j][4] = docfiltro.get(j).getPrim_apell();
            matriz[j][5] = docfiltro.get(j).getSeg_apelli();
            matriz[j][6] = docfiltro.get(j).getCorreo();
            matriz[j][7] = docfiltro.get(j).getGenero();
            matriz[j][8] = docfiltro.get(j).getDireccion();
            matriz[j][9] = docfiltro.get(j).getTelefono();
            matriz[j][10] = docfiltro.get(j).getTipo_sangre();
            matriz[j][11] = docfiltro.get(j).getEspecialidad();
            matriz[j][12] = docfiltro.get(j).getFecha_Nacimiento();

        }
        TablaDoctor.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "codigo", "Nombre", "segundo_nombre", "primer apellido", "segundo apellido", "correo", "genero", "direccion", "telefono", "tipo sangre", "seguro", "fecha nacimiento", "fecha ingreso"
                }
        ));
        } else {
            JOptionPane.showMessageDialog(this, "El doctor no existe en la base de datos");
        }
    }

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
            java.util.logging.Logger.getLogger(doctor_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doctor_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doctor_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doctor_crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doctor_crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarDoctor;
    private javax.swing.JButton BtEditarDoctor;
    private javax.swing.JButton BtEliminarDoctor;
    private javax.swing.JButton BtIngresarDoctor;
    private javax.swing.JButton BtRegresarDoctor;
    private javax.swing.JTable TablaDoctor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
