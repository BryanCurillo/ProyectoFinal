package ventanas;

import conexion_bada.Insert_administrador;
import clases.administrador;
import clases.usuario;
import conexion_bada.Insert_usuario;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class login_administrador extends javax.swing.JFrame {

    public static int BotonLoginAdmin;
    
    Insert_administrador inserAdmin = new Insert_administrador();

    public login_administrador() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuarioA = new javax.swing.JTextField();
        txtContraseniaA = new javax.swing.JPasswordField();
        BotonRegistrarAdmin = new javax.swing.JButton();
        boton_regresar_menu_principal = new javax.swing.JButton();
        BotonIniciarSesionA1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gerente.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 250, 220));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setText("USUARIO:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setText("CONTRASEÑA:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txtUsuarioA.setToolTipText("INGRESE SU USUARIO");
        getContentPane().add(txtUsuarioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        txtContraseniaA.setToolTipText("INGRESE SU CONTRASEÑA");
        getContentPane().add(txtContraseniaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, 30));

        BotonRegistrarAdmin.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        BotonRegistrarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro.png"))); // NOI18N
        BotonRegistrarAdmin.setText("REGISTRAR");
        BotonRegistrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarAdminActionPerformed(evt);
            }
        });
        getContentPane().add(BotonRegistrarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 140, 30));

        boton_regresar_menu_principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_regresar_menu_principal.setToolTipText("REGRESAR MENU PRINCIPAL");
        boton_regresar_menu_principal.setBorder(null);
        boton_regresar_menu_principal.setOpaque(false);
        boton_regresar_menu_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regresar_menu_principalActionPerformed(evt);
            }
        });
        getContentPane().add(boton_regresar_menu_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        BotonIniciarSesionA1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        BotonIniciarSesionA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciar-sesion (1).png"))); // NOI18N
        BotonIniciarSesionA1.setText("INICIAR SESION");
        BotonIniciarSesionA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarSesionA1ActionPerformed(evt);
            }
        });
        getContentPane().add(BotonIniciarSesionA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/teahub.io-full-hd-vertical-wallpapers-874835.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarAdminActionPerformed
        //new Agregar_administrador().setVisible(true);
        Agregar_administrador mi_agregarAdmin = new Agregar_administrador();
        mi_agregarAdmin.setVisible(true);
        BotonLoginAdmin = 1;
        dispose();
    }//GEN-LAST:event_BotonRegistrarAdminActionPerformed

    private void boton_regresar_menu_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regresar_menu_principalActionPerformed
        // TODO add your handling code here:
        inicio_frame menup = new inicio_frame();
        menup.setVisible(true);
        dispose();

    }//GEN-LAST:event_boton_regresar_menu_principalActionPerformed

    private void BotonIniciarSesionA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarSesionA1ActionPerformed
        LoginAdministrador();
    }//GEN-LAST:event_BotonIniciarSesionA1ActionPerformed

    public void LoginAdministrador() {
        Insert_usuario miInsert = new Insert_usuario();

        boolean bandera = false;
        List<administrador> com = inserAdmin.ListaAdministrador();

        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).getCod_usuario() == miInsert.ConsultarUsuario(txtUsuarioA.getText(), txtContraseniaA.getText())) {

                bandera = true;
                i = com.size();

                acceso_administrador mi_accesoA = new acceso_administrador();
                mi_accesoA.setVisible(true);
                dispose();

            }
        }

        if (!bandera) {

            JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto");

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
            java.util.logging.Logger.getLogger(login_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIniciarSesionA1;
    private javax.swing.JButton BotonRegistrarAdmin;
    private javax.swing.JButton boton_regresar_menu_principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContraseniaA;
    private javax.swing.JTextField txtUsuarioA;
    // End of variables declaration//GEN-END:variables
}
