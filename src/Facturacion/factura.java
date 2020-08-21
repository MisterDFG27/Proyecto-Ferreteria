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
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class factura extends javax.swing.JFrame implements Printable {

    DefaultTableModel modelo, modelo1;
    ProductoDAO pdao = new ProductoDAO();
    String date, datesolo, prod;
    int cont, idp, pre, cant, cant1, iva, desc, total;
    Proforma p = new Proforma();

    public factura() {
        initComponents();
        String principal[] = {"Codigo producto", "Descripción", "Cantidad", "Precio"};
        String datos[][] = {};
        modelo = new DefaultTableModel(datos, principal);
        tbimprimir1.setModel(modelo);
        setLocationRelativeTo(null);
        txttotal.setVisible(false);
        txtresta.setVisible(false);
        txtcantm.setVisible(false);

    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datesolo = dateFormat.format(txtFecha.getDate());

    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        p.impresion1.printAll(graphics);

        return PAGE_EXISTS;

    }

    void actualizarStock() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Producto pr = new Producto();
            idp = Integer.parseInt(tbimprimir1.getValueAt(i, 0).toString());
            cant = Integer.parseInt(tbimprimir1.getValueAt(i, 2).toString());
            pr = pdao.listarID(idp);
            int sa = pr.getCant() - cant;
            pdao.actualizarStock(sa, idp);
        }
    }

    void clientesproductos() {
        cont = 0;
        if (txtnombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }
        if (cont == 0) {

            for (int i = 0; i < modelo.getRowCount(); i++) {

                prod = tbimprimir1.getValueAt(i, 1).toString();
                cant1 = Integer.parseInt(tbimprimir1.getValueAt(i, 2).toString());
                total = Integer.parseInt(tbimprimir1.getValueAt(i, 3).toString());

                try {
                    Conexión cc = new Conexión();
                    Connection cn = cc.conexion();
                    processCalendar();
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO `clientesproductos`(`Cliente`, `Fecha`, `Productos`, `Cantidad`,`Total`) VALUES (?,?,?,?,?)");
                    pst.setString(1, txtnombre.getText());
                    pst.setString(2, datesolo);
                    pst.setString(3, prod);
                    pst.setInt(4, cant1);
                    pst.setInt(5, total);

                    pst.executeUpdate();

                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }

    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
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
        txttotal = new javax.swing.JTextField();
        txtcantm = new javax.swing.JTextField();
        txtresta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Materiales:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Vendedor(a):");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Subtotal:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));

        txtnombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 100, -1));

        txtvendedor.setEditable(false);
        txtvendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txtvendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 110, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Cantidad:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        btnfacturar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnfacturar1.setText("FACTURAR");
        btnfacturar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnfacturar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 110, 30));

        btneliminar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btneliminar1.setText("Cargar Proforma");
        btneliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar1ActionPerformed(evt);
            }
        });
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

            },
            new String [] {
                "Id_producto", "Productos", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbimprimir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbimprimir1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbimprimir1);
        if (tbimprimir1.getColumnModel().getColumnCount() > 0) {
            tbimprimir1.getColumnModel().getColumn(0).setResizable(false);
            tbimprimir1.getColumnModel().getColumn(1).setResizable(false);
            tbimprimir1.getColumnModel().getColumn(2).setResizable(false);
            tbimprimir1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 710, 140));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Nombre:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Fecha:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        txtFecha.setToolTipText("");
        txtFecha.setDateFormatString("yyyy-MM-dd");
        txtFecha.setMaxSelectableDate(new java.util.Date(253370790110000L));
        txtFecha.setMinSelectableDate(new java.util.Date(-62135744290000L));
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 140, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Apellido:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        txtapellido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtapellido.setToolTipText("");
        jPanel2.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 100, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Cedula:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        txtcedula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 100, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Generacion de factura");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 780, 10));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("Datos Cliente:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setText("Materiales:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 770, 20));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Lista de materiales");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 150, 30));

        txtprodp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txtprodp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 160, 30));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Cod. producto:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txtcodp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txtcodp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 70, 30));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("Precio:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        txtpreciop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(txtpreciop, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 110, 30));

        txtcantidad.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        jPanel2.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 40, 30));

        btneliminar2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btneliminar2.setText("ELIMINAR");
        btneliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar2ActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 110, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("Factura:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 80, 30));

        txtsubtotal.setEditable(false);
        txtsubtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsubtotal.setText("0");
        jPanel2.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 130, 40));

        txtusuario.setEditable(false);
        jPanel2.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 130, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("Producto:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 710));

        txttotal.setEditable(false);
        txttotal.setText("jTextField1");
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtcantm.setEditable(false);
        getContentPane().add(txtcantm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 60, -1));

        txtresta.setEditable(false);
        getContentPane().add(txtresta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnfacturar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturar1ActionPerformed
        cont = 0;

        if (txtcedula.getText().equals("") || txtnombre.getText().equals("") || txtapellido.getText().equals("") || txtvendedor.getText().equals("") || txtsubtotal.getText().equals("")) {
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
            clientesproductos();
            actualizarStock();
            txtapellido.setText("");
            txtcedula.setText("");
            txtnombre.setText("");
            txtsubtotal.setText("");
            JOptionPane.showMessageDialog(this, "Guardado con exito");

            limpiarTabla();
        }
        txttotal.setVisible(false);
        txtresta.setVisible(false);
        txtcantm.setVisible(false);
    }//GEN-LAST:event_btnfacturar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Materiales m = new Materiales();
        m.setVisible(true);
        txttotal.setVisible(false);
        txtresta.setVisible(false);
        txtcantm.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int c = Integer.parseInt(txtcantidad.getValue().toString()), cm = Integer.parseInt(txtcantm.getText());

            if (c > cm) {
                JOptionPane.showMessageDialog(null, "Cantidad insuficiente en stock \nCantidad maxima de "+txtprodp.getText()+" es de "+txtcantm.getText()+"", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int suma, precio, cantidad, subtotal, total;

                precio = Integer.parseInt(txtpreciop.getText());
                cantidad = Integer.parseInt(txtcantidad.getValue().toString());
                subtotal = Integer.parseInt(txtsubtotal.getText());

                suma = precio * cantidad + subtotal;
                total = precio * cantidad;

                txtsubtotal.setText("" + suma);

                String codigo = txtcodp.getText();
                String producto = txtprodp.getText();
                Object datos[] = {codigo, producto, cantidad, total};
                modelo.addRow(datos);

                txtcodp.setText("");
                txtprodp.setText("");
                txtpreciop.setText("");
                txtcantidad.setValue(1);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        txttotal.setVisible(false);
        txtresta.setVisible(false);
        txtcantm.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnmenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenu1ActionPerformed
        Menu.Menu_Principal m = new Menu.Menu_Principal();
        m.setVisible(true);
        m.txtusuario.setText(txtusuario.getText());
        dispose();
    }//GEN-LAST:event_btnmenu1ActionPerformed

    private void btneliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar2ActionPerformed
        int sub = Integer.parseInt(txtsubtotal.getText());
        int mcant= Integer.parseInt(txtresta.getText());
        int resta;
        
        resta = sub - mcant;
        txtsubtotal.setText(""+resta);
        
        int filaselect = tbimprimir1.getSelectedRow();
        if (filaselect >= 0) {
            modelo.removeRow(filaselect);

        } else {

            JOptionPane.showMessageDialog(this, "Selecione una fila a eliminar");
        }

txttotal.setVisible(false);
        txtresta.setVisible(false);
        txtcantm.setVisible(false);
    }//GEN-LAST:event_btneliminar2ActionPerformed

    private void btneliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar1ActionPerformed

        try {
            int subtotal = Integer.parseInt(txtsubtotal.getText());
            double iva = subtotal * 0.13, descuento = subtotal * 0.20;
            int total = (int) (subtotal + iva - descuento);

            p.setVisible(true);

            for (int i = 0; i < tbimprimir1.getRowCount(); i++) {
                String Datos[] = new String[4];
                Datos[0] = tbimprimir1.getValueAt(i, 0).toString();
                Datos[1] = tbimprimir1.getValueAt(i, 1).toString();
                Datos[2] = tbimprimir1.getValueAt(i, 2).toString();
                Datos[3] = tbimprimir1.getValueAt(i, 3).toString();
                p.modelo2.addRow(Datos);
            }

            processCalendar();
            p.lblfecha.setText(datesolo);
            p.lblnombre.setText(txtnombre.getText() + " " + txtapellido.getText());
            p.lblvendedor.setText(txtvendedor.getText());
            p.lblsubtotal.setText(txtsubtotal.getText());
            p.lbltotal.setText("" + total);
        } catch (Exception e) {
            System.out.print(e);
        }

        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
        } catch (PrinterException ex) {
            System.out.println(ex);
        }
        txttotal.setVisible(false);
        txtresta.setVisible(false);
        txtcantm.setVisible(false);
    }//GEN-LAST:event_btneliminar1ActionPerformed

    private void tbimprimir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbimprimir1MouseClicked
       int fila = tbimprimir1.getSelectedRow();
        if (fila >= 0) {
            txtresta.setText(tbimprimir1.getValueAt(fila, 3).toString());

        }
    }//GEN-LAST:event_tbimprimir1MouseClicked

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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tbimprimir1;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JSpinner txtcantidad;
    public static javax.swing.JTextField txtcantm;
    private javax.swing.JTextField txtcedula;
    public static javax.swing.JTextField txtcodp;
    private javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtpreciop;
    public static javax.swing.JTextField txtprodp;
    private javax.swing.JTextField txtresta;
    private javax.swing.JTextField txtsubtotal;
    public javax.swing.JTextField txttotal;
    public javax.swing.JTextField txtusuario;
    public javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables
 Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
