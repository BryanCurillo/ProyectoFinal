/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.doctor;
import clases.paciente;
import clases.cita_medica;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import conexion_bada.Insert_ChequeoMedico;
import conexion_bada.Insert_doctor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class listarCitasMedicas extends javax.swing.JFrame {

    //Insert inserpaciente = new Insert();
    //Insert_doctor inserdoctor = new Insert_doctor();
    Insert_ChequeoMedico inserchequeo = new Insert_ChequeoMedico();
    Conexion mi_cone = new Conexion();

    public listarCitasMedicas() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarDatosChequeoTabla();
    }

//    public void CargarDatosChequeoTabla() {
//
//        var citfiltro = new ArrayList<clases.cita_medica>();
//        inserchequeo.ListaChequeo().forEach((e) -> {
//            citfiltro.add(e);
//        });
//        String matriz[][] = new String[citfiltro.size()][13];
//
//        if (!citfiltro.isEmpty()) {
//
//            var pacifiltro = new ArrayList<paciente>();
//            inserchequeo.ListaChequeoPaciente().forEach((e) -> {
//                pacifiltro.add(e);
//            });
//
//            for (int i = 0; i < pacifiltro.size(); i++) {
//
//                matriz[i][1] = pacifiltro.get(i).getCedula();
//                matriz[i][2] = pacifiltro.get(i).getPri_nomb() + " " + pacifiltro.get(i).getSeg_nombre();
//                matriz[i][3] = pacifiltro.get(i).getPrim_apell() + " " + pacifiltro.get(i).getSeg_apelli();
//
//            }
//
//            var docfiltro = new ArrayList<doctor>();
//            inserchequeo.ListaChequeoDoctor().forEach((e) -> {
//                docfiltro.add(e);
//            });
//
//            for (int j = 0; j < docfiltro.size(); j++) {
//
//                matriz[j][4] = docfiltro.get(j).getCedula();
//                matriz[j][5] = docfiltro.get(j).getPri_nomb() + " " + docfiltro.get(j).getSeg_nombre();
//                matriz[j][6] = docfiltro.get(j).getPrim_apell() + " " + docfiltro.get(j).getSeg_apelli();
//                matriz[j][7] = docfiltro.get(j).getEspecialidad();
//
//            }
//
//            for (int j = 0; j < citfiltro.size(); j++) {
//
//                matriz[j][8] = citfiltro.get(j).getFecha_chequeoActual();
//                matriz[j][9] = citfiltro.get(j).getHoraChequeo();
//                matriz[j][0] = String.valueOf(citfiltro.get(j).getCodigo_citas());
//
//            }
//
//            TablaChequeos.setModel(new javax.swing.table.DefaultTableModel(
//                    matriz,
//                    new String[]{
//                        "Codigo de chequeo","Cédula del paciente", "Nombres del paciente", "Apellidos del paciente", "Cédula del doctor", "Nombres del doctor", "Apellidos del doctor", "Especialidad del doctor", "Fecha del chequeo médico", "Hora del chequeo médico"
//                    }
//            ));
//
//        } else {
//            JOptionPane.showMessageDialog(null, "No existe chequeos medicos registrados");
//        }
//
//    }
//
    public void CargarDatosChequeoTabla() {
        int codCita = 0;

        Insert_ChequeoMedico inserchek = new Insert_ChequeoMedico();
        List<cita_medica> com = inserchek.ListaChequeo();

        String matriz[][] = new String[com.size()][15];

        for (int i = 0; i < com.size(); i++) {
            codCita = com.get(i).getCodigo_citas();

            //System.out.println("CodCita: " + codCita);
            matriz[i][0] = String.valueOf(com.get(i).getCodigo_citas());
            matriz[i][8] = com.get(i).getFecha_chequeoActual();
            matriz[i][9] = com.get(i).getHoraChequeo();

            //Paciente
            var pacifiltro = new ArrayList<paciente>();
            inserchequeo.ListaChequeoPaciente(codCita).forEach((e) -> {
                pacifiltro.add(e);
            });

            for (int j = 0; j < pacifiltro.size(); j++) {
                matriz[i][1] = pacifiltro.get(j).getCedula();
                matriz[i][2] = pacifiltro.get(j).getPri_nomb() + " " + pacifiltro.get(j).getSeg_nombre();
                matriz[i][3] = pacifiltro.get(j).getPrim_apell() + " " + pacifiltro.get(j).getSeg_apelli();

            }

            //Doctor
            var docfiltro = new ArrayList<doctor>();
            inserchequeo.ListaChequeoDoctor(codCita).forEach((e) -> {
                docfiltro.add(e);
            });

            for (int j = 0; j < docfiltro.size(); j++) {
                matriz[i][4] = docfiltro.get(j).getCedula();
                matriz[i][5] = docfiltro.get(j).getPri_nomb() + " " + docfiltro.get(j).getSeg_nombre();
                matriz[i][6] = docfiltro.get(j).getPrim_apell() + " " + docfiltro.get(j).getSeg_apelli();
                matriz[i][7] = docfiltro.get(j).getEspecialidad();
            }
        }

        TablaChequeos.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Codigo de chequeo", "Cédula del paciente", "Nombres del paciente", "Apellidos del paciente", "Cédula del doctor", "Nombres del doctor", "Apellidos del doctor", "Especialidad", "Fecha del chequeo médico", "Hora del chequeo médico"
                }
        ));
    }

    public void CancelarChequeo() {

        int fila = TablaChequeos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar la cita?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                String codigoCita;
                codigoCita = TablaChequeos.getValueAt(fila, 0).toString();
                try {
                    mi_cone.InsertUpdateDeleteAcciones("UPDATE cita SET cita_estado = 'No' Where cita_codigo = '" + codigoCita + "'");
                    JOptionPane.showMessageDialog(null, "La cita ha sido cancelada con éxito");
                    CargarDatosChequeoTabla();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaChequeos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        CancelarChequeo = new javax.swing.JButton();
        ModificarCitaMedica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE CHEQUEOS MEDICOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 11, -1, -1));

        TablaChequeos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo de chequeo", "Cédula del paciente", "Nombres del Paciente", "Apellidos del Paciente", "Cedula del doctor", "Nombre del Doctor", "Apellido del Doctor", "Especialidad del Doctor", "Fecha Chequeo ", "Hora  Chequeo"
            }
        ));
        jScrollPane1.setViewportView(TablaChequeos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1180, 190));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hogar_de_los_ancianos__1_-removebg-preview (2).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(906, 11, -1, 90));

        CancelarChequeo.setText("Cancelar Chequeo");
        CancelarChequeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarChequeoActionPerformed(evt);
            }
        });
        jPanel1.add(CancelarChequeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        ModificarCitaMedica.setText("Modificar");
        ModificarCitaMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarCitaMedicaActionPerformed(evt);
            }
        });
        jPanel1.add(ModificarCitaMedica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarChequeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarChequeoActionPerformed
        CancelarChequeo();
    }//GEN-LAST:event_CancelarChequeoActionPerformed

    private void ModificarCitaMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarCitaMedicaActionPerformed
        modificar_Cita();
    }//GEN-LAST:event_ModificarCitaMedicaActionPerformed

    public void modificar_Cita() {

        int seleccion = TablaChequeos.getSelectedRow();

        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {
            this.dispose();
            int codigo = (Integer) TablaChequeos.getValueAt(seleccion, 1);
            inserchequeo.ListaChequeo().forEach((e) -> {
                if (e.getCodigo_citas() == codigo) {

                    new agregar_citamedica(codigo).setVisible(true);
                    
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
            java.util.logging.Logger.getLogger(listarCitasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarCitasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarCitasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarCitasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarCitasMedicas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarChequeo;
    private javax.swing.JButton ModificarCitaMedica;
    private javax.swing.JTable TablaChequeos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
