package Registros;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Locale;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Empleados extends javax.swing.JFrame {

    int cont;

    public Empleados() {
        initComponents();
         ImageIcon icono = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Proyecto-Ferreteria\\src\\Imagenes\\Empleados2.png");
        jLabel4.setIcon(icono);
        setLocationRelativeTo(null);
   

        lblRequeridoCedula.setVisible(false);
        lblRequeridoNombre.setVisible(false);
        lblRequeridoAP1.setVisible(false);
        lblRequeridoAP2.setVisible(false);
        lblRequeridoCE.setVisible(false);
        lblRequeridoUsuario.setVisible(false);

    }
    public void contra(){
        String contra ="";
        contra = UUID.randomUUID().toString().toUpperCase().substring(0,10);
        txtcontra.setText(contra);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrimerP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSegundoP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        lblRequeridoCedula = new javax.swing.JLabel();
        lblRequeridoNombre = new javax.swing.JLabel();
        lblRequeridoAP1 = new javax.swing.JLabel();
        lblRequeridoCE = new javax.swing.JLabel();
        lblRequeridoUsuario = new javax.swing.JLabel();
        lblRequeridoAP2 = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();
        chVerContra = new javax.swing.JCheckBox();
        btnmenu = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnguardar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Registro de empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        btnguardar.setBackground(new java.awt.Color(0, 0, 0));
        btnguardar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 160, 40));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 145, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Cédula");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 145, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 141, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Primer Apellido");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));
        jPanel1.add(txtPrimerP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 145, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Correo electrónico");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Segundo Apellido");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));
        jPanel1.add(txtSegundoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 145, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Datos de Usuario");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Usuario");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 110, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Contraseña");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Tipo de usuario");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        cmbTipoUsuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Empleado" }));
        jPanel1.add(cmbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 110, -1));

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Datos Personales");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        lblRequeridoCedula.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRequeridoCedula.setForeground(new java.awt.Color(204, 0, 0));
        lblRequeridoCedula.setText("Requerido");
        jPanel1.add(lblRequeridoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        lblRequeridoNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRequeridoNombre.setForeground(new java.awt.Color(204, 0, 0));
        lblRequeridoNombre.setText("Requerido");
        jPanel1.add(lblRequeridoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        lblRequeridoAP1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRequeridoAP1.setForeground(new java.awt.Color(204, 0, 0));
        lblRequeridoAP1.setText("Requerido");
        jPanel1.add(lblRequeridoAP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        lblRequeridoCE.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRequeridoCE.setForeground(new java.awt.Color(204, 0, 0));
        lblRequeridoCE.setText("Requerido");
        jPanel1.add(lblRequeridoCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, -1, -1));

        lblRequeridoUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRequeridoUsuario.setForeground(new java.awt.Color(204, 0, 0));
        lblRequeridoUsuario.setText("Requerido");
        jPanel1.add(lblRequeridoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        lblRequeridoAP2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRequeridoAP2.setForeground(new java.awt.Color(204, 0, 0));
        lblRequeridoAP2.setText("Requerido");
        jPanel1.add(lblRequeridoAP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        txtcontra.setEditable(false);
        jPanel1.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 110, -1));

        chVerContra.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chVerContra.setText("Ver contraseña");
        chVerContra.setContentAreaFilled(false);
        chVerContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chVerContraActionPerformed(evt);
            }
        });
        jPanel1.add(chVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        btnmenu.setBackground(new java.awt.Color(0, 0, 0));
        btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmenuMouseClicked(evt);
            }
        });
        btnmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(67, 81, 141));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Menú");
        btnmenu.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 20));

        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 90, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel15.setText("Bienvenido:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel16.setText("Bienvenido:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        txtusuario.setEditable(false);
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 130, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, -1));

        btnguardar1.setBackground(new java.awt.Color(0, 0, 0));
        btnguardar1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnguardar1.setText("Lista empleados");
        btnguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 160, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empleados2.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 410, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        cont = 0;

        if (txtcedula.getText().equals("")) {
            lblRequeridoCedula.setVisible(true);
            cont++;
        } else {
            lblRequeridoCedula.setVisible(false);

        }

        if (txtnombre.getText().equals("")) {
            lblRequeridoNombre.setVisible(true);
            cont++;
        } else {
            lblRequeridoNombre.setVisible(false);

        }

        if (txtPrimerP.getText().equals("")) {
            lblRequeridoAP1.setVisible(true);
            cont++;
        } else {
            lblRequeridoAP1.setVisible(false);

        }

        if (txtSegundoP.getText().equals("")) {
            lblRequeridoAP2.setVisible(true);
            cont++;
        } else {
            lblRequeridoAP2.setVisible(false);

        }

        if (txtEmail.getText().equals("")) {
            lblRequeridoCE.setVisible(true);
            cont++;
        } else {
            lblRequeridoCE.setVisible(false);

        }

        if (txtUsuario.getText().equals("")) {
            lblRequeridoUsuario.setVisible(true);
            cont++;
        } else {
            lblRequeridoUsuario.setVisible(false);

        }

        if (cont == 0) {

            try {
                Conexión cc = new Conexión();
                Connection cn = cc.conexion();

                PreparedStatement pst = cn.prepareStatement("INSERT INTO usuarios(nombreUsuario,"
                        + "contraseña,Cedula,nombre,primerApellido,segundoApellido,email,tipo_Usuario) VALUES (?,?,?,?,?,?,?,?)");
                pst.setString(1, txtUsuario.getText());
                pst.setString(2, txtcontra.getText());
                pst.setString(3, txtcedula.getText());
                pst.setString(4, txtnombre.getText());
                pst.setString(5, txtPrimerP.getText());
                pst.setString(6, txtSegundoP.getText());
                pst.setString(7, txtEmail.getText());
                pst.setString(8, (String) cmbTipoUsuario.getSelectedItem());

                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e);
            }

            txtUsuario.setText("");
            txtcontra.setText("");
            txtcedula.setText("");
            txtnombre.setText("");
            txtPrimerP.setText("");
            txtSegundoP.setText("");
            txtEmail.setText("");
            JOptionPane.showMessageDialog(this, "Guardado con exito");

        }


    }//GEN-LAST:event_btnguardarActionPerformed


    private void chVerContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chVerContraActionPerformed

        if (chVerContra.isSelected()) {
            txtcontra.setEchoChar((char) 0);
        } else {
            txtcontra.setEchoChar('*');
        }


    }//GEN-LAST:event_chVerContraActionPerformed

    private void btnmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenuMouseClicked
        Menu.Menu_Principal m = new Menu.Menu_Principal();
                m.setVisible(true);
                dispose();

                m.txtusuario.setText(txtusuario.getText());  
        
    }//GEN-LAST:event_btnmenuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       contra();
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
       Listaempleados l = new Listaempleados();
       l.setVisible(true);
    }//GEN-LAST:event_btnguardar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar1;
    private javax.swing.JPanel btnmenu;
    private javax.swing.JCheckBox chVerContra;
    private javax.swing.JComboBox cmbTipoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRequeridoAP1;
    private javax.swing.JLabel lblRequeridoAP2;
    private javax.swing.JLabel lblRequeridoCE;
    private javax.swing.JLabel lblRequeridoCedula;
    private javax.swing.JLabel lblRequeridoNombre;
    private javax.swing.JLabel lblRequeridoUsuario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPrimerP;
    private javax.swing.JTextField txtSegundoP;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
