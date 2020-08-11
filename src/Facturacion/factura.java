package Facturacion;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class factura extends javax.swing.JFrame {

    DefaultTableModel modelo, modelo1;
    String date;
    String datesolo;
    int cont;

    public factura() {
        initComponents();

        String principal[] = {"Codigo producto", "Descripción", "Precio unitario", "Cantidad"};
        String datos[][] = {};
        modelo = new DefaultTableModel(datos, principal);
        tbimprimir1.setModel(modelo);
        setLocationRelativeTo(null);

    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datesolo = dateFormat.format(txtFecha.getDate());

    }

    //Tabla stock
    void mostrardatos(String valor) {
        String producto = txtprodp.getText();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad Stock");

        tbstock.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT `" + producto + "` FROM inventario ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbstock.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtvendedor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnfacturar1 = new javax.swing.JButton();
        btneliminar1 = new javax.swing.JButton();
        btnmenu1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbimprimir1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtprodp = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtcodp = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtpreciop = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JSpinner();
        btneliminar2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtsubtotal = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbstock = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Materiales:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        jLabel14.setText("Vendedor(a):");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jLabel15.setText("Subtotal:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 100, -1));

        txtvendedor.setEditable(false);
        jPanel2.add(txtvendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 110, 30));

        jLabel16.setText("Cantidad:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        btnfacturar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnfacturar1.setText("FACTURAR");
        btnfacturar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnfacturar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 110, 30));

        btneliminar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btneliminar1.setText("Cargar Proforma");
        jPanel2.add(btneliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 160, 30));

        btnmenu1.setBackground(new java.awt.Color(0, 0, 0));
        btnmenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnmenu1.setForeground(new java.awt.Color(255, 255, 255));
        btnmenu1.setText("MENU");
        btnmenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenu1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 670, 80, 40));

        tbimprimir1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tbimprimir1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_producto", "Productos", "Precio", "Cantidad"
            }
        ));
        jScrollPane3.setViewportView(tbimprimir1);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 710, 140));

        jLabel17.setText("Nombre:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel18.setText("Fecha:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        txtFecha.setDateFormatString("yyyy-MM-dd");
        txtFecha.setMaxSelectableDate(new java.util.Date(253370790110000L));
        txtFecha.setMinSelectableDate(new java.util.Date(-62135744290000L));
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 140, 30));

        jLabel19.setText("Apellido:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        txtapellido.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtapellido.setToolTipText("");
        jPanel2.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 100, -1));

        jLabel20.setText("Cedula:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));
        jPanel2.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 100, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Generacion de factura");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 770, 10));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("Datos Cliente:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setText("Materiales:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 770, 20));

        jButton1.setText("Lista de materiales");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 140, 30));

        jLabel24.setText("Cantidad en stock:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));
        jPanel2.add(txtprodp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 160, 30));

        jLabel25.setText("Cod. producto:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        jPanel2.add(txtcodp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 70, 30));

        jLabel26.setText("Precio:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));
        jPanel2.add(txtpreciop, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 110, 30));

        txtcantidad.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        jPanel2.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 40, 30));

        btneliminar2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btneliminar2.setText("ELIMINAR");
        btneliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar2ActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 100, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("Factura:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 80, 30));

        txtsubtotal.setEditable(false);
        txtsubtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsubtotal.setText("0");
        jPanel2.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 130, 40));

        txtusuario.setEditable(false);
        jPanel2.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 130, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jLabel28.setText("Producto:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        tbstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbstock);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 170, 60));

        jButton3.setText("Colsultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnfacturar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturar1ActionPerformed
        cont = 0;

        if (txtcedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }

        if (txtnombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }

        
        if (txtapellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }

        if (txtvendedor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }

        if (txtsubtotal.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }

        if (cont == 0) {

            try {
                Conexión cc = new Conexión();
                Connection cn = cc.conexion();
                processCalendar();
                PreparedStatement pst = cn.prepareStatement("INSERT INTO datosfactura(Cedula,Nombre,Apellido,Fecha,Vendedor,Subtotal) VALUES (?,?,?,?,?,?)");
                pst.setString(1, txtcedula.getText());
                pst.setString(2, txtnombre.getText());
                pst.setString(3, txtapellido.getText());
                pst.setString(4, datesolo);
                pst.setString(5, txtvendedor.getText());
                pst.setString(6, txtsubtotal.getText());

                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e);
            }

            txtapellido.setText("");
            txtcedula.setText("");
            txtnombre.setText("");
            txtvendedor.setText("");
            txtsubtotal.setText("");
            JOptionPane.showMessageDialog(this, "Guardado con exito");
        }

    }//GEN-LAST:event_btnfacturar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Materiales m = new Materiales();
        m.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int suma, precio, cantidad, subtotal;

        precio = Integer.parseInt(txtpreciop.getText());
        cantidad = Integer.parseInt(txtcantidad.getValue().toString());
        subtotal = Integer.parseInt(txtsubtotal.getText());

        suma = precio * cantidad + subtotal;

        txtsubtotal.setText("" + suma);

        String codigo = txtcodp.getText();
        String producto = txtprodp.getText();
        Object datos[] = {codigo, producto, precio, cantidad};
        modelo.addRow(datos);

        txtcodp.setText("");
        txtprodp.setText("");
        txtpreciop.setText("");
        txtcantidad.setValue(1);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnmenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu1ActionPerformed
        Menu.Menu_Principal m = new Menu.Menu_Principal();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmenu1ActionPerformed

    private void btneliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar2ActionPerformed
        int filaselect = tbimprimir1.getSelectedRow();
        if (filaselect >= 0) {
            modelo.removeRow(filaselect);

        } else {

            JOptionPane.showMessageDialog(this, "Selecione una fila a eliminar");
        }
    }//GEN-LAST:event_btneliminar2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrardatos("");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar1;
    private javax.swing.JButton btneliminar2;
    private javax.swing.JButton btnfacturar1;
    private javax.swing.JButton btnmenu1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tbimprimir1;
    private javax.swing.JTable tbstock;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JSpinner txtcantidad;
    private javax.swing.JTextField txtcedula;
    public static javax.swing.JTextField txtcodp;
    private javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtpreciop;
    public static javax.swing.JTextField txtprodp;
    private javax.swing.JTextField txtsubtotal;
    public javax.swing.JTextField txtusuario;
    public javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables
 Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
