package Reporte;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JFrame {

    String datesolo, date1, date2;

    public Productos() {
        initComponents();
             ImageIcon icono = new ImageIcon("C:\\Users\\iamjorgecruz\\Desktop\\Proyecto-Ferreteria\\src\\Imagenes\\12.png");
     jLabel4.setIcon(icono);
        setLocationRelativeTo(null);
        mostrardatos("");
        mostrarMontototal("");
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datesolo = dateFormat.format(dateunica.getDate());
        
    }
    
    public void processCalendar2f() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date1 = dateFormat.format(dateinicial.getDate());
        date2 = dateFormat.format(datefinal.getDate());
    }

    //Mostrar tabla
    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Productos");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Productos, SUM(Cantidad), SUM(Total) FROM `clientesproductos` GROUP BY Productos";

        }
        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Suma total tabla
    void mostrarMontototal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total ");

        tbMontoR.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "Select SUM(Total) FROM `clientesproductos`";
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

    //Consulta 1 fecha
    void Consultafechaunica(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Productos");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");

        processCalendar();
        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Productos, SUM(Cantidad),  SUM(Total) FROM `clientesproductos` WHERE Fecha = '" + datesolo + "' GROUP BY Productos";

        }
        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Suma total consulta 1 fecha
    void mostrarMonto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total del dia");

        tbMontoR.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "Select SUM(Total) FROM `clientesproductos` WHERE Fecha = '" + datesolo + "'";

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

    //Consulta 2 fecha
    void Consulta2fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Productos");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");

        processCalendar2f();
        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Productos, SUM(Cantidad), SUM(Total) FROM `clientesproductos` WHERE Fecha BETWEEN '"+date1+"' AND '"+date2+"' GROUP BY Productos";

        }
        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Suma total consulta 2 fechas
    void mostrarMonto2fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total del dia");

        tbMontoR.setModel(modelo);
        processCalendar2f();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT SUM(Total) FROM `clientesproductos` WHERE Fecha BETWEEN '"+date1+"' AND '"+date2+"'";

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
        dateunica = new com.toedter.calendar.JDateChooser();
        dateinicial = new com.toedter.calendar.JDateChooser();
        datefinal = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        btnfiltrofechas = new javax.swing.JButton();
        btnfiltrodia = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
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
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 800, 220));

        txtVerAll.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtVerAll.setText("Ver todos los registros facturados");
        txtVerAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVerAllMouseClicked(evt);
            }
        });
        jPanel1.add(txtVerAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        btnTotalR.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTotalR.setText("Monto total registrado");
        btnTotalR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTotalRMouseClicked(evt);
            }
        });
        jPanel1.add(btnTotalR, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, -1));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 170, 50));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Reporte productos");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 50));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Consultas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Fecha Unica");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Fecha Final");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 340, -1, -1));

        btnFiltrar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnFiltrar.setText("Filtrar por 1 fecha");
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, -1, -1));

        btnFitrar2Fechas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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

        jPanel1.add(btnmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 500, 90, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Fecha Inicial");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, -1, -1));

        dateunica.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateunica, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 100, 30));

        dateinicial.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateinicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 110, 30));

        datefinal.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(datefinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 370, 110, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 20, 530));

        btnfiltrofechas.setBackground(new java.awt.Color(0, 0, 0));
        btnfiltrofechas.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnfiltrofechas.setText("Filtrar");
        btnfiltrofechas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnfiltrofechas.setContentAreaFilled(false);
        btnfiltrofechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltrofechasActionPerformed(evt);
            }
        });
        jPanel1.add(btnfiltrofechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 430, 110, 30));

        btnfiltrodia.setBackground(new java.awt.Color(0, 0, 0));
        btnfiltrodia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnfiltrodia.setText("Filtrar");
        btnfiltrodia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnfiltrodia.setContentAreaFilled(false);
        btnfiltrodia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltrodiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnfiltrodia, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, 130, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 410, 10));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        txtusuario.setEditable(false);
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 120, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/{07B9E67E-F201-4068-8F87-079C3C29812D}.png.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/232.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -10, 1460, 1080));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked

    }//GEN-LAST:event_btnFiltrarMouseClicked

    private void txtVerAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVerAllMouseClicked
        mostrardatos("");
        mostrarMontototal("");
    }//GEN-LAST:event_txtVerAllMouseClicked

    private void btnTotalRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalRMouseClicked

    }//GEN-LAST:event_btnTotalRMouseClicked

    private void btnFitrar2FechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFitrar2FechasMouseClicked

    }//GEN-LAST:event_btnFitrar2FechasMouseClicked

    private void btnmenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenu1MouseClicked
       
       Menu.Menu_Principal m = new Menu.Menu_Principal();
                m.setVisible(true);
                dispose();

                m.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_btnmenu1MouseClicked

    private void btnfiltrodiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltrodiaActionPerformed
        Consultafechaunica("");
        mostrarMonto("");
    }//GEN-LAST:event_btnfiltrodiaActionPerformed

    private void btnfiltrofechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltrofechasActionPerformed
        Consulta2fechas("");
        mostrarMonto2fechas("");
    }//GEN-LAST:event_btnfiltrofechasActionPerformed

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
    private javax.swing.JButton btnfiltrodia;
    private javax.swing.JButton btnfiltrofechas;
    private javax.swing.JPanel btnmenu1;
    private com.toedter.calendar.JDateChooser datefinal;
    private com.toedter.calendar.JDateChooser dateinicial;
    private com.toedter.calendar.JDateChooser dateunica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
    Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
