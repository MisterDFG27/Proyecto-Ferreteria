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

    int cont;
    String date;
 String CantidV;
 
    public factura() {
        initComponents();
         txtrequeridoN.setVisible(false);
            txtrequeridoC.setVisible(false);
            txtrequeridoV.setVisible(false);
            txtrequeridofecha.setVisible(false);
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
        date = dateFormat.format(txtFechaI.getDate());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        cmbmaterial = new javax.swing.JComboBox<>();
        txtvendedor = new javax.swing.JTextField();
        cmbpago = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        btnfacturar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbimprimir = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtrequeridoN = new javax.swing.JLabel();
        txtrequeridoC = new javax.swing.JLabel();
        txtrequeridoV = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFechaI = new com.toedter.calendar.JDateChooser();
        txtrequeridofecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Generacion de factura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel2.setText("MATERIAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel3.setText("ID VENDEDOR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel4.setText("FORMA DE PAGO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, -1));

        cmbmaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alambre", "Varilla", "Anticorrosivo", "Arena fina", "Zinc", "Aguarras", "Disco metabo", "Block", "Varilla grafilada", "Tubo galvanizado", "Pala clásica", "Brocha", "Cemento", "Grasa amarilla", "Broca concreto", "Perfil galvanizado", "Inodoro blanco", "Tornillos techo", "Soldadura", "Manguera reforzadora" }));
        jPanel1.add(cmbmaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 160, -1));
        jPanel1.add(txtvendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 140, -1));

        cmbpago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "efectivo", "tarjeta", " " }));
        jPanel1.add(cmbpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        jLabel5.setText("CANTIDAD");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 110, -1));

        btnfacturar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnfacturar.setText("FACTURAR");
        btnfacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturarActionPerformed(evt);
            }
        });
        jPanel1.add(btnfacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, 30));

        btneliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btneliminar.setText("ELIMINAR");
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 100, 30));

        btnmenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnmenu.setText("MENU");
        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 80, 30));

        tbimprimir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tbimprimir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_factura", "Nombre_cliente", "Producto", "Cantidad", "Id_vendedor", "Forma_pago"
            }
        ));
        jScrollPane2.setViewportView(tbimprimir);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 660, 140));

        jLabel6.setText("NOMBRE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        txtrequeridoN.setText("REQUERIDO");
        jPanel1.add(txtrequeridoN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        txtrequeridoC.setText("REQUERIDO");
        jPanel1.add(txtrequeridoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        txtrequeridoV.setText("REQUERIDO");
        jPanel1.add(txtrequeridoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel7.setText("FECHA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanel1.add(txtFechaI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 150, -1));

        txtrequeridofecha.setText("REQUERIDO");
        jPanel1.add(txtrequeridofecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrardatosTotalVehiculosDiaregistro(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Facturacion");

        tbimprimir.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT númeroPlaca FROM registro WHERE fk_estado = 'D'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbimprimir.setModel(modelo);

            txtcantidad.setText("" + tbimprimir.getRowCount());

            //Bloquear la opcion a los 0
            CantidV = txtcantidad.getText();

            if (Integer.parseInt(CantidV) == 0) {

                txtnombre.setEnabled(false);
                txtFechaI.setEnabled(false);
                txtcantidad.setEnabled(false);
                txtvendedor.setEnabled(false);

            } else {
                txtnombre.setEnabled(true);
                txtFechaI.setEnabled(true);
                txtcantidad.setEnabled(true);
                txtvendedor.setEnabled(true);

            }
            //-----------------------

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbimprimir.setVisible(true);

    }


    
    private void btnfacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturarActionPerformed

        cont = 0;

        if (txtnombre.getText().equals("")) {
            txtrequeridoN.setVisible(true);
            cont++;
        } else {
            txtrequeridoN.setVisible(false);

        }

        if (txtcantidad.getText().equals("")) {
            txtrequeridoC.setVisible(true);
            cont++;
        } else {
            txtrequeridoC.setVisible(false);
        }

        if (txtvendedor.getText().equals("")) {
            txtrequeridoV.setVisible(true);
            cont++;
        } else {
            txtrequeridoV.setVisible(false);
        }

        if (cont == 0) {

            try {
                Conexión cc = new Conexión();
                Connection cn = cc.conexion();
                processCalendar();

                PreparedStatement pst = cn.prepareStatement("INSERT INTO registro(númeroPlaca,"
                        + "fecha,horaEntrada,fk_tipoVehiculo,fk_usuario,fk_estado) VALUES (?,?,?,?,?,?)");
                pst.setString(1, txtnombre.getText());
                pst.setString(2, date);
                pst.setString(3, (String) cmbmaterial.getSelectedItem());
                pst.setString(4, txtcantidad.getText());
                pst.setString(5, txtvendedor.getText());
                pst.setString(6, (String) cmbpago.getSelectedItem());

                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e);
            }

            txtnombre.setText("");
            txtvendedor.setText("");

            txtrequeridoN.setVisible(false);
            txtrequeridoC.setVisible(false);
            txtrequeridoV.setVisible(false);
            txtrequeridofecha.setVisible(false);

            mostrardatosTotalVehiculosDiaregistro("");

            JOptionPane.showMessageDialog(this, "Registro agregado");
        }

    }//GEN-LAST:event_btnfacturarActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnfacturar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JComboBox<String> cmbmaterial;
    private javax.swing.JComboBox<String> cmbpago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbimprimir;
    private com.toedter.calendar.JDateChooser txtFechaI;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JLabel txtrequeridoC;
    private javax.swing.JLabel txtrequeridoN;
    private javax.swing.JLabel txtrequeridoV;
    private javax.swing.JLabel txtrequeridofecha;
    private javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables
 Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
