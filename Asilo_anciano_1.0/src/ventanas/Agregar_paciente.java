package ventanas;

import clases.paciente;
import ventanas.crud_paciente;
import conexion_bada.Conexion;
import conexion_bada.Insert;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import clases.validaciones;
import clases.persona;
import clases.usuario;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.ResultSet;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.List;
//import java.util.Locale;
//import javax.swing.table.DefaultTableModel;

//Import para imagen
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import javax.swing.JLabel;

public class Agregar_paciente extends javax.swing.JFrame {

    Conexion mi_cone = new Conexion();
    validaciones misvalidaciones = new validaciones();

    String afiliacion = "";
    String genero = "";
    String FechaDeIngreso = "";

    DateFormat df = DateFormat.getDateInstance();
    Insert persona = new Insert();
    Insert paciente = new Insert();
//    ArrayList<paciente> lista_Paciente = new ArrayList();
    Insert inser = new Insert();

    public JLabel getLabelFoto() {
        return LabelFoto;
    }

    public void setLabelFoto(JLabel LabelFoto) {
        this.LabelFoto = LabelFoto;
    }

    //IMAGEN
    FileInputStream fis; //Cambie a clase paciente
    int longitudBytes;

    public Agregar_paciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        btModificar.setVisible(false);
        cargarcod();
    }

    public Agregar_paciente(String cedula) {
        initComponents();
        this.setLocationRelativeTo(null);
        Guardar_paciente.setVisible(false);
        Guardar_paciente.setVisible(false);

        String SQL_SELECT = "SELECT * FROM pacientes WHERE cedula = " + cedula + ";";
        llenar_paciente(cedula);

    }

    public void llenar_paciente(String cedula) {
        fecha_ingreso_paciente.setEnabled(false);
        text_cedula_paciente.setEnabled(false);
        text_codigo_paciente.setEnabled(false);
        List<paciente> com = inser.ListaPaciente();
        com.stream().forEach(p -> {
            if (cedula.equalsIgnoreCase(p.getCedula())) {
                text_codigo_paciente.setText(String.valueOf(p.getCodigo()));
                text_cedula_paciente.setText(p.getCedula().toString());
                text_PrimerNombre_paciente.setText(p.getPri_nomb().toString());
                text_SegundoNombre_paciente.setText(p.getSeg_nombre().toString());
                text_PrimerApellido_paciente.setText(p.getPrim_apell().toString());
                text_SegundoApellido_paciente.setText(p.getSeg_apelli().toString());
                text_email_paciente.setText(p.getCorreo().toString());
                text_direccion_paciente.setText(p.getDireccion());
                text_celular_paciente.setText(p.getTelefono());
                if (p.getGenero().equalsIgnoreCase("hombre")) {
                    Masculino_paciente.setSelected(true);
                }
                if (p.getGenero().equalsIgnoreCase("mujer")) {
                    Femenino_paciente.setSelected(true);
                }

                if (p.getSeguro().equalsIgnoreCase("si")) {
                    check_iess.setSelected(true);
                } else {
                    check_iess.setSelected(false);
                }

                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = null;
                try {
                    fecha = formatofecha.parse(p.getFecha_Nacimiento());
                } catch (ParseException ex) {
                    Logger.getLogger(Agregar_administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                fecha_Nacimiento_paciente.setDate(fecha);

                Date fecha2 = null;
                try {
                    fecha2 = formatofecha.parse(p.getFecha_de_ingreso());
                } catch (ParseException ex) {
                    Logger.getLogger(Agregar_administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                fecha_ingreso_paciente.setDate(fecha2);

                for (int j = 0; j < combo_sangre_paciente.getItemCount(); j++) {
                    if (combo_sangre_paciente.getItemAt(j).equalsIgnoreCase(p.getTipo_sangre())) {
                        combo_sangre_paciente.setSelectedIndex(j);
                        j = combo_sangre_paciente.getItemCount();
                    }
                }
                System.out.println("====");
                System.out.println(p.getCodigo());
                paciente.ConsultarFoto(String.valueOf(p.getCodigo()), LabelFoto);
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_sexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        text_codigo_paciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fecha_ingreso_paciente = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        text_celular_paciente = new javax.swing.JTextField();
        text_email_paciente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        text_direccion_paciente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        combo_sangre_paciente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        fecha_Nacimiento_paciente = new com.toedter.calendar.JDateChooser();
        Femenino_paciente = new javax.swing.JRadioButton();
        Masculino_paciente = new javax.swing.JRadioButton();
        Guardar_paciente = new javax.swing.JButton();
        Regresar_acceso_recepcionista = new javax.swing.JButton();
        check_iess = new javax.swing.JCheckBox();
        Checkbox_Seguro_paciente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        text_SegundoApellido_paciente = new javax.swing.JTextField();
        text_PrimerApellido_paciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        text_PrimerNombre_paciente = new javax.swing.JTextField();
        text_cedula_paciente = new javax.swing.JTextField();
        text_SegundoNombre_paciente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        LabelFoto = new javax.swing.JLabel();
        SeleccionarImagen = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btModificar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(240, 239, 180));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Celular:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Datos Personales");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        text_codigo_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_codigo_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_codigo_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_codigo_pacienteMousePressed(evt);
            }
        });
        text_codigo_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_codigo_pacienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Código:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Fecha de Ingreso:");

        text_celular_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_celular_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_celular_paciente.setText("Ingrese el Celular");
        text_celular_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_celular_pacienteMousePressed(evt);
            }
        });

        text_email_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_email_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_email_paciente.setText("Ingrese el E-mail");
        text_email_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_email_pacienteMousePressed(evt);
            }
        });
        text_email_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_email_pacienteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("E-mail:");

        text_direccion_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_direccion_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_direccion_paciente.setText("Ingrese la Dirección");
        text_direccion_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_direccion_pacienteMousePressed(evt);
            }
        });
        text_direccion_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_direccion_pacienteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Dirección:");

        combo_sangre_paciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Tipo de Sangre:");

        grupo_sexo.add(Femenino_paciente);
        Femenino_paciente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Femenino_paciente.setText("F");
        Femenino_paciente.setOpaque(false);

        grupo_sexo.add(Masculino_paciente);
        Masculino_paciente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Masculino_paciente.setText("M");
        Masculino_paciente.setOpaque(false);
        Masculino_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Masculino_pacienteActionPerformed(evt);
            }
        });

        Guardar_paciente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Guardar_paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar (1).png"))); // NOI18N
        Guardar_paciente.setToolTipText("Guardar");
        Guardar_paciente.setBorder(null);
        Guardar_paciente.setOpaque(false);
        Guardar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_pacienteActionPerformed(evt);
            }
        });

        Regresar_acceso_recepcionista.setBackground(new java.awt.Color(204, 204, 204));
        Regresar_acceso_recepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        Regresar_acceso_recepcionista.setToolTipText("Regresar");
        Regresar_acceso_recepcionista.setBorder(null);
        Regresar_acceso_recepcionista.setFocusPainted(false);
        Regresar_acceso_recepcionista.setOpaque(false);
        Regresar_acceso_recepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_acceso_recepcionistaActionPerformed(evt);
            }
        });

        check_iess.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        check_iess.setBorder(null);
        check_iess.setOpaque(false);
        check_iess.setPreferredSize(new java.awt.Dimension(35, 35));

        Checkbox_Seguro_paciente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Checkbox_Seguro_paciente.setText("Seguro:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Sexo:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Fecha de Nacimiento:");

        text_SegundoApellido_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_SegundoApellido_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_SegundoApellido_paciente.setText("Ingrese el Segundo Apellido");
        text_SegundoApellido_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_SegundoApellido_pacienteMousePressed(evt);
            }
        });
        text_SegundoApellido_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_SegundoApellido_pacienteActionPerformed(evt);
            }
        });

        text_PrimerApellido_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_PrimerApellido_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_PrimerApellido_paciente.setText("Ingrese el Primer Apellido");
        text_PrimerApellido_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_PrimerApellido_pacienteMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Primer Nombre:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cédula:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Primer Apellido:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE PACIENTES");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Segundo Nombre:");

        text_PrimerNombre_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_PrimerNombre_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_PrimerNombre_paciente.setText("Ingrese el Primer Nombre");
        text_PrimerNombre_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_PrimerNombre_pacienteMousePressed(evt);
            }
        });
        text_PrimerNombre_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_PrimerNombre_pacienteActionPerformed(evt);
            }
        });

        text_cedula_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_cedula_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_cedula_paciente.setText("Ingrese Cedula");
        text_cedula_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_cedula_pacienteMousePressed(evt);
            }
        });
        text_cedula_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_cedula_pacienteActionPerformed(evt);
            }
        });

        text_SegundoNombre_paciente.setForeground(new java.awt.Color(102, 102, 102));
        text_SegundoNombre_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_SegundoNombre_paciente.setText("Ingrese el Segundo Nombre");
        text_SegundoNombre_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                text_SegundoNombre_pacienteMousePressed(evt);
            }
        });

        LabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SeleccionarImagen.setText("Seleccionar Imagen");
        SeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarImagenActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Segundo Apellido:");

        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar (1).png"))); // NOI18N
        btModificar.setToolTipText("MODIFICAR");
        btModificar.setBorder(null);
        btModificar.setBorderPainted(false);
        btModificar.setOpaque(false);
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_PrimerNombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_cedula_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_SegundoNombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_SegundoApellido_paciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_direccion_paciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_PrimerApellido_paciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_celular_paciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_email_paciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(text_codigo_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(fecha_ingreso_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(Masculino_paciente)
                                        .addGap(18, 18, 18)
                                        .addComponent(Femenino_paciente)
                                        .addGap(82, 82, 82))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SeleccionarImagen)
                                            .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)))
                                .addComponent(Checkbox_Seguro_paciente)
                                .addGap(18, 18, 18)
                                .addComponent(check_iess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fecha_Nacimiento_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(combo_sangre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(Guardar_paciente)
                .addGap(62, 62, 62)
                .addComponent(btModificar)
                .addGap(53, 53, 53)
                .addComponent(Regresar_acceso_recepcionista)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_cedula_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(text_PrimerNombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(text_SegundoNombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_PrimerApellido_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(text_SegundoApellido_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(text_codigo_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel19))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(fecha_ingreso_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(SeleccionarImagen)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_iess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_direccion_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel8)
                        .addComponent(Masculino_paciente)
                        .addComponent(Femenino_paciente)
                        .addComponent(Checkbox_Seguro_paciente)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(text_celular_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addComponent(fecha_Nacimiento_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(text_email_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(combo_sangre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Guardar_paciente)
                    .addComponent(Regresar_acceso_recepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btModificar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarImagenActionPerformed
        LabelFoto.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                this.longitudBytes = (int) j.getSelectedFile().length();

                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(LabelFoto.getWidth(), LabelFoto.getHeight(), Image.SCALE_DEFAULT);

                    LabelFoto.setIcon(new ImageIcon(icono));
                    LabelFoto.updateUI();
                    System.out.println("si seleccione");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "foto:" + ex);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_SeleccionarImagenActionPerformed

    private void text_SegundoNombre_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_SegundoNombre_pacienteMousePressed

        text_SegundoNombre_paciente.setText("");
        text_SegundoNombre_paciente.setForeground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_text_SegundoNombre_pacienteMousePressed

    private void text_cedula_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_cedula_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_cedula_pacienteActionPerformed

    private void text_cedula_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_cedula_pacienteMousePressed

        text_cedula_paciente.setText("");
        text_cedula_paciente.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_cedula_pacienteMousePressed

    private void text_PrimerNombre_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_PrimerNombre_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_PrimerNombre_pacienteActionPerformed

    private void text_PrimerNombre_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_PrimerNombre_pacienteMousePressed

        text_PrimerNombre_paciente.setText("");
        text_PrimerNombre_paciente.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_PrimerNombre_pacienteMousePressed

    private void text_PrimerApellido_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_PrimerApellido_pacienteMousePressed

        text_PrimerApellido_paciente.setText("");
        text_PrimerApellido_paciente.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_PrimerApellido_pacienteMousePressed

    private void text_SegundoApellido_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_SegundoApellido_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_SegundoApellido_pacienteActionPerformed

    private void text_SegundoApellido_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_SegundoApellido_pacienteMousePressed

        text_SegundoApellido_paciente.setText("");
        text_SegundoApellido_paciente.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_text_SegundoApellido_pacienteMousePressed

    private void Regresar_acceso_recepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_acceso_recepcionistaActionPerformed
        crud_paciente mi_crudP = new crud_paciente();
        mi_crudP.setVisible(true);
        dispose();
    }//GEN-LAST:event_Regresar_acceso_recepcionistaActionPerformed

    private void Guardar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_pacienteActionPerformed
        try {
            RegistrarPacientes();
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Guardar_pacienteActionPerformed

    private void Masculino_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Masculino_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Masculino_pacienteActionPerformed

    private void text_direccion_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_direccion_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_direccion_pacienteActionPerformed

    private void text_direccion_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_direccion_pacienteMousePressed

        text_direccion_paciente.setText("");
        text_direccion_paciente.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_direccion_pacienteMousePressed

    private void text_email_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_email_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_email_pacienteActionPerformed

    private void text_email_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_email_pacienteMousePressed

        text_email_paciente.setText("");
        text_email_paciente.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_email_pacienteMousePressed

    private void text_celular_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_celular_pacienteMousePressed

        text_celular_paciente.setText("");
        text_celular_paciente.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_celular_pacienteMousePressed

    private void text_codigo_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_codigo_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_codigo_pacienteActionPerformed

    private void text_codigo_pacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_codigo_pacienteMousePressed

        text_codigo_paciente.setForeground(Color.BLACK);
    }//GEN-LAST:event_text_codigo_pacienteMousePressed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificarlo?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            modificar_paciente();
            crud_paciente mi_crudP = new crud_paciente();
            mi_crudP.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btModificarActionPerformed

    public void cargarcod() {
        text_codigo_paciente.setEnabled(false);
        text_codigo_paciente.setText(String.valueOf(inser.cargarcodigo()));
        fecha_ingreso_paciente.setEnabled(false);
        Date fecha = null;
        LocalDate ahora = LocalDate.now();

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

        try {
            fecha = formatofecha.parse(ahora.toString());
        } catch (ParseException ex) {
            Logger.getLogger(clases.paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.out.println(ahora);
        fecha_ingreso_paciente.setDate(fecha);
    }

    public void RegistrarPacientes() throws SQLException {
//        Insert persona = new Insert();
//        Insert paciente = new Insert();
//        System.out.println("holaaaaaaaaaaa" + text_cedula_paciente.getText());
//        llenar_paciente();
//        inser.ListaPaciente();
        try {
            if (validaciones()) {
                if (inser.validarduplicado(text_cedula_paciente.getText())) {
                    String c = text_cedula_paciente.getText();

                    persona.setCedula(text_cedula_paciente.getText());
                    persona.setPri_nomb(text_PrimerNombre_paciente.getText());
                    persona.setSeg_nombre(text_SegundoNombre_paciente.getText());
                    persona.setPrim_apell(text_PrimerApellido_paciente.getText());
                    persona.setSeg_apelli(text_SegundoApellido_paciente.getText());

                    if (Masculino_paciente.isSelected()) {
                        genero = "hombre";
                    }
                    if (Femenino_paciente.isSelected()) {
                        genero = "mujer";
                    }
                    persona.setGenero(genero);

                    if (check_iess.isSelected()) {
                        afiliacion = "si";
                    } else {
                        afiliacion = "no";
                    }

                    persona.setCorreo(text_email_paciente.getText());

                    String dia = Integer.toString(fecha_Nacimiento_paciente.getCalendar().get(Calendar.DAY_OF_MONTH));
                    String mes = Integer.toString(fecha_Nacimiento_paciente.getCalendar().get(Calendar.MONTH) + 1);
                    String año = Integer.toString(fecha_Nacimiento_paciente.getCalendar().get(Calendar.YEAR));
                    String FechaNacimiento = (dia + "-" + mes + "-" + año);
                    persona.setFecha_Nacimiento(FechaNacimiento);

                    persona.setDireccion(text_direccion_paciente.getText());
                    persona.setTelefono(text_celular_paciente.getText());
                    persona.setTipo_sangre(combo_sangre_paciente.getSelectedItem().toString());

                    String diaI = Integer.toString(fecha_ingreso_paciente.getCalendar().get(Calendar.DAY_OF_MONTH));
                    String mesI = Integer.toString(fecha_ingreso_paciente.getCalendar().get(Calendar.MONTH) + 1);
                    String añoI = Integer.toString(fecha_ingreso_paciente.getCalendar().get(Calendar.YEAR));

                    //SI VALE
                    //String FechaDeIngreso = (diaI + "-" + mesI + "-" + añoI);
                    FechaDeIngreso = (añoI + "-" + mesI + "-" + diaI);

                    //String FechaDeIngreso = df.format(fecha_ingreso_paciente.getDate());
                    //SI VALE
                    paciente.setFecha_de_ingreso(FechaDeIngreso);
                    paciente.setSeguro(afiliacion);
                    paciente.setCedula(text_cedula_paciente.getText());

//                    if (persona.InsertarPersona() && paciente.InsertarPaciente(c, afiliacion, FechaDeIngreso, fis)) {
                    if (persona.InsertarPersona() && paciente.InsertarPaciente(FechaDeIngreso, fis)) {// longitudBytes,
                        System.out.println("Conexion Exitosa");
                        limpiar();
                        cargarcod();
                    } else {
                        System.out.println("Conexion Erronea");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "EL PACIENTE YA EXISTE EN LA BASE DE DATOS");
                    text_cedula_paciente.setText("");
                }

            }
        } catch (NullPointerException n) {

        }

    }

    public void modificar_paciente() {
        if (Masculino_paciente.isSelected()) {
            genero = "hombre";
        }
        if (Femenino_paciente.isSelected()) {
            genero = "mujer";
        }
        if (validaciones()) {
            String tipoo_sangre = combo_sangre_paciente.getSelectedItem().toString();
            if (check_iess.isSelected()) {
                afiliacion = "si";
            } else {
                afiliacion = "no";
            }
            String dia = Integer.toString(fecha_Nacimiento_paciente.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(fecha_Nacimiento_paciente.getCalendar().get(Calendar.MONTH) + 1);
            String año = Integer.toString(fecha_Nacimiento_paciente.getCalendar().get(Calendar.YEAR));
            String FechaNacimiento = (dia + "-" + mes + "-" + año);

            String diaI = Integer.toString(fecha_ingreso_paciente.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mesI = Integer.toString(fecha_ingreso_paciente.getCalendar().get(Calendar.MONTH) + 1);
            String añoI = Integer.toString(fecha_ingreso_paciente.getCalendar().get(Calendar.YEAR));
            String FechaDeIngreso = (añoI + "-" + mesI + "-" + diaI);

            mi_cone.InsertUpdateDeleteAcciones("UPDATE persona per SET  per_primer_nombre='" + text_PrimerNombre_paciente.getText() + "', per_segundo_nombre='" + text_SegundoNombre_paciente.getText() + "'"
                    + ", per_primer_apellido='" + text_PrimerApellido_paciente.getText() + "', per_segundo_apellido='" + text_SegundoApellido_paciente.getText() + "'"
                    + ", per_correo='" + text_email_paciente.getText() + "', per_genero='" + genero + "', per_direccion='" + text_direccion_paciente.getText() + "', per_telefono='" + text_celular_paciente.getText() + "', per_tipo_sangre='" + tipoo_sangre + "',per_fecha_nacimiento='" + FechaNacimiento + "' WHERE per_cedula='" + text_cedula_paciente.getText() + "'");
//            System.out.println(fis.toString());
            //mi_cone.InsertUpdateDeleteAcciones("UPDATE paciente SET paci_seguro='" + afiliacion + "',paci_fecha_de_ingreso='" + FechaDeIngreso + "' WHERE paci_cedula='" + text_cedula_paciente.getText() + "'");
            //            mi_cone.InsertUpdateDeleteAcciones("UPDATE paciente SET paci_seguro='" + afiliacion + "',paci_fecha_de_ingreso='" + FechaDeIngreso + "',paci_foto=" + fis + " WHERE paci_cedula='" + text_cedula_paciente.getText() + "'");
            Date date = new Date();
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            FechaDeIngreso = formatofecha.format(date);
            java.sql.Date fechasql = java.sql.Date.valueOf(FechaDeIngreso);
            try {

                String sql = "UPDATE paciente SET paci_seguro = ?, paci_fecha_de_ingreso= ? ,paci_foto = ?\n"
                        + "WHERE paci_cedula = ?;";
                try {

                    PreparedStatement ps = mi_cone.getCon().prepareStatement(sql);
                    // ps.setInt(1,co);

                    ps.setString(1, afiliacion);
                    ps.setDate(2, fechasql);
                    ps.setBinaryStream(3, fis);//,longitud
                    ps.setString(4, text_cedula_paciente.getText());
                    ps.execute();
                    ps.close();

                    System.out.println("Guardado Exitosamente");
                    //inserto = true;
                } catch (SQLException | NumberFormatException | HeadlessException x) {
                    System.out.println("No ha registrado nada" + x.getLocalizedMessage());

                    limpiar();
                }

            } catch (NullPointerException n) {

            }

        }

    }

    public void limpiar() {
        text_codigo_paciente.setText("");
        text_cedula_paciente.setText("");
        text_PrimerNombre_paciente.setText("");
        text_SegundoNombre_paciente.setText("");
        text_PrimerApellido_paciente.setText("");
        text_SegundoApellido_paciente.setText("");
        grupo_sexo.clearSelection();
        text_direccion_paciente.setText("");
        text_email_paciente.setText("");
        text_celular_paciente.setText("");
        combo_sangre_paciente.setSelectedIndex(0);
        check_iess.setSelected(false);
        fecha_Nacimiento_paciente.setCalendar(null);
        fecha_ingreso_paciente.setCalendar(null);
        LabelFoto.setIcon(null);
    }

    public boolean validaciones() {
        boolean validado = true;

        if (text_cedula_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la cedula del paciente");
        } else {
            if (!misvalidaciones.validar_cedula(text_cedula_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Cedula incorrecta");
                validado = false;
            }
        }
//
        if (text_PrimerNombre_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del paciente");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_PrimerNombre_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Primer nombre incorrecto");
                validado = false;
            }
        }
        if (text_SegundoNombre_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del paciente");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_SegundoNombre_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Segundo nombre incorrecto");
                validado = false;
            }
        }
        if (text_PrimerApellido_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el apellido del paciente");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_PrimerApellido_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Primer apellido incorrecto");
                validado = false;
            }
        }
        if (text_SegundoApellido_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el apellido del paciente");
        } else {
            if (!misvalidaciones.validar_nombre_apellido(text_SegundoApellido_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Segundo apellido incorrecto");
                validado = false;
            }
        }
        if (text_direccion_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la direccion del paciente");
        } else {
            if (!misvalidaciones.validarDireccion(text_direccion_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Direccion invalida");
                validado = false;
            }
        }
        if (text_celular_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el celular del paciente");
        } else {
            if (!misvalidaciones.validarTelefono(text_celular_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Celular invalido");
                validado = false;
            }
        }
        if (text_email_paciente.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese el correo del paciente");
        } else {
            if (!misvalidaciones.validarCorreo(text_email_paciente.getText())) {
                JOptionPane.showMessageDialog(this, "Correo invalido");
                validado = false;
            }
        }

        if (combo_sangre_paciente.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de sangre");
        }
//        System.out.println(String.valueOf(fecha_Nacimiento_paciente.getCalendar()));
        if (fecha_Nacimiento_paciente.getDate() == null) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la fecha de nacimiento del paciente");
        }
        if (fecha_ingreso_paciente.getDate() == null) {
            validado = false;
            JOptionPane.showMessageDialog(this, "Ingrese la fecha de ingreso del paciente");
        }
        if (!Masculino_paciente.isSelected() && !Femenino_paciente.isSelected()) {
            validado = false;
            JOptionPane.showMessageDialog(this, "seleccione un genero");
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
            java.util.logging.Logger.getLogger(Agregar_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_paciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Checkbox_Seguro_paciente;
    private javax.swing.JRadioButton Femenino_paciente;
    private javax.swing.JButton Guardar_paciente;
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JRadioButton Masculino_paciente;
    private javax.swing.JButton Regresar_acceso_recepcionista;
    private javax.swing.JButton SeleccionarImagen;
    private javax.swing.JButton btModificar;
    private javax.swing.JCheckBox check_iess;
    private javax.swing.JComboBox<String> combo_sangre_paciente;
    private com.toedter.calendar.JDateChooser fecha_Nacimiento_paciente;
    private com.toedter.calendar.JDateChooser fecha_ingreso_paciente;
    private javax.swing.ButtonGroup grupo_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField text_PrimerApellido_paciente;
    private javax.swing.JTextField text_PrimerNombre_paciente;
    private javax.swing.JTextField text_SegundoApellido_paciente;
    private javax.swing.JTextField text_SegundoNombre_paciente;
    private javax.swing.JTextField text_cedula_paciente;
    private javax.swing.JTextField text_celular_paciente;
    private javax.swing.JTextField text_codigo_paciente;
    private javax.swing.JTextField text_direccion_paciente;
    private javax.swing.JTextField text_email_paciente;
    // End of variables declaration//GEN-END:variables
}
