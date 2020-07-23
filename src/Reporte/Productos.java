package Reporte;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JFrame {

    String date;
    String date2;

    public Productos() {
        initComponents();
        setLocationRelativeTo(null);
    
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
//        date = dateFormat.format(txtFecha1.getDate());

    }

    public void processCalendar2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 //       date2 = dateFormat.format(txtFecha2.getDate());

    }

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Monto Total");
        modelo.addColumn("Tipo de vehículo");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT númeroPlaca , horaEntrada , horaSalida, montoTotal, fk_tipoVehiculo "
                    + "FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo";

        }
        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrarFiltro(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Monto total");
        modelo.addColumn("Tipo de vehículo");

        tbDatos.setModel(modelo);
        processCalendar();
        String sql = "";

        if (valor.equals("")) {

           /* sql = "Select númeroPlaca , horaEntrada , horaSalida, montoTotal, fk_tipoVehiculo "
                    + "From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + " AND fecha='" + date + "'";

        }

        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarFiltro2Fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Monto total");
        modelo.addColumn("Tipo de vehículo");

        tbDatos.setModel(modelo);
        processCalendar();
        processCalendar2();
        String sql = "";

        if (valor.equals("")) {

            sql = "Select númeroPlaca , horaEntrada , horaSalida, montoTotal, fk_tipoVehiculo "
                    + "From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + " AND fecha between'" + date + "' and '" + date2 + "'  ";

        }

        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarMonto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Suma total de montos de datos filtados");

        tbmontoT.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo "
                    + "WHERE fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + "  AND fecha='" + date + "'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmontoT.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarMonto2Fecha(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Suma total de montos de datos filtados");

        tbmontoT.setModel(modelo);
        processCalendar();
        processCalendar2();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo "
                    + "WHERE fk_tipoVehiculo= " + cmbTipoVehiculo.getSelectedItem()
                    + "  AND fecha between'" + date + "' and '" + date2 + "'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmontoT.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarMontoTotal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Suma total");

        tbMontoR.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbMontoR.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarDatosPorPlaca(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número Placa");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
        modelo.addColumn("Fecha");
        modelo.addColumn("Monto total");
        modelo.addColumn("Tipo de vehículo");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "Select númeroPlaca , horaEntrada , horaSalida, fecha, montoTotal, fk_tipoVehiculo "
                    + "From registro a INNER JOIN factura b  on b.fk_registro = a.id_registo "
                    + "where númeroPlaca ='" + txtPlaca.getText() + "'";

        }

        String[] datos = new String[6];
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

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
*/
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        txtVerAll = new javax.swing.JLabel();
        btnTotalR = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMontoR = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JLabel();
        btnFitrar2Fechas = new javax.swing.JLabel();
        btnmenu1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        btnfiltro2fechas = new javax.swing.JButton();
        btnfiltrodia = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Nombre_productos", "Precio_Unitario", "Precio_Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 720, 140));

        txtVerAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtVerAll.setForeground(new java.awt.Color(0, 0, 0));
        txtVerAll.setText("Ver todos los registros facturados");
        txtVerAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVerAllMouseClicked(evt);
            }
        });
        jPanel1.add(txtVerAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnTotalR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTotalR.setText("Monto total registrado");
        btnTotalR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTotalRMouseClicked(evt);
            }
        });
        jPanel1.add(btnTotalR, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        tbMontoR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbMontoR);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 170, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Reporte");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Consultas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Fecha Unica");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Fecha Final");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 360, -1, -1));

        btnFiltrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        btnFiltrar.setText("Filtrar por 1 fecha");
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        btnFitrar2Fechas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFitrar2Fechas.setForeground(new java.awt.Color(0, 0, 0));
        btnFitrar2Fechas.setText("Filtrar por 2 fechas");
        btnFitrar2Fechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFitrar2FechasMouseClicked(evt);
            }
        });
        jPanel1.add(btnFitrar2Fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 320, -1, 20));

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

        jPanel1.add(btnmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 90, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Fecha Inicial");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, -1, -1));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, -1, -1));
        jPanel1.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 390, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 20, 450));

        btnfiltro2fechas.setText("Filtrar");
        jPanel1.add(btnfiltro2fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, -1, -1));

        btnfiltrodia.setText("Filtrar");
        jPanel1.add(btnfiltrodia, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 470, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 533));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked

        try {
//            txtFecha2.setEnabled(false);
  //          txtFecha2.setDate(null);
            mostrarFiltro("");
           // mostrarMonto("");

            DefaultTableModel tb = (DefaultTableModel) tbMontoR.getModel();
            int a = tbMontoR.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                tb.removeRow(tb.getRowCount() - 1);
            }
        } catch (Exception i) {

        }
    }//GEN-LAST:event_btnFiltrarMouseClicked

    private void txtVerAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVerAllMouseClicked
        mostrardatos("");
       // mostrarMontoTotal("");
      //  txtFecha1.setDate(null);
    //    txtFecha2.setDate(null);
       /* DefaultTableModel tb = (DefaultTableModel) tbmontoT.getModel();
        int a = tbmontoT.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);

        }*/

    }//GEN-LAST:event_txtVerAllMouseClicked

    private void btnTotalRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalRMouseClicked
       // mostrarMontoTotal("");
    }//GEN-LAST:event_btnTotalRMouseClicked

    private void btnFitrar2FechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFitrar2FechasMouseClicked

        try {

          //  txtFecha2.setEnabled(true);
            /*mostrarFiltro2Fechas("");
            mostrarMonto2Fecha("");*/

            DefaultTableModel tb = (DefaultTableModel) tbMontoR.getModel();
            int a = tbMontoR.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                tb.removeRow(tb.getRowCount() - 1);
            }

        } catch (Exception i) {

        }

    }//GEN-LAST:event_btnFitrar2FechasMouseClicked

    private void btnmenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenu1MouseClicked
        dispose();
    }//GEN-LAST:event_btnmenu1MouseClicked

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFiltrar;
    private javax.swing.JLabel btnFitrar2Fechas;
    private javax.swing.JLabel btnTotalR;
    private javax.swing.JButton btnfiltro2fechas;
    private javax.swing.JButton btnfiltrodia;
    private javax.swing.JPanel btnmenu1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbDatos;
    private javax.swing.JTable tbMontoR;
    private javax.swing.JLabel txtVerAll;
    // End of variables declaration//GEN-END:variables
    Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
