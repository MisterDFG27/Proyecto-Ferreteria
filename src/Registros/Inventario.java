package Registros;

import Conexion.Conexión;
import Menu.Menu_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JFrame {

    int cont;

    public Inventario() {
        initComponents();
        ImageIcon icono = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\inventario1.jpg");
        lbllogo.setIcon(icono);
         ImageIcon icono1 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\logo2.jpg");
        lbllogo1.setIcon(icono1);
        txtcant.setVisible(false);
        setLocationRelativeTo(null);
        mostrardatos("");
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

    void Limpiar() {
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
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        lbllogo1 = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 190, 30));

        btMenu.setBackground(new java.awt.Color(102, 255, 204));
        btMenu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btMenu.setText("Menu");
        btMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btMenu.setContentAreaFilled(false);
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 111, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel1.setText("Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 120, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 40, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Cantidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 110, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 111, 44));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Actualizar tabla");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 120, 44));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Precio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 80, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Proovedor:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 130, 40));
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 120, 30));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 210, 30));

        tbinventario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbinventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_producto", "Nombre_producto", "Cantidad", "Precio", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbinventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbinventario);
        if (tbinventario.getColumnModel().getColumnCount() > 0) {
            tbinventario.getColumnModel().getColumn(0).setResizable(false);
            tbinventario.getColumnModel().getColumn(1).setResizable(false);
            tbinventario.getColumnModel().getColumn(2).setResizable(false);
            tbinventario.getColumnModel().getColumn(3).setResizable(false);
            tbinventario.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 640, 560));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 111, 44));

        txtcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 90, 30));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Modificar");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 110, 44));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 100, 40));

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(255, 255, 255));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 50, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bienvenido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        txtusuario.setEditable(false);
        txtusuario.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 130, 30));
        jPanel1.add(lbllogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 210, 60));

        lbllogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbllogo.setName(""); // NOI18N
        jPanel1.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -640, 500, 1400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, 560));

        txtcant.setText("jTextField1");
        getContentPane().add(txtcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        Menu_Principal e = new Menu_Principal();
        e.setVisible(true);
        dispose();
        e.txtusuario.setText(txtusuario.getText());
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
            System.out.println(ex);
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

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbllogo1;
    private javax.swing.JTable tbinventario;
    private javax.swing.JTextField txtcant;
    private javax.swing.JSpinner txtcantidad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtproovedor;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
 Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
