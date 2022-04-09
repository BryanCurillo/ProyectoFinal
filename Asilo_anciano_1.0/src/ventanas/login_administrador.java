package ventanas;

import conexion_bada.Insert_administrador;
import clases.administrador;
import clases.usuario;
import conexion_bada.Insert_usuario;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class login_administrador extends javax.swing.JFrame {

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
        BotonIniciarSesionA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gerente.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 250, 220));

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
        getContentPane().add(txtUsuarioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        txtContraseniaA.setText("jPasswordField1");
        getContentPane().add(txtContraseniaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, 30));

        BotonIniciarSesionA.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        BotonIniciarSesionA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciar-sesion (1).png"))); // NOI18N
        BotonIniciarSesionA.setText("INICIAR SESION");
        BotonIniciarSesionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarSesionAActionPerformed(evt);
            }
        });
        getContentPane().add(BotonIniciarSesionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/teahub.io-full-hd-vertical-wallpapers-874835.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIniciarSesionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarSesionAActionPerformed
        LoginAdministrador();
    }//GEN-LAST:event_BotonIniciarSesionAActionPerformed

    public void LoginAdministrador() {
        Insert_usuario miInsert = new Insert_usuario();

        List<administrador> com = inserAdmin.ListaAdministrador();

        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).getCod_usuario() != miInsert.ConsultarUsuario(txtUsuarioA.getText(), txtContraseniaA.getText())) {

                acceso_doctor mi_acceso = new acceso_doctor();
                mi_acceso.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto");
            }
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
    private javax.swing.JButton BotonIniciarSesionA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContraseniaA;
    private javax.swing.JTextField txtUsuarioA;
    // End of variables declaration//GEN-END:variables
}
