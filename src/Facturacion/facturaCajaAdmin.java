package Facturacion;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class facturaCajaAdmin extends javax.swing.JFrame implements Runnable {

    DefaultTableModel modelo;
    DefaultTableModel modelo1;

    String date;

    String fechacalendario;
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread hora1;

    public facturaCajaAdmin() {
        initComponents();
        ImageIcon icono = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\caja1.jpg");
        ImageIcon icono1 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\logo1.jpg");
        lbllogo.setIcon(icono);
        lbllogo1.setIcon(icono1);
        lbhora.setVisible(false);
        setLocationRelativeTo(null);
        lbcorreo.setVisible(false);
        txtcorreo.setVisible(false);
        btncorreo.setVisible(false);
        txtfecha.setVisible(false);
        mostrardatos("");
        hora1 = new Thread(this);
        hora1.start();

    }

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Subtotal");

        tbFactura.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM `datosfactura`";

        }
        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbFactura.setModel(modelo);
    }

    void productos(String valor) {
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("productos");
        modelo1.addColumn("Cantidad");
        modelo1.addColumn("Total");
        modelo1.addColumn("Fecha");

        tbproductos.setModel(modelo1);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT `Productos`, `Cantidad`, `Total`, `Fecha` FROM `clientesproductos` WHERE Cliente = '" + txtnombre.getText() + "' AND Fecha = '" + txtfecha.getText() + "'";

        }
        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo1.addRow(datos);
            }
            tbproductos.setModel(modelo1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbproductos.setModel(modelo1);
    }
    
     public void eliminar() {
        String sql = "DELETE FROM `datosfactura` WHERE `datosfactura`.`id` = " + txtid.getText() + "";
        try {
            Conexión cc = new Conexión();
            Connection cn = cc.conexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            mostrardatos("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbproductos = new javax.swing.JTable();
        txtfecha = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnfacturar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn2 = new javax.swing.JButton();
        lbcorreo = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        btncorreo = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        lbdesc = new javax.swing.JLabel();
        cmbdesc = new javax.swing.JComboBox<>();
        btnmenu = new javax.swing.JButton();
        lbhora = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusuario1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        lbllogo1 = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();

        tbproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbproductos);

        txtfecha.setText("jTextField1");

        txtid.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbFactura.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFactura.setGridColor(new java.awt.Color(255, 255, 255));
        tbFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 780, 280));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Bienvenido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        btnfacturar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnfacturar.setText("Calcular");
        btnfacturar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnfacturar.setContentAreaFilled(false);
        btnfacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturarActionPerformed(evt);
            }
        });
        jPanel1.add(btnfacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 370, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("CAJA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cliente");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        jPanel2.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, -1));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 130, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Factura");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Subtotal");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("Factura electronica");
        btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, 40));

        lbcorreo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbcorreo.setForeground(new java.awt.Color(255, 255, 255));
        lbcorreo.setText("Correo:");
        jPanel2.add(lbcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));
        jPanel2.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 200, 30));

        btncorreo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btncorreo.setForeground(new java.awt.Color(255, 255, 255));
        btncorreo.setText("Enviar");
        btncorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btncorreo.setContentAreaFilled(false);
        btncorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncorreoActionPerformed(evt);
            }
        });
        jPanel2.add(btncorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 100, 30));

        btnImprimir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("Facturar");
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 40));

        lbdesc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbdesc.setForeground(new java.awt.Color(255, 255, 255));
        lbdesc.setText("Descuento");
        jPanel2.add(lbdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        cmbdesc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmbdesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20%", "21%", "22%", "23%", "24%", "25%" }));
        cmbdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdescActionPerformed(evt);
            }
        });
        jPanel2.add(cmbdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 300, 600));

        btnmenu.setBackground(new java.awt.Color(0, 0, 0));
        btnmenu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnmenu.setText("MENU");
        btnmenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnmenu.setContentAreaFilled(false);
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 90, 40));

        lbhora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbhora.setText("jLabel1");
        jPanel1.add(lbhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Bienvenido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        txtusuario1.setEditable(false);
        jPanel1.add(txtusuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 130, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setText("Bienvenido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, -1, -1));

        txtusuario.setEditable(false);
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 130, 30));
        jPanel1.add(lbllogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 210, 110));

        lbllogo.setText("jLabel1");
        jPanel1.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -200, 1230, 840));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturarActionPerformed
       try{
        int filaselect = tbFactura.getSelectedRow();
        if (filaselect >= 0) {
            txtnombre.setText(tbFactura.getValueAt(filaselect, 2).toString());
            txtsubtotal.setText(tbFactura.getValueAt(filaselect, 6).toString());
            txtfecha.setText(tbFactura.getValueAt(filaselect, 4).toString());
            txtid.setText(tbFactura.getValueAt(filaselect, 0).toString());
            
        } else {
            JOptionPane.showMessageDialog(this, "Fila no seleccionada");

        }
        }catch(Exception e){
            System.out.println(e);
        }
               
        productos("");
        eliminar();
    }//GEN-LAST:event_btnfacturarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed


        int monto = Integer.parseInt(txtsubtotal.getText());
        String desc = cmbdesc.getSelectedItem().toString();
        if (monto < 100000) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.10;
            double total = (int) monto + iva - descuento;
            
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
            
        }
        
        if (monto >= 100000) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.10;
            double total = (int) monto + iva - descuento;

            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
            
        }
        else if (monto >= 500000) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.15;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        } else if (monto >= 1000000 && desc.equals("20%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.20;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        } else if (monto >= 1000000 && desc.equals("21%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.21;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        } else if (monto >= 1000000 && desc.equals("22%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.22;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        } else if (monto >= 1000000 && desc.equals("23%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.23;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        } else if (monto >= 1000000 && desc.equals("24%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.24;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        } else if (monto >= 1000000 && desc.equals("25%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.25;
            double total = (int) monto + iva - descuento;
            JOptionPane.showMessageDialog(null, "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        Menu.Menu_Principal m = new Menu.Menu_Principal();
        m.setVisible(true);
         m.txtusuario.setText(txtusuario.getText());
        dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void cmbdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdescActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        lbcorreo.setVisible(true);
        txtcorreo.setVisible(true);
        btncorreo.setVisible(true);
        
        
        
    }//GEN-LAST:event_btn2ActionPerformed

    private void btncorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncorreoActionPerformed
       int monto = Integer.parseInt(txtsubtotal.getText());
        String desc = cmbdesc.getSelectedItem().toString();
       
        
        if (monto < 100000) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.10;
            double total = (int) monto + iva - descuento;
            
            try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
        }
        
        
        
        
        
        
        if (monto >= 100000) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.10;
            double total = (int) monto + iva - descuento;

          try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }
        else if (monto >= 500000) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.15;
            double total = (int) monto + iva - descuento;
      try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 


        } 
        
        
        
        
        else if (monto >= 1000000 && desc.equals("20%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.20;
            double total = (int) monto + iva - descuento;
            try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 
        } 
        
        
        
        
        else if (monto >= 1000000 && desc.equals("21%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.21;
            double total = (int) monto + iva - descuento;
            try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        }
        
        
        
        
        else if (monto >= 1000000 && desc.equals("22%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.22;
            double total = (int) monto + iva - descuento;
            try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 
        } 
        
        
        
        
        else if (monto >= 1000000 && desc.equals("23%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.23;
            double total = (int) monto + iva - descuento;
            try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 
        } 
        
        
        
        else if (monto >= 1000000 && desc.equals("24%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.24;
            double total = (int) monto + iva - descuento;
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 
        } 
        
        
        
        
        else if (monto >= 1000000 && desc.equals("25%")) {
            double iva = (int) monto * 0.13;
            double descuento = (int) monto * 0.25;
            double total = (int) monto + iva - descuento;
            try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ferrewakanda@gmail.com";
            String passwordRemitente = "pantera+22";
            String correoReceptor = txtcorreo.getText();
            String asunto = "Factura electronica";
            String mensaje = "FERRETERIA WAKANDA"
                    + "\nCEDULA: 3101761963"
                    + "\nDIRECCION: Africa, Wakanda 50mts, norte de la torre del rey"
                    + "\nTELEFONO:(00 237)563-547"
                    + "\n------------------------------"
                    + "\n           CONTADO      "
                    + "\n------------------------------"
                    + "\nCLIENTE: " + txtnombre.getText()
                    + "\nFECHA: " + txtfecha.getText()
                    + "\n------------------------"
                    + "\n------------------------"
                    + "\nSUBTOTAL: " + monto
                    + "\nDESCUENTO: " + descuento
                    + "\nIVA: " + iva
                    + "\n--------------------------"
                    + "\nTOTAL: " + total
                    + "\n--------------------------"
                    + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                    + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTURA."
                    + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                    + "\nFECHA 30/09/1987 DE DGTD";
            
           MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            

        } catch (AddressException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Fac_electronic.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
    }//GEN-LAST:event_btncorreoActionPerformed

    private void tbFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFacturaMouseClicked

    }//GEN-LAST:event_tbFacturaMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(facturaCajaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaCajaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaCajaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaCajaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new facturaCajaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn2;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btncorreo;
    private javax.swing.JButton btnfacturar;
    private javax.swing.JButton btnmenu;
    public static javax.swing.JComboBox<String> cmbdesc;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbcorreo;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbhora;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbllogo1;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTable tbproductos;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsubtotal;
    public javax.swing.JTextField txtusuario;
    public javax.swing.JTextField txtusuario1;
    // End of variables declaration//GEN-END:variables
  Conexión cc = new Conexión();
    Connection cn = cc.conexion();

    //Reloj
    public void run() {
        Thread control = Thread.currentThread();
        while (control == hora1) {
            calcula();
            lbhora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {

            }

        }
    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fecha = new Date();

        calendario.setTime(fecha);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            hora = h > 9 ? " " + h : "0" + h;

        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? " "
                    + calendario.get(Calendar.HOUR_OF_DAY) : "0"
                    + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? " "
                + calendario.get(Calendar.MINUTE) : "0"
                + calendario.get(Calendar.MINUTE);

        segundos = calendario.get(Calendar.SECOND) > 9 ? " "
                + calendario.get(Calendar.SECOND) : "0"
                + calendario.get(Calendar.SECOND);
    }
}
