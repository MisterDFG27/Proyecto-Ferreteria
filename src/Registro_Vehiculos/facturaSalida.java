package Registro_Vehiculos;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class facturaSalida extends javax.swing.JFrame {

    //----------------En proceso----------------//
    String date;

    String fechacalendario;

    public facturaSalida() {
        initComponents();
        setLocationRelativeTo(null);
       
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
   //     fechacalendario = dateFormat.format(txtFecha.getDate());

    }

    public void mostrarVehiculoFacturar(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Registro");
        modelo.addColumn("Placa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Entrada");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Tipo de vehículo");
        modelo.addColumn("Estado");

        tbFactura.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT id_registo, númeroPlaca, fecha, horaEntrada, fk_tipoVehiculo, horaSalida, fk_estado FROM registro "
                    + "WHERE númeroPlaca ='" + txtPlaca.getText() + "' and fecha = '" + fechacalendario + "'";

        }
        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbFactura.setVisible(true);

    }

    public void CalcularHoras() {

        int horaE = Integer.parseInt(txtHEntrada.getText());
        int horaS = Integer.parseInt(txtHSalida.getText());
        int minE = Integer.parseInt(txtMEntrada.getText());
        int minS = Integer.parseInt(txtMSalida.getText());

        int th = horaS - horaE;
        int tm = minS - minE;

        int tt = th;

        int horas1;

        int minP;

        if (tm > 0) {

            if (tt < 0 && (tm < 30)) {

                horas1 = 24 + tt;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt < 0 && (tm >= 30)) {

                horas1 = (24 + tt) + 1;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt >= 0 && (tm >= 30)) {

                tt = tt + 1;
                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);

            } else if (tt >= 0 && (tm < 30)) {

                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);
            }
        } else  {// menor a cero

            minP = horaE - horaS;

            if (tt < 0 && (minP < 30)) {

                horas1 = 24 + tt;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt < 0 && (minP >= 30)) {

                horas1 = (24 + tt) + 1;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt >= 0 && (minP >= 30)) {

                tt = tt + 1;
                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);

            } else if (tt >= 0 && (minP < 30)) {

                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);
            }

        }

    }

    public void CalcularMontoExtra() {

        String tipoVehiculo = cbVehiculos.getSelectedItem().toString();
        String tipoHorario = cbHorario.getSelectedItem().toString();

        int horas = Integer.parseInt(txtCantHoras.getText());
        int canMin = Integer.parseInt(txtCantmin.getText());

        int monto = 1000;

        int montoExtra = 0;

        int montoTotal;

        if (tipoHorario == "Diurno") {

            if (tipoVehiculo == "1") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1300 + ((horas - 2) * 600));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if ((horas > 2)) {

                    montoTotal = 1000 + ((horas - 2) * 600);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "2") {
                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1375 + ((horas - 2) * 750));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 750);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "3") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1250 + ((horas - 2) * 500));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 500);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
        } else if (tipoHorario == "Nocturno") {

            if (tipoVehiculo == "1") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1325 + ((horas - 2) * 650));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 650);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "2") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1400 + ((horas - 2) * 800));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 800);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "3") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1275 + ((horas - 2) * 550));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 550);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
        }else if(tipoHorario == "Especial"){
            
            if (tipoVehiculo == "1") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1275 + ((horas - 2) * 550));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if ((horas > 2)) {

                    montoTotal = 1000 + ((horas - 2) * 550);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "2") {
                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1325 + ((horas - 2) * 650));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 650);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "3") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1225 + ((horas - 2) * 450));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 450);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            
            
        }

    }
    
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnBuscarRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtIDRegistroBusqueda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHoraSalida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEstadoSalida = new javax.swing.JTextField();
        BtnSalidaregistro = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtHEntrada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMEntrada = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtHSalida = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtMSalida = new javax.swing.JTextField();
        txtTotHoras = new javax.swing.JTextField();
        btnCarlcularHoras = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMontoExtra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtIDregistro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnInsertarF = new javax.swing.JLabel();
        Calcular = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtTP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMTX = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMT = new javax.swing.JTextField();
        txtCantmin = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCantHoras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbHorario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbVehiculos = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        btnmenu = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 900, 110));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Desde 8 o más horas precio especial");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Liviano: 550, Pesado: 650, Motos: 450 ");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        btnBuscarRegistro.setText("Buscar");
        btnBuscarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 650, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 110, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Número de Placa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Facturación de vehículos");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Salida del vehículo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("ID registro");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));
        jPanel1.add(txtIDRegistroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Hora de Salida:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));
        jPanel1.add(txtHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 90, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Estado");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        txtEstadoSalida.setText("F");
        txtEstadoSalida.setEnabled(false);
        jPanel1.add(txtEstadoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 90, -1));

        BtnSalidaregistro.setText("Confirmar");
        BtnSalidaregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalidaregistroActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalidaregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 110, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Calcular horas a pagar");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Entrada");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));
        jPanel1.add(txtHEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 40, -1));

        jLabel22.setText(":");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 10, -1));
        jPanel1.add(txtMEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 40, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Salida");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));
        jPanel1.add(txtHSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 40, -1));

        jLabel24.setText(":");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 10, -1));
        jPanel1.add(txtMSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 40, -1));

        txtTotHoras.setEnabled(false);
        jPanel1.add(txtTotHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 110, -1));

        btnCarlcularHoras.setText("Obtener ");
        btnCarlcularHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarlcularHorasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarlcularHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 110, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total a Pagar");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 20));
        jPanel2.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 90, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Monto Extra");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));
        jPanel2.add(txtMontoExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monto");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID registro");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        jPanel2.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, -1));
        jPanel2.add(txtIDregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Factura");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        btnInsertarF.setBackground(new java.awt.Color(255, 255, 255));
        btnInsertarF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInsertarF.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarF.setText("Guardar Factura");
        btnInsertarF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarFMouseClicked(evt);
            }
        });
        jPanel2.add(btnInsertarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, 300, 570));

        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });
        jPanel1.add(Calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 620, 130, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Total a pagar");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, -1, -1));

        txtTP.setEnabled(false);
        jPanel1.add(txtTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, 100, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Montro extra");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, -1, -1));

        txtMTX.setEnabled(false);
        jPanel1.add(txtMTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 100, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Monto");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, -1, -1));

        txtMT.setEnabled(false);
        jPanel1.add(txtMT, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 100, -1));

        txtCantmin.setEnabled(false);
        txtCantmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantminActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 110, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Minutos excedidos");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, -1, -1));

        txtCantHoras.setEnabled(false);
        jPanel1.add(txtCantHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Horas a pagar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Horario");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, -1));

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diurno", "Nocturno", "Especial" }));
        jPanel1.add(cbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tipo Vehiculo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, -1, -1));

        cbVehiculos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jPanel1.add(cbVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 100, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Calcular montos ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        btnmenu.setBackground(new java.awt.Color(0, 153, 153));
        btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmenuMouseClicked(evt);
            }
        });
        btnmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(67, 81, 141));
        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Menú");
        btnmenu.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 20));

        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 90, 40));

        jLabel29.setText("Liviano");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, -1, -1));

        jLabel30.setText("Pesado");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, -1, -1));

        jLabel31.setText("Motos");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarlcularHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarlcularHorasActionPerformed

        CalcularHoras();

        int minE = Integer.parseInt(txtMEntrada.getText());
        int minS = Integer.parseInt(txtMSalida.getText());
        int horas = Integer.parseInt(txtTotHoras.getText());

        int tm = (minS - minE);

        int minP;

        if (horas > 2) {
            if ((tm < 0)) {
                minP = (minE - minS);

                txtCantmin.setText("" + minP);

                CalcularHoras();
            } else {

                txtCantmin.setText("" + tm);

                CalcularHoras();

            }
        } else {

            txtCantmin.setText("0");

        }
    }//GEN-LAST:event_btnCarlcularHorasActionPerformed

    private void BtnSalidaregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalidaregistroActionPerformed

        txtIDregistro.setText(txtIDRegistroBusqueda.getText());

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE registro SET horaSalida='" + txtHoraSalida.getText() + "',"
                + "fk_estado='" + txtEstadoSalida.getText() + "' WHERE id_registo='" + txtIDRegistroBusqueda.getText() + "'");
            pst.executeUpdate();
            mostrarVehiculoFacturar("");
            JOptionPane.showMessageDialog(this, "Seguir con la factura");

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_BtnSalidaregistroActionPerformed

    private void btnBuscarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistroActionPerformed

        mostrarVehiculoFacturar("");
    }//GEN-LAST:event_btnBuscarRegistroActionPerformed

    private void txtCantminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantminActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        CalcularMontoExtra();

        txtMonto.setText(txtMT.getText());
        txtMontoExtra.setText(txtMTX.getText());
        txtTotalPagar.setText(txtTP.getText());
    }//GEN-LAST:event_CalcularActionPerformed

    private void btnInsertarFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarFMouseClicked
      try {

            PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(monto,montoextra,montoTotal,fk_registro) VALUES (?,?,?,?)");

            pst.setString(1, txtMonto.getText());
            pst.setString(2, txtMontoExtra.getText());
            pst.setString(3, txtTotalPagar.getText());
            pst.setString(4, txtIDregistro.getText());

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
        }

        //buscar vehiculo
        txtPlaca.setText("");

        //Guardar pago
        txtMonto.setText("");
        txtMontoExtra.setText("");
        txtTotalPagar.setText("");
        txtIDregistro.setText("");

        //Salida del vehiculo
        txtIDRegistroBusqueda.setText("");
        txtHoraSalida.setText("");

        //calcular horas
        txtHEntrada.setText("");
        txtMEntrada.setText("");
        txtHSalida.setText("");
        txtMSalida.setText("");
        txtTotHoras.setText("");

        //calcular montos
        txtCantHoras.setText("");
        txtCantmin.setText("");
        txtMT.setText("");
        txtMTX.setText("");
        txtTP.setText("");

        DefaultTableModel tb = (DefaultTableModel) tbFactura.getModel();
        int a = tbFactura.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        JOptionPane.showMessageDialog(this, "Factura guardada");
    }//GEN-LAST:event_btnInsertarFMouseClicked

    private void btnmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenuMouseClicked
        dispose();
    }//GEN-LAST:event_btnmenuMouseClicked

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
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalidaregistro;
    private javax.swing.JButton Calcular;
    private javax.swing.JButton btnBuscarRegistro;
    private javax.swing.JButton btnCarlcularHoras;
    private javax.swing.JLabel btnInsertarF;
    private javax.swing.JPanel btnmenu;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox cbVehiculos;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtCantHoras;
    private javax.swing.JTextField txtCantmin;
    private javax.swing.JTextField txtEstadoSalida;
    private javax.swing.JTextField txtHEntrada;
    private javax.swing.JTextField txtHSalida;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtIDRegistroBusqueda;
    private javax.swing.JTextField txtIDregistro;
    private javax.swing.JTextField txtMEntrada;
    private javax.swing.JTextField txtMSalida;
    private javax.swing.JTextField txtMT;
    private javax.swing.JTextField txtMTX;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoExtra;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTP;
    private javax.swing.JTextField txtTotHoras;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
  datosP cc = new datosP();
    Connection cn = cc.conexion();
}
