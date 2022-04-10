package ventanas;

import clases.doctor;
import conexion_bada.Insert_familiar;
import clases.familiar;
import conexion_bada.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class crud_familiar extends javax.swing.JFrame {

    Insert_familiar inser = new Insert_familiar();
    Conexion mi_cone = new Conexion();

    public crud_familiar() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        this.BtIngresarFamiliar.setEnabled(false);
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
        btrefrescar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtRegresarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        BtRegresarFamiliar.setToolTipText("Regresar");
        BtRegresarFamiliar.setBorder(null);
        BtRegresarFamiliar.setOpaque(false);
        BtRegresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtRegresarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, 50, 40));

        BtIngresarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        BtIngresarFamiliar.setToolTipText("INGRESAR FAMILIAR");
        BtIngresarFamiliar.setBorder(null);
        BtIngresarFamiliar.setOpaque(false);
        BtIngresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtIngresarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 40, 40));

        text_buscar.setText("Buscar...");
        text_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_buscarMousePressed(evt);
            }
        });
        text_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 250, 40));

        BtBuscarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        BtBuscarFamiliar.setToolTipText("BUSCAR FAMILIAR");
        BtBuscarFamiliar.setBorder(null);
        BtBuscarFamiliar.setOpaque(false);
        BtBuscarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtBuscarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 50, 40));

        BtEditarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        BtEditarFamiliar.setToolTipText("EDITAR FAMILIAR");
        BtEditarFamiliar.setBorder(null);
        BtEditarFamiliar.setOpaque(false);
        BtEditarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtEditarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 50, 40));

        BtEliminarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar-usuario.png"))); // NOI18N
        BtEliminarFamiliar.setToolTipText("ELIMINAR FAMILIAR");
        BtEliminarFamiliar.setBorder(null);
        BtEliminarFamiliar.setOpaque(false);
        BtEliminarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarFamiliarActionPerformed(evt);
            }
        });
        getContentPane().add(BtEliminarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, 50, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE FAMILIARES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        TablaFamiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cédula", "Nombres", "Apellidos", "Correo", "Sexo", "Dirección", "Tipo de sangre", "Celular", "Fecha de nacimiento", "Parentesco", "Paciente"
            }
        ));
        jScrollPane1.setViewportView(TablaFamiliar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1260, 290));

        btrefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rotacion.png"))); // NOI18N
        btrefrescar.setToolTipText("ver todos");
        btrefrescar.setBorder(null);
        btrefrescar.setOpaque(false);
        btrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrefrescarActionPerformed(evt);
            }
        });
        getContentPane().add(btrefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/—Pngtree—green simple solid color background_1323927.png"))); // NOI18N
        Fondo.setText("jLabel1");
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarFamiliarActionPerformed
        this.dispose();
        new acceso_administrador().setVisible(true);
    }//GEN-LAST:event_BtRegresarFamiliarActionPerformed

    private void BtIngresarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarFamiliarActionPerformed
        this.dispose();
        new agregar_familiar().setVisible(true);
    }//GEN-LAST:event_BtIngresarFamiliarActionPerformed

    private void BtEliminarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarFamiliarActionPerformed
        eliminar_familiar();
    }//GEN-LAST:event_BtEliminarFamiliarActionPerformed
    public void eliminar_familiar() {

        int fila = TablaFamiliar.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            String cod;
            cod = TablaFamiliar.getValueAt(fila, 0).toString();
            try {
                mi_cone.InsertUpdateDeleteAcciones("DELETE FROM familiar where fam_codigo='" + cod + "'");
                cargarTabla();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    private void BtBuscarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarFamiliarActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_familiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del familiar");
        }

    }//GEN-LAST:event_BtBuscarFamiliarActionPerformed

    private void BtEditarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarFamiliarActionPerformed
        modificar_familiar();
        
    }//GEN-LAST:event_BtEditarFamiliarActionPerformed
    public void modificar_familiar() {

        int seleccion = TablaFamiliar.getSelectedRow();
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            String cedula = TablaFamiliar.getValueAt(seleccion, 1).toString();
//            System.out.println(cedula);
            inser.ListaFamiliar().forEach((e) -> {
                if (e.getCedula().equals(cedula)) {
                    new agregar_familiar(cedula).setVisible(true);
                    this.dispose();
                    text_buscar.setText("");

                }
            });
        }
    }
    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        // TODO add your handling code here:
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_buscarMousePressed

    private void btrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrefrescarActionPerformed
        // TODO add your handling code here:
        cargarTabla();

    }//GEN-LAST:event_btrefrescarActionPerformed

    private void text_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_buscarActionPerformed

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaFamiliar.getModel();
        tb.setNumRows(0);
        List<familiar> com = inser.ListaFamiliar();
        com.stream().forEach(p -> {
            String[] cami = {p.getCodigo(), p.getCedula(), p.getPri_nomb()+"   "+ p.getSeg_nombre(), p.getPrim_apell()+"   "+ p.getSeg_apelli(), p.getCorreo(), p.getGenero(), p.getDireccion(), p.getTipo_sangre(), p.getTelefono(), p.getFecha_Nacimiento(), p.getParectesco(),String.valueOf(p.getCodigo_paciente())};
            tb.addRow(cami);
        });
    }

    public void buscar_familiar() {
        String cedula = text_buscar.getText();
        var familiarfiltro = new ArrayList<familiar>();

        inser.ListaFamiliar().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                familiarfiltro.add(e);
            }
        });

        if (familiarfiltro.size() != 0) {
            String matriz[][] = new String[familiarfiltro.size()][12];
            for (int j = 0; j < familiarfiltro.size(); j++) {
                matriz[j][0] = familiarfiltro.get(j).getCodigo();
                matriz[j][1] = familiarfiltro.get(j).getCedula();
                matriz[j][2] = familiarfiltro.get(j).getPri_nomb()+"   "+familiarfiltro.get(j).getSeg_nombre();;
                matriz[j][3] = familiarfiltro.get(j).getPrim_apell()+"   "+familiarfiltro.get(j).getSeg_apelli();
                matriz[j][4] = familiarfiltro.get(j).getCorreo();
                matriz[j][5] = familiarfiltro.get(j).getGenero();
                matriz[j][6] = familiarfiltro.get(j).getDireccion();
                matriz[j][7] = familiarfiltro.get(j).getTipo_sangre();
                matriz[j][8] = familiarfiltro.get(j).getTelefono();
                matriz[j][9] = familiarfiltro.get(j).getFecha_Nacimiento();
                matriz[j][10] = familiarfiltro.get(j).getParectesco();
                matriz[j][11] = String.valueOf(familiarfiltro.get(j).getCodigo_paciente());

            }
            TablaFamiliar.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "Codigo", "Cédula", "Nombres", "Apellidos", "Correo", "Sexo", "Dirección", "Tipo de sangre", "Celular", "Fecha de nacimiento", "Parentesco", "Paciente"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "La persona no existe en la base de datos");
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
    private javax.swing.JButton btrefrescar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
