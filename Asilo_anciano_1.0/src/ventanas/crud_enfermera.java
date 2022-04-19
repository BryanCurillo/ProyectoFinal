/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.enfermera;
import clases.paciente;
import conexion_bada.Conexion;
import conexion_bada.Insert_enfermera;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class crud_enfermera extends javax.swing.JFrame {

    Conexion mi_cone = new Conexion();
    Insert_enfermera inser = new Insert_enfermera();

    public crud_enfermera() {
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
        BtAgregarEnfermera = new javax.swing.JButton();
        BtBuscarEnfermera = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        BtModificarEnfermera = new javax.swing.JButton();
        BtEliminarEnfermera = new javax.swing.JButton();
        BtRegresarEnfermera = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEnfermera = new javax.swing.JTable();
        Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("LISTA DE ENFERMERA/O");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        BtAgregarEnfermera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        BtAgregarEnfermera.setToolTipText("AGREGAR ENFERMERA");
        BtAgregarEnfermera.setBorder(null);
        BtAgregarEnfermera.setOpaque(false);
        BtAgregarEnfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAgregarEnfermeraActionPerformed(evt);
            }
        });
        jPanel1.add(BtAgregarEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 40, 40));

        BtBuscarEnfermera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        BtBuscarEnfermera.setToolTipText("BUSCAR ENFERMERA");
        BtBuscarEnfermera.setBorder(null);
        BtBuscarEnfermera.setOpaque(false);
        BtBuscarEnfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarEnfermeraActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscarEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 50, 40));

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
        jPanel1.add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 230, 30));

        BtModificarEnfermera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        BtModificarEnfermera.setToolTipText("EDITAR ENFERMERA");
        BtModificarEnfermera.setBorder(null);
        BtModificarEnfermera.setOpaque(false);
        BtModificarEnfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModificarEnfermeraActionPerformed(evt);
            }
        });
        jPanel1.add(BtModificarEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 50, 40));

        BtEliminarEnfermera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar-usuario.png"))); // NOI18N
        BtEliminarEnfermera.setToolTipText("ELIMINAR ENFERMERA");
        BtEliminarEnfermera.setBorder(null);
        BtEliminarEnfermera.setOpaque(false);
        BtEliminarEnfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarEnfermeraActionPerformed(evt);
            }
        });
        jPanel1.add(BtEliminarEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 50, 40));

        BtRegresarEnfermera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        BtRegresarEnfermera.setToolTipText("REGRESAR");
        BtRegresarEnfermera.setBorder(null);
        BtRegresarEnfermera.setOpaque(false);
        BtRegresarEnfermera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarEnfermeraActionPerformed(evt);
            }
        });
        jPanel1.add(BtRegresarEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 50, 40));

        TablaEnfermera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Sexo", "Tipo de sangre", "Dirección", "Fecha de nacimiento", "Años de experiencia", "E-mail", "Celular"
            }
        ));
        jScrollPane1.setViewportView(TablaEnfermera);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 980, 300));

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rotacion.png"))); // NOI18N
        Actualizar.setToolTipText("VER TODOS");
        Actualizar.setBorder(null);
        Actualizar.setOpaque(false);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wallpaperbetter (3).jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 490));

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

    private void text_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_buscarActionPerformed

    private void BtRegresarEnfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarEnfermeraActionPerformed
        this.dispose();
        new acceso_administrador().setVisible(true);
    }//GEN-LAST:event_BtRegresarEnfermeraActionPerformed

    private void BtAgregarEnfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAgregarEnfermeraActionPerformed
        this.dispose();
        new agregar_enfermera().setVisible(true);
    }//GEN-LAST:event_BtAgregarEnfermeraActionPerformed

    private void BtBuscarEnfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarEnfermeraActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_enfermera();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula de la enfermera");
        }

    }//GEN-LAST:event_BtBuscarEnfermeraActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        // TODO add your handling code here:
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_buscarMousePressed

    private void BtModificarEnfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModificarEnfermeraActionPerformed
        modificar_ENFERMERA();
    }//GEN-LAST:event_BtModificarEnfermeraActionPerformed

    private void BtEliminarEnfermeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarEnfermeraActionPerformed
        eliminar_recepcionista();
    }//GEN-LAST:event_BtEliminarEnfermeraActionPerformed
    public void eliminar_recepcionista() {
        int fila = TablaEnfermera.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha selecionado una fila");
        } else {
            int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cod;
                String cedula;
                cedula = TablaEnfermera.getValueAt(fila, 1).toString();
                cod = TablaEnfermera.getValueAt(fila, 0).toString();
                try {
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM enfermera where enfer_codigo='" + cod + "'");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM persona where per_cedula='" + cedula + "'");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM usuario where us_codigo='" + cod + "'");
                    cargarTabla();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

    }

    public void modificar_ENFERMERA() {

        int seleccion = TablaEnfermera.getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha selecionado una fila");
        } else {
            String cedula = TablaEnfermera.getValueAt(seleccion, 1).toString();
            inser.ListaEnfermera().forEach((e) -> {
                if (e.getCedula().equals(cedula)) {
                    new agregar_enfermera(cedula).setVisible(true);
                    text_buscar.setText("");

                }
            });

        }

    }

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaEnfermera.getModel();
        tb.setNumRows(0);
        List<enfermera> com = inser.ListaEnfermera();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCodigo()), p.getCedula(), p.getPri_nomb(), p.getSeg_nombre(), p.getPrim_apell(), p.getSeg_apelli(), p.getGenero(), p.getTipo_sangre(), p.getDireccion(), p.getFecha_Nacimiento(), p.getAnio_experiencia(), p.getCorreo(), p.getTelefono()};
            tb.addRow(cami);
        });
    }

    public void buscar_enfermera() {
        String cedula = text_buscar.getText();
        var pacientefiltro = new ArrayList<enfermera>();

        inser.ListaEnfermera().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                pacientefiltro.add(e);
            }
        });

        if (pacientefiltro.size() != 0) {
            String matriz[][] = new String[pacientefiltro.size()][14];
            for (int j = 0; j < pacientefiltro.size(); j++) {
                matriz[j][0] = String.valueOf(pacientefiltro.get(j).getCodigo());
                matriz[j][1] = pacientefiltro.get(j).getCedula();
                matriz[j][2] = pacientefiltro.get(j).getPri_nomb();
                matriz[j][3] = pacientefiltro.get(j).getSeg_nombre();
                matriz[j][4] = pacientefiltro.get(j).getPrim_apell();
                matriz[j][5] = pacientefiltro.get(j).getSeg_apelli();
                matriz[j][6] = pacientefiltro.get(j).getCorreo();
                matriz[j][7] = pacientefiltro.get(j).getGenero();
                matriz[j][8] = pacientefiltro.get(j).getDireccion();
                matriz[j][9] = pacientefiltro.get(j).getTelefono();
                matriz[j][10] = pacientefiltro.get(j).getTipo_sangre();
                matriz[j][11] = pacientefiltro.get(j).getAnio_experiencia();
                matriz[j][12] = pacientefiltro.get(j).getFecha_Nacimiento();

            }
            TablaEnfermera.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "codigo", "Nombre", "segundo_nombre", "primer apellido", "segundo apellido", "correo", "genero", "direccion", "telefono", "tipo sangre", "seguro", "fecha nacimiento", "fecha ingreso"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "La enfermera no existe en la base de datos");
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
            java.util.logging.Logger.getLogger(crud_enfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_enfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_enfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_enfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_enfermera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton BtAgregarEnfermera;
    private javax.swing.JButton BtBuscarEnfermera;
    private javax.swing.JButton BtEliminarEnfermera;
    private javax.swing.JButton BtModificarEnfermera;
    private javax.swing.JButton BtRegresarEnfermera;
    private javax.swing.JTable TablaEnfermera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
