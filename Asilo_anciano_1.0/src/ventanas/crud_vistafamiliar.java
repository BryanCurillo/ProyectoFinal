/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.paciente;
import clases.familiar;
import clases.persona;
import clases.visita_familiar;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import conexion_bada.Conexion;
import javax.swing.table.DefaultTableModel;
import conexion_bada.Insert;
import conexion_bada.Insert_Persona;
import conexion_bada.Insert_visita_familiar;
import conexion_bada.Insert_familiar;
import java.util.Calendar;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class crud_vistafamiliar extends javax.swing.JFrame {

    Conexion cone = new Conexion();
    Insert inser = new Insert();
    Insert_visita_familiar inservisitante = new Insert_visita_familiar();
    Insert_familiar insertfamiliar = new Insert_familiar();
    Insert_Persona insertpersona = new Insert_Persona();

    /**
     * Creates new form crud_vistafamiliar
     */
    public crud_vistafamiliar() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarcod();
        BloquearCamposFamiliar();
        BloquearCamposPaciente();
        cargarTabla();

    }

    public void Buscar_Familiar() {
        String cedula = txtvisitcedula.getText();
        var familiarfiltro = new ArrayList<familiar>();
        insertfamiliar.ListaFamiliar().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                familiarfiltro.add(e);
            }
        });
        if (!familiarfiltro.isEmpty()) {

            for (int i = 0; i < familiarfiltro.size(); i++) {
                txt_codigo_familiar.setText(String.valueOf(familiarfiltro.get(i).getCodigo()));
                txtvisitnombre.setText(familiarfiltro.get(i).getPri_nomb() + " " + familiarfiltro.get(i).getSeg_nombre());
                txtvisitapellido.setText(familiarfiltro.get(i).getPrim_apell() + " " + familiarfiltro.get(i).getSeg_apelli());
            }

        } else {
            JOptionPane.showMessageDialog(this, "El familiar no se encuentra registrado");
            LimpiarCamposVisita();
        }
    }

    public void IngresarVisitante() {
        Insert_visita_familiar fam = new Insert_visita_familiar();

        if (ValidarDatos()) {

            String cedula = txtvisitcedula.getText();
            var familiarfiltro = new ArrayList<familiar>();
            insertfamiliar.ListaFamiliar().forEach((e) -> {
                if (e.getCedula().equals(cedula)) {
                    familiarfiltro.add(e);
                }
            });
            if (!familiarfiltro.isEmpty()) {

                fam.setCod_familiar_visita(Integer.parseInt(txt_codigo_familiar.getText()));
                fam.setCod_paciente_visita(Integer.parseInt(txt_codigo_paciente_visita.getText()));

                fam.setHorario_visita(combohorariovisita.getSelectedItem().toString());

                String dia = Integer.toString(fecha_visita.getCalendar().get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(fecha_visita.getCalendar().get(Calendar.MONTH) + 1);
                String anio = Integer.toString(fecha_visita.getCalendar().get(Calendar.YEAR));
                String fecha = (dia + "-" + mes + "-" + anio);
                fam.setFecha_visita(fecha);

                if (fam.InsertarVisitaFamiliar()) {
                    System.out.println("Conexion Exitosa");
                    LimpiarTodoslosDatos();
                    cargarcod();

                } else {
                    System.out.println("Conexion Erronea");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El familiar  no se encuentra registrado");

            }
        }

    }

    public void Buscar_PacienteDialog() {
        String cedula = txt_buscar_paciente_dialog.getText();
        var pacienteDialogfiltro = new ArrayList<paciente>();
        inser.ListaPaciente().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                pacienteDialogfiltro.add(e);
            }
        });
        if (pacienteDialogfiltro.size() != 0) {

            String matriz[][] = new String[pacienteDialogfiltro.size()][14];
            for (int j = 0; j < pacienteDialogfiltro.size(); j++) {
                matriz[j][0] = String.valueOf(pacienteDialogfiltro.get(j).getCodigo());
                matriz[j][1] = pacienteDialogfiltro.get(j).getCedula();
                matriz[j][2] = pacienteDialogfiltro.get(j).getPri_nomb() + "  " + pacienteDialogfiltro.get(j).getSeg_nombre();
                matriz[j][3] = pacienteDialogfiltro.get(j).getPrim_apell() + "  " + pacienteDialogfiltro.get(j).getSeg_apelli();;

            }
            tabla_paciente_dialog.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "El paciente no se encuentra registrado");
        }
    }

    public void CargarTodosLosPacientes() {
        DefaultTableModel tb = (DefaultTableModel) tabla_paciente_dialog.getModel();
        tb.setNumRows(0);
        List<paciente> com = inser.ListaPaciente();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCodigo()), p.getCedula(), p.getPri_nomb() + "  " + p.getSeg_nombre(), p.getPrim_apell() + "  " + p.getSeg_apelli()};
            tb.addRow(cami);
        });
    }

    public void CargarDatosPacienteEnTXT() {
        int fila = tabla_paciente_dialog.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            String codigoAux;
            String cedulaAux;
            String nombresAux;
            String apellidosAux;

            codigoAux = tabla_paciente_dialog.getValueAt(fila, 0).toString();
            cedulaAux = tabla_paciente_dialog.getValueAt(fila, 1).toString();
            nombresAux = tabla_paciente_dialog.getValueAt(fila, 2).toString();
            apellidosAux = tabla_paciente_dialog.getValueAt(fila, 3).toString();

            txt_codigo_paciente_visita.setText(codigoAux);
            txt_cedula_paciente_visita.setText(cedulaAux);
            txt_nombre_paciente_visita.setText(nombresAux);
            txt_apellido_paciente_visita.setText(apellidosAux);

            registro_paciente.dispose();
        }

    }

    public void buscar_Paciente() {
        String cedula = txt_cedula_paciente_visita.getText();
        var pacientefiltro = new ArrayList<paciente>();
        inser.ListaPaciente().forEach((e) -> {
            if (e.getCedula().equals(cedula)) {
                pacientefiltro.add(e);
            }
        });
        if (pacientefiltro.size() != 0) {

            List<paciente> com = inser.ListaPaciente();
            com.stream().forEach(p -> {
                txt_codigo_paciente_visita.setText(String.valueOf(p.getCodigo()));
                txt_nombre_paciente_visita.setText(p.getPri_nomb().toString());
                txt_apellido_paciente_visita.setText(p.getPrim_apell().toString());

            });

        } else {
            JOptionPane.showMessageDialog(this, "El paciente no existe en la base de datos");
            LimpiarCamposPaciente();
        }
    }

    public void cargarTabla() {
         
        int cod = 0;
        Insert_visita_familiar insertvisita = new Insert_visita_familiar();
        var visitafiltro = new ArrayList<familiar>();
        insertvisita.ListaFamiliares().forEach((e) -> {
            visitafiltro.add(e);
        });

        String matriz[][] = new String[visitafiltro.size()][9];

        for (int i = 0; i < visitafiltro.size(); i++) {

            
            matriz[i][3] = visitafiltro.get(i).getPri_nomb();
            matriz[i][4] = visitafiltro.get(i).getSeg_nombre();
            matriz[i][5] = visitafiltro.get(i).getPrim_apell();
            matriz[i][6] = visitafiltro.get(i).getSeg_apelli();

        }

        var registrofiltro = new ArrayList<clases.visita_familiar>();
        inservisitante.ListaVisita().forEach((e) -> {
            registrofiltro.add(e);
        });

        for (int j = 0; j < registrofiltro.size(); j++) {

            matriz[j][0] = String.valueOf(registrofiltro.get(j).getCod_visita());
            matriz[j][1] = String.valueOf(registrofiltro.get(j).getCod_familiar_visita());
            matriz[j][2] = String.valueOf(registrofiltro.get(j).getCod_paciente_visita());
            matriz[j][7] = registrofiltro.get(j).getFecha_visita();
            matriz[j][8] = registrofiltro.get(j).getHorario_visita();
        }

        tablavisitante.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Codigo Visitante","Codigo Familiar","Codigo Paciente", "Primer Nombre ", "Segundo Nombre","Primer Apellido","Segundo Apellido","Fecha de Visita", "Horario Visita"
                }
        ));
    }

    public void cargarcod() {
        txt_codigo_registro.setEnabled(false);
        txt_codigo_registro.setText(String.valueOf(inservisitante.cargarcodigo()));
    }

    public boolean ValidarDatos() {

        boolean validado = true;

        if (txtvisitcedula.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del visitante");
        }

        if (txt_codigo_paciente_visita.getText().isEmpty()) {
            validado = false;
        }

        if (txt_codigo_registro.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del visitante");
        }

        if (txt_cedula_paciente_visita.getText().isEmpty()) {
            validado = false;
        }

        if (combohorariovisita.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese la hora de la visita del familiar");
        }

        if (fecha_visita.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "Ingrese la fecha de la visita del familiar");
        }

        return validado;
    }

    public boolean validarduplicado(String cedula) throws SQLException {
        boolean validar = false;
        int codigo = 0;
        String sqls = "select count(*) from persona where per_cedula='" + cedula + "';";
        ResultSet dup = cone.selectConsulta(sqls);
//        try {catch
        while (dup.next()) {
            codigo = dup.getInt("count");
        }
        if (codigo == 0) {
            validar = true;
        }

        System.out.println("repetido=" + codigo);
        return validar;
    }

    public void LimpiarTodoslosDatos() {
        LimpiarCamposPaciente();
        LimpiarCamposVisita();
        txt_codigo_registro.setText("");
        txt_cedula_paciente_visita.setText("");
        txtvisitcedula.setText("");
        fecha_visita.setCalendar(null);
        combohorariovisita.setSelectedIndex(0);

    }

    public void LimpiarCamposPaciente() {
        txt_codigo_paciente_visita.setText("");
        txt_nombre_paciente_visita.setText("");
        txt_apellido_paciente_visita.setText("");
    }

    public void LimpiarCamposVisita() {
        txt_codigo_familiar.setText("");
        txtvisitnombre.setText("");
        txtvisitapellido.setText("");

    }

    public void BloquearCamposPaciente() {

        txt_cedula_paciente_visita.setEditable(false);
        txt_codigo_paciente_visita.setEditable(false);
        txt_nombre_paciente_visita.setEditable(false);
        txt_apellido_paciente_visita.setEditable(false);

    }

    public void BloquearCamposFamiliar() {
        txt_codigo_familiar.setEditable(false);
        txtvisitnombre.setEditable(false);
        txtvisitapellido.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registro_paciente = new javax.swing.JDialog();
        txt_buscar_paciente_dialog = new javax.swing.JTextField();
        boton_buscar_paciente_visita_dialog = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cargar_paciente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_paciente_dialog = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fecha_visita = new com.toedter.calendar.JDateChooser();
        boton_guardar_registro = new javax.swing.JButton();
        boton_regresar_acceso_recepcionista = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtvisitcedula = new javax.swing.JTextField();
        boton_buscar_paciente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combohorariovisita = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtvisitnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtvisitapellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_nombre_paciente_visita = new javax.swing.JTextField();
        txt_apellido_paciente_visita = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablavisitante = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txt_cedula_paciente_visita = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_codigo_paciente_visita = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_codigo_registro = new javax.swing.JTextField();
        boton_buscar_familiar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_codigo_familiar = new javax.swing.JTextField();

        txt_buscar_paciente_dialog.setText("Buscar...");
        txt_buscar_paciente_dialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_buscar_paciente_dialogMousePressed(evt);
            }
        });

        boton_buscar_paciente_visita_dialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        boton_buscar_paciente_visita_dialog.setToolTipText("Buscar Paciente");
        boton_buscar_paciente_visita_dialog.setBorder(null);
        boton_buscar_paciente_visita_dialog.setOpaque(false);
        boton_buscar_paciente_visita_dialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_paciente_visita_dialogActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZARTAB.jpeg"))); // NOI18N
        jButton4.setToolTipText("ACTUALIZAR");
        jButton4.setBorder(null);
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cargar_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carga-de-archivos.png"))); // NOI18N
        cargar_paciente.setToolTipText("CARGAR PACIENTE");
        cargar_paciente.setBorder(null);
        cargar_paciente.setOpaque(false);
        cargar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_pacienteActionPerformed(evt);
            }
        });

        tabla_paciente_dialog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS"
            }
        ));
        jScrollPane1.setViewportView(tabla_paciente_dialog);

        javax.swing.GroupLayout registro_pacienteLayout = new javax.swing.GroupLayout(registro_paciente.getContentPane());
        registro_paciente.getContentPane().setLayout(registro_pacienteLayout);
        registro_pacienteLayout.setHorizontalGroup(
            registro_pacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registro_pacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_buscar_paciente_dialog, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_buscar_paciente_visita_dialog)
                .addGap(33, 33, 33)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargar_paciente)
                .addGap(26, 26, 26))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        registro_pacienteLayout.setVerticalGroup(
            registro_pacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registro_pacienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(registro_pacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargar_paciente)
                    .addGroup(registro_pacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4)
                        .addGroup(registro_pacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_buscar_paciente_dialog, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_buscar_paciente_visita_dialog))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(240, 232, 158));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("REGISTRO DE VISITA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Fecha de Visita:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel2.add(fecha_visita, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 150, 30));

        boton_guardar_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar (1).png"))); // NOI18N
        boton_guardar_registro.setToolTipText("GUARDAR");
        boton_guardar_registro.setBorder(null);
        boton_guardar_registro.setOpaque(false);
        boton_guardar_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_registroActionPerformed(evt);
            }
        });
        jPanel2.add(boton_guardar_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        boton_regresar_acceso_recepcionista.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boton_regresar_acceso_recepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        boton_regresar_acceso_recepcionista.setToolTipText("REGRESAR");
        boton_regresar_acceso_recepcionista.setBorder(null);
        boton_regresar_acceso_recepcionista.setOpaque(false);
        boton_regresar_acceso_recepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regresar_acceso_recepcionistaActionPerformed(evt);
            }
        });
        jPanel2.add(boton_regresar_acceso_recepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 330, 40, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Cedula Visitante:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, -1));
        jPanel2.add(txtvisitcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 250, 30));

        boton_buscar_paciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_buscar_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        boton_buscar_paciente.setToolTipText("Buscar");
        boton_buscar_paciente.setBorder(null);
        boton_buscar_paciente.setOpaque(false);
        boton_buscar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_pacienteActionPerformed(evt);
            }
        });
        jPanel2.add(boton_buscar_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Horario de Visita");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        combohorariovisita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion una hora", "1pm-2pm", "2pm-3pm", "3pm-4pm", "4pm-5pm", "5pm-6pm" }));
        combohorariovisita.setOpaque(false);
        combohorariovisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohorariovisitaActionPerformed(evt);
            }
        });
        jPanel2.add(combohorariovisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 130, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Nombres Visitante:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel2.add(txtvisitnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 250, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INFORMACION DE PACIENTE");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 260, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 810, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Apellidos Visitante:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));
        jPanel2.add(txtvisitapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 250, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Nombres:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Apellidos:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));
        jPanel2.add(txt_nombre_paciente_visita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 190, 30));
        jPanel2.add(txt_apellido_paciente_visita, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 200, 30));

        tablavisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Visita", "Codigo Familiar", "Codigo Paciente", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Fecha Visita", "Horario de Visita"
            }
        ));
        jScrollPane2.setViewportView(tablavisitante);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 980, 280));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Cedula:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        jPanel2.add(txt_cedula_paciente_visita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 140, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Codigo Paciente:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));
        jPanel2.add(txt_codigo_paciente_visita, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 70, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Codigo Registro:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));
        jPanel2.add(txt_codigo_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 70, 30));

        boton_buscar_familiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        boton_buscar_familiar.setToolTipText("Buscar Familiar");
        boton_buscar_familiar.setBorder(null);
        boton_buscar_familiar.setOpaque(false);
        boton_buscar_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_familiarActionPerformed(evt);
            }
        });
        jPanel2.add(boton_buscar_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Codigo Familiar:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));
        jPanel2.add(txt_codigo_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_buscar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_pacienteActionPerformed
        // TODO add your handling code here:

        registro_paciente.setSize(529, 309);
        CargarTodosLosPacientes();
        registro_paciente.setVisible(true);
        registro_paciente.setLocationRelativeTo(boton_buscar_paciente);

    }//GEN-LAST:event_boton_buscar_pacienteActionPerformed

    private void boton_regresar_acceso_recepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regresar_acceso_recepcionistaActionPerformed
        // TODO add your handling code here:
        acceso_recepcionista acrep = new acceso_recepcionista();
        acrep.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_regresar_acceso_recepcionistaActionPerformed

    private void combohorariovisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohorariovisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohorariovisitaActionPerformed

    private void boton_buscar_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_familiarActionPerformed
        // TODO add your handling code here:
        Buscar_Familiar();


    }//GEN-LAST:event_boton_buscar_familiarActionPerformed

    private void boton_buscar_paciente_visita_dialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_paciente_visita_dialogActionPerformed
        // TODO add your handling code here:
        if (!txt_buscar_paciente_dialog.getText().isEmpty()) {
            Buscar_PacienteDialog();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del paciente");
        }


    }//GEN-LAST:event_boton_buscar_paciente_visita_dialogActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cargar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_pacienteActionPerformed
        // TODO add your handling code here:
        CargarDatosPacienteEnTXT();
    }//GEN-LAST:event_cargar_pacienteActionPerformed

    private void boton_guardar_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_registroActionPerformed
        // TODO add your handling code here:
        try {
            IngresarVisitante();
        } catch (NullPointerException x) {

            //System.out.println("Error: " + x);
        }
        cargarTabla();
    }//GEN-LAST:event_boton_guardar_registroActionPerformed

    private void txt_buscar_paciente_dialogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscar_paciente_dialogMousePressed
        // TODO add your handling code here:
        txt_buscar_paciente_dialog.setText("");
        txt_buscar_paciente_dialog.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_buscar_paciente_dialogMousePressed

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
            java.util.logging.Logger.getLogger(crud_vistafamiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_vistafamiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_vistafamiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_vistafamiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crud_vistafamiliar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_buscar_familiar;
    private javax.swing.JButton boton_buscar_paciente;
    private javax.swing.JButton boton_buscar_paciente_visita_dialog;
    private javax.swing.JButton boton_guardar_registro;
    private javax.swing.JButton boton_regresar_acceso_recepcionista;
    private javax.swing.JButton cargar_paciente;
    private javax.swing.JComboBox<String> combohorariovisita;
    private com.toedter.calendar.JDateChooser fecha_visita;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDialog registro_paciente;
    private javax.swing.JTable tabla_paciente_dialog;
    private javax.swing.JTable tablavisitante;
    private javax.swing.JTextField txt_apellido_paciente_visita;
    private javax.swing.JTextField txt_buscar_paciente_dialog;
    private javax.swing.JTextField txt_cedula_paciente_visita;
    private javax.swing.JTextField txt_codigo_familiar;
    private javax.swing.JTextField txt_codigo_paciente_visita;
    private javax.swing.JTextField txt_codigo_registro;
    private javax.swing.JTextField txt_nombre_paciente_visita;
    private javax.swing.JTextField txtvisitapellido;
    private javax.swing.JTextField txtvisitcedula;
    private javax.swing.JTextField txtvisitnombre;
    // End of variables declaration//GEN-END:variables
}
