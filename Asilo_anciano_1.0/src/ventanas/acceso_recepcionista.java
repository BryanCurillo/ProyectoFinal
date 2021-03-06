
package ventanas;


public class acceso_recepcionista extends javax.swing.JFrame {
    
    public static int Botones;
    
    public acceso_recepcionista() {
        initComponents();
        this.setLocationRelativeTo(null);
        Botones = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_registrar_paciente = new javax.swing.JButton();
        boton_agendar_chequeos = new javax.swing.JButton();
        boton_registrar_familiar = new javax.swing.JButton();
        boton_regresar_login_recepcionista = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boton_registrar_visitante = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        jLabel1.setText("ACCESO DE RECEPCIONISTA");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        boton_registrar_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registros-medicos.png"))); // NOI18N
        boton_registrar_paciente.setToolTipText("REGISTRAR PACIENTE");
        boton_registrar_paciente.setBorder(null);
        boton_registrar_paciente.setOpaque(false);
        boton_registrar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrar_pacienteActionPerformed(evt);
            }
        });
        getContentPane().add(boton_registrar_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        boton_agendar_chequeos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cita-medica.png"))); // NOI18N
        boton_agendar_chequeos.setToolTipText("AGENDAR CHEQUEOS MEDICOS");
        boton_agendar_chequeos.setBorder(null);
        boton_agendar_chequeos.setOpaque(false);
        boton_agendar_chequeos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agendar_chequeosActionPerformed(evt);
            }
        });
        getContentPane().add(boton_agendar_chequeos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        boton_registrar_familiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/family_1.png"))); // NOI18N
        boton_registrar_familiar.setToolTipText("REGISTRO DE FAMILIAR");
        boton_registrar_familiar.setBorder(null);
        boton_registrar_familiar.setOpaque(false);
        boton_registrar_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrar_familiarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_registrar_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        boton_regresar_login_recepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_regresar_login_recepcionista.setToolTipText("REGRESAR AL LOGIN");
        boton_regresar_login_recepcionista.setBorder(null);
        boton_regresar_login_recepcionista.setOpaque(false);
        boton_regresar_login_recepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regresar_login_recepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_regresar_login_recepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hogar_de_los_ancianos__1_-removebg-preview (2).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 120, 90));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel5.setText("REGISTRO DE PACIENTES");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel6.setText("REGISTRO DE FAMILIAR");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel7.setText("REGISTRAR CHEQUEO MEDICO");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        boton_registrar_visitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/curriculum (1).png"))); // NOI18N
        boton_registrar_visitante.setToolTipText("REGISTRAR VISITANTE");
        boton_registrar_visitante.setBorder(null);
        boton_registrar_visitante.setOpaque(false);
        boton_registrar_visitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrar_visitanteActionPerformed(evt);
            }
        });
        getContentPane().add(boton_registrar_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        jLabel8.setText("REGISTRO DE VISITAS");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/teahub.io-dark-yellow-wallpaper-2550281 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_regresar_login_recepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regresar_login_recepcionistaActionPerformed
        login_recepcionista re = new login_recepcionista();
        re.setVisible(true);
        Botones = 0;
        dispose();
       
    }//GEN-LAST:event_boton_regresar_login_recepcionistaActionPerformed

    private void boton_registrar_visitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrar_visitanteActionPerformed
        crud_vistafamiliar visita = new crud_vistafamiliar();
        visita.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_registrar_visitanteActionPerformed

    private void boton_registrar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrar_pacienteActionPerformed
        crud_paciente mi_crudP = new crud_paciente();
        mi_crudP.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_boton_registrar_pacienteActionPerformed

    private void boton_registrar_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrar_familiarActionPerformed
       crud_familiar agrefamiliar = new crud_familiar();
        agrefamiliar.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_registrar_familiarActionPerformed

    private void boton_agendar_chequeosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agendar_chequeosActionPerformed
        agregar_citamedica ct = new agregar_citamedica();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_agendar_chequeosActionPerformed

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
            java.util.logging.Logger.getLogger(acceso_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(acceso_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(acceso_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(acceso_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new acceso_recepcionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agendar_chequeos;
    private javax.swing.JButton boton_registrar_familiar;
    private javax.swing.JButton boton_registrar_paciente;
    private javax.swing.JButton boton_registrar_visitante;
    private javax.swing.JButton boton_regresar_login_recepcionista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
