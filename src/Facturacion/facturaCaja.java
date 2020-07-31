package Facturacion;

import Conexion.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class facturaCaja extends javax.swing.JFrame implements Runnable  {
DefaultTableModel modelo ;

   
    String date;

    String fechacalendario;
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread hora1;

    public facturaCaja() {
        initComponents();
        setLocationRelativeTo(null);
        mostrardatos("");
        hora1 = new Thread (this);
        hora1.start();
                 
        
    }

    

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nombre cliente");
        modelo.addColumn("fk_idvendedor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nombre_producto");
        modelo.addColumn("cantidad");
        modelo.addColumn("Precio");

        tbFactura.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT nombre_Cliente, fk_idVendedor, Fecha, Nombre_producto, Cantidad, Precio FROM `facturas`";

        }
        String[] datos = new String[6];
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

                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbFactura.setModel(modelo); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        btnfacturar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        btnmenu = new javax.swing.JButton();
        lbhora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbFactura.setBackground(new java.awt.Color(0, 0, 0));
        tbFactura.setForeground(new java.awt.Color(0, 255, 255));
        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFactura.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 780, 260));

        btnfacturar.setText("Facturar");
        btnfacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturarActionPerformed(evt);
            }
        });
        jPanel1.add(btnfacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 370, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("CAJA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monto");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cliente");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        jPanel2.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, -1));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Factura");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descuento");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));
        jPanel2.add(txtdescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 290, 680));

        btnmenu.setText("Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        lbhora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbhora.setText("jLabel1");
        jPanel1.add(lbhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturarActionPerformed
 int filaselect = tbFactura.getSelectedRow();
        if (filaselect >= 0) {
            txtnombre.setText(tbFactura.getValueAt(filaselect, 0).toString());
            txtMonto.setText(tbFactura.getValueAt(filaselect, 5).toString());
           
            
            modelo.removeRow(filaselect);  
        }else{
            JOptionPane.showMessageDialog(this, "Fila no seleccionada");
        
        }

    }//GEN-LAST:event_btnfacturarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int monto = Integer.parseInt(txtMonto.getText());
        int porciento= Integer.parseInt(txtdescuento.getText());
        double iva = monto * 0.13;
        double descuento = monto * porciento;
        int cargos=0;
        double total=monto+iva-descuento;

        JOptionPane.showMessageDialog(null, "ALMACEN-------------"
                + "\nCEDULA: 3-029-321847"
                + "\n100 MTR OESTE PARQUE DE GUACIMO"
                + "\nTEL: 23956584"
                + "\n------------------------------"
                + "\n           CONTADO      "
                + "\n------------------------------"
                + "\nCLIENTE: "+ txtnombre.getText()
                + "\nFECHA: "+"30-7-2020"
                + "\n------------------------"
                + "\n------------------------"
                + "\nSUBTOTAL: "+ monto
                + "\nDESCUENTO: "+ descuento
                + "\nIVA: "+ iva
                + "\nOTROS CARGOS: "+ cargos
                + "\n--------------------------"
                + "\nTOTAL: "+total
                + "\n--------------------------"
                + "\nNO SE ACEPTAN DEVOLUCIONES DE NINGUN TIPO"
                + "\nLUEGO DE 8 DIAS DE EMITIDA LA FACTUCRA."
                + "\nAUTORIZACION MEDIANTE EL OFICIO NO.04-007-97 DE"
                + "\nFECHA 30/09/1987 DE DGTD");

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
       
    }//GEN-LAST:event_btnmenuActionPerformed

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
            java.util.logging.Logger.getLogger(facturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturaCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnfacturar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbhora;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
  Conexión cc = new Conexión();
    Connection cn = cc.conexion();
    //Reloj
    public void run() {
        Thread control = Thread.currentThread();
        while (control==hora1){
        calcula();
        lbhora.setText(hora+":"+minutos+":"+segundos+" "+ampm);
        
            try{
                Thread.sleep(1000);
                
            }catch(InterruptedException e){
                
            }
            
        }
    }
    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fecha = new Date();
        
        calendario.setTime(fecha);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM":"PM";
        
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            hora = h > 9? " " + h :"0" + h;
            
        }else{
            hora=calendario.get(Calendar.HOUR_OF_DAY) > 9? " "
                    +calendario.get(Calendar.HOUR_OF_DAY) :"0"
                    +calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) >9? " "
                +calendario.get(Calendar.MINUTE):"0"
                +calendario.get(Calendar.MINUTE);
        
        segundos = calendario.get(Calendar.SECOND) >9? " "
                +calendario.get(Calendar.SECOND):"0"
                +calendario.get(Calendar.SECOND);
    }
}
