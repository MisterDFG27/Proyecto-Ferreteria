package Login;

import Menu.Menu_Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    int timer;

    public Login() {
        initComponents();
          ImageIcon icono = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Proyecto-Ferreteria\\src\\Imagenes\\ferre1.png");
        lblogo1.setIcon(icono);

        setLocationRelativeTo(null);
       
    }

    void acceder(String usuario, String clave) {
        String cap = "", nom = "", ape = "";
        String sql = "SELECT * FROM usuarios WHERE nombreUsuario='" + usuario + "' && Contraseña='" + clave + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("tipo_Usuario");
                nom = rs.getString("Nombre");
                ape = rs.getString("primerApellido");
            }
            if (cap.equals("Administrador")) {
                Menu.Menu_Principal m = new Menu.Menu_Principal();
                m.setVisible(true);
                dispose();

                m.txtusuario.setText(nom+" "+ape);

                
            } else if (cap.equals("Empleado")) {
                Menu.Menu_Empleado m = new Menu.Menu_Empleado();
                m.setVisible(true);
                dispose();
  
                m.txtusuario.setText(nom+" "+ape);

              
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblogo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Usuario");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(470, 170, 100, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Contraseña");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(450, 280, 130, 28);
        jPanel2.add(PwClave);
        PwClave.setBounds(440, 320, 150, 30);
        jPanel2.add(txtusuario);
        txtusuario.setBounds(440, 210, 150, 30);

        btnrecuperar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrecuperar.setText("Recuperación de contraseña");
        btnrecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrecuperarMouseClicked(evt);
            }
        });
        jPanel2.add(btnrecuperar);
        btnrecuperar.setBounds(560, 490, 172, 17);

        btnIngresar.setBackground(new java.awt.Color(0, 0, 0));
        btnIngresar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar);
        btnIngresar.setBounds(290, 410, 140, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/{07B9E67E-F201-4068-8F87-079C3C29812D}.png.jpg"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(500, 0, 220, 110);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profile.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(490, 110, 60, 50);

        lblogo1.setBackground(new java.awt.Color(255, 204, 153));
        lblogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ferre1.png"))); // NOI18N
        lblogo1.setText("Fondo1");
        lblogo1.setPreferredSize(new java.awt.Dimension(1600, 1568));
        jPanel2.add(lblogo1);
        lblogo1.setBounds(-80, 0, 820, 520);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 530));

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
                conect = DriverManager.getConnection("jdbc:mysql://localhost/ferreteriabd", "root", "");

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblogo1;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    conectar cc = new conectar();
    Connection cn = cc.conexion();
}
