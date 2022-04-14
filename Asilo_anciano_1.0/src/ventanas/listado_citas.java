package ventanas;

import clases.doctor;
import clases.paciente;
import clases.cita_medica;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import conexion_bada.Insert_ChequeoMedico;
import conexion_bada.Insert_doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class listado_citas extends javax.swing.JFrame {

    Insert_ChequeoMedico inserchequeo = new Insert_ChequeoMedico();

    public listado_citas() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        boton_regresar_menu_doctor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaChequeosDoctor = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(172, 240, 157));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE CHEQUEOS MEDICOS");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        jButton1.setToolTipText("BUSCAR PACIENTE");
        jButton1.setBorder(null);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boton_regresar_menu_doctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_regresar_menu_doctor.setToolTipText("regresar");
        boton_regresar_menu_doctor.setBorder(null);
        boton_regresar_menu_doctor.setOpaque(false);
        boton_regresar_menu_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regresar_menu_doctorActionPerformed(evt);
            }
        });

        TablaChequeosDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula del Paciente", " Nombres del Paciente", "Apellidos del Paciente", "Fecha Chequeo ", "Hora  Chequeo"
            }
        ));
        jScrollPane1.setViewportView(TablaChequeosDoctor);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZARTAB.jpeg"))); // NOI18N
        jButton3.setToolTipText("CARGAR DATOS");
        jButton3.setBorder(null);
        jButton3.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DIGITE SU NÚMERO DE CÉDULA:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hogar_de_los_ancianos__1_-removebg-preview (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)
                        .addComponent(jButton3)
                        .addGap(47, 47, 47)
                        .addComponent(boton_regresar_menu_doctor))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(boton_regresar_menu_doctor)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_regresar_menu_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regresar_menu_doctorActionPerformed
        // TODO add your handling code here:
        acceso_doctor acdoctor = new acceso_doctor();
        acdoctor.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_regresar_menu_doctorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FiltrarDatosChequeoTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void FiltrarDatosChequeoTabla() {

        String cedulaAux = txtCedula.getText();
        int codDoc = 0;

        Insert_ChequeoMedico inserchek = new Insert_ChequeoMedico();

        List<doctor> com = inserchek.ListaChequeoDoctor();

        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).getCedula().equalsIgnoreCase(cedulaAux)) {

                codDoc = com.get(i).getCodigo();
            }
        }

        System.out.println("Bien codDoc: " + codDoc);

        var pacidosfiltro = new ArrayList<paciente>();
        inserchequeo.ListaChequeoPacienteDos(codDoc).forEach((e) -> {
            pacidosfiltro.add(e);
        });

        String matriz[][] = new String[pacidosfiltro.size()][6];

        for (int i = 0; i < pacidosfiltro.size(); i++) {

            matriz[i][0] = pacidosfiltro.get(i).getCedula();
            matriz[i][1] = pacidosfiltro.get(i).getPri_nomb() + " " + pacidosfiltro.get(i).getSeg_nombre();
            matriz[i][2] = pacidosfiltro.get(i).getPrim_apell() + " " + pacidosfiltro.get(i).getSeg_apelli();

        }

        var citfiltro = new ArrayList<clases.cita_medica>();
        inserchequeo.ListaChequeoDos(codDoc).forEach((e) -> {
            citfiltro.add(e);
        });

        for (int j = 0; j < citfiltro.size(); j++) {

            matriz[j][3] = citfiltro.get(j).getFecha_chequeoActual();
            matriz[j][4] = citfiltro.get(j).getHoraChequeo();

        }
        
        TablaChequeosDoctor.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Cédula del paciente", "Nombres del paciente", "Apellidos del paciente", "Fecha del chequeo médico", "Hora del chequeo médico"
                }
        ));
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
            java.util.logging.Logger.getLogger(listado_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listado_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listado_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listado_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listado_citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaChequeosDoctor;
    private javax.swing.JButton boton_regresar_menu_doctor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}