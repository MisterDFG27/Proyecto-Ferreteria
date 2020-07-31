package Reporte;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Factura extends javax.swing.JFrame {

    String datesolo, date1, date2;

    public Factura() {
        initComponents();
        setLocationRelativeTo(null);
        mostrardatos("");
        mostrarMontototal("");
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datesolo = dateFormat.format(jdatefecha1.getDate());

    }

    public void processCalendar2f() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date1 = dateFormat.format(jdateinicial.getDate());
        date2 = dateFormat.format(jdatefinal.getDate());
    }

    //Mostrar tabla
    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idfactura");
        modelo.addColumn("nombre");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Codigo Productos");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Sub Total");
        modelo.addColumn("Descuento");
        modelo.addColumn("IVA");
        modelo.addColumn("Total");

        tbreporte.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = " SELECT * FROM `facturas` ";

        }
        String[] datos = new String[13];
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
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);
                modelo.addRow(datos);
            }
            tbreporte.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Suma total tabla
    void mostrarMontototal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total ");

        tbmonto.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "Select SUM(Total) FROM `facturas`";
        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmonto.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    //Consulta 1 fecha
    void Consultafechaunica(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idfactura");
        modelo.addColumn("nombre");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Codigo Productos");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Sub Total");
        modelo.addColumn("Descuento");
        modelo.addColumn("IVA");
        modelo.addColumn("Total");

        processCalendar();
        tbreporte.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT  * FROM `facturas` WHERE Fecha = '" + datesolo + "'";

        }
        String[] datos = new String[13];
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
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);
                modelo.addRow(datos);
            }
            tbreporte.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Suma total consulta 1 fecha
    void mostrarMonto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total del dia");

        tbmonto.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "Select SUM(Total) FROM `facturas` WHERE Fecha = '" + datesolo + "'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmonto.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    //Consulta 2 fecha
    void Consulta2fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idfactura");
        modelo.addColumn("nombre");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Codigo Productos");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Sub Total");
        modelo.addColumn("Descuento");
        modelo.addColumn("IVA");
        modelo.addColumn("Total");

        processCalendar2f();
        tbreporte.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM facturas WHERE Fecha BETWEEN '" + date1 + "' AND '" + date2 + "'";

        }
        String[] datos = new String[13];
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
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);

                modelo.addRow(datos);
            }
            tbreporte.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Suma total consulta 2 fechas
    void mostrarMonto2fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total del dia");

        tbmonto.setModel(modelo);
        processCalendar2f();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT SUM(Total) FROM `facturas` WHERE Fecha between = '" + date1 + "' and '" + date2 + "'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmonto.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbreporte = new javax.swing.JTable();
        txtmostrar = new javax.swing.JLabel();
        btnTotalR = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JLabel();
        btnFitrar2Fechas = new javax.swing.JLabel();
        btnmenu1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdatefecha1 = new com.toedter.calendar.JDateChooser();
        jdateinicial = new com.toedter.calendar.JDateChooser();
        jdatefinal = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        btnfiltro2 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbmonto = new javax.swing.JTable();
        btnfiltro1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbreporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_factura", "Nombre_cliente", "Fecha", "Nombre_productos", "Cantidad", "Presentación", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbreporte.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbreporte);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 780, 230));

        txtmostrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtmostrar.setText("Ver todos los registros facturados");
        txtmostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtmostrarMouseClicked(evt);
            }
        });
        jPanel1.add(txtmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        btnTotalR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTotalR.setText("Monto total registrado");
        btnTotalR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTotalRMouseClicked(evt);
            }
        });
        jPanel1.add(btnTotalR, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Reporte");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Consultas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nombre Cliente:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Fecha Final");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 340, -1, -1));

        btnFiltrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFiltrar.setText("Filtrar por 1 fecha");
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, -1, -1));

        btnFitrar2Fechas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFitrar2Fechas.setText("Filtrar por 2 fechas");
        btnFitrar2Fechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFitrar2FechasMouseClicked(evt);
            }
        });
        jPanel1.add(btnFitrar2Fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 300, -1, 20));

        btnmenu1.setBackground(new java.awt.Color(0, 0, 0));
        btnmenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmenu1MouseClicked(evt);
            }
        });
        btnmenu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(67, 81, 141));
        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Menú");
        btnmenu1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 20));

        jPanel1.add(btnmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 490, 90, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Fecha Inicial");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, -1, -1));

        jdatefecha1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdatefecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 110, 30));

        jdateinicial.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdateinicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 120, 30));

        jdatefinal.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdatefinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 370, 120, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 20, 530));

        btnfiltro2.setBackground(new java.awt.Color(0, 0, 0));
        btnfiltro2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfiltro2.setForeground(new java.awt.Color(255, 255, 255));
        btnfiltro2.setText("Filtrar");
        btnfiltro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltro2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnfiltro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 430, 80, 30));

        btnbuscar.setText("Buscar");
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 440, 10));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Fecha Unica");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, -1, -1));

        tbmonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbmonto);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 170, 50));

        btnfiltro1.setBackground(new java.awt.Color(0, 0, 0));
        btnfiltro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfiltro1.setForeground(new java.awt.Color(255, 255, 255));
        btnfiltro1.setText("Filtrar");
        btnfiltro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltro1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnfiltro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 80, 30));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        txtusuario.setEditable(false);
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1240, 533));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked

    }//GEN-LAST:event_btnFiltrarMouseClicked

    private void txtmostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtmostrarMouseClicked
        mostrardatos("");

    }//GEN-LAST:event_txtmostrarMouseClicked

    private void btnTotalRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalRMouseClicked
        // mostrarMontoTotal("");
    }//GEN-LAST:event_btnTotalRMouseClicked

    private void btnFitrar2FechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFitrar2FechasMouseClicked

    }//GEN-LAST:event_btnFitrar2FechasMouseClicked

    private void btnmenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenu1MouseClicked
        Menu.Menu_Principal m = new Menu.Menu_Principal();
                m.setVisible(true);
                dispose();

                m.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_btnmenu1MouseClicked

    private void btnfiltro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltro1ActionPerformed
        Consultafechaunica("");
    }//GEN-LAST:event_btnfiltro1ActionPerformed

    private void btnfiltro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltro2ActionPerformed
        Consulta2fechas("");
    }//GEN-LAST:event_btnfiltro2ActionPerformed

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFiltrar;
    private javax.swing.JLabel btnFitrar2Fechas;
    private javax.swing.JLabel btnTotalR;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnfiltro1;
    private javax.swing.JButton btnfiltro2;
    private javax.swing.JPanel btnmenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdatefecha1;
    private com.toedter.calendar.JDateChooser jdatefinal;
    private com.toedter.calendar.JDateChooser jdateinicial;
    private javax.swing.JTable tbmonto;
    private javax.swing.JTable tbreporte;
    private javax.swing.JLabel txtmostrar;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
    Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
