package ventanas;

import clases.usuario;
import conexion_bada.Insert_usuario;
import clases.especialidad;
import javax.swing.JOptionPane;
import clases.validaciones;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import clases.familiar;
import clases.paciente;
import conexion_bada.Insert_familiar;
//import conexion_bada.Insert;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class agregar_familiar extends javax.swing.JFrame {

    DateFormat df = DateFormat.getDateInstance();
    ArrayList<familiar> lista_familiar = new ArrayList();
    Conexion mi_cone = new Conexion();
    validaciones misvalidaciones = new validaciones();
    Insert inser = new Insert();
    Insert_usuario usu = new Insert_usuario();
    Insert_familiar insertFamiliar = new Insert_familiar();
    crud_familiar cruddami = new crud_familiar();
    Conexion cone = new Conexion();

    public agregar_familiar() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarcod();
        txt_codPaci.setEnabled(false);
        boton_modificar.setVisible(false);
    }

    public agregar_familiar(String cedula) {
        initComponents();
        this.setLocationRelativeTo(null);
        GuardarFamiliar.setVisible(false);
        String SQL_SELECT = "SELECT * FROM familiar WHERE fam_cedula = " + cedula + ";";
        llenar_familiar(cedula);
    }

    public void llenar_familiar(String cedula) {
        text_cedula_familiar.setEnabled(false);
        List<familiar> com = insertFamiliar.ListaFamiliar();
        com.stream().forEach(p -> {
            if (cedula.equalsIgnoreCase(p.getCedula())) {
                txtCodigo.setText(String.valueOf(p.getCodigo()));
                text_cedula_familiar.setText(p.getCedula().toString());
                text_PrimerNombre_familiar.setText(p.getPri_nomb().toString());
                text_SegundoNombre_familiar.setText(p.getSeg_nombre().toString());
                text_PrimerApellido_familiar.setText(p.getPrim_apell().toString());
                text_SegundoApellido_familiar.setText(p.getSeg_apelli().toString());
                text_email_familiar.setText(p.getCorreo().toString());
                text_direccion_familiar.setText(p.getDireccion());
                text_celular_familiar.setText(p.getTelefono());
                for (int j = 0; j < jcb_parentesco.getItemCount(); j++) {
                    if (jcb_parentesco.getItemAt(j).equalsIgnoreCase(p.getParectesco())) {
                        jcb_parentesco.setSelectedIndex(j);
                        j = jcb_parentesco.getItemCount();
                    }
                }
                if (p.getGenero().equalsIgnoreCase("hombre")) {
                    Masculino_familiar.setSelected(true);
                }
                if (p.getGenero().equalsIgnoreCase("mujer")) {
                    Femenino_familiar.setSelected(true);
                }
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = null;
                try {
                    fecha = formatofecha.parse(p.getFecha_Nacimiento());
                } catch (ParseException ex) {
                    Logger.getLogger(Agregar_administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                fecha_nacimiento_familiar.setDate(fecha);

                for (int i = 0; i < combo_sangre_familiar.getItemCount(); i++) {
                    if (combo_sangre_familiar.getItemAt(i).equalsIgnoreCase(p.getTipo_sangre())) {
                        combo_sangre_familiar.setSelectedIndex(i);
                        i = combo_sangre_familiar.getItemCount();
                    }
                }
                txt_codPaci.setText(String.valueOf(p.getCodigo_paciente()));

                List<usuario> usua = usu.ListaUsuariosModi(String.valueOf(p.getCod_usuario()), "familiar", "fam");
                usua.stream().forEach(u -> {
                    txtUsuario.setText(u.getUsuario());
                    txtContrasenia.setText(u.getContraseña());
                });
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Genero_familiar = new javax.swing.ButtonGroup();
        cargarPaciente = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPaciente = new javax.swing.JTable();
        BtBuscarFamiliar = new javax.swing.JButton();
        text_buscar = new javax.swing.JTextField();
        cargarP = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Masculino_familiar = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RegresarFamiliar = new javax.swing.JButton();
        GuardarFamiliar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Femenino_familiar = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fecha_nacimiento_familiar = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        text_cedula_familiar = new javax.swing.JTextField();
        text_PrimerNombre_familiar = new javax.swing.JTextField();
        text_SegundoNombre_familiar = new javax.swing.JTextField();
        text_PrimerApellido_familiar = new javax.swing.JTextField();
        text_SegundoApellido_familiar = new javax.swing.JTextField();
        text_direccion_familiar = new javax.swing.JTextField();
        text_email_familiar = new javax.swing.JTextField();
        text_celular_familiar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        combo_sangre_familiar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        boton_modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        jcb_parentesco = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        buscarp = new javax.swing.JButton();
        txt_codPaci = new javax.swing.JTextField();

        cargarPaciente.setResizable(false);

        TablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS"
            }
        ));
        TablaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaPacienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPaciente);

        BtBuscarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        BtBuscarFamiliar.setToolTipText("BUSCAR PACIENTE");
        BtBuscarFamiliar.setBorder(null);
        BtBuscarFamiliar.setOpaque(false);
        BtBuscarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarFamiliarActionPerformed(evt);
            }
        });

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

        cargarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carga-de-archivos.png"))); // NOI18N
        cargarP.setToolTipText("CARGAR CEDULA");
        cargarP.setBorder(null);
        cargarP.setOpaque(false);
        cargarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarPActionPerformed(evt);
            }
        });

        boton_actualizar.setText("Actualizar");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cargarPacienteLayout = new javax.swing.GroupLayout(cargarPaciente.getContentPane());
        cargarPaciente.getContentPane().setLayout(cargarPacienteLayout);
        cargarPacienteLayout.setHorizontalGroup(
            cargarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarPacienteLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cargarPacienteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(text_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtBuscarFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(boton_actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargarP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        cargarPacienteLayout.setVerticalGroup(
            cargarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cargarPacienteLayout.createSequentialGroup()
                .addGroup(cargarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cargarPacienteLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(text_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cargarPacienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtBuscarFamiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cargarPacienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cargarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cargarPacienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boton_actualizar)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(240, 239, 180));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Primer Nombre:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Segundo Nombre:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("E-mail:");

        Genero_familiar.add(Masculino_familiar);
        Masculino_familiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Masculino_familiar.setText("M");
        Masculino_familiar.setOpaque(false);
        Masculino_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Masculino_familiarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Sexo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Segundo Apellido:");

        RegresarFamiliar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RegresarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        RegresarFamiliar.setToolTipText("Regresar");
        RegresarFamiliar.setBorder(null);
        RegresarFamiliar.setOpaque(false);
        RegresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarFamiliarActionPerformed(evt);
            }
        });

        GuardarFamiliar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        GuardarFamiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar (1).png"))); // NOI18N
        GuardarFamiliar.setToolTipText("Guardar");
        GuardarFamiliar.setBorder(null);
        GuardarFamiliar.setOpaque(false);
        GuardarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarFamiliarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Dirección:");

        Genero_familiar.add(Femenino_familiar);
        Femenino_familiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Femenino_familiar.setText("F");
        Femenino_familiar.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Primer Apellido:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Cédula:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Fecha de Nacimiento:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Celular:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Datos Personales");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        text_cedula_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_cedula_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_cedula_familiar.setText("Ingrese la Cedula");
        text_cedula_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_cedula_familiarMousePressed(evt);
            }
        });
        text_cedula_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_cedula_familiarActionPerformed(evt);
            }
        });

        text_PrimerNombre_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_PrimerNombre_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_PrimerNombre_familiar.setText("Ingrese el Primer Nombre");
        text_PrimerNombre_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_PrimerNombre_familiarMousePressed(evt);
            }
        });
        text_PrimerNombre_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_PrimerNombre_familiarActionPerformed(evt);
            }
        });

        text_SegundoNombre_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_SegundoNombre_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_SegundoNombre_familiar.setText("Ingrese el Segundo Nombre");
        text_SegundoNombre_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_SegundoNombre_familiarMousePressed(evt);
            }
        });

        text_PrimerApellido_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_PrimerApellido_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_PrimerApellido_familiar.setText("Ingrese el Primer Apellido");
        text_PrimerApellido_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_PrimerApellido_familiarMousePressed(evt);
            }
        });

        text_SegundoApellido_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_SegundoApellido_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_SegundoApellido_familiar.setText("Ingrese el Segundo Apellido");
        text_SegundoApellido_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_SegundoApellido_familiarMousePressed(evt);
            }
        });
        text_SegundoApellido_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_SegundoApellido_familiarActionPerformed(evt);
            }
        });

        text_direccion_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_direccion_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_direccion_familiar.setText("Ingrese la Dirección");
        text_direccion_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_direccion_familiarMousePressed(evt);
            }
        });
        text_direccion_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_direccion_familiarActionPerformed(evt);
            }
        });

        text_email_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_email_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_email_familiar.setText("Ingrese el E-mail");
        text_email_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_email_familiarMousePressed(evt);
            }
        });

        text_celular_familiar.setForeground(new java.awt.Color(102, 102, 102));
        text_celular_familiar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_celular_familiar.setText("Ingrese el celular");
        text_celular_familiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_celular_familiarMousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Tipo de Sangre:");

        combo_sangre_familiar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Parentesco Familiar:");

        boton_modificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar (1).png"))); // NOI18N
        boton_modificar.setToolTipText("MODIFICAR");
        boton_modificar.setBorder(null);
        boton_modificar.setOpaque(false);
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Familiar");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Codigo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("CREAR USUARIO");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("NUEVO USUARIO:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("NUEVA CONTRASEÑA:");

        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setText("Ej: Usuario1");
        txtUsuario.setToolTipText("El usuario debe contener minimo 3 letras y 1 numero");
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtContrasenia.setForeground(new java.awt.Color(102, 102, 102));
        txtContrasenia.setText("Ej: Pass1@");
        txtContrasenia.setToolTipText("Debe contener minimo 1 letra minus, 1 mayus, 1 numero y un caracter especial, minimo 5caract. y max 20");
        txtContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseniaMousePressed(evt);
            }
        });
        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyTyped(evt);
            }
        });

        jcb_parentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el parentesco", "Padre/Madre", "Suegro/a", "Hijo/a", "Yerno/Nuera", "Nieto/a", "Hermano/a", "Cuñado/a", "Tio/a", "Sobrino/a" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Paciente:");

        buscarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar (2).png"))); // NOI18N
        buscarp.setToolTipText("buscar paciente");
        buscarp.setBorder(null);
        buscarp.setOpaque(false);
        buscarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarpActionPerformed(evt);
            }
        });

        txt_codPaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codPaciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(98, 98, 98)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_email_familiar)
                            .addComponent(text_SegundoNombre_familiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_PrimerNombre_familiar)
                            .addComponent(text_cedula_familiar)
                            .addComponent(text_PrimerApellido_familiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_SegundoApellido_familiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_direccion_familiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_celular_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(GuardarFamiliar)
                        .addGap(56, 56, 56)
                        .addComponent(boton_modificar)
                        .addGap(61, 61, 61)
                        .addComponent(RegresarFamiliar)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jcb_parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(129, 129, 129)
                                                .addComponent(Masculino_familiar)
                                                .addGap(35, 35, 35)
                                                .addComponent(Femenino_familiar))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel19))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(combo_sangre_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(fecha_nacimiento_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(49, 49, 49)
                                                .addComponent(txt_codPaci, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buscarp)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(393, 393, 393))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(text_cedula_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(text_PrimerNombre_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text_SegundoNombre_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscarp)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(txt_codPaci, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcb_parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(text_PrimerApellido_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Femenino_familiar)
                            .addComponent(Masculino_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha_nacimiento_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(text_SegundoApellido_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_direccion_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(text_email_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_modificar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RegresarFamiliar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GuardarFamiliar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(combo_sangre_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(text_celular_familiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtBuscarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarFamiliarActionPerformed

        if (!text_buscar.getText().isEmpty()) {
            buscar_paciente();
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del paciente");
        }
    }//GEN-LAST:event_BtBuscarFamiliarActionPerformed

    private void text_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_buscarMousePressed
        // TODO add your handling code here:
        text_buscar.setText("");
        text_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_buscarMousePressed

    private void text_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_buscarActionPerformed

    private void TablaPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPacienteMousePressed

    }//GEN-LAST:event_TablaPacienteMousePressed

    private void cargarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarPActionPerformed
        cargar_codigo_paci();

    }//GEN-LAST:event_cargarPActionPerformed

    private void buscarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarpActionPerformed
        cargarPaciente.setSize(494, 258);
        cargarTablaF();
        cargarPaciente.setVisible(true);
        cargarPaciente.setLocationRelativeTo(buscarp);
    }//GEN-LAST:event_buscarpActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificarlo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            modificar_familiar();
        }
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void text_celular_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_celular_familiarMousePressed
        text_celular_familiar.setText("");
        text_celular_familiar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_celular_familiarMousePressed

    private void text_email_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_email_familiarMousePressed
        text_email_familiar.setText("");
        text_email_familiar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_email_familiarMousePressed

    private void text_direccion_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_direccion_familiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_direccion_familiarActionPerformed

    private void text_direccion_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_direccion_familiarMousePressed
        text_direccion_familiar.setText("");
        text_direccion_familiar.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_direccion_familiarMousePressed

    private void text_SegundoApellido_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_SegundoApellido_familiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_SegundoApellido_familiarActionPerformed

    private void text_SegundoApellido_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_SegundoApellido_familiarMousePressed
        text_SegundoApellido_familiar.setText("");
        text_SegundoApellido_familiar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_SegundoApellido_familiarMousePressed

    private void text_PrimerApellido_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_PrimerApellido_familiarMousePressed
        text_PrimerApellido_familiar.setText("");
        text_PrimerApellido_familiar.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_PrimerApellido_familiarMousePressed

    private void text_SegundoNombre_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_SegundoNombre_familiarMousePressed
        text_SegundoNombre_familiar.setText("");
        text_SegundoNombre_familiar.setForeground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_text_SegundoNombre_familiarMousePressed

    private void text_PrimerNombre_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_PrimerNombre_familiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_PrimerNombre_familiarActionPerformed

    private void text_PrimerNombre_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_PrimerNombre_familiarMousePressed
        text_PrimerNombre_familiar.setText("");
        text_PrimerNombre_familiar.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_PrimerNombre_familiarMousePressed

    private void text_cedula_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_cedula_familiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_cedula_familiarActionPerformed

    private void text_cedula_familiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_cedula_familiarMousePressed
        if (text_cedula_familiar.getText().equalsIgnoreCase("Ingrese la cedula")) {
            text_cedula_familiar.setText("");
        }
        
        text_cedula_familiar.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_cedula_familiarMousePressed

    private void GuardarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarFamiliarActionPerformed
        try {
            RegistrarFamiliar();
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GuardarFamiliarActionPerformed

    private void RegresarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarFamiliarActionPerformed
        crud_familiar mi_crudF = new crud_familiar();
        mi_crudF.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarFamiliarActionPerformed

    private void Masculino_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masculino_familiarActionPerformed

    }//GEN-LAST:event_Masculino_familiarActionPerformed

    private void txt_codPaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codPaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codPaciActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        txtUsuario.setText("");
        txtUsuario.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseniaMousePressed
        txtContrasenia.setText("");
        txtUsuario.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtContraseniaMousePressed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        cargarTablaF();
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyTyped
        txtContrasenia.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtContraseniaKeyTyped

    public void modificar_familiar() {
        String genero = "";
        if (Masculino_familiar.isSelected()) {
            genero = "hombre";
        }
        if (Femenino_familiar.isSelected()) {
            genero = "mujer";
        }
        String tipoo_sangre = combo_sangre_familiar.getSelectedItem().toString();

        String dia = Integer.toString(fecha_nacimiento_familiar.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(fecha_nacimiento_familiar.getCalendar().get(Calendar.MONTH) + 1);
        String año = Integer.toString(fecha_nacimiento_familiar.getCalendar().get(Calendar.YEAR));
        String FechaNacimiento = (dia + "-" + mes + "-" + año);

        mi_cone.InsertUpdateDeleteAcciones("UPDATE persona per SET  per_primer_nombre='" + text_PrimerNombre_familiar.getText() + "', per_segundo_nombre='" + text_SegundoNombre_familiar.getText() + "'"
                + ", per_primer_apellido='" + text_PrimerApellido_familiar.getText() + "', per_segundo_apellido='" + text_SegundoApellido_familiar.getText() + "'"
                + ", per_correo='" + text_email_familiar.getText() + "', per_genero='" + genero + "', per_direccion='" + text_direccion_familiar.getText() + "', per_telefono='" + text_celular_familiar.getText() + "', per_tipo_sangre='" + tipoo_sangre + "',per_fecha_nacimiento='" + FechaNacimiento + "' WHERE per_cedula='" + text_cedula_familiar.getText() + "'");

        mi_cone.InsertUpdateDeleteAcciones("UPDATE familiar SET fam_parentesco='" + jcb_parentesco.getSelectedItem().toString() + "', fam_codigo_paciente='" + Integer.parseInt(txt_codPaci.getText()) + "' WHERE fam_cedula='" + text_cedula_familiar.getText() + "'");
//
//         int codigousuarioAux = 0;
//            
//            List<familiar> fami = insertFamiliar.ListaFamiliar();
//
//            for (int i = 0; i < fami.size(); i++) {
//
//                String cedulaAux = text_cedula_familiar.getText();
//                
//                
//                if (cedulaAux.equals(fami.get(i).getCedula())) {
//
//                    codigousuarioAux = fami.get(i).getCod_usuario();
//  
//                }
//            }

            mi_cone.InsertUpdateDeleteAcciones("UPDATE usuario SET us_usuario='" + txtUsuario.getText() + "', us_contrasena='" + txtContrasenia.getText() + "' WHERE us_codigo='" + insertFamiliar.cargarcodigoUSER(text_cedula_familiar.getText()) + "'");
            
        JOptionPane.showMessageDialog(null,"El registro se modifico exitosamente");
        limpiar();
        //this.dispose();
    }

    public void cargarcod() {
        txtCodigo.setEnabled(false);
        txtCodigo.setText(String.valueOf(insertFamiliar.cargarcodigo()));
    }

    public void RegistrarFamiliar() throws SQLException {

        Insert_familiar familiar = new Insert_familiar();

        try {
            if (validaciones()) {
                if (familiar.validarduplicado(text_cedula_familiar.getText())) {
                    if (usu.validarNomduplicado(txtUsuario.getText())) {
                        String genero = "";
                        //familiar.setCodigo(text_codigo_familiar.getText());
                        familiar.setCedula(text_cedula_familiar.getText());
                        familiar.setPri_nomb(text_PrimerNombre_familiar.getText());
                        familiar.setSeg_nombre(text_SegundoNombre_familiar.getText());
                        familiar.setPrim_apell(text_PrimerApellido_familiar.getText());
                        familiar.setSeg_apelli(text_SegundoApellido_familiar.getText());
                        familiar.setDireccion(text_direccion_familiar.getText());
                        if (Masculino_familiar.isSelected()) {
                            genero = "hombre";
                        }
                        if (Femenino_familiar.isSelected()) {
                            genero = "mujer";
                        }
                        familiar.setGenero(genero);
                        familiar.setCorreo(text_email_familiar.getText());

                        String dia = Integer.toString(fecha_nacimiento_familiar.getCalendar().get(Calendar.DAY_OF_MONTH));
                        String mes = Integer.toString(fecha_nacimiento_familiar.getCalendar().get(Calendar.MONTH) + 1);
                        String año = Integer.toString(fecha_nacimiento_familiar.getCalendar().get(Calendar.YEAR));
                        String FechaNacimiento = (dia + "-" + mes + "-" + año);
                        //String FechaNacimiento = df.format(fecha_nacimiento_familiar.getDate());
                        familiar.setFecha_Nacimiento(FechaNacimiento);

                        familiar.setTelefono(text_celular_familiar.getText());
                        familiar.setTipo_sangre(combo_sangre_familiar.getSelectedItem().toString());
                        familiar.InsertarPersona();
                        //Fin Persona
                        ///////////////////////////////////
                        usu.setContraseña(txtContrasenia.getText());
                        usu.setUsuario(txtUsuario.getText());
                        usu.InsertarUsuario();
                        /////////////////////////////////////
                        familiar.setParectesco(jcb_parentesco.getSelectedItem().toString());
                        familiar.setCedula(text_cedula_familiar.getText());
                        familiar.setCod_usuario(usu.obtenerUsuario());
                        familiar.setCodigo_paciente(Integer.parseInt(txt_codPaci.getText()));

                        if (familiar.InsertarFamiliar()) {
                            //System.out.println("Conexion Exitosa");
                            JOptionPane.showMessageDialog(this, "El familiar se guardo exitosamente");
                            limpiar();
                            cargarcod();
                        } else {
                            //System.out.println("Conexion Erronea");
                            JOptionPane.showMessageDialog(this,"El familiar no se guardo correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe");
                        txtUsuario.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El doctor ya existe en el sistema");
                    text_cedula_familiar.setText("");

                }
            }
        } catch (NullPointerException n) {

        }
    }

    public boolean validaciones() {
        boolean validado = true;

        if (text_cedula_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la cedula");
        } else {
            if (!misvalidaciones.validar_cedula(text_cedula_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Cedula incorrecta");
                validado = false;
            }
        }
//
        if (text_PrimerNombre_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el nombre");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_PrimerNombre_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Primer nombre incorrecto");
                validado = false;
            }
        }
        if (text_SegundoNombre_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el nombre");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_SegundoNombre_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Segundo nombre incorrecto");
                validado = false;
            }
        }
        if (text_PrimerApellido_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el primer apellido");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_PrimerApellido_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Primer apellido incorrecto");
                validado = false;
            }
        }
        if (text_SegundoApellido_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el segundo apellido");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_SegundoApellido_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Segundo apellido incorrecto");
                validado = false;
            }
        }
        if (text_direccion_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la direccion");
        } else {
            if (!misvalidaciones.validarDireccion(text_direccion_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Direccion invalida");
                validado = false;
            }
        }
        if (text_celular_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el celular");
        } else {
            if (!misvalidaciones.validarTelefono(text_celular_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Celular invalido");
                validado = false;
            }
        }
        if (text_email_familiar.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el correo");
        } else {
            if (!misvalidaciones.validarCorreo(text_email_familiar.getText())) {
                JOptionPane.showMessageDialog(this, "Correo invalido");
                validado = false;
            }
        }

        if (txtUsuario.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese un usuario");
        } else {
            if (!misvalidaciones.validarUsuario(txtUsuario.getText())) {
                JOptionPane.showMessageDialog(this, "Usuario invalido");
                validado = false;
            }
        }

        if (txtContrasenia.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese una contraseña");
        } else {
            if (!misvalidaciones.validarContrasena(txtContrasenia.getText())) {
                JOptionPane.showMessageDialog(this, "Contraseña invalida");
                validado = false;
            }
        }

        if (jcb_parentesco.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Seleccione el parentesco");
        }

        if (combo_sangre_familiar.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de sangre");
        }
        if (fecha_nacimiento_familiar.getDate() == null) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la fecha de nacimiento");
        }

        if (!Masculino_familiar.isSelected() && !Femenino_familiar.isSelected()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "seleccione un genero");
        }

        return validado;
    }

    public void limpiar() {
        txtCodigo.setText("");
        text_cedula_familiar.setText("");
        text_PrimerNombre_familiar.setText("");
        text_SegundoNombre_familiar.setText("");
        text_PrimerApellido_familiar.setText("");
        text_SegundoApellido_familiar.setText("");
        text_direccion_familiar.setText("");
        text_email_familiar.setText("");
        text_celular_familiar.setText("");
        Genero_familiar.clearSelection();
        combo_sangre_familiar.setSelectedIndex(0);
        jcb_parentesco.setSelectedIndex(0);
        fecha_nacimiento_familiar.setCalendar(null);
        txtUsuario.setText("");
        txtContrasenia.setText("");
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
                matriz[j][0] = String.valueOf(pacientefiltro.get(j).getCodigo());
                matriz[j][1] = pacientefiltro.get(j).getCedula();
                matriz[j][2] = pacientefiltro.get(j).getPri_nomb() + "  " + pacientefiltro.get(j).getSeg_nombre();
                matriz[j][3] = pacientefiltro.get(j).getPrim_apell() + "  " + pacientefiltro.get(j).getSeg_apelli();;

            }
            TablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String[]{
                        "CODIGO", "CEDULA", "NOMBRES", "APELLIDOS"
                    }
            ));
        } else {
            JOptionPane.showMessageDialog(this, "El paciente no existe en la base de datos");
        }
    }

    public void cargarTablaF() {
        DefaultTableModel tb = (DefaultTableModel) TablaPaciente.getModel();
        tb.setNumRows(0);
        List<paciente> com = inser.ListaPaciente();
        com.stream().forEach(p -> {
            String[] cami = {String.valueOf(p.getCodigo()), p.getCedula(), p.getPri_nomb() + "  " + p.getSeg_nombre(), p.getPrim_apell() + "  " + p.getSeg_apelli()};
            tb.addRow(cami);
        });
    }

    public void cargar_codigo_paci() {
        int fila = TablaPaciente.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una fila");
        } else {

            String cod;
            cod = TablaPaciente.getValueAt(fila, 0).toString();
            txt_codPaci.setText(cod);
//            System.out.println(cod);
            cargarPaciente.dispose();
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
            java.util.logging.Logger.getLogger(agregar_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregar_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregar_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregar_familiar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregar_familiar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarFamiliar;
    private javax.swing.JRadioButton Femenino_familiar;
    private javax.swing.ButtonGroup Genero_familiar;
    private javax.swing.JButton GuardarFamiliar;
    private javax.swing.JRadioButton Masculino_familiar;
    private javax.swing.JButton RegresarFamiliar;
    private javax.swing.JTable TablaPaciente;
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JButton buscarp;
    private javax.swing.JButton cargarP;
    private javax.swing.JDialog cargarPaciente;
    private javax.swing.JComboBox<String> combo_sangre_familiar;
    private com.toedter.calendar.JDateChooser fecha_nacimiento_familiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcb_parentesco;
    private javax.swing.JTextField text_PrimerApellido_familiar;
    private javax.swing.JTextField text_PrimerNombre_familiar;
    private javax.swing.JTextField text_SegundoApellido_familiar;
    private javax.swing.JTextField text_SegundoNombre_familiar;
    private javax.swing.JTextField text_buscar;
    private javax.swing.JTextField text_cedula_familiar;
    private javax.swing.JTextField text_celular_familiar;
    private javax.swing.JTextField text_direccion_familiar;
    private javax.swing.JTextField text_email_familiar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txt_codPaci;
    // End of variables declaration//GEN-END:variables
}
