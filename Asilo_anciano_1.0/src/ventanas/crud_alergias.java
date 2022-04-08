package ventanas;

import clases.alergias;
import clases.validaciones;
import conexion_bada.Conexion;
import conexion_bada.Insert_alergias;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class crud_alergias extends javax.swing.JFrame {

    //Objeto de la clase validaciones 
    validaciones misvalidaciones = new validaciones();

    ArrayList<alergias> lista_Alergias = new ArrayList();
    Insert_alergias inser = new Insert_alergias();

    public crud_alergias() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        cargarcod();
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
        txtalergia = new javax.swing.JTextField();
        Guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_alergias = new javax.swing.JTable();
        bt_regresar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        txt_codigo_alergia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 232, 158));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE ALERGIAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Nombre de Alergia:");

        txtalergia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtalergiaMousePressed(evt);
            }
        });
        txtalergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalergiaActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(153, 153, 153));
        Guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar (1).png"))); // NOI18N
        Guardar.setToolTipText("GUARDAR");
        Guardar.setBorder(null);
        Guardar.setOpaque(false);
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        tabla_alergias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre de Alergia"
            }
        ));
        jScrollPane1.setViewportView(tabla_alergias);

        bt_regresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        bt_regresar.setToolTipText("REGRESAR");
        bt_regresar.setBorder(null);
        bt_regresar.setOpaque(false);

        Consultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        Consultar.setToolTipText("CONSULTAR");
        Consultar.setBorder(null);
        Consultar.setOpaque(false);
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Codigo:");

        Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (3).png"))); // NOI18N
        Buscar.setToolTipText("Buscar");
        Buscar.setBorder(null);
        Buscar.setOpaque(false);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Codigo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addComponent(Consultar)
                                .addGap(84, 84, 84)
                                .addComponent(bt_regresar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtalergia, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(Guardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txt_codigo_alergia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_codigo_alergia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Guardar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtalergia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Consultar)
                    .addComponent(bt_regresar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        RegistrarAlergias();
        cargarTabla();
    }//GEN-LAST:event_GuardarActionPerformed

    private void txtalergiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtalergiaMousePressed
//        txtalergia.setText("");
//        txtalergia.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtalergiaMousePressed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        buscar_alergia();
    }//GEN-LAST:event_BuscarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void txtalergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalergiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalergiaActionPerformed

    public void cargarcod() {
        txt_codigo_alergia.setEnabled(false);
        txt_codigo_alergia.setText(String.valueOf(inser.cargarcodigo()));
    }

    public void llenar_alergias() {
        for (int i = 0; i < inser.ListaAlergias().size(); i++) {
            List<alergias> com = inser.ListaAlergias();
            com.stream().forEach(p -> {
                txtalergia.setText(p.getNombre_alergia().toString());
            });
        }
    }

    //Guardar las alergias en la BD
    public void RegistrarAlergias() {
        Insert_alergias alergia = new Insert_alergias();
        try {
            if (validarInformacion() == true && ValidarDuplicados() == true) {
                alergia.setNombre_alergia(txtalergia.getText());
                
                if (alergia.InsertarAlergias()) {
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

        if (txtalergia.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la alergia");
        } else {
            if (!misvalidaciones.validarNombresEspacios(txtalergia.getText())) {
                JOptionPane.showMessageDialog(this, "Nombre de la alergia incorrecto");
                validado = false;
            }
        }
        return validado;
    }

    //Mostrar los datos en la tabla
    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) tabla_alergias.getModel();
        tb.setNumRows(0);
        List<alergias> com = inser.ListaAlergias();
        com.stream().forEach(p -> {
            String[] cami = {p.getCodigo_alergia(), p.getNombre_alergia()};
            tb.addRow(cami);
        });
    }

    public void Limpiar() {
        txtalergia.setText("");
    }

    public void buscar_alergia() {
        String codigo = txtBuscar.getText();
        var alergiafiltro = new ArrayList<alergias>();

        inser.ListaAlergias().forEach((e) -> {
            if (e.getCodigo_alergia().equals(codigo)) {
                alergiafiltro.add(e);
            }
        });
        String matriz[][] = new String[alergiafiltro.size()][3];
        for (int j = 0; j < alergiafiltro.size(); j++) {
            matriz[j][0] = alergiafiltro.get(j).getCodigo_alergia();
            matriz[j][1] = alergiafiltro.get(j).getNombre_alergia();

        }
        tabla_alergias.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "codigo", "Nombre"
                }
        ));
    }

    public boolean ValidarDuplicados() {
        boolean validado = true;
        Insert_alergias inser = new Insert_alergias();
        List<alergias> com = inser.ListaAlergias();

        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).getNombre_alergia().equalsIgnoreCase(txtalergia.getText())) {
                validado = false;
                JOptionPane.showMessageDialog(null, "La alergia ya existe");
            }
        }

        return validado;
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
            java.util.logging.Logger.getLogger(crud_alergias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_alergias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_alergias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_alergias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_alergias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton bt_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_alergias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txt_codigo_alergia;
    private javax.swing.JTextField txtalergia;
    // End of variables declaration//GEN-END:variables
}
