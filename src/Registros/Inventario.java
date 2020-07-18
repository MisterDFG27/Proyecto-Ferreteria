package Registros;

import Conexion.Conexión;
import Menu.Menu_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Inventario extends javax.swing.JFrame {

    int cont, opcion = 0;
    
    public Inventario() {
        initComponents();
        setLocationRelativeTo(null);
        
        txtCantTotRet.setEditable(false);
        txtCantTotalIngr.setEditable(false);
        txtCantIngr.setVisible(false);
        lblReqRet12.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbProductIngre = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCantIngr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCantTotalIngr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCantTotRet = new javax.swing.JTextField();
        lblReqRet1 = new javax.swing.JLabel();
        lblReqRet12 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblReqIng1 = new javax.swing.JLabel();

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
        jLabel2.setText("Ingreso de productos.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 120, 177, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Seleccionar producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 183, 143, 44));

        cmbProductIngre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alambre", "Varilla", "Anticorrosivo", "Arena fina", "Zinc", "Aguarras", "Disco metabo", "Block", "Varilla grafilada", "Tubo galvanizado", "Pala clásica", "Brocha", "Cemento", "Grasa amarilla", "Broca concreto", "Perfil galvanizado", "Inodoro blanco", "Tornillos techo", "Soldadura", "Manguera reforzadora" }));
        jPanel1.add(cmbProductIngre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 129, 44));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 246, 143, 44));
        jPanel1.add(txtCantIngr, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 247, 111, 44));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad total:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 345, 143, 44));
        jPanel1.add(txtCantTotalIngr, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 345, 111, 44));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Retiro de productos.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 120, 177, 51));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Seleccionar producto:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 183, 143, 44));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cantidad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 246, 143, 44));
        jPanel1.add(txtCantTotRet, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 345, 111, 44));

        lblReqRet1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReqRet1.setForeground(new java.awt.Color(0, 153, 153));
        lblReqRet1.setText("Requerido");
        jPanel1.add(lblReqRet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, -1, -1));

        lblReqRet12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblReqRet12ActionPerformed(evt);
            }
        });
        jPanel1.add(lblReqRet12, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 247, 111, 44));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad total:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 344, 143, 44));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alambre", "Varilla", "Anticorrosivo", "Arena fina", "Zinc", "Aguarras", "Disco metabo", "Block", "Varilla grafilada", "Tubo galvanizado", "Pala clásica", "Brocha", "Cemento", "Grasa amarilla", "Broca concreto", "Perfil galvanizado", "Inodoro blanco", "Tornillos techo", "Soldadura", "Manguera reforzadora" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 184, 129, 44));

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 422, 111, 44));

        jButton2.setText("Cargar");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 422, 111, 44));

        lblReqIng1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReqIng1.setForeground(new java.awt.Color(0, 153, 153));
        lblReqIng1.setText("Requerido");
        jPanel1.add(lblReqIng1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        this.setVisible(false);
        Menu_Principal obj = new Menu_Principal();
        obj.setVisible(true);
    }//GEN-LAST:event_btMenuActionPerformed

    private void lblReqRet12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReqRet12ActionPerformed

    }//GEN-LAST:event_lblReqRet12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      cont = 0;

        Conexión cc = new Conexión();
        Connection cn = cc.conexion();

        if (txtCantIngr.getText().equals("")) {
            lblReqIng1.setVisible(true);
            cont++;
        } else {
            lblReqIng1.setVisible(false);

        }
        if (cont == 0) {
            try {

                opcion = cmbProductIngre.getSelectedIndex();

                switch (opcion) {

                    case 0:

                        PreparedStatement pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, txtCantIngr.getText());
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        
                        pst.executeUpdate();
                        pst.close();
                        break;
                    case 1:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, txtCantIngr.getText());
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        pst.close();
                        break;
                    case 2:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, txtCantIngr.getText());
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;

                    case 3:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, txtCantIngr.getText());
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 4:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, txtCantIngr.getText());
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 5:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, txtCantIngr.getText());
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;

                    case 6:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, txtCantIngr.getText());
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 7:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, txtCantIngr.getText());
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 8:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, txtCantIngr.getText());
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;

                    case 9:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, txtCantIngr.getText());
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 10:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, txtCantIngr.getText());
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 11:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, txtCantIngr.getText());
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;

                    case 12:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, txtCantIngr.getText());
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 13:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, txtCantIngr.getText());
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;

                    case 14:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, txtCantIngr.getText());
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 15:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, txtCantIngr.getText());
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 16:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, txtCantIngr.getText());
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;

                    case 17:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, txtCantIngr.getText());
                        pst.setString(19, "");
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 18:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");            
                        pst.setString(19, txtCantIngr.getText());
                        pst.setString(20, "");
                        pst.executeUpdate();
                        break;
                    case 19:

                        pst = cn.prepareStatement("INSERT INTO inventario(Alambre,Varilla,Anticorrosivo,Arenafina,Zinc,Aguarras,Discometabo,Block,Varillagrafilada,Tubogalvanizado,Palaclasica,Brocha,Cemento,Grasaamarilla,Brocaconcreto,Perfilgalvanizado,Inodoroblanco,Tornillostecho,Soldadura,Marguerareforzadora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, "");
                        pst.setString(2, "");
                        pst.setString(3, "");
                        pst.setString(4, "");
                        pst.setString(5, "");
                        pst.setString(6, "");
                        pst.setString(7, "");
                        pst.setString(8, "");
                        pst.setString(9, "");
                        pst.setString(10, "");
                        pst.setString(11, "");
                        pst.setString(12, "");
                        pst.setString(13, "");
                        pst.setString(14, "");
                        pst.setString(15, "");
                        pst.setString(16, "");
                        pst.setString(17, "");
                        pst.setString(18, "");
                        pst.setString(19, "");
                        pst.setString(20, txtCantIngr.getText());
                        pst.executeUpdate();
                        break;

                }

            } catch (Exception e) {
                System.out.print(e);
            }
            txtCantIngr.setText("");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> cmbProductIngre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblReqIng1;
    private javax.swing.JLabel lblReqRet1;
    private javax.swing.JTextField lblReqRet12;
    private javax.swing.JTextField txtCantIngr;
    private javax.swing.JTextField txtCantTotRet;
    private javax.swing.JTextField txtCantTotalIngr;
    // End of variables declaration//GEN-END:variables
}
