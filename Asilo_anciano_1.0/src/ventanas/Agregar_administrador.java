/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
//Prueba

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.awt.Color;
import clases.administrador;
import clases.usuario;
//import conexion_bada.Insert_familiar;
//import conexion_bada.Insert;
import conexion_bada.Insert_administrador;
import conexion_bada.Insert_usuario;
import conexion_bada.Insert_Persona;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import clases.validaciones;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Agregar_administrador extends javax.swing.JFrame {

    Conexion mi_cone = new Conexion();
    DateFormat df = DateFormat.getDateInstance();
//    ArrayList<administrador> lista_administrador = new ArrayList();
    validaciones misvalidaciones = new validaciones();
    Insert_administrador inserCargarCodigo = new Insert_administrador();
    Insert_usuario usu = new Insert_usuario();
    Conexion cone = new Conexion();

    public Agregar_administrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarcod();
    }

    public Agregar_administrador(String cedula) {
        initComponents();
        this.setLocationRelativeTo(null);

//        cargarcod();
        llenar_administrador(cedula);
        Guardar_administrador.setVisible(false);
    }

    public void llenar_administrador(String cedula) {
        txt_cedula_administrador.setEnabled(false);
        txt_codigo_administrador.setEnabled(false);
        List<administrador> com = inserCargarCodigo.ListaAdministrador();
        com.stream().forEach(p -> {
            if (cedula.equalsIgnoreCase(p.getCedula())) {
                txt_codigo_administrador.setText(String.valueOf(p.getCodigo()));
                txt_cedula_administrador.setText(p.getCedula().toString());
                txt_PrimerNombre_administrador.setText(p.getPri_nomb().toString());
                txt_SegundoNombre_administrador.setText(p.getSeg_nombre().toString());
                txt_PrimerApellido_administrador.setText(p.getPrim_apell().toString());
                txt_SegundoApellido_administrador.setText(p.getSeg_apelli().toString());
                txt_email_administrador.setText(p.getCorreo().toString());
                txt_direccion_administrador.setText(p.getDireccion());
                txt_celular_administrador.setText(p.getTelefono());
//            System.out.println(p.getGenero());
                if (p.getGenero().equalsIgnoreCase("hombre")) {
                    Masculino_administrador.setSelected(true);
                }
                if (p.getGenero().equalsIgnoreCase("mujer")) {
                    Femenino_administrador.setSelected(true);
                }

                for (int i = 0; i < combo_sangre_administrador.getItemCount(); i++) {
                    if (combo_sangre_administrador.getItemAt(i).equalsIgnoreCase(p.getTipo_sangre())) {
                        combo_sangre_administrador.setSelectedIndex(i);
                        i = combo_sangre_administrador.getItemCount();
                    }
                }

                for (int j = 0; j < jCB_nivelDeeducacion_administrador.getItemCount(); j++) {
                    if (jCB_nivelDeeducacion_administrador.getItemAt(j).equalsIgnoreCase(p.getNivel_educacion())) {
                        jCB_nivelDeeducacion_administrador.setSelectedIndex(j);
                        j = jCB_nivelDeeducacion_administrador.getItemCount();
                    }
                }

                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = null;
                try {
                    fecha = formatofecha.parse(p.getFecha_Nacimiento());
                } catch (ParseException ex) {
                    Logger.getLogger(Agregar_administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                Fecha_Nacimiento_administrador.setDate(fecha);

//            System.out.println(p.getFecha_Nacimiento());
                List<usuario> usua = usu.ListaUsuariosModi(String.valueOf(p.getCod_usuario()), "administrador", "admin");
                usua.stream().forEach(u -> {
                    txt_usuario.setText(u.getUsuario());
                    txt_contrasena.setText(u.getContraseña());
                });
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Genero_administrador = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_celular_administrador = new javax.swing.JTextField();
        txt_SegundoNombre_administrador = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_PrimerNombre_administrador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_codigo_administrador = new javax.swing.JTextField();
        Masculino_administrador = new javax.swing.JRadioButton();
        Guardar_administrador = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combo_sangre_administrador = new javax.swing.JComboBox<>();
        txt_cedula_administrador = new javax.swing.JTextField();
        txt_PrimerApellido_administrador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Femenino_administrador = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_direccion_administrador = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_SegundoApellido_administrador = new javax.swing.JTextField();
        txt_email_administrador = new javax.swing.JTextField();
        Regresar_administrador = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Fecha_Nacimiento_administrador = new com.toedter.calendar.JDateChooser();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_contrasena = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCB_nivelDeeducacion_administrador = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 239, 180));

        txt_celular_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_celular_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_celular_administrador.setText("Ingrese el celular");
        txt_celular_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_celular_administradorMousePressed(evt);
            }
        });

        txt_SegundoNombre_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_SegundoNombre_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SegundoNombre_administrador.setText("Ingrese el Segundo nombre");
        txt_SegundoNombre_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_SegundoNombre_administradorMousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Dirección:");

        txt_PrimerNombre_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_PrimerNombre_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_PrimerNombre_administrador.setText("Ingrese el Primer nombre");
        txt_PrimerNombre_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_PrimerNombre_administradorMousePressed(evt);
            }
        });
        txt_PrimerNombre_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PrimerNombre_administradorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR ADMINISTRADOR");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Fecha de Nacimiento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Código:");

        txt_codigo_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_codigo_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_codigo_administradorMousePressed(evt);
            }
        });
        txt_codigo_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigo_administradorActionPerformed(evt);
            }
        });

        Genero_administrador.add(Masculino_administrador);
        Masculino_administrador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Masculino_administrador.setText("M");
        Masculino_administrador.setOpaque(false);
        Masculino_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Masculino_administradorActionPerformed(evt);
            }
        });

        Guardar_administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar (1).png"))); // NOI18N
        Guardar_administrador.setToolTipText("GUARDAR");
        Guardar_administrador.setBorder(null);
        Guardar_administrador.setOpaque(false);
        Guardar_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_administradorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Tipo de Sangre:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cedula:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Sexo:");

        combo_sangre_administrador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        txt_cedula_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_cedula_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cedula_administrador.setText("Ingrese la cedula");
        txt_cedula_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_cedula_administradorMousePressed(evt);
            }
        });
        txt_cedula_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedula_administradorActionPerformed(evt);
            }
        });

        txt_PrimerApellido_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_PrimerApellido_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_PrimerApellido_administrador.setText("Ingrese el Primer apellido");
        txt_PrimerApellido_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_PrimerApellido_administradorMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Primer Apellido:");

        Genero_administrador.add(Femenino_administrador);
        Femenino_administrador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Femenino_administrador.setText("F");
        Femenino_administrador.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Primer Nombre:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Segundo Nombre:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Datos Personales");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("E-mail:");

        txt_direccion_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_direccion_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion_administrador.setText("Ingrese la dirección");
        txt_direccion_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_direccion_administradorMousePressed(evt);
            }
        });
        txt_direccion_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccion_administradorActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Celular:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Segundo Apellido:");

        txt_SegundoApellido_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_SegundoApellido_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SegundoApellido_administrador.setText("Ingrese el Segundo apellido");
        txt_SegundoApellido_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_SegundoApellido_administradorMousePressed(evt);
            }
        });
        txt_SegundoApellido_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SegundoApellido_administradorActionPerformed(evt);
            }
        });

        txt_email_administrador.setForeground(new java.awt.Color(102, 102, 102));
        txt_email_administrador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email_administrador.setText("Ingrese el E-mail");
        txt_email_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_email_administradorMousePressed(evt);
            }
        });

        Regresar_administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        Regresar_administrador.setToolTipText("REGRESAR");
        Regresar_administrador.setBorder(null);
        Regresar_administrador.setOpaque(false);
        Regresar_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_administradorActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Nivel de Educacion:");

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("CREAR USUARIO");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("NUEVO USUARIO:");

        txt_usuario.setForeground(new java.awt.Color(102, 102, 102));
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuario.setText("Ej: Usuario1");
        txt_usuario.setToolTipText("El usuario debe contener minimo 3 letras y 1 numero");
        txt_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_usuarioMousePressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("NUEVA CONTRASEÑA:");

        txt_contrasena.setForeground(new java.awt.Color(102, 102, 102));
        txt_contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contrasena.setText("Ej: Pass1@");
        txt_contrasena.setToolTipText("Debe contener minimo 1 letra minus, 1 mayus, 1 numero y un caracter especial, minimo 5caract. y max 20");
        txt_contrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_contrasenaMousePressed(evt);
            }
        });
        txt_contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contrasenaKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar-documento.png"))); // NOI18N
        jButton1.setToolTipText("MODIFICAR");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCB_nivelDeeducacion_administrador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Basica", "Bachillerato", "Superior", "Superior Universitario", "Posgrado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SegundoApellido_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_celular_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_direccion_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButton1)
                                .addGap(110, 110, 110)
                                .addComponent(Regresar_administrador)))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_PrimerApellido_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SegundoNombre_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_PrimerNombre_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cedula_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(Masculino_administrador)
                                .addGap(36, 36, 36)
                                .addComponent(Femenino_administrador)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_sangre_administrador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCB_nivelDeeducacion_administrador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(172, 172, 172))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_codigo_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Fecha_Nacimiento_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(163, 163, 163))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(Guardar_administrador)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cedula_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_codigo_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Masculino_administrador)
                            .addComponent(Femenino_administrador)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_PrimerNombre_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fecha_Nacimiento_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combo_sangre_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_SegundoNombre_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_PrimerApellido_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jCB_nivelDeeducacion_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_SegundoApellido_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_email_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_celular_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_direccion_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addComponent(txt_contrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Guardar_administrador)
                        .addComponent(Regresar_administrador))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1010, 1460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cedula_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cedula_administradorMousePressed
        if (txt_cedula_administrador.getText().equalsIgnoreCase("Ingrese la cedula")) {
            txt_cedula_administrador.setText("");
        }
        txt_cedula_administrador.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedula_administradorMousePressed

    private void txt_cedula_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedula_administradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedula_administradorActionPerformed

    private void txt_PrimerNombre_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PrimerNombre_administradorMousePressed
        txt_PrimerNombre_administrador.setText("");
        txt_PrimerNombre_administrador.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PrimerNombre_administradorMousePressed

    private void txt_PrimerNombre_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PrimerNombre_administradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PrimerNombre_administradorActionPerformed

    private void txt_SegundoNombre_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SegundoNombre_administradorMousePressed
        txt_SegundoNombre_administrador.setText("");
        txt_SegundoNombre_administrador.setForeground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SegundoNombre_administradorMousePressed

    private void txt_PrimerApellido_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PrimerApellido_administradorMousePressed
        txt_PrimerApellido_administrador.setText("");
        txt_PrimerApellido_administrador.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PrimerApellido_administradorMousePressed

    private void txt_SegundoApellido_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SegundoApellido_administradorMousePressed
        txt_SegundoApellido_administrador.setText("");
        txt_SegundoApellido_administrador.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_SegundoApellido_administradorMousePressed

    private void txt_SegundoApellido_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SegundoApellido_administradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SegundoApellido_administradorActionPerformed

    private void txt_direccion_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_direccion_administradorMousePressed
        txt_direccion_administrador.setText("");
        txt_direccion_administrador.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccion_administradorMousePressed

    private void txt_direccion_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccion_administradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccion_administradorActionPerformed

    private void Masculino_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masculino_administradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Masculino_administradorActionPerformed

    private void txt_codigo_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigo_administradorMousePressed
