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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JFrame {

    int cont, opcion = 0;

    public Inventario() {
        initComponents();
        setLocationRelativeTo(null);
        mostrardatos("");

    }
    //Mostrar tabla

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id_Inventario");
        modelo.addColumn("Alambre");
        modelo.addColumn("Varilla");
        modelo.addColumn("Anticorrosivo");
        modelo.addColumn("Arenafina");
        modelo.addColumn("Zinc");
        modelo.addColumn("Aguarras");
        modelo.addColumn("Discometabo");
        modelo.addColumn("Block");
        modelo.addColumn("Varillagrafilada");
        modelo.addColumn("Tubogalvanizado");
        modelo.addColumn("Palaclasica");
        modelo.addColumn("Brocha");
        modelo.addColumn("Cemento");
        modelo.addColumn("Grasaamarilla");
        modelo.addColumn("Brocaconcreto");
        modelo.addColumn("Perfilgalvanizado");
        modelo.addColumn("Inodoroblanco");
        modelo.addColumn("Tornillostecho");
        modelo.addColumn("Soldadura");
        modelo.addColumn("Marguerareforzadora");
        

        tbreporte.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = " SELECT * FROM `inventario` ";

        }
        String[] datos = new String[21];
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);
                datos[13] = rs.getString(14);
                datos[14] = rs.getString(15);
                datos[15] = rs.getString(16);
                datos[16] = rs.getString(17);
                datos[17] = rs.getString(18);
                datos[18] = rs.getString(19);
                datos[19] = rs.getString(20);
                datos[20] = rs.getString(21);

                modelo.addRow(datos);
            }
            tbreporte.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void limpiar() {
        txtAguarras.setText("");
        txtAnticorrosivo.setText("");
        txtArena.setText("");
        txtBlock.setText("");
        txtBroca.setText("");
        txtBrocha.setText("");
        txtCemento.setText("");
        txtDiscometabo.setText("");
        txtGrasa.setText("");
        txtInodoro.setText("");
        txtInventario.setText("");
        txtManguera.setText("");
        txtPala.setText("");
        txtPerfil.setText("");
        txtTornillos.setText("");
        txtTubo.setText("");
        txtVarilla.setText("");
        txtVarillaGra.setText("");
        txtZinc.setText("");
        txtSoldadura.setText("");
        txtAlambre.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtInventario = new javax.swing.JTextField();
        txtArena = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbreporte = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtZinc = new javax.swing.JTextField();
        txtDiscometabo = new javax.swing.JTextField();
        txtVarilla = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBlock = new javax.swing.JTextField();
        txtTubo = new javax.swing.JTextField();
        txtAguarras = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPala = new javax.swing.JTextField();
        txtBrocha = new javax.swing.JTextField();
        txtGrasa = new javax.swing.JTextField();
        txtVarillaGra = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBroca = new javax.swing.JTextField();
        txtPerfil = new javax.swing.JTextField();
        txtTornillos = new javax.swing.JTextField();
        txtCemento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblal = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtSoldadura = new javax.swing.JTextField();
        txtManguera = new javax.swing.JTextField();
        txtAnticorrosivo = new javax.swing.JTextField();
        txtInodoro = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtAlambre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btMenu.setText("Menu");
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 584, 111, 33));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 155, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Modificacion de productos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 120, 220, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("VarillaGrafilada");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 100, 44));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Zinc");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 90, 44));

        txtInventario.setEditable(false);
        jPanel1.add(txtInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 60, 44));
        jPanel1.add(txtArena, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 60, 44));

        tbreporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbreporte);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1530, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Varilla:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 90, 44));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Arenafina");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 90, 44));
        jPanel1.add(txtZinc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 60, 44));
        jPanel1.add(txtDiscometabo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 60, 44));
        jPanel1.add(txtVarilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 60, 44));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("ID inventario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 183, 100, 44));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("TuboGalvanizado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 120, 44));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Discometabo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 100, 44));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Block");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 100, 44));
        jPanel1.add(txtBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 60, 44));
        jPanel1.add(txtTubo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 60, 44));
        jPanel1.add(txtAguarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 60, 44));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Pala");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 100, 44));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Brocha");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 100, 44));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("TornillosTecho");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, 100, 44));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Aguarras");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 100, 44));
        jPanel1.add(txtPala, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 60, 44));
        jPanel1.add(txtBrocha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 60, 44));
        jPanel1.add(txtGrasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 60, 44));
        jPanel1.add(txtVarillaGra, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 60, 44));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("BrochaConcreto");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 100, 44));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Perfil");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 100, 44));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Cemento");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 100, 44));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Grasa");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 100, 44));
        jPanel1.add(txtBroca, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 60, 44));
        jPanel1.add(txtPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 60, 44));
        jPanel1.add(txtTornillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 180, 60, 44));
        jPanel1.add(txtCemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 60, 44));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Soldadura");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 100, 44));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Manguera");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 100, 44));

        lblal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblal.setText("Alambre");
        jPanel1.add(lblal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 340, 90, 44));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Inodoro");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 100, 44));
        jPanel1.add(txtSoldadura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 230, 60, 44));
        jPanel1.add(txtManguera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 60, 44));

        txtAnticorrosivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnticorrosivoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAnticorrosivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 60, 44));
        jPanel1.add(txtInodoro, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 60, 44));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, -1));

        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Anticorrosivo");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, 100, 44));

        txtAlambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlambreActionPerformed(evt);
            }
        });
        jPanel1.add(txtAlambre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 340, 60, 44));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        this.setVisible(false);
        Menu_Principal obj = new Menu_Principal();
        obj.setVisible(true);
    }//GEN-LAST:event_btMenuActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed

        int fila = tbreporte.getSelectedRow();
        if (fila >= 0) {

            txtInventario.setText(tbreporte.getValueAt(fila, 0).toString());
            txtAlambre.setText(tbreporte.getValueAt(fila, 1).toString());
            txtVarilla.setText(tbreporte.getValueAt(fila, 2).toString());
            txtAnticorrosivo.setText(tbreporte.getValueAt(fila, 3).toString());
            txtArena.setText(tbreporte.getValueAt(fila, 4).toString());
            txtZinc.setText(tbreporte.getValueAt(fila, 5).toString());
            txtAguarras.setText(tbreporte.getValueAt(fila, 6).toString());
            txtDiscometabo.setText(tbreporte.getValueAt(fila, 7).toString());;
            txtBlock.setText(tbreporte.getValueAt(fila, 8).toString());
            txtVarillaGra.setText(tbreporte.getValueAt(fila, 9).toString());
            txtTubo.setText(tbreporte.getValueAt(fila, 10).toString());
            txtPala.setText(tbreporte.getValueAt(fila, 11).toString());
            txtBrocha.setText(tbreporte.getValueAt(fila, 12).toString());
            txtCemento.setText(tbreporte.getValueAt(fila, 13).toString());
            txtGrasa.setText(tbreporte.getValueAt(fila, 14).toString());
            txtBroca.setText(tbreporte.getValueAt(fila, 15).toString());
            txtPerfil.setText(tbreporte.getValueAt(fila, 16).toString());
            txtInodoro.setText(tbreporte.getValueAt(fila, 17).toString());
            txtTornillos.setText(tbreporte.getValueAt(fila, 18).toString());
            txtSoldadura.setText(tbreporte.getValueAt(fila, 19).toString());
            txtManguera.setText(tbreporte.getValueAt(fila, 20).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Favor seleccionar la fila de articulos de abajo");
        }
    }//GEN-LAST:event_btConsultarActionPerformed

    private void txtAnticorrosivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnticorrosivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnticorrosivoActionPerformed

    private void txtAlambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlambreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlambreActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        try {
            
            PreparedStatement pps = cn.prepareStatement("UPDATE inventario SET Alambre='" + txtAlambre.getText() + "',Varilla='" + txtVarilla.getText() + "',Anticorrosivo='" + txtAnticorrosivo.getText()
                    + "',Arenafina='" + txtArena.getText() + "',Zinc='" + txtZinc.getText() + "',Aguarras='" + txtAguarras.getText() + "',Discometabo='" + txtDiscometabo.getText() + "',Block='" + txtBlock.getText()
                    + "',Varillagrafilada='" + txtVarillaGra.getText() + "',Tubogalvanizado='" + txtTubo.getText() + "',Palaclasica='" + txtPala.getText() + "',Brocha='" + txtBrocha.getText() + "',Cemento='" + txtCemento.getText()
                    + "',Grasaamarilla='" + txtGrasa.getText() + "',Brocaconcreto='" + txtBroca.getText() + "',Perfilgalvanizado='" + txtPerfil.getText() + "',Inodoroblanco='" + txtInodoro.getText()
                    + "',Tornillostecho='" + txtTornillos.getText() + "',Soldadura='" + txtSoldadura.getText() + "',Manguerareforzadora='" + txtManguera.getText() + "' WHERE id_Inventario='" + txtInventario.getText() + "'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inventario actualizado.");
            limpiar();
            mostrardatos("");

        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btModificarActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btMenu;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblal;
    private javax.swing.JTable tbreporte;
    private javax.swing.JTextField txtAguarras;
    private javax.swing.JTextField txtAlambre;
    private javax.swing.JTextField txtAnticorrosivo;
    private javax.swing.JTextField txtArena;
    private javax.swing.JTextField txtBlock;
    private javax.swing.JTextField txtBroca;
    private javax.swing.JTextField txtBrocha;
    private javax.swing.JTextField txtCemento;
    private javax.swing.JTextField txtDiscometabo;
    private javax.swing.JTextField txtGrasa;
    private javax.swing.JTextField txtInodoro;
    private javax.swing.JTextField txtInventario;
    private javax.swing.JTextField txtManguera;
    private javax.swing.JTextField txtPala;
    private javax.swing.JTextField txtPerfil;
    private javax.swing.JTextField txtSoldadura;
    private javax.swing.JTextField txtTornillos;
    private javax.swing.JTextField txtTubo;
    private javax.swing.JTextField txtVarilla;
    private javax.swing.JTextField txtVarillaGra;
    private javax.swing.JTextField txtZinc;
    // End of variables declaration//GEN-END:variables
Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
