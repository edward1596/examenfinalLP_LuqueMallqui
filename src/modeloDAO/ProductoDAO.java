package modeloDAO;

import config.bd.ConectaBd;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ProductoDAO implements CRUD{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Producto e = new Producto();
    
    @Override
    public List listarProducto() {
        ArrayList<Producto> productos = new ArrayList<>();
        String consulta = " select *  "
                        + "from Producto ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setCodigo(rs.getString("codigo"));
                    producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getString("estado"));
                productos.add(producto);
            }            
        } catch (SQLException e) {
            System.out.println("Error durante el select");
        }
        return productos;
    }

    @Override
    public Producto buscarProducto(int idproducto) {
        String consulta = " select *  "
                        + "from producto  "
                        + "where idproducto = " + idproducto + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdproducto(rs.getInt("idproducto"));
                e.setCodigo(rs.getString("codigo"));
                e.setNombre(rs.getString("nombre"));
                e.setPrecio(rs.getFloat("precio"));
                e.setStock(rs.getInt("stock"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error durante el select");        
        }
        return e;
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        String consulta = " insert into producto(codigo, nombre, precio, stock, estado)  "
                        + " values(  "
                        + "'"+ producto.getCodigo() +"', "
                        + "'"+ producto.getNombre() +"',  "
                        + "'"+ producto.getPrecio() +"',  "
                        + "'"+ producto.getStock() +"',  "
                        + "'"+ producto.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la insert del nuevo producto");
            return true;
        }
        return false;
    }

    @Override
    public boolean editarProducto(Producto producto) {
        String consulta = " update producto  "
                        + " set  "
                        + " nombre = '"+ producto.getNombre() +"', "
                        + " precio = '"+ producto.getPrecio() +"', "
                        + " stock = '"+ producto.getStock() +"', "
                        + " codigo = '"+ producto.getCodigo()+"', "
                        + " estado = '"+ producto.getEstado() +"'  "
                        + " where "
                        + " idproducto = " + producto.getIdproducto() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del producto");
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(int idproducto) {
        String consulta = " delete  "
                        + " from producto  "
                        + " where "
                        + " idproducto = " + idproducto;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del producto");
            return true;
        }
        return false;
    }    
}