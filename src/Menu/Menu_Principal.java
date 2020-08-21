package Menu;

import Conexion.Conexión;
import Facturacion.facturaCaja;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class Menu_Principal extends javax.swing.JFrame {

    public Menu_Principal() {
        initComponents();
         ImageIcon icono = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\note.png");
        ImageIcon icono1 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\descarga.png");
        ImageIcon icono2 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\cog.png");
        ImageIcon icono3 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\exit.png");
        ImageIcon icono4 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\ferre3.png");
        ImageIcon icono5 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Proyecto topicos\\Proyecto-Ferreteria\\src\\Imagenes\\logo1.jpg");
        lbllogo.setIcon(icono);
        lbllogo1.setIcon(icono1);
        lbllogo2.setIcon(icono2);
        lbllogo3.setIcon(icono3);
        lbllogo4.setIcon(icono4);
        lbllogo5.setIcon(icono5);
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
        lbllogo5 = new javax.swing.JLabel();
        lbllogo4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        lbllogo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        lbllogo1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        lbllogo2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        lbllogo3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Bienvenido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 240, 70));

        txtusuario.setEditable(false);
        txtusuario.setBackground(new java.awt.Color(204, 51, 0));
        txtusuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 260, 50));
        jPanel1.add(lbllogo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 220, 130));

        lbllogo4.setText("jLabel2");
        jPanel1.add(lbllogo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 880, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 340));

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 153, 153));

        jMenu1.setText("                                                                                                                             ");
        jMenuBar1.add(jMenu1);

        lbllogo.setBackground(new java.awt.Color(255, 255, 255));
        lbllogo.setBorder(null);
        lbllogo.setText("Registrar");
        lbllogo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbllogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoMouseClicked(evt);
            }
        });

        jMenuItem1.setText("Empleado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        lbllogo.add(jMenuItem1);

        jMenuItem2.setText("Inventario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        lbllogo.add(jMenuItem2);

        jMenuBar1.add(lbllogo);

        lbllogo1.setText("Facturación");
        lbllogo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbllogo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogo1MouseClicked(evt);
            }
        });
        lbllogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbllogo1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Facturar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        lbllogo1.add(jMenuItem3);

        jMenuItem4.setText("Caja");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        lbllogo1.add(jMenuItem4);

        jMenuBar1.add(lbllogo1);

        lbllogo2.setText("Reporte");
        lbllogo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbllogo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogo2MouseClicked(evt);
            }
        });
        lbllogo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbllogo2ActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Factura");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        lbllogo2.add(jMenuItem5);

        jMenuItem6.setText("Productos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        lbllogo2.add(jMenuItem6);

        jMenuBar1.add(lbllogo2);

        lbllogo3.setForeground(new java.awt.Color(255, 51, 51));
        lbllogo3.setText("Cerrar Sesión");
        lbllogo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbllogo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogo3MouseClicked(evt);
            }
        });
        jMenuBar1.add(lbllogo3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbllogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoMouseClicked


    }//GEN-LAST:event_lbllogoMouseClicked

    private void lbllogo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogo1MouseClicked

    }//GEN-LAST:event_lbllogo1MouseClicked

    private void lbllogo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogo3MouseClicked
        Login.Login m = new Login.Login();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbllogo3MouseClicked

    private void lbllogo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogo2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbllogo2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Registros.Empleados e = new Registros.Empleados();
        e.setVisible(true);
        dispose();
        e.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      Registros.Inventario e = new Registros.Inventario();  
       e.setVisible(true);
        dispose();
        e.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void lbllogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbllogo1ActionPerformed

    }//GEN-LAST:event_lbllogo1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Facturacion.factura e = new Facturacion.factura();
        e.setVisible(true);
        dispose();
        e.txtusuario.setText(txtusuario.getText());
        e.txtvendedor.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void lbllogo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbllogo2ActionPerformed
        Reporte.Productos r = new Reporte.Productos();
        r.setVisible(true);
        dispose();
        r.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_lbllogo2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Facturacion.facturaCaja f = new Facturacion.facturaCaja();
        f.setVisible(true);
        dispose();
        f.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Reporte.Factura f = new Reporte.Factura();
        f.setVisible(true);
        dispose();
        f.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       Reporte.Productos f = new Reporte.Productos();
        f.setVisible(true);
        dispose();
        f.txtusuario.setText(txtusuario.getText());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JMenu lbllogo;
    private javax.swing.JMenu lbllogo1;
    public javax.swing.JMenu lbllogo2;
    private javax.swing.JMenu lbllogo3;
    private javax.swing.JLabel lbllogo4;
    private javax.swing.JLabel lbllogo5;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
   Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
