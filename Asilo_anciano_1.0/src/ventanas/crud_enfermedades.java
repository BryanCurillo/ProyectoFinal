/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.ArrayList;
import clases.enfermedades;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import conexion_bada.insert_enfermedad;
import javax.swing.JOptionPane;
import clases.validaciones;

/**
 *
 * @author Usuario
 */
public class crud_enfermedades extends javax.swing.JFrame {

    insert_enfermedad inser = new insert_enfermedad();

    //Objeto de la clase validaciones 
    validaciones misvalidaciones = new validaciones();

    public crud_enfermedades() {

        this.setTitle("Enfermedades");
        initComponents();
        this.setLocationRelativeTo(null);
//        limpiarDatos();
        cargarTabla();
        cargarcod();
    }
    
    public void cargarcod() {
        txt_codigo.setEnabled(false);
        txt_codigo.setText(String.valueOf(inser.cargarcodigo()));
    }

    public void guardarEnfermedad() {
        insert_enfermedad enfermedades = new insert_enfermedad();

        try {
            if (validarInformacion() == true && ValidarDuplicados() == true) {
                enfermedades.setNombre_enfermedad(txtEnfermedad.getText());
                

                if (enfermedades.insert_enfermedad()) {
                    System.out.println("Conexion Exitosa");
                    Limpiar();
                    cargarcod();
                } else {
                    System.out.println("Conexion Erronea");
                }
            }

        } catch (NullPointerException e) {

        }
    }

    public boolean validarInformacion() {
        boolean validado = true;

        if (txtEnfermedad.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la enfermedad");
        } else {
            if (!misvalidaciones.validarNombresEspacios(txtEnfermedad.getText())) {
                JOptionPane.showMessageDialog(this, "Nombre de la enfermedad incorrecto");
                validado = false;
            }
        }

        return validado;
    }

    public void Limpiar() {
        txtEnfermedad.setText("");
    }

    public void limpiarDatos() {
        txtEnfermedad.setText("");
    }

    public void llenar_enfermedades() {

        for (int i = 0; i < inser.ListEnfermedad().size(); i++) {

            List<enfermedades> com = inser.ListEnfermedad();
            com.stream().forEach(p -> {
                txtEnfermedad.setText(p.getNombre_enfermedad().toString());

            });
        }

    }

    public void cargarTabla() {
        DefaultTableModel tab = (DefaultTableModel) tabla_enfermedad.getModel();
        tab.setNumRows(0);
        List<enfermedades> com = inser.ListEnfermedad();
        com.stream().forEach(p -> {
            String[] cami = {p.getCodigo_enfermedad(), p.getNombre_enfermedad()};
            tab.addRow(cami);

        });

    }

    public void buscar_enfermedad() {
        String codigo = txtBuscar.getText();
        var enfermedadfiltro = new ArrayList<enfermedades>();

        inser.ListEnfermedad().forEach((e) -> {
            if (e.getCodigo_enfermedad().equals(codigo)) {
                enfermedadfiltro.add(e);
            }
        });
        String matriz[][] = new String[enfermedadfiltro.size()][3];
        for (int j = 0; j < enfermedadfiltro.size(); j++) {
            matriz[j][0] = enfermedadfiltro.get(j).getCodigo_enfermedad();
            matriz[j][1] = enfermedadfiltro.get(j).getNombre_enfermedad();

        }
        tabla_enfermedad.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "codigo", "Nombre"
                }
        ));
    }
    
    public boolean ValidarDuplicados() { 
        boolean validado = true;
        insert_enfermedad inser = new insert_enfermedad();
        List<enfermedades> com = inser.ListEnfermedad();

        for (int i = 0; i < com.size(); i++) {
            if(com.get(i).getNombre_enfermedad().equalsIgnoreCase(txtEnfermedad.getText())){
                validado = false;
                JOptionPane.showMessageDialog(null, "La enfermedad ya existe");
            }
        }
        
        return validado;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonguardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_enfermedad = new javax.swing.JTable();
        boton_regresar_acceso = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        txtEnfermedad = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 232, 158));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE ENFERMEDADES  ");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Nombre de Enfermedades");

        botonguardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar (1).png"))); // NOI18N
        botonguardar.setToolTipText("GUARDAR");
        botonguardar.setBorder(null);
        botonguardar.setOpaque(false);
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });

        tabla_enfermedad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre de Enfermedad"
            }
        ));
        jScrollPane1.setViewportView(tabla_enfermedad);

        boton_regresar_acceso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_regresar_acceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_regresar_acceso.setToolTipText("REGRESAR");
        boton_regresar_acceso.setBorder(null);
        boton_regresar_acceso.setOpaque(false);
        boton_regresar_acceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regresar_accesoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Código:");

        Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        Buscar.setToolTipText("Buscar");
        Buscar.setBorder(null);
        Buscar.setOpaque(false);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Consultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (1).png"))); // NOI18N
        Consultar.setToolTipText("CONSULTAR");
        Consultar.setBorder(null);
        Consultar.setOpaque(false);
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Codigo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(txtEnfermedad, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(Consultar)
                                .addGap(116, 116, 116)
                                .addComponent(boton_regresar_acceso)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Consultar)
                    .addComponent(boton_regresar_acceso))
                .addGap(187, 187, 187))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
        // TODO add your handling code here:
        guardarEnfermedad();
        cargarTabla();

    }//GEN-LAST:event_botonguardarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        buscar_enfermedad();
    }//GEN-LAST:event_BuscarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void txtEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnfermedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnfermedadActionPerformed

    private void boton_regresar_accesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regresar_accesoActionPerformed
        // TODO add your handling code here:
        acceso_enfermera enferm = new acceso_enfermera();
        enferm.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_regresar_accesoActionPerformed

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
            java.util.logging.Logger.getLogger(crud_enfermedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_enfermedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_enfermedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_enfermedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_enfermedades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton boton_regresar_acceso;
    private javax.swing.JButton botonguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_enfermedad;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEnfermedad;
    private javax.swing.JTextField txt_codigo;
    // End of variables declaration//GEN-END:variables
}
