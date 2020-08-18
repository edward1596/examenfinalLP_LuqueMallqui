/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;
import config.bd.ConectaBd;
import interfaces.CRUD1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO implements CRUD1{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Proveedor e = new Proveedor();
    
    @Override
    public List listarProveedor() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String consulta = " select *  "
                        + "from Proveedor ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
               proveedor.setIdproveedor(rs.getInt("idproveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                    proveedor.setRuc(rs.getString("Ruc"));
                proveedor.setDireccion(rs.getString("Direccion"));
                proveedor.setEstado(rs.getString("estado"));
                proveedores.add(proveedor);
            }            
        } catch (SQLException e) {
            System.out.println("Error durante el select");
        }
        return proveedores;
    }

    @Override
    public Proveedor buscarProveedor(int idproveedor) {
        String consulta = " select *  "
                        + "from proveedor  "
                        + "where idproveedor = " + idproveedor + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdproveedor(rs.getInt("idproveedor"));
               
                e.setNombre(rs.getString("nombre"));
                e.setRuc(rs.getString("ruc"));
                e.setDireccion(rs.getString("Direccion"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error durante el select");        
        }
        return e;
    }

    @Override
    public boolean agregarProveedor(Proveedor proveedor) {
        String consulta = " insert into proveedor( nombre, ruc, direccion, estado)  "
                        + " values(  "
                       
                        + "'"+ proveedor.getNombre() +"',  "
                        + "'"+ proveedor.getRuc() +"',  "
                        + "'"+ proveedor.getDireccion() +"',  "
                        + "'"+ proveedor.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la insert del nuevo proveedor");
            return true;
        }
        return false;
    }

    @Override
    public boolean editarProveedor(Proveedor proveedor) {
        String consulta = " update producto  "
                        + " set  "
                        + " nombre = '"+ proveedor.getNombre() +"', "
                        + " ruck = '"+ proveedor.getRuc() +"', "
                        + " direccion = '"+ proveedor.getDireccion() +"', "
                        + " estado = '"+ proveedor.getEstado() +"'  "
                        + " where "
                        + " idproveedor = " + proveedor.getIdproveedor() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del proveedor");
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarProveedor(int idproveedor) {
        String consulta = " delete  "
                        + " from proveedor  "
                        + " where "
                        + " idproveedor = " + idproveedor;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del proveedor");
            return true;
        }
        return false;
    }    
}