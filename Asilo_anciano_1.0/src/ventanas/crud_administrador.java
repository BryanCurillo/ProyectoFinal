//
package ventanas;

import clases.administrador;
import clases.paciente;
import conexion_bada.Conexion;
import conexion_bada.Insert_administrador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class crud_administrador extends javax.swing.JFrame {

    Insert_administrador inser = new Insert_administrador();
    Conexion mi_cone = new Conexion();

    public crud_administrador() {
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
        BtEditarAdministrador = new javax.swing.JButton();
        Listar = new javax.swing.JButton();
        BtBuscarAdministrador = new javax.swing.JButton();
        BtEliminarAdministrador = new javax.swing.JButton();
        BtRegresarAdministrador = new javax.swing.JButton();
        BtIngresarAdministrador = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAdministrador = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 239, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtEditarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        BtEditarAdministrador.setToolTipText("EDITAR ADMINISTRADOR");
        BtEditarAdministrador.setBorder(null);
        BtEditarAdministrador.setOpaque(false);
        BtEditarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtEditarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 50, 40));

        Listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rotacion.png"))); // NOI18N
        Listar.setToolTipText("VER TODOS");
        Listar.setBorderPainted(false);
        Listar.setOpaque(false);
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });
        jPanel1.add(Listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 50, -1));

        BtBuscarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        BtBuscarAdministrador.setToolTipText("BUSCAR ADMINISTRADOR");
        BtBuscarAdministrador.setBorder(null);
        BtBuscarAdministrador.setOpaque(false);
        BtBuscarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, 40));

        BtEliminarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar-usuario.png"))); // NOI18N
        BtEliminarAdministrador.setToolTipText("ELIMINAR ADMINISTRADOR");
        BtEliminarAdministrador.setBorder(null);
        BtEliminarAdministrador.setOpaque(false);
        BtEliminarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtEliminarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 50, 40));

        BtRegresarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        BtRegresarAdministrador.setToolTipText("REGRESAR");
        BtRegresarAdministrador.setBorder(null);
        BtRegresarAdministrador.setOpaque(false);
        BtRegresarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtRegresarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 50, 40));

        BtIngresarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        BtIngresarAdministrador.setToolTipText("INGRESAR ADMINISTRADOR");
        BtIngresarAdministrador.setBorder(null);
        BtIngresarAdministrador.setOpaque(false);
        BtIngresarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtIngresarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 50, 40));

        text_buscar.setText("Ingrese la cédula a consultar...");
        text_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_buscarMousePressed(evt);
            }
        });
        jPanel1.add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, 40));

        TablaAdministrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cédula", "Primer nombre", "segundo nombre", "Primer apellido", "Segundo apellido", "Genero", "Tipo de sangre", "Dirección", "Fecha de nacimiento", "Nivel de educacion", "E-mail", "Celular"
            }
        ));
        jScrollPane1.setViewportView(TablaAdministrador);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 980, 250));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE ADMINISTRADORES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1021, 461));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarAdministradorActionPerformed
        this.dispose();
        new inicio_frame().setVisible(true);
    }//GEN-LAST:event_BtRegresarAdministradorActionPerformed

    private void BtEliminarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarAdministradorActionPerformed
        EliminarAdministrador();
    }//GEN-LAST:event_BtEliminarAdministradorActionPerformed

    private void BtBuscarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarAdministradorActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_admin();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del administrador");
        }
    }//GEN-LAST:event_BtBuscarAdministradorActionPerformed

    private void BtIngresarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarAdministradorActionPerformed
        this.dispose();
        new Agregar_administrador().setVisible(true);
    }//GEN-LAST:event_BtIngresarAdministradorActionPerformed

    private void ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_ListarActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);    }//GEN-LAST:event_text_buscarMousePressed

    private void BtEditarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarAdministradorActionPerformed
        modificar_Administrador();
    }//GEN-LAST:event_BtEditarAdministradorActionPerformed
    public void modificar_Administrador() {

        int seleccion = TablaAdministrador.getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            this.dispose();
            String cedula = TablaAdministrador.getValueAt(seleccion, 1).toString();
            inser.ListaAdministrador().forEach((e) -> {
                if (e.getCedula().equals(cedula)) {
                    new Agregar_administrador(cedula).setVisible(true);
                    text_buscar.setText("");
                }
            });
        }
    }

    public void EliminarAdministrador() {

        int fila = TablaAdministrador.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            
            int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cod;
                String cedula;
                cedula = TablaAdministrador.getValueAt(fila, 1).toString();
                cod = TablaAdministrador.getValueAt(fila, 0).toString();
                try {
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM administrador where admin_codigo=" + cod + "");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM persona where per_cedula='" + cedula + "'");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM usuario where us_codigo='" + cod + "'");
                    
                    JOptionPane.showMessageDialog(null, "El registro se eliminó éxitosamente");
                    cargarTabla();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

    }

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaAdministrador.getModel();
        tb.setNumRows(0);
        List<administrador> com = inser.ListaAdministrador();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCodigo()), p.getCedula(), p.getPri_nomb(), p.getSeg_nombre(), p.getPrim_apell(), p.getSeg_apelli(), p.getGenero(), p.getTipo_sangre(), p.getDireccion(), p.getFecha_Nacimiento(), p.getNivel_educacion(), p.getCorreo(), p.getTelefono()};
            tb.addRow(cami);
        });
    }

    public void buscar_admin() {

        String cedula = text_buscar.getText();
        var adminfiltro = new ArrayList<administrador>();

        inser.ListaAdministrador().forEach((a) -> {
            if (a.getCedula().equals(cedula)) {
                adminfiltro.add(a);
            }
        });
        if (adminfiltro.size() != 0) {
            String matriz[][] = new String[adminfiltro.size()][14];
            for (int j = 0; j < adminfiltro.size(); j++) {
                matriz[j][0] = String.valueOf(adminfiltro.get(j).getCodigo());
                matriz[j][1] = adminfiltro.get(j).getCedula();
                matriz[j][2] = adminfiltro.get(j).getPri_nomb();
                matriz[j][3] = adminfiltro.get(j).getSeg_nombre();
                matriz[j][4] = adminfiltro.get(j).getPrim_apell();
                matriz[j][5] = adminfiltro.get(j).getSeg_apelli();
                matriz[j][6] = adminfiltro.get(j).getGenero();
                matriz[j][7] = adminfiltro.get(j).getTipo_sangre();
                matriz[j][8] = adminfiltro.get(j).getDireccion();
                matriz[j][9] = adminfiltro.get(j).getFecha_Nacimiento();
                matriz[j][10] = adminfiltro.get(j).getNivel_educacion();
                matriz[j][11] = adminfiltro.get(j).getCorreo();
                matriz[j][12] = adminfiltro.get(j).getTelefono();

            }
            TablaAdministrador.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "Codigo", "Cédula", "Primer nombre", "segundo nombre", "Primer apellido", "Segundo apellido", "Genero", "Tipo de sangre", "Dirección", "Fecha de nacimiento", "Nivel de educacion", "E-mail", "Celular"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "El administrador no existe en la base de datos");
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
            java.util.logging.Logger.getLogger(crud_administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarAdministrador;
    private javax.swing.JButton BtEditarAdministrador;
    private javax.swing.JButton BtEliminarAdministrador;
    private javax.swing.JButton BtIngresarAdministrador;
    private javax.swing.JButton BtRegresarAdministrador;
    private javax.swing.JButton Listar;
    private javax.swing.JTable TablaAdministrador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
