package ventanas;

public class acceso_administrador extends javax.swing.JFrame {

    public static int BotonAgregarApagar;

    public acceso_administrador() {
        initComponents();
        BotonAgregarApagar = 2;
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

        jLabel2 = new javax.swing.JLabel();
        boton_crud_paciente = new javax.swing.JButton();
        boton_crud_doctor = new javax.swing.JButton();
        boton_crud_enfermera = new javax.swing.JButton();
        boton_crud_recepcionista = new javax.swing.JButton();
        boton_crud_familiar = new javax.swing.JButton();
        boton_otros = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botol_crud_especialidades = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        boton_crud_alergias = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        boton_regresar_administrador = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel2.setText("ACCESO ADMINISTRADOR");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        boton_crud_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ancianos.png"))); // NOI18N
        boton_crud_paciente.setToolTipText("CRUD PACIENTE");
        boton_crud_paciente.setBorder(null);
        boton_crud_paciente.setOpaque(false);
        boton_crud_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crud_pacienteActionPerformed(evt);
            }
        });
        getContentPane().add(boton_crud_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        boton_crud_doctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctor.png"))); // NOI18N
        boton_crud_doctor.setToolTipText("CRUD DOCTOR");
        boton_crud_doctor.setBorder(null);
        boton_crud_doctor.setOpaque(false);
        boton_crud_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crud_doctorActionPerformed(evt);
            }
        });
        getContentPane().add(boton_crud_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        boton_crud_enfermera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/enfermeras.png"))); // NOI18N
        boton_crud_enfermera.setToolTipText("CRUD ENFERMERA");
        boton_crud_enfermera.setBorder(null);
        boton_crud_enfermera.setOpaque(false);
        boton_crud_enfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crud_enfermeraActionPerformed(evt);
            }
        });
        getContentPane().add(boton_crud_enfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        boton_crud_recepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recepcionista.png"))); // NOI18N
        boton_crud_recepcionista.setToolTipText("CRUD RECEPCIONISTA");
        boton_crud_recepcionista.setBorder(null);
        boton_crud_recepcionista.setOpaque(false);
        boton_crud_recepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crud_recepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_crud_recepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        boton_crud_familiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/family.png"))); // NOI18N
        boton_crud_familiar.setToolTipText("CRUD FAMILIAR");
        boton_crud_familiar.setBorder(null);
        boton_crud_familiar.setOpaque(false);
        boton_crud_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crud_familiarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_crud_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        boton_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/virus (1).png"))); // NOI18N
        boton_otros.setToolTipText("AGREGAR ENFERMEDADES");
        boton_otros.setBorder(null);
        boton_otros.setOpaque(false);
        boton_otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_otrosActionPerformed(evt);
            }
        });
        getContentPane().add(boton_otros, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel3.setText("CRUD PACIENTE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hogar_de_los_ancianos__1_-removebg-preview (2).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 120, 100));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel5.setText("CRUD DOCTORES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel6.setText("CRUD ENFERMERA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel7.setText("CRUD RECEPCIONISTA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel8.setText("CRUD FAMILIAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jLabel10.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel10.setText("ENFERMEDADES");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        botol_crud_especialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctor (3).png"))); // NOI18N
        botol_crud_especialidades.setToolTipText("AGREGAR ESPECIALIDADES");
        botol_crud_especialidades.setBorder(null);
        botol_crud_especialidades.setOpaque(false);
        botol_crud_especialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botol_crud_especialidadesActionPerformed(evt);
            }
        });
        getContentPane().add(botol_crud_especialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel9.setText("ESPECIALIDADES MEDICAS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        boton_crud_alergias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/antihistaminicos.png"))); // NOI18N
        boton_crud_alergias.setToolTipText("CRUD ALERGIAS");
        boton_crud_alergias.setBorder(null);
        boton_crud_alergias.setOpaque(false);
        boton_crud_alergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crud_alergiasActionPerformed(evt);
            }
        });
        getContentPane().add(boton_crud_alergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jLabel11.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel11.setText("ALERGIAS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicamento.png"))); // NOI18N
        jButton2.setToolTipText("CRUD MEDICAMENTOS");
        jButton2.setBorder(null);
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        boton_regresar_administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_regresar_administrador.setBorder(null);
        boton_regresar_administrador.setOpaque(false);
        boton_regresar_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regresar_administradorActionPerformed(evt);
            }
        });
        getContentPane().add(boton_regresar_administrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, -1));

        jLabel12.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel12.setText("MEDICAMENTOS");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos-de-pantalla-lisos-color-pastel-mountainstyle.co_.-fondo-de-pantalla-hd-1080p-lisos (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_crud_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crud_doctorActionPerformed
        // TODO add your handling code here:
        doctor_crud doc = new doctor_crud();
        doc.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_crud_doctorActionPerformed

    private void boton_crud_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crud_familiarActionPerformed
        // TODO add your handling code here:
        crud_familiar fa = new crud_familiar();
        fa.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_crud_familiarActionPerformed

    private void boton_otrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_otrosActionPerformed
        // TODO add your handling code here:
        crud_enfermedades enferm = new crud_enfermedades();
        enferm.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_otrosActionPerformed

    private void boton_crud_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crud_pacienteActionPerformed
        // TODO add your handling code here:
        crud_paciente pac = new crud_paciente();
        pac.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_crud_pacienteActionPerformed

    private void boton_crud_enfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crud_enfermeraActionPerformed
        // TODO add your handling code here:
        crud_enfermera ef = new crud_enfermera();
        ef.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_crud_enfermeraActionPerformed

    private void boton_crud_recepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crud_recepcionistaActionPerformed
        // TODO add your handling code here:
        crud_recepcionista rec = new crud_recepcionista();
        rec.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_crud_recepcionistaActionPerformed

    private void botol_crud_especialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botol_crud_especialidadesActionPerformed
        // TODO add your handling code here:
        crud_especialidad espec = new crud_especialidad();
        espec.setVisible(true);
        dispose();
    }//GEN-LAST:event_botol_crud_especialidadesActionPerformed

    private void boton_crud_alergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crud_alergiasActionPerformed
        // TODO add your handling code here:
        crud_alergias ale = new crud_alergias();
        ale.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_crud_alergiasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Medicamentos medi = new Medicamentos();
        medi.setVisible(true);
        dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void boton_regresar_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regresar_administradorActionPerformed
        // TODO add your handling code here:
        login_administrador admin = new login_administrador();
        admin.setVisible(true);
        BotonAgregarApagar =0;
        dispose();
    }//GEN-LAST:event_boton_regresar_administradorActionPerformed

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
            java.util.logging.Logger.getLogger(acceso_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(acceso_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(acceso_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(acceso_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new acceso_administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botol_crud_especialidades;
    private javax.swing.JButton boton_crud_alergias;
    private javax.swing.JButton boton_crud_doctor;
    private javax.swing.JButton boton_crud_enfermera;
    private javax.swing.JButton boton_crud_familiar;
    private javax.swing.JButton boton_crud_paciente;
    private javax.swing.JButton boton_crud_recepcionista;
    private javax.swing.JButton boton_otros;
    private javax.swing.JButton boton_regresar_administrador;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
