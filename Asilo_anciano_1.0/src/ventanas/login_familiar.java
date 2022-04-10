package ventanas;

import clases.familiar;
import conexion_bada.Insert_familiar;
import conexion_bada.Insert_usuario;
import java.util.List;
import javax.swing.JOptionPane;

public class login_familiar extends javax.swing.JFrame {

    Insert_familiar InsertFami = new Insert_familiar();

    public login_familiar() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    public void LoginFamiliar() {

        Insert_usuario miInsert = new Insert_usuario();

        boolean bandera = false;
        List<familiar> com = InsertFami.ListaFamiliar();

        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).getCod_usuario() == miInsert.ConsultarUsuario(txtUsuarioF.getText(), txtContraseniaF.getText())) {

                acceso_familiar mi_accesoF = new acceso_familiar();
                mi_accesoF.setVisible(true);
                dispose();

                bandera = true;
                i = com.size();
            }
        }

        if (!bandera) {
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto");
        }

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuarioF = new javax.swing.JTextField();
        txtContraseniaF = new javax.swing.JPasswordField();
        BotonIniciarSesionR = new javax.swing.JButton();
        boton_para_menu_principal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/familia.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("USUARIO:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setText("CONTRASEÑA:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txtUsuarioF.setToolTipText("INGRESE SU USUARIO");
        getContentPane().add(txtUsuarioF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 140, 30));

        txtContraseniaF.setToolTipText("INGRESE SU CONTRASEÑA");
        getContentPane().add(txtContraseniaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 140, 30));

        BotonIniciarSesionR.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        BotonIniciarSesionR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciar-sesion (1).png"))); // NOI18N
        BotonIniciarSesionR.setText("INICIAR SESION");
        BotonIniciarSesionR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarSesionRActionPerformed(evt);
            }
        });
        getContentPane().add(BotonIniciarSesionR, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        boton_para_menu_principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_para_menu_principal.setToolTipText("REGRESAR");
        boton_para_menu_principal.setBorder(null);
        boton_para_menu_principal.setOpaque(false);
        boton_para_menu_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_para_menu_principalActionPerformed(evt);
            }
        });
        getContentPane().add(boton_para_menu_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/teahub.io-pastel-color-wallpaper-409511 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_para_menu_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_para_menu_principalActionPerformed
        inicio_frame menup = new inicio_frame();
        menup.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_para_menu_principalActionPerformed

    private void BotonIniciarSesionRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarSesionRActionPerformed
        LoginFamiliar();
    }//GEN-LAST:event_BotonIniciarSesionRActionPerformed

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
            java.util.logging.Logger.getLogger(login_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_familiar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIniciarSesionR;
    private javax.swing.JButton boton_para_menu_principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtContraseniaF;
    private javax.swing.JTextField txtUsuarioF;
    // End of variables declaration//GEN-END:variables
}
