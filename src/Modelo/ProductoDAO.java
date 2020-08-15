
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion.Conexión acceso = new Conexion.Conexión();
    Producto pro = new Producto();
    
   public int actualizarStock(int cant, int idp){
       String sql="update materiales set Cantidad=? where Id_producto=?";
       try {
           con=acceso.conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, cant);
           ps.setInt(2, idp);
           ps.executeUpdate();
       } catch (Exception e) {
       }
       return r;
   }
    public Producto listarID(int id){
        Producto p=new Producto();
        String sql="select * from materiales where Id_producto=?";
        try {
            con=acceso.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setProd(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setCant(rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return p;
    }
   
    //*************MANTENIMIENTO CRUD**************
    public List listarProducto() {
        String sql = "select * from materiales";
        List<Producto> listaprod = new ArrayList<>();
        try {
            con = acceso.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setProd(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setCant(rs.getInt(4));
                listaprod.add(p);
            }
        } catch (Exception e) {
        }
        return listaprod;
    }

    public int agregar(Producto p) {
        String sql = "insert into materiales(Nombre_producto,Precio_Unitario,Cantidad)values(?,?,?)";
        try {
            con = acceso.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getProd());
            ps.setDouble(2, p.getPre());
            ps.setInt(3, p.getCant());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

//    public int actualizarStock(int cant, int id) {
//        String sql = "update producto set Stock=? where IdProducto=?";
//        try {
//            con = acceso.Conectar();
//            ps = con.prepareStatement(sql);          
//            ps.setInt(1, cant);           
//            ps.setInt(2, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//        return r;
//    }
    public int actualizar(Producto p) {
        String sql = "update materiales set Nombre_producto=?,Precio_Unitario=?,Cantidad=? where Id_producto=?";
        try {
            con = acceso.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getProd());
            ps.setDouble(2, p.getPre());
            ps.setInt(3, p.getCant());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int delete(int id) {
        String sql = "delete from materiales where Id_producto=?";
        try {
            con = acceso.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
