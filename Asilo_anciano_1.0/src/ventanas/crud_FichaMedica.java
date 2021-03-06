//
package ventanas;

import clases.administrador;
import clases.paciente;
import clases.claseFichaMedica;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import conexion_bada.Insert_administrador;
import conexion_bada.insert_ficha_medica;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class crud_FichaMedica extends javax.swing.JFrame {

    insert_ficha_medica inserFicha = new insert_ficha_medica();
    Conexion mi_cone = new Conexion();
    Insert inser = new Insert();

    public crud_FichaMedica() {
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

        BtBuscarAdministrador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablafichas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtRegresarAdministrador = new javax.swing.JButton();
        Listar = new javax.swing.JButton();
        BtEliminarAdministrador = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        BtIngresarAdministrador = new javax.swing.JButton();
        BtVer_Ficha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtBuscarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (1).png"))); // NOI18N
        BtBuscarAdministrador.setToolTipText("BUSCAR REGISTRO");
        BtBuscarAdministrador.setBorder(null);
        BtBuscarAdministrador.setOpaque(false);
        BtBuscarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(BtBuscarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, 40));

        Tablafichas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo ficha", "Codigo Paciente", "C??dula", "Nombres", "Apellidos", "Fecha de registro"
            }
        ));
        jScrollPane1.setViewportView(Tablafichas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 980, 250));

        jPanel1.setBackground(new java.awt.Color(240, 239, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE FICHAS MEDICAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        BtRegresarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        BtRegresarAdministrador.setToolTipText("Regresar");
        BtRegresarAdministrador.setBorder(null);
        BtRegresarAdministrador.setOpaque(false);
        BtRegresarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegresarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtRegresarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 50, 40));

        Listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/documento (1).png"))); // NOI18N
        Listar.setToolTipText("VER TODOS");
        Listar.setBorderPainted(false);
        Listar.setOpaque(false);
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });
        jPanel1.add(Listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, 40));

        BtEliminarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/expediente (1).png"))); // NOI18N
        BtEliminarAdministrador.setToolTipText("ELIMINAR FICHA MEDICA");
        BtEliminarAdministrador.setBorder(null);
        BtEliminarAdministrador.setOpaque(false);
        BtEliminarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtEliminarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 50, 40));

        text_buscar.setText("Ingrese el n??mero de c??dula a consultar ...");
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
        jPanel1.add(text_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, 40));

        BtIngresarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/expediente.png"))); // NOI18N
        BtIngresarAdministrador.setToolTipText("INGRESAR FECHA MEDICA");
        BtIngresarAdministrador.setBorder(null);
        BtIngresarAdministrador.setOpaque(false);
        BtIngresarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresarAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(BtIngresarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 50, 40));

        BtVer_Ficha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ver_ficha.png"))); // NOI18N
        BtVer_Ficha.setToolTipText("MODIFICAR FICHAS MEDICAS ");
        BtVer_Ficha.setBorder(null);
        BtVer_Ficha.setOpaque(false);
        BtVer_Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVer_FichaActionPerformed(evt);
            }
        });
        jPanel1.add(BtVer_Ficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarAdministradorActionPerformed
        
        FichaMedica.BotonEnfermedayAlergia=0;
        this.dispose();
        new acceso_enfermera().setVisible(true);
    }//GEN-LAST:event_BtRegresarAdministradorActionPerformed

    private void BtEliminarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarAdministradorActionPerformed
        EliminarFicha();
    }//GEN-LAST:event_BtEliminarAdministradorActionPerformed

    private void BtBuscarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarAdministradorActionPerformed
        if (!text_buscar.getText().isEmpty()) {
            buscar_ficha();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del paciente");
        }
    }//GEN-LAST:event_BtBuscarAdministradorActionPerformed

    private void BtIngresarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresarAdministradorActionPerformed
        this.dispose();
        new FichaMedica().setVisible(true);
    }//GEN-LAST:event_BtIngresarAdministradorActionPerformed

    private void ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_ListarActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        text_buscar.setText("");
    }//GEN-LAST:event_text_buscarMousePressed

    private void BtVer_FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVer_FichaActionPerformed
        ver_ficha();
    }//GEN-LAST:event_BtVer_FichaActionPerformed

    private void text_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_buscarActionPerformed


    public void ver_ficha() {

        int seleccion = Tablafichas.getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            this.dispose();
            int cod_paciente = Integer.parseInt(Tablafichas.getValueAt(seleccion, 1).toString());
            inserFicha.ListaFichaMedica().forEach((e) -> {
                if (e.getCodigo_paciente() == cod_paciente) {
                    new FichaMedica(cod_paciente).setVisible(true);
                    text_buscar.setText("");

                }
            });

        }

    }

    public void SeleccionarFicha() {

        int seleccion = Tablafichas.getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            this.dispose();
            int CodigoP = Integer.parseInt(Tablafichas.getValueAt(seleccion, 0).toString());
            inserFicha.ListaFichaMedica().forEach((e) -> {
                if (e.getCodigo_paciente() == CodigoP) {
                    new ventanas.FichaMedica(CodigoP).setVisible(true);
                    text_buscar.setText("");

                }
            });

        }

    }

    public void EliminarFicha() {

        int fila = Tablafichas.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(this, "??Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String cod;
                String cedula;
                cedula = Tablafichas.getValueAt(fila, 1).toString();
                cod = Tablafichas.getValueAt(fila, 0).toString();
                try {
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM ficha_alergia where fa_codigo_ficha=" + cod + "");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM ficha_enfermedad where fe_codigo_ficha=" + cod + "");
                    mi_cone.InsertUpdateDeleteAcciones("DELETE FROM ficha where ficha_codigo=" + cod + "");

                    cargarTabla();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

    }

    public void cargarTabla() {
        DefaultTableModel tb = (DefaultTableModel) Tablafichas.getModel();
        tb.setNumRows(0);
        List<claseFichaMedica> com = inserFicha.ListaFichaMedica();
        List<paciente> com2 = inser.ListaPaciente();
        com.stream().forEach(f -> {
            com2.stream().forEach(p -> {
                if (f.getCodigo_paciente() == p.getCodigo()) {
                    String[] cami = {String.valueOf(f.getCodigo_ficha_medica()), String.valueOf(f.getCodigo_paciente()), p.getCedula(), p.getPri_nomb() + "  " + p.getSeg_nombre(), p.getPrim_apell() + "  " + p.getSeg_apelli(),p.getFecha_de_ingreso()};
                    tb.addRow(cami);
                }
            });
        });
    }

    public void buscar_ficha() {

        String cedula = text_buscar.getText();
        var fichafiltro = new ArrayList<claseFichaMedica>();

        inserFicha.ListaFichaMedica().forEach((a) -> {
            if (a.getCedula().equals(cedula)) {
                fichafiltro.add(a);
            }
        });
        if (fichafiltro.size() != 0) {
            String matriz[][] = new String[fichafiltro.size()][6];
            for (int j = 0; j < fichafiltro.size(); j++) {
                matriz[j][0] = String.valueOf(fichafiltro.get(j).getCodigo_ficha_medica());
                matriz[j][1] = String.valueOf(fichafiltro.get(j).getCodigo_paciente());
                matriz[j][2] = fichafiltro.get(j).getCedula();
                matriz[j][3] = fichafiltro.get(j).getPri_nomb() + "   " + fichafiltro.get(j).getSeg_nombre();
                matriz[j][4] = fichafiltro.get(j).getPrim_apell() + "   " + fichafiltro.get(j).getSeg_apelli();
                matriz[j][5] = fichafiltro.get(j).getFecha_de_ingreso();

            }
            Tablafichas.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "Codigo ficha", "Codigo Paciente", "C??dula", "Nombres", "Apellidos", "Fecha de registro"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "La ficha no se encuentra registrada");
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
            java.util.logging.Logger.getLogger(crud_FichaMedica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_FichaMedica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_FichaMedica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_FichaMedica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_FichaMedica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarAdministrador;
    private javax.swing.JButton BtEliminarAdministrador;
    private javax.swing.JButton BtIngresarAdministrador;
    private javax.swing.JButton BtRegresarAdministrador;
    private javax.swing.JButton BtVer_Ficha;
    private javax.swing.JButton Listar;
    private javax.swing.JTable Tablafichas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField text_buscar;
    // End of variables declaration//GEN-END:variables
}
