package Facturacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Proforma extends javax.swing.JFrame  {

    String hora, minuto;
    Thread hilo;
    DefaultTableModel modelo2;

    public Proforma() {
        initComponents();
        ImageIcon icono = new ImageIcon("C:\\Users\\PCUser\\Documents\\NetBeansProjects\\Proyecto-Ferreteria\\src\\Imagenes\\1.jpg");
        lbllogo.setIcon(icono);
        modelo2 = new DefaultTableModel();
        modelo2.addColumn("ID");
        modelo2.addColumn("Productos");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Cantidad");
        tbfactura.setModel(modelo2);
        Calendar calen = new GregorianCalendar();
        Date h = new Date();
        calen.setTime(h);
        hora = calen.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calen.get(Calendar.HOUR_OF_DAY) : "0" + calen.get(Calendar.HOUR_OF_DAY);
        minuto = calen.get(Calendar.MINUTE) > 9 ? "" + calen.get(Calendar.MINUTE) : "0" + calen.get(Calendar.MINUTE);
        lblhora.setText(hora + ":" + minuto);

    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        impresion1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbfactura = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lblvendedor = new javax.swing.JLabel();
        lblsubtotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        impresion1.setBackground(new java.awt.Color(255, 255, 255));
        impresion1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Cliente:");
        impresion1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        lblnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblnombre.setText("\"                            \"");
        impresion1.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("FACTURA PROFORMA");
        impresion1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel10.setText("IVA:                          13%");
        impresion1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, -1, -1));

        tbfactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbfactura);
        if (tbfactura.getColumnModel().getColumnCount() > 0) {
            tbfactura.getColumnModel().getColumn(0).setResizable(false);
            tbfactura.getColumnModel().getColumn(1).setResizable(false);
            tbfactura.getColumnModel().getColumn(2).setResizable(false);
            tbfactura.getColumnModel().getColumn(3).setResizable(false);
        }

        impresion1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 770, 200));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel12.setText("Descuento:              20%");
        impresion1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, -1, -1));

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel13.setText("Total a pagar:");
        impresion1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, -1, -1));

        lbltotal.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        lbltotal.setText("\"                   \"");
        impresion1.add(lbltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, 110, -1));
        impresion1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 840, 10));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Vendedor:");
        impresion1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        lblvendedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblvendedor.setText("\"                            \"");
        impresion1.add(lblvendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 130, -1));

        lblsubtotal.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        lblsubtotal.setText("\"                     \"");
        impresion1.add(lblsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 120, -1));

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel18.setText("Subtotal:");
        impresion1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel11.setText("Fecha:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 10, 39, 15);

        lblfecha.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        lblfecha.setText("\"              \"");
        jPanel2.add(lblfecha);
        lblfecha.setBounds(70, 10, 110, 15);

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel3.setText("Hora:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 40, 33, 15);

        lblhora.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        lblhora.setText("\"                 \"");
        jPanel2.add(lblhora);
        lblhora.setBounds(70, 40, 100, 15);

        impresion1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 190, 70));

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.jpg"))); // NOI18N
        impresion1.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 110));

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel8.setText("Ced:3101761963");
        impresion1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel14.setText("Dirección: Africa, Wakanda 50mts, norte de la torre del rey");
        impresion1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel16.setText("Telefono:(00 237)563-547");
        impresion1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel17.setText("Email: ferrewakanda@blackmail.com");
        impresion1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel19.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel19.setText("Ferreteria Wakanda");
        impresion1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(impresion1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(impresion1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel impresion1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblfecha;
    public javax.swing.JLabel lblhora;
    private javax.swing.JLabel lbllogo;
    public javax.swing.JLabel lblnombre;
    public javax.swing.JLabel lblsubtotal;
    public javax.swing.JLabel lbltotal;
    public javax.swing.JLabel lblvendedor;
    public static javax.swing.JTable tbfactura;
    // End of variables declaration//GEN-END:variables

}
