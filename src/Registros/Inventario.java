package Registros;

import Conexion.Conexión;
import Menu.Menu_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        modelo.addColumn("idinventario");
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
    ;
        
        

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantIngr = new javax.swing.JTextField();
        txtCantTotalIngr = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbreporte = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCantTotalIngr1 = new javax.swing.JTextField();
        txtCantTotalIngr2 = new javax.swing.JTextField();
        txtCantTotalIngr3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCantTotalIngr4 = new javax.swing.JTextField();
        txtCantTotalIngr5 = new javax.swing.JTextField();
        txtCantTotalIngr6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCantTotalIngr7 = new javax.swing.JTextField();
        txtCantTotalIngr8 = new javax.swing.JTextField();
        txtCantTotalIngr9 = new javax.swing.JTextField();
        txtCantTotalIngr10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCantTotalIngr11 = new javax.swing.JTextField();
        txtCantTotalIngr12 = new javax.swing.JTextField();
        txtCantTotalIngr13 = new javax.swing.JTextField();
        txtCantTotalIngr14 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCantTotalIngr15 = new javax.swing.JTextField();
        txtCantTotalIngr16 = new javax.swing.JTextField();
        txtCantTotalIngr17 = new javax.swing.JTextField();
        txtCantTotalIngr18 = new javax.swing.JTextField();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 43, 155, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Modificacion de productos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 120, 220, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("VarillaGrafilada");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 100, 44));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Zinc");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 90, 44));
        jPanel1.add(txtCantIngr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 60, 44));
        jPanel1.add(txtCantTotalIngr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 60, 44));

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
        jPanel1.add(txtCantTotalIngr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 60, 44));
        jPanel1.add(txtCantTotalIngr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 60, 44));
        jPanel1.add(txtCantTotalIngr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 60, 44));

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
        jPanel1.add(txtCantTotalIngr4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 60, 44));
        jPanel1.add(txtCantTotalIngr5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 60, 44));
        jPanel1.add(txtCantTotalIngr6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 60, 44));

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
        jPanel1.add(txtCantTotalIngr7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 60, 44));
        jPanel1.add(txtCantTotalIngr8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 60, 44));
        jPanel1.add(txtCantTotalIngr9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 60, 44));
        jPanel1.add(txtCantTotalIngr10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 60, 44));

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
        jPanel1.add(txtCantTotalIngr11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 60, 44));
        jPanel1.add(txtCantTotalIngr12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 60, 44));
        jPanel1.add(txtCantTotalIngr13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 180, 60, 44));
        jPanel1.add(txtCantTotalIngr14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 60, 44));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Soldadura");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 100, 44));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Manguera");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 100, 44));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Anticorrosivo");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, 100, 44));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Inodoro");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 100, 44));
        jPanel1.add(txtCantTotalIngr15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 230, 60, 44));
        jPanel1.add(txtCantTotalIngr16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 60, 44));
        jPanel1.add(txtCantTotalIngr17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 60, 44));
        jPanel1.add(txtCantTotalIngr18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 60, 44));

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
    private javax.swing.JButton btMenu;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbreporte;
    private javax.swing.JTextField txtCantIngr;
    private javax.swing.JTextField txtCantTotalIngr;
    private javax.swing.JTextField txtCantTotalIngr1;
    private javax.swing.JTextField txtCantTotalIngr10;
    private javax.swing.JTextField txtCantTotalIngr11;
    private javax.swing.JTextField txtCantTotalIngr12;
    private javax.swing.JTextField txtCantTotalIngr13;
    private javax.swing.JTextField txtCantTotalIngr14;
    private javax.swing.JTextField txtCantTotalIngr15;
    private javax.swing.JTextField txtCantTotalIngr16;
    private javax.swing.JTextField txtCantTotalIngr17;
    private javax.swing.JTextField txtCantTotalIngr18;
    private javax.swing.JTextField txtCantTotalIngr2;
    private javax.swing.JTextField txtCantTotalIngr3;
    private javax.swing.JTextField txtCantTotalIngr4;
    private javax.swing.JTextField txtCantTotalIngr5;
    private javax.swing.JTextField txtCantTotalIngr6;
    private javax.swing.JTextField txtCantTotalIngr7;
    private javax.swing.JTextField txtCantTotalIngr8;
    private javax.swing.JTextField txtCantTotalIngr9;
    // End of variables declaration//GEN-END:variables
Conexión cc = new Conexión();
    Connection cn = cc.conexion();
}
