package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexión {
    
     Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3308/ferreteriabd","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
    
}