//        txt_codigo_administrador.setText("");
//        txt_codigo_administrador.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_codigo_administradorMousePressed

    private void txt_codigo_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigo_administradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_administradorActionPerformed

    private void txt_email_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_email_administradorMousePressed
        txt_email_administrador.setText("");
        txt_email_administrador.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_email_administradorMousePressed

    private void txt_celular_administradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_celular_administradorMousePressed
        txt_celular_administrador.setText("");
        txt_celular_administrador.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_celular_administradorMousePressed

    private void Guardar_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_administradorActionPerformed

        try {
            RegistrarAdministrador();
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Guardar_administradorActionPerformed

    private void Regresar_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_administradorActionPerformed
        this.dispose();
        new crud_administrador().setVisible(true);
    }//GEN-LAST:event_Regresar_administradorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificarlo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            modificar_administrador();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuarioMousePressed
        txt_usuario.setText("");
        txt_usuario.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_usuarioMousePressed

    private void txt_contrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contrasenaKeyReleased

    }//GEN-LAST:event_txt_contrasenaKeyReleased

    private void txt_contrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_contrasenaMousePressed
        txt_contrasena.setText("");
        txt_contrasena.setForeground(Color.BLACK);    }//GEN-LAST:event_txt_contrasenaMousePressed
    public void modificar_administrador() {
        String genero = "";
        if (Masculino_administrador.isSelected()) {
            genero = "hombre";
        }
        if (Femenino_administrador.isSelected()) {
            genero = "mujer";
        }
        if (validaciones()) {
            String tipoo_sangre = combo_sangre_administrador.getSelectedItem().toString();

            String dia = Integer.toString(Fecha_Nacimiento_administrador.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(Fecha_Nacimiento_administrador.getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(Fecha_Nacimiento_administrador.getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            mi_cone.InsertUpdateDeleteAcciones("UPDATE persona per SET  per_primer_nombre='" + txt_PrimerNombre_administrador.getText() + "', per_segundo_nombre='" + txt_SegundoNombre_administrador.getText() + "'"
                    + ", per_primer_apellido='" + txt_PrimerApellido_administrador.getText() + "', per_segundo_apellido='" + txt_SegundoApellido_administrador.getText() + "'"
                    + ", per_correo='" + txt_email_administrador.getText() + "', per_genero='" + genero + "', per_direccion='" + txt_direccion_administrador.getText() + "', per_telefono='" + txt_celular_administrador.getText() + "', per_tipo_sangre='" + tipoo_sangre + "',per_fecha_nacimiento='" + FechaNacimiento + "' WHERE per_cedula='" + txt_cedula_administrador.getText() + "'");

            mi_cone.InsertUpdateDeleteAcciones("UPDATE administrador SET admin_nivel_educacion='" + jCB_nivelDeeducacion_administrador.getSelectedItem().toString() + "' WHERE admin_cedula='" + txt_cedula_administrador.getText() + "'");
            limpiar();
        }
    }

    public void cargarcod() {
        txt_codigo_administrador.setEnabled(false);
        txt_codigo_administrador.setText(String.valueOf(inserCargarCodigo.cargarcodigo()));
    }

    public void RegistrarAdministrador() throws SQLException {
        Insert_administrador admin = new Insert_administrador();

        Insert_Persona per = new Insert_Persona();
        try {
            if (validaciones()) {
                if (per.validarduplicado(txt_cedula_administrador.getText())) {
                    if (usu.validarNomduplicado(txt_usuario.getText())) {
                        String genero = "";
//                usuario usu = new usuario();
//                    persona.setCodigo(txt_codigo_administrador.getText());
                        admin.setCedula(txt_cedula_administrador.getText());
                        admin.setPri_nomb(txt_PrimerNombre_administrador.getText());
                        admin.setSeg_nombre(txt_SegundoNombre_administrador.getText());
                        admin.setPrim_apell(txt_PrimerApellido_administrador.getText());
                        admin.setSeg_apelli(txt_SegundoApellido_administrador.getText());
                        admin.setDireccion(txt_direccion_administrador.getText());
                        if (Masculino_administrador.isSelected()) {
                            genero = "hombre";
                        }
                        if (Femenino_administrador.isSelected()) {
                            genero = "mujer";
                        }
                        admin.setGenero(genero);
                        admin.setCorreo(txt_email_administrador.getText());

                        String dia = Integer.toString(Fecha_Nacimiento_administrador.getCalendar().get(Calendar.DAY_OF_MONTH));
                        String mes = Integer.toString(Fecha_Nacimiento_administrador.getCalendar().get(Calendar.MONTH) + 1);
                        String año = Integer.toString(Fecha_Nacimiento_administrador.getCalendar().get(Calendar.YEAR));
                        String fecha = (dia + "-" + mes + "-" + año);

                        //String FechaNacimiento = df.format(Fecha_Nacimiento_administrador.getDate());
                        admin.setFecha_Nacimiento(fecha);

                        admin.setTelefono(txt_celular_administrador.getText());
                        admin.setTipo_sangre(combo_sangre_administrador.getSelectedItem().toString());
                        admin.InsertarPersona();
                        //fin persona
                        //////////////////////////
                        usu.setContraseña(txt_contrasena.getText());
                        usu.setUsuario(txt_usuario.getText());
                        usu.InsertarUsuario();
                        ////////////////
                        admin.setNivel_educacion(jCB_nivelDeeducacion_administrador.getSelectedItem().toString());
                        admin.setCedula(txt_cedula_administrador.getText());
                        admin.setCod_usuario(usu.obtenerUsuario());
                        if (admin.InsertarAdministrador()) {
                            System.out.println("Conexion Exitosa");
                            limpiar();
                            cargarcod();
                        } else {
                            System.out.println("Conexion Erronea");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe");
                        txt_usuario.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El administrador ya existe en el sistema");
                    txt_cedula_administrador.setText("");

                }
            }
        } catch (NullPointerException n) {

        }
    }

    public boolean validaciones() {
        boolean validado = true;

        if (txt_cedula_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la cedula");
        } else {
            if (!misvalidaciones.validar_cedula(txt_cedula_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Cedula incorrecta");
                validado = false;
            }
        }
//
        if (txt_PrimerNombre_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el primer nombre");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(txt_PrimerNombre_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Primer nombre incorrecto");
                validado = false;
            }
        }
        if (txt_SegundoNombre_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el segundo nombre");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(txt_SegundoNombre_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Segundo nombre incorrecto");
                validado = false;
            }
        }
        if (txt_PrimerApellido_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el primer apellido");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(txt_PrimerApellido_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Primer apellido incorrecto");
                validado = false;
            }
        }
        if (txt_SegundoApellido_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el segundo apellido");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(txt_SegundoApellido_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Segundo apellido incorrecto");
                validado = false;
            }
        }
        if (txt_direccion_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la direccion");
        } else {
            if (!misvalidaciones.validarDireccion(txt_direccion_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Direccion invalida");
                validado = false;
            }
        }
        if (txt_celular_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el celular");
        } else {
            if (!misvalidaciones.validarTelefono(txt_celular_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Celular invalido");
                validado = false;
            }
        }
        if (txt_email_administrador.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el correo");
        } else {
            if (!misvalidaciones.validarCorreo(txt_email_administrador.getText())) {
                JOptionPane.showMessageDialog(this, "Correo invalido");
                validado = false;
            }
        }

        if (txt_usuario.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese un usuario");
        } else {
            if (!misvalidaciones.validarUsuario(txt_usuario.getText())) {
                JOptionPane.showMessageDialog(this, "Usuario invalido");
                validado = false;
            }
        }

        if (txt_contrasena.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese una contraseña");
        } else {
            if (!misvalidaciones.validarContrasena(txt_contrasena.getText())) {
                JOptionPane.showMessageDialog(this, "Contraseña invalida");
                validado = false;
            }
        }

        if (jCB_nivelDeeducacion_administrador.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Seleccione el nivel de educacion");
        }

        if (combo_sangre_administrador.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de sangre");
        }
//        System.out.println(String.valueOf(fecha_Nacimiento_paciente.getCalendar()));
        if (Fecha_Nacimiento_administrador.getDate() == null) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la fecha de nacimiento del administrador");
        }

        if (!Masculino_administrador.isSelected() && !Femenino_administrador.isSelected()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "seleccione un genero");
        }

        return validado;
    }

    public void limpiar() {
        txt_codigo_administrador.setText("");
        txt_cedula_administrador.setText("");
        txt_PrimerNombre_administrador.setText("");
        txt_SegundoNombre_administrador.setText("");
        txt_PrimerApellido_administrador.setText("");
        txt_SegundoApellido_administrador.setText("");
        txt_direccion_administrador.setText("");
        txt_email_administrador.setText("");
        txt_celular_administrador.setText("");
        Genero_administrador.clearSelection();
        combo_sangre_administrador.setSelectedIndex(0);
        jCB_nivelDeeducacion_administrador.setSelectedIndex(0);
        Fecha_Nacimiento_administrador.setCalendar(null);
        txt_usuario.setText("");
        txt_contrasena.setText("");

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
            java.util.logging.Logger.getLogger(Agregar_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fecha_Nacimiento_administrador;
    private javax.swing.JRadioButton Femenino_administrador;
    private javax.swing.ButtonGroup Genero_administrador;
    private javax.swing.JButton Guardar_administrador;
    private javax.swing.JRadioButton Masculino_administrador;
    private javax.swing.JButton Regresar_administrador;
    private javax.swing.JComboBox<String> combo_sangre_administrador;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCB_nivelDeeducacion_administrador;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField txt_PrimerApellido_administrador;
    private javax.swing.JTextField txt_PrimerNombre_administrador;
    private javax.swing.JTextField txt_SegundoApellido_administrador;
    private javax.swing.JTextField txt_SegundoNombre_administrador;
    private javax.swing.JTextField txt_cedula_administrador;
    private javax.swing.JTextField txt_celular_administrador;
    private javax.swing.JTextField txt_codigo_administrador;
    private javax.swing.JTextField txt_contrasena;
    private javax.swing.JTextField txt_direccion_administrador;
    private javax.swing.JTextField txt_email_administrador;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
