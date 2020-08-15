package Facturacion;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Materiales extends javax.swing.JFrame {

    public Materiales() {
        initComponents();
        setLocationRelativeTo(null);
        mostrardatos("");
        txtcod.setVisible(false);
        txtprod.setVisible(false);
        txtprecio.setVisible(false);
    }
    
     void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id_Productos");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");

        tbmateriales.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Id_producto, Nombre_producto, Precio_Unitario, Cantidad FROM `materiales`";

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

                modelo.addRow(datos);
            }
            tbmateriales.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmateriales = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtprecio = new javax.swing.JTextField();
        txtprod = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Lista de materiales:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        tbmateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_Producto", "Descripcion", "Precio_Unitario"
            }
        ));
        tbmateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbmaterialesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbmateriales);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 610, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 641, 480));

        txtprecio.setEditable(false);
        getContentPane().add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 60, -1));

        txtprod.setEditable(false);
        getContentPane().add(txtprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 60, -1));

        txtcod.setEditable(false);
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       factura.txtcodp.setText(txtcod.getText());
       factura.txtprodp.setText(txtprod.getText());
       factura.txtpreciop.setText(txtprecio.getText());
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbmaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmaterialesMouseClicked
        int seleccionar = tbmateriales.rowAtPoint(evt.getPoint());
        txtcod.setText(String.valueOf(tbmateriales.getValueAt(seleccionar,0)));
        txtprod.setText(String.valueOf(tbmateriales.getValueAt(seleccionar,1)));
        txtprecio.setText(String.valueOf(tbmateriales.getValueAt(seleccionar,2)));
        txtcod.setVisible(false);
        txtprod.setVisible(false);
        txtprecio.setVisible(false);
    }//GEN-LAST:event_tbmaterialesMouseClicked

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
            java.util.logging.Logger.getLogger(Materiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Materiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Materiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Materiales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Materiales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbmateriales;
    public javax.swing.JTextField txtcod;
    public javax.swing.JTextField txtprecio;
    public javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables
   Conexión cc = new Conexión();
   Connection cn = cc.conexion();
}
