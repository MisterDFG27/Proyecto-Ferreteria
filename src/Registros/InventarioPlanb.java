package Registros;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InventarioPlanb extends javax.swing.JFrame {

    int cont;

    public InventarioPlanb() {
        initComponents();
        setLocationRelativeTo(null);
    }

    void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Proovedor");

        tbinventario.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM `materiales`";

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
            tbinventario.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void AgregarBD() {
        cont = 0;

        if (txtnombre.getText().equals("") || txtproovedor.getText().equals("") || txtprecio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
            cont++;
        }

        if (cont == 0) {

            try {
                Conexión cc = new Conexión();
                Connection cn = cc.conexion();

                PreparedStatement pst = cn.prepareStatement("INSERT INTO materiales(Nombre_producto, Cantidad, Precio_Unitario, Proovedor) VALUES (?,?,?,?)");
                pst.setString(1, txtnombre.getText());
                pst.setString(2, txtprecio.getText());
                pst.setString(3, txtcantidad.getValue().toString());
                pst.setString(4, txtproovedor.getText());

                pst.executeUpdate();
                mostrardatos("");
                Limpiar();
            } catch (Exception e) {
                System.out.print(e);
            }
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
        }
    }

    public void eliminar() {
        String sql = "DELETE FROM `materiales` WHERE `materiales`.`Id_producto` = " + txtid.getText() + "";
        try {
            Conexión cc = new Conexión();
            Connection cn = cc.conexion();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            mostrardatos("");
            Limpiar();
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
    }
    
    void Limpiar(){
        txtid.setText("");
        txtnombre.setText("");
        txtcantidad.setValue(0);
        txtproovedor.setText("");
        txtprecio.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtproovedor = new javax.swing.JTextField();
        btMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbinventario = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtcantidad = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtcant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 190, 30));

        btMenu.setText("Menu");
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 111, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 30, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cantidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 90, 30));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 111, 44));

        jButton2.setText("Actualizar tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 120, 44));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Precio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 60, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Proovedor:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 90, 30));
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 120, 30));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 230, 30));

        tbinventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_producto", "Nombre_producto", "Cantidad", "Precio", "Proveedor"
            }
        ));
        tbinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbinventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbinventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 640, 540));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 111, 44));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 90, 30));

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 111, 44));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 90, 40));

        txtid.setEditable(false);
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtcant.setText("jTextField1");
        getContentPane().add(txtcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed

    }//GEN-LAST:event_btMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AgregarBD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrardatos("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {

            PreparedStatement pps = cn.prepareStatement("UPDATE materiales SET Nombre_producto='" + txtnombre.getText() + "',Cantidad='" + txtcantidad.getValue().toString() + "',Precio_Unitario='" + txtprecio.getText() + "',Proovedor='" + txtproovedor.getText() + "' WHERE `materiales`.`Id_producto` = " + txtid.getText() + "");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inventario actualizado.");
            mostrardatos("");
            Limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbinventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbinventarioMouseClicked
        int fila = tbinventario.getSelectedRow();
        if (fila >= 0) {
            txtid.setText(tbinventario.getValueAt(fila, 0).toString());
            txtnombre.setText(tbinventario.getValueAt(fila, 1).toString());
            txtcant.setText(tbinventario.getValueAt(fila, 2).toString());
            txtprecio.setText(tbinventario.getValueAt(fila, 3).toString());
            txtproovedor.setText(tbinventario.getValueAt(fila, 4).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Favor seleccionar un articulo");
        }
        int c = Integer.parseInt(txtcant.getText());
        txtcantidad.setValue(c);
    }//GEN-LAST:event_tbinventarioMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminar();
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
            java.util.logging.Logger.getLogger(InventarioPlanb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioPlanb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioPlanb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioPlanb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InventarioPlanb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbinventario;
    private javax.swing.JTextField txtcant;
    private javax.swing.JSpinner txtcantidad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtproovedor;
    // End of variables declaration//GEN-END:variables
 Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
