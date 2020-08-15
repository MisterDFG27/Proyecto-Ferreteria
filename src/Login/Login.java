package Login;

import Menu.Menu_Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    int timer;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
       
    }

    void acceder(String usuario, String clave) {
        String cap = "";
        String sql = "SELECT * FROM usuarios WHERE nombreUsuario='" + usuario + "' && Contraseña='" + clave + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("fk_tipoUsuario");
            }
            if (cap.equals("1")) {
                Menu.Menu_Principal m = new Menu.Menu_Principal();
                m.setVisible(true);
                dispose();

                m.txtusuario.setText(txtusuario.getText());

                
            } else if (cap.equals("2")) {
                Menu.Menu_Empleado m = new Menu.Menu_Empleado();
                m.setVisible(true);
                dispose();
  
                m.txtusuario.setText(txtusuario.getText());

              
            } else if (timer == 2) {
                JOptionPane.showMessageDialog(null, "Ha excedido el numero de intentos.", "Por favor ingrese a 'Recuperar contraseña' para enviar su usuario y contraseña por correo", JOptionPane.OK_OPTION);
                btnIngresar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectas, intentelo nuevamente. \n Quedan " + (2 - timer) + " intentos");
                txtusuario.setText("");
                PwClave.setText("");
                timer = timer + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PwClave = new javax.swing.JPasswordField();
        txtusuario = new javax.swing.JTextField();
        btnrecuperar = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Usuario");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(200, 140, 59, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(180, 230, 88, 22);
        jPanel2.add(PwClave);
        PwClave.setBounds(160, 270, 136, 20);
        jPanel2.add(txtusuario);
        txtusuario.setBounds(160, 170, 136, 20);

        btnrecuperar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnrecuperar.setText("Recuperación de contraseña");
        btnrecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrecuperarMouseClicked(evt);
            }
        });
        jPanel2.add(btnrecuperar);
        btnrecuperar.setBounds(254, 522, 220, 22);

        btnIngresar.setBackground(new java.awt.Color(0, 0, 0));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar);
        btnIngresar.setBounds(140, 340, 179, 45);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Inicio de sesión");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(160, 70, 160, 50);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrecuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrecuperarMouseClicked
        Correo e = new Correo();
        e.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnrecuperarMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usu = txtusuario.getText();
        String cla = new String(PwClave.getPassword());
        acceder(usu, cla);

        Menu_Principal m = new Menu_Principal();
    }//GEN-LAST:event_btnIngresarActionPerformed

    public class conectar {

        Connection conect = null;

        public Connection conexion() {
            try {

                //Cargamos el Driver MySQL
                Class.forName("com.mysql.jdbc.Driver");
                conect = DriverManager.getConnection("jdbc:mysql://localhost:3308/ferreteriabd", "root", "");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
            return conect;

        }
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPasswordField PwClave;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel btnrecuperar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    conectar cc = new conectar();
    Connection cn = cc.conexion();
}
