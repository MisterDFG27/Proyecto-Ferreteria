package Menu;

import Conexion.Conexión;
import Facturacion.facturaCaja;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class Menu_Empleado extends javax.swing.JFrame {

    public Menu_Empleado() {
        initComponents();
        ImageIcon icono = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\descarga.png");
        ImageIcon icono1 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\exit.png");
        ImageIcon icono2 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\ferre3.png");
        ImageIcon icono3 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\logo2.jpg");
        lbllogo.setIcon(icono);
        lbllogo1.setIcon(icono1);
        lbllogo2.setIcon(icono2);
        lbllogo3.setIcon(icono3);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        lbllogo3 = new javax.swing.JLabel();
        lbllogo2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        lbllogo = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        lbllogo1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Bienvenido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 350, 70));

        txtusuario.setEditable(false);
        txtusuario.setBackground(new java.awt.Color(204, 51, 0));
        txtusuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, 50));
        jPanel1.add(lbllogo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 230, 80));

        lbllogo2.setText("jLabel2");
        jPanel1.add(lbllogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 340));

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 153, 153));

        jMenu1.setBackground(new java.awt.Color(255, 204, 102));
        jMenu1.setText("                                                                                                                                                                                               ");
        jMenuBar1.add(jMenu1);

        lbllogo.setText("Facturación   ");
        lbllogo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbllogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoMouseClicked(evt);
            }
        });
        lbllogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbllogoActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Facturar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        lbllogo.add(jMenuItem3);

        jMenuItem4.setText("Caja");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        lbllogo.add(jMenuItem4);

        jMenuBar1.add(lbllogo);

        lbllogo1.setForeground(new java.awt.Color(255, 51, 51));
        lbllogo1.setText("Cerrar Sesión");
        lbllogo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbllogo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogo1MouseClicked(evt);
            }
        });
        jMenuBar1.add(lbllogo1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbllogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoMouseClicked

    }//GEN-LAST:event_lbllogoMouseClicked

    private void lbllogo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogo1MouseClicked
        Login.Login m = new Login.Login();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbllogo1MouseClicked

    private void lbllogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbllogoActionPerformed

    }//GEN-LAST:event_lbllogoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Facturacion.factura e = new Facturacion.factura();
        e.setVisible(true);
        dispose();
        e.txtusuario.setText(txtusuario.getText());
        e.txtvendedor.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Facturacion.facturaCaja f = new Facturacion.facturaCaja();
        f.setVisible(true);
        dispose();
        f.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenu lbllogo;
    private javax.swing.JMenu lbllogo1;
    private javax.swing.JLabel lbllogo2;
    private javax.swing.JLabel lbllogo3;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
   Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
