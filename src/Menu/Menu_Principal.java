package Menu;

import Conexion.datosP;
import Facturacion.facturaCaja;
import java.sql.Connection;

public class Menu_Principal extends javax.swing.JFrame {

    public Menu_Principal() {
        initComponents();
        setLocationRelativeTo(null);
        
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        EmpleadoR = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Factura = new javax.swing.JMenu();
        Mantenimiento = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bienvenido:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, -1, -1));

        txtusuario.setEditable(false);
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 340));

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 153, 153));

        jMenu1.setText("                                                                                                                                                                          ");
        jMenuBar1.add(jMenu1);

        EmpleadoR.setBackground(new java.awt.Color(255, 255, 255));
        EmpleadoR.setBorder(null);
        EmpleadoR.setText("Registrar");
        EmpleadoR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpleadoR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadoRMouseClicked(evt);
            }
        });

        jMenuItem1.setText("Empleado");
        EmpleadoR.add(jMenuItem1);

        jMenuItem2.setText("Inventario");
        EmpleadoR.add(jMenuItem2);

        jMenuBar1.add(EmpleadoR);

        Factura.setText("Facturar");
        Factura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturaMouseClicked(evt);
            }
        });
        jMenuBar1.add(Factura);

        Mantenimiento.setText("Reporte");
        Mantenimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MantenimientoMouseClicked(evt);
            }
        });
        jMenuBar1.add(Mantenimiento);

        CerrarSesion.setForeground(new java.awt.Color(0, 153, 153));
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarSesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(CerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpleadoRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadoRMouseClicked
        Registros.Empleados m = new Registros.Empleados();
        m.setVisible(true);
   
    }//GEN-LAST:event_EmpleadoRMouseClicked

    private void FacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturaMouseClicked
        facturaCaja m = new facturaCaja();
        m.setVisible(true);
    }//GEN-LAST:event_FacturaMouseClicked

    private void CerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarSesionMouseClicked
        Login.Login m = new Login.Login();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionMouseClicked

    private void MantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MantenimientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MantenimientoMouseClicked

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
    private javax.swing.JMenu CerrarSesion;
    public javax.swing.JMenu EmpleadoR;
    private javax.swing.JMenu Factura;
    public javax.swing.JMenu Mantenimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
   datosP cc = new datosP();
    Connection cn = cc.conexion();
}
