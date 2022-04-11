package ventanas;

import ventanas.Agregar_paciente;
import clases.paciente;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class crud_paciente extends javax.swing.JFrame {

    Insert inser = new Insert();
    Conexion mi_cone = new Conexion();

    public crud_paciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        apagar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtIngresarPaciente = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        BtBuscarPaciente = new javax.swing.JButton();
        BtEditarPaciente = new javax.swing.JButton();
        BtEliminarPaciente = new javax.swing.JButton();
        BtRegresarPaciente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPaciente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 211, 139));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 59, 153));
        jLabel2.setText("LISTA DE PACIENTES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        BtIngresarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        BtIngresarPaciente.setToolTipText("INGRESAR PACIENTE");
        BtIngresarPaciente.setBorder(null);
        BtIngresarPaciente.setOpaque(false);
        BtIngresarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtIngresarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 50, 40));

        text_buscar.setText("Buscar...");
        text_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_buscarMousePressed(evt);
            }
        });
        jPanel1.add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 210, 30));

        BtBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        BtBuscarPaciente.setToolTipText("BUSCAR PACIENTE");
        BtBuscarPaciente.setBorder(null);
        BtBuscarPaciente.setOpaque(false);
        BtBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, 40));

        BtEditarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        BtEditarPaciente.setBorder(null);
        BtEditarPaciente.setOpaque(false);
        BtEditarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtEditarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 50, 40));

        BtEliminarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar-usuario.png"))); // NOI18N
        BtEliminarPaciente.setToolTipText("ELIMINAR PACIENTE");
        BtEliminarPaciente.setBorder(null);
        BtEliminarPaciente.setOpaque(false);
        BtEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtEliminarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 50, 40));

        BtRegresarPaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtRegresarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        BtRegresarPaciente.setToolTipText("Regresar");
        BtRegresarPaciente.setBorder(null);
        BtRegresarPaciente.setOpaque(false);
        BtRegresarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(BtRegresarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 50, 40));

        TablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cédula", "Primer nombre", "segundo nombre", "Primer apellido", "Segundo apellido", "E-mail", "Sexo", "Dirección", "Celular", "Tipo de sangre", "Seguro", "Fecha de nacimiento", "Fecha de ingreso"
            }
        ));
        jScrollPane1.setViewportView(TablaPaciente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 980, 280));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rotacion.png"))); // NOI18N
        jButton1.setToolTipText("Ver todos");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtIngresarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarPacienteActionPerformed
        this.dispose();
        new Agregar_paciente().setVisible(true);

    }//GEN-LAST:event_BtIngresarPacienteActionPerformed

    private void BtRegresarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarPacienteActionPerformed
        if (acceso_recepcionista.Botones == 1) {
            acceso_recepcionista mi_accesoR = new acceso_recepcionista();
            mi_accesoR.setVisible(true);
            dispose();
        }else{
            if(acceso_administrador.BotonAgregarApagar == 2){
                acceso_administrador mi_accesoA = new acceso_administrador();
                mi_accesoA.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_BtRegresarPacienteActionPerformed

    private void BtEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarPacienteActionPerformed
        eliminar_paciente();
    }//GEN-LAST:event_BtEliminarPacienteActionPerformed

    public void apagar() {
        if (acceso_recepcionista.Botones == 1) {
            BtEliminarPaciente.setEnabled(false);
        } else {
            if (acceso_administrador.BotonAgregarApagar == 2) {
                BtIngresarPaciente.setEnabled(false);
            }
        }
    }
    //Desactiva los botones al ingresar como Recepcionista
//    public void DesactivarBotonModificarYEliminar() {
//        BtEditarPaciente.setEnabled(false);
//        BtEliminarPaciente.setEnabled(false);
//    }

    //Desactiva los botones al ingresar como Recepcionista
//    public void DesactivarBotonAgregar() {
//        BtIngresarPaciente.setEnabled(false);
//    }
    public void eliminar_paciente() {
        int fila = TablaPaciente.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cod;
                String cedula;
                cedula = TablaPaciente.getValueAt(fila, 1).toString();
                cod = TablaPaciente.getValueAt(fila, 0).toString();
                try {
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM paciente where paci_codigo='" + cod + "'");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM persona where per_cedula='" + cedula + "'");
                    cargarTabla();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
    private void BtBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarPacienteActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_paciente();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del administrador");
        }

    }//GEN-LAST:event_BtBuscarPacienteActionPerformed

    private void BtEditarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarPacienteActionPerformed
        modificar_paciente();
    }//GEN-LAST:event_BtEditarPacienteActionPerformed
    public void modificar_paciente() {
        int seleccion = TablaPaciente.getSelectedRow();
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            String cedula = TablaPaciente.getValueAt(seleccion, 1).toString();
//            System.out.println(cedula);
            inser.ListaPaciente().forEach((e) -> {
                if (e.getCedula().equals(cedula)) {
                    new Agregar_paciente(cedula).setVisible(true);
                    this.dispose();
                    text_buscar.setText("");

                }
            });
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);

    }//GEN-LAST:event_text_buscarMousePressed

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) TablaPaciente.getModel();
        tb.setNumRows(0);
        List<paciente> com = inser.ListaPaciente();
        com.stream().forEach(p -> {
            String[] cami = {p.getCodigo(), p.getCedula(), p.getPri_nomb(), p.getSeg_nombre(), p.getPrim_apell(), p.getSeg_apelli(), p.getCorreo(), p.getGenero(), p.getDireccion(), p.getTelefono(), p.getTipo_sangre(), p.getSeguro(), p.getFecha_Nacimiento(), p.getFecha_de_ingreso()};
            tb.addRow(cami);
        });
        
    }

    public void buscar_paciente() {
        String cedula = text_buscar.getText();
        var pacientefiltro = new ArrayList<paciente>();
        inser.ListaPaciente().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                pacientefiltro.add(e);
            }
        });
        if (pacientefiltro.size() != 0) {

            String matriz[][] = new String[pacientefiltro.size()][14];
            for (int j = 0; j < pacientefiltro.size(); j++) {
                matriz[j][0] = pacientefiltro.get(j).getCodigo();
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
                matriz[j][11] = pacientefiltro.get(j).getSeguro();
                matriz[j][12] = pacientefiltro.get(j).getFecha_Nacimiento();
                matriz[j][13] = pacientefiltro.get(j).getFecha_de_ingreso();

            }
            TablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "codigo", "Nombre", "segundo_nombre", "primer apellido", "segundo apellido", "correo", "genero", "direccion", "telefono", "tipo sangre", "seguro", "fecha nacimiento", "fecha ingreso"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "El paciente no existe en la base de datos");
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
            java.util.logging.Logger.getLogger(crud_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarPaciente;
    private javax.swing.JButton BtEditarPaciente;
    private javax.swing.JButton BtEliminarPaciente;
    private javax.swing.JButton BtIngresarPaciente;
    private javax.swing.JButton BtRegresarPaciente;
    public javax.swing.JTable TablaPaciente;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
