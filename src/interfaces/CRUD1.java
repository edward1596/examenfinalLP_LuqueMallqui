/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Proveedor;

public interface CRUD1 {
    
    
    public List listarProveedor();
    public Proveedor buscarProveedor(int idProveedor);
    public boolean agregarProveedor(Proveedor Proveedor);
    public boolean editarProveedor(Proveedor Proveedor);
    public boolean eliminarProveedor(int iProveedor);
    
}
