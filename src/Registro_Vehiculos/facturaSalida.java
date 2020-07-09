package Registro_Vehiculos;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class facturaSalida extends javax.swing.JFrame {

    //----------------En proceso----------------//
    String date;

    String fechacalendario;

    public facturaSalida() {
        initComponents();
        setLocationRelativeTo(null);
       
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
   //     fechacalendario = dateFormat.format(txtFecha.getDate());

    }

    public void mostrarVehiculoFacturar(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Registro");
        modelo.addColumn("Placa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Entrada");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Tipo de vehículo");
        modelo.addColumn("Estado");

        tbFactura.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT id_registo, númeroPlaca, fecha, horaEntrada, fk_tipoVehiculo, horaSalida, fk_estado FROM registro "
                    +  "' and fecha = '" + fechacalendario + "'";

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
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbFactura.setVisible(true);

    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        btnBuscarRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtIDregistro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnfacturacion = new javax.swing.JButton();
        btnmenu = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tbFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 530, 320));

        btnBuscarRegistro.setText("Buscar");
        btnBuscarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 370, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("CAJA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total a Pagar");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 20));
        jPanel2.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monto");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID factura");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        jPanel2.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, -1));
        jPanel2.add(txtIDregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Factura");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        btnfacturacion.setText("Facturar");
        btnfacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturacionActionPerformed(evt);
            }
        });
        jPanel2.add(btnfacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 300, 570));

        btnmenu.setBackground(new java.awt.Color(0, 153, 153));
        btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmenuMouseClicked(evt);
            }
        });
        btnmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(67, 81, 141));
        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Menú");
        btnmenu.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 20));

        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 90, 40));

        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 635, 100, 40));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistroActionPerformed

        mostrarVehiculoFacturar("");
    }//GEN-LAST:event_btnBuscarRegistroActionPerformed

    private void btnmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenuMouseClicked
        dispose();
    }//GEN-LAST:event_btnmenuMouseClicked

    private void btnfacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturacionActionPerformed
         JOptionPane.showMessageDialog(null,"ALMACEN-------------"
                 +"\nCEDULA:3-029-321847"
                 +"\n100 MTR OESTE PARQUE DE GUACIMO"
                 +"\nTEL:23956584"
                 +"\n------------------------------"
                 +"\n           CONTADO      "
                 +"\n------------------------------"
                 +"\nFACTURA :"+txtIDregistro.getText()
                 +"\nCLIENTE: "
                 +"\nVENDEDOR:"
                 +"\nFECHA:"
                 +"\n------------------------"
                 +"\n------------------------"
                 +"\nSUBTOTAL:"
                 +"\nDESCUENTO"
                 +"\nIVA:"
                 +"\nOTROS CARGOS"
                 +"\n--------------------------"
                 +"\nTOTAL:"
                 +"\n--------------------------"
                 +"\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                         +"\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                 +"\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                         +"\nFECHA 30/09/1987 DE DGTD"   );
         
    }//GEN-LAST:event_btnfacturacionActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarRegistro;
    private javax.swing.JButton btnfacturacion;
    private javax.swing.JPanel btnmenu;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtIDregistro;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
  datosP cc = new datosP();
    Connection cn = cc.conexion();
}
