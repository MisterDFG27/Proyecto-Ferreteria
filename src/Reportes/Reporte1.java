package Reportes;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Reporte1 extends javax.swing.JFrame {
   
    DefaultTableModel modelo;
    
    String date;
   
   
    public Reporte1() {
        initComponents();
        setLocationRelativeTo(null);
      
    }
    
    //Calendario
    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      //  date = dateFormat.format(txtfecha.getDate());

    }

    //cantidad vehiculo liviano
    void mostrardatosVL(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        processCalendar();
        tbcantliv.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='1' AND fecha='"+date+"' and fk_estado ='F'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantliv.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbcantliv.setVisible(true);
    }

    //cantidad vehiculo Pesado
    void mostrardatosVP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");
        processCalendar();
        tbcantp.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='2' AND fecha='"+date+"' and fk_estado ='F'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantp.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbcantp.setVisible(true);
    }

    //cantidad Moto
    void mostrardatosM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");
        processCalendar();
        tbcantm.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='3' AND fecha='"+date+"' and fk_estado ='F'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantm.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbcantm.setVisible(true);
    }

    //monto liviano
    void mostrardatosML(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto");
        processCalendar();
        tbmont1.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql ="SELECT Sum(montototal) From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"' and fk_tipoVehiculo = 1 and fk_estado ='F'";


        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
               

                modelo.addRow(datos);
            }
            tbmont1.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         tbmont1.setVisible(true);
    }

    //monto de pesados
    void mostrardatosMP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto");
        processCalendar();
        tbmont2.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql ="SELECT Sum(montototal) From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"' and fk_tipoVehiculo = 2 and fk_estado ='F'";


        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
               

                modelo.addRow(datos);
            }
            tbmont2.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         tbmont2.setVisible(true);
    }
    
    //Monto de motos
    void mostrardatosMM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto");
        processCalendar();
        tbmont3.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql ="SELECT Sum(montototal) From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"' and fk_tipoVehiculo = 3 and fk_estado ='F'";


        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
               

                modelo.addRow(datos);
            }
            tbmont3.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         tbmont3.setVisible(true);
    }
    
    //Monto Total
    void mostrarMontoTotal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total");
        
        tbMontoR.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"'";

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
         tbMontoR.setVisible(true);
    }
    
    //limpiar
    void limpiartabla() {
          tbcantliv.setVisible(false);
         tbcantp.setVisible(false);
         tbcantm.setVisible(false);
        tbmont1.setVisible(false);
         tbmont2.setVisible(false);
        tbmont3.setVisible(false);
         tbMontoR.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnmenu1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbmont1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbcantliv = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbmont2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbcantp = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmont3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcantm = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbMontoR = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Motocicletas:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 110, 20));

        btnlimpiar.setBackground(new java.awt.Color(0, 153, 153));
        btnlimpiar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 100, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("            Reporte General");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 340, 42));

        btnmenu1.setBackground(new java.awt.Color(0, 153, 153));
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

        jPanel3.add(btnmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 90, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Fecha");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 60, 30));

        btnbuscar.setBackground(new java.awt.Color(0, 153, 153));
        btnbuscar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 120, 30));

        tbmont1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbmont1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbmont1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbmont1);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 90, 60));

        tbcantliv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantliv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantliv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tbcantliv);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 90, 60));

        tbmont2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbmont2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbmont2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbmont2);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 90, 60));

        tbcantp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbcantp);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 90, 60));

        tbmont3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbmont3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbmont3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbmont3);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 90, 60));

        tbcantm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbcantm);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 90, 60));

        tbMontoR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbMontoR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbMontoR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tbMontoR);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 100, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Cierre de caja");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Vehiculo Liviano:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 140, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Vehiculo Pesado:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, 20));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 153));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 420, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 430, 10));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 153));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 430, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Tipo vehículo");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 150, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        mostrardatosVL("");
        mostrardatosVP("");
        mostrardatosM("");
        mostrardatosML("");
        mostrardatosMP("");
        mostrardatosMM("");
        mostrarMontoTotal("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
      limpiartabla();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnmenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenu1MouseClicked
        dispose();
    }//GEN-LAST:event_btnmenu1MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JPanel btnmenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbMontoR;
    private javax.swing.JTable tbcantliv;
    private javax.swing.JTable tbcantm;
    private javax.swing.JTable tbcantp;
    private javax.swing.JTable tbmont1;
    private javax.swing.JTable tbmont2;
    private javax.swing.JTable tbmont3;
    // End of variables declaration//GEN-END:variables
 datosP cc = new datosP();
    Connection cn = cc.conexion();
}
