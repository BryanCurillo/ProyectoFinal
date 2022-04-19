/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.paciente;
import clases.recepcionista;
import conexion_bada.Conexion;
import java.util.ArrayList;
import conexion_bada.Insert_recepcionista;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class crud_recepcionista extends javax.swing.JFrame {

    Insert_recepcionista inser = new Insert_recepcionista();
    Conexion mi_cone = new Conexion();

    public crud_recepcionista() {
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

        jLabel2 = new javax.swing.JLabel();
        BtRegresarRecepcionista = new javax.swing.JButton();
        BtEliminarRecepcionista = new javax.swing.JButton();
        BtEditarRecepcionista = new javax.swing.JButton();
        BtBuscarRecepcionista = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        BtIngresarRecepcionista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaRecepcionista = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE RECEPCIONISTAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        BtRegresarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anterior.png"))); // NOI18N
        BtRegresarRecepcionista.setToolTipText("REGRESAR");
        BtRegresarRecepcionista.setBorder(null);
        BtRegresarRecepcionista.setOpaque(false);
        BtRegresarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(BtRegresarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 50, 40));

        BtEliminarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar-usuario.png"))); // NOI18N
        BtEliminarRecepcionista.setToolTipText("ELIMINAR RECEPCIONISTA");
        BtEliminarRecepcionista.setBorder(null);
        BtEliminarRecepcionista.setOpaque(false);
        BtEliminarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(BtEliminarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 50, 40));

        BtEditarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        BtEditarRecepcionista.setToolTipText("EDITAR RECEPCIONISTA");
        BtEditarRecepcionista.setBorder(null);
        BtEditarRecepcionista.setOpaque(false);
        BtEditarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(BtEditarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 50, 40));

        BtBuscarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        BtBuscarRecepcionista.setToolTipText("BUSCAR RECEPCIONISTA");
        BtBuscarRecepcionista.setBorder(null);
        BtBuscarRecepcionista.setOpaque(false);
        BtBuscarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(BtBuscarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 50, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rotacion.png"))); // NOI18N
        jButton1.setToolTipText("VER TODOS");
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, 40));

        text_buscar.setText("Buscar...");
        text_buscar.setToolTipText("");
        text_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_buscarMousePressed(evt);
            }
        });
        getContentPane().add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 40));

        BtIngresarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        BtIngresarRecepcionista.setToolTipText("INGRESAR RECEPCIONISTA");
        BtIngresarRecepcionista.setBorder(null);
        BtIngresarRecepcionista.setOpaque(false);
        BtIngresarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(BtIngresarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 50, 40));

        TablaRecepcionista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Correo", "Telefono", "Dirección", "Fecha de nacimiento", "Tipo de sangre", "Genero", "Hora de ingreso", "Hora de salida"
            }
        ));
        jScrollPane1.setViewportView(TablaRecepcionista);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1240, 310));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wallpaperbetter (1).jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarRecepcionistaActionPerformed
        this.dispose();
        new acceso_administrador().setVisible(true);
    }//GEN-LAST:event_BtRegresarRecepcionistaActionPerformed

    private void BtEliminarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarRecepcionistaActionPerformed
        eliminar_recepcionista();
    }//GEN-LAST:event_BtEliminarRecepcionistaActionPerformed
    public void eliminar_recepcionista() {
        int fila = TablaRecepcionista.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cod;
                String cedula;
                cedula = TablaRecepcionista.getValueAt(fila, 1).toString();
                cod = TablaRecepcionista.getValueAt(fila, 0).toString();
                try {
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM recepcionista where recep_codigo='" + cod + "'");
                     mi_cone.InsertUpdateDeleteAcciones("DELETE FROM persona where per_cedula='" + cedula + "'");
                    
                    cargarTabla();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
    private void BtBuscarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarRecepcionistaActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_recepcionista();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del recepcionista");
        }
    }//GEN-LAST:event_BtBuscarRecepcionistaActionPerformed

    public void buscar_recepcionista() {
        String cedula = text_buscar.getText();
        var recepfiltro = new ArrayList<recepcionista>();

        inser.ListaRecepcionista().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                recepfiltro.add(e);
            }
        });
        if (recepfiltro.size() != 0) {
            String matriz[][] = new String[recepfiltro.size()][14];
            for (int j = 0; j < recepfiltro.size(); j++) {
                matriz[j][0] = String.valueOf(recepfiltro.get(j).getCodigo());
                matriz[j][1] = recepfiltro.get(j).getCedula();
                matriz[j][2] = recepfiltro.get(j).getPri_nomb();
                matriz[j][3] = recepfiltro.get(j).getSeg_nombre();
                matriz[j][4] = recepfiltro.get(j).getPrim_apell();
                matriz[j][5] = recepfiltro.get(j).getSeg_apelli();
                matriz[j][6] = recepfiltro.get(j).getCorreo();
                matriz[j][7] = recepfiltro.get(j).getTelefono();
                matriz[j][8] = recepfiltro.get(j).getDireccion();
                matriz[j][9] = recepfiltro.get(j).getFecha_Nacimiento();
                matriz[j][10] = recepfiltro.get(j).getTipo_sangre();
                matriz[j][11] = recepfiltro.get(j).getGenero();
                matriz[j][12] = recepfiltro.get(j).getHora_ingreso();
                matriz[j][13] = recepfiltro.get(j).getHora_salida();

            }
            TablaRecepcionista.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "Código", "Cédula", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Correo", "Telefono", "Dirección", "Fecha de nacimiento", "Tipo de sangre", "Genero", "Hora de ingreso", "Hora de salida"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "La recepcionista no existe en la base de datos");
        }
    }

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaRecepcionista.getModel();
        tb.setNumRows(0);
        List<recepcionista> com = inser.ListaRecepcionista();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCodigo()), p.getCedula(), p.getPri_nomb(), p.getSeg_nombre(), p.getPrim_apell(), p.getSeg_apelli(), p.getCorreo(), p.getTelefono(), p.getDireccion(), p.getFecha_Nacimiento(), p.getTipo_sangre(), p.getGenero(), p.getHora_ingreso(), p.getHora_salida()};
            tb.addRow(cami);
        });
    }
    private void BtIngresarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarRecepcionistaActionPerformed
        this.dispose();
        new Agregar_recepcionista().setVisible(true);
    }//GEN-LAST:event_BtIngresarRecepcionistaActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        // TODO add your handling code here:
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_buscarMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtEditarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarRecepcionistaActionPerformed
        modificar_recepcionista();
    }//GEN-LAST:event_BtEditarRecepcionistaActionPerformed
    public void modificar_recepcionista() {

        int seleccion = TablaRecepcionista.getSelectedRow();
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            String cedula = TablaRecepcionista.getValueAt(seleccion, 1).toString();
            inser.ListaRecepcionista().forEach((e) -> {
                if (e.getCedula().equals(cedula)) {
                    new Agregar_recepcionista(cedula).setVisible(true);
                    text_buscar.setText("");

                }
            });
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
            java.util.logging.Logger.getLogger(crud_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_recepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_recepcionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarRecepcionista;
    private javax.swing.JButton BtEditarRecepcionista;
    private javax.swing.JButton BtEliminarRecepcionista;
    private javax.swing.JButton BtIngresarRecepcionista;
    private javax.swing.JButton BtRegresarRecepcionista;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTable TablaRecepcionista;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
