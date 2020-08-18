package interfaces;

import java.util.List;
import modelo.Producto;


public interface CRUD {
     public List listarProducto();
    public Producto buscarProducto(int idProducto);
    public boolean agregarProducto(Producto Producto);
    public boolean editarProducto(Producto Producto);
    public boolean eliminarProducto(int idProducto);
    
  
}
