package vistacontrol;

import java.util.List;
import modelo.Producto;
import modelo.Proveedor;
import modeloDAO.ProductoDAO;
import modeloDAO.ProveedorDAO;
import utils.Leer;

public class Index {
    public static void AgregarProducto(){
        
        String codigo;
        String nombre;
        float precio;
        int stock;
        String estado;
        System.out.println("Agregar Nuevo Producto");
        System.out.print("Código: ");
        codigo = Leer.cadena();
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Precio: ");
        precio = Leer.flotante();
        System.out.print("Stock: ");
        stock = Leer.entero();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Producto producto = new Producto(codigo, nombre, precio, stock, estado);
        ProductoDAO estudianteDAO = new ProductoDAO();
        estudianteDAO.agregarProducto(producto);
        
    }
    
    public static void EliminarProducto(){
        ListarProducto();
        System.out.print("Ingrese el ID del Estudiante a Eliminar: ");
        int id = Leer.entero();
        ProductoDAO estudianteDAO = new ProductoDAO();
        estudianteDAO.eliminarProducto(id);
    }
    
    public static void EditarProducto(){
        ListarProducto();
        System.out.print("Ingrese el ID del producto a Editar: ");
        int id = Leer.entero();
        String codigo;
        String nombre;
        float precio;
        int stock;
        String estado;
        System.out.println("Editar Estudiante");
        System.out.print("Nuevo Código: ");
        codigo = Leer.cadena();
        System.out.print("Nuevo Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Nuevo Precio: ");
        precio = Leer.flotante();
        System.out.print("Nuevo Stock: ");
        stock = Leer.entero();
        System.out.print("Nuevo Estado: ");
        estado = Leer.cadena();
        Producto producto = new Producto(id, codigo, nombre, precio, stock, estado);
        ProductoDAO estudianteDAO = new ProductoDAO();
        estudianteDAO.editarProducto(producto);
    }
    
    public static void ListarProducto(){
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> productos = productoDAO.listarProducto();
        System.out.println("ID\tCódigo\t\tNombre\t\tStock\t\tEstado");
        for (Producto producto : productos) {
            System.out.println( producto.getIdproducto()+ "\t" + 
                                producto.getCodigo()+ "\t" + 
                                producto.getNombre()+ "\t" +
                                producto.getStock()+ "\t" +
                                producto.getEstado());            
        }
        
    }
    
    public static void AgregarProveedor(){
        
        String nombre;
        String ruc;
        String direccion;      
        String estado; 
        System.out.println("Agregar Nuevo Proveedor:");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Ruc: ");
        ruc = Leer.cadena();
        System.out.print("Dirección: ");
        direccion = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Proveedor proveedor = new Proveedor(nombre, ruc, direccion, estado);
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.agregarProveedor(proveedor);
        
    }
    
    public static void EliminarProveedor(){
        ListarProveedor();
        System.out.print("Ingrese el ID del Proveedor a Eliminar: ");
        int id = Leer.entero();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.eliminarProveedor(id);
    }
    
    public static void EditarProveedor(){
        ListarProveedor();
        System.out.print("Ingrese el ID del proveedor a Editar: ");
        int id = Leer.entero();
        String nombre;
        String ruc;
        String direccion;      
        String estado; 
        System.out.println("Editar Estudiante");
        System.out.print("Nuevo Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Nuevo Ruc: ");
        ruc = Leer.cadena();
        System.out.print("Nuevo Dirección: ");
        direccion = Leer.cadena();
        System.out.print("Nuevo Estado: ");
        estado = Leer.cadena();
        Proveedor proveedor = new Proveedor(id, nombre, ruc, direccion, estado);
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.editarProveedor(proveedor);
    }
    
    public static void ListarProveedor(){
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        List<Proveedor> proveedores = proveedorDAO.listarProveedor();
        System.out.println("ID\tNombre\t\tRuc\t\tDirección\t\tEstado");
        for (Proveedor proveedor : proveedores) {
            System.out.println( proveedor.getIdproveedor()+ "\t" + 
                                proveedor.getNombre()+ "\t" + 
                                proveedor.getRuc()+ "\t" +
                                proveedor.getDireccion()+ "\t" +
                                proveedor.getEstado());            
        }
        
    }

    public static void salir(){
        System.out.println("Gracias por su visita");
    }
    
    public static void error(int tipo){
        switch(tipo){
            case 1:
                System.out.println("Opción fuera de rango");
                break;
            case 2:
                System.out.println(".....");
                break;
        }
        
    }
    
    public static void menu(){
        System.out.println("Menu Principal");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Eliminar Producto");
        System.out.println("3. Editar Producto");
        System.out.println("4. Listar Producto");
        System.out.println("5. Agregar Proveedor");
        System.out.println("6. Eliminar Proveedor");
        System.out.println("7. Editar Proveedor");
        System.out.println("8. Listar Proveedor");
        System.out.println("9. Salir");
        System.out.print("Elegir las opciones [1-9]: ");
        
    }
    
    
    public static void inicio(){
        int opcion;
        do {            
            menu();
            opcion = Leer.entero();
            switch(opcion){
                case 1:
                    AgregarProducto();
                    break;
                case 2:
                    EliminarProducto();
                    break;
                case 3:
                    EditarProducto();
                    break;
                case 4:
                    ListarProducto();
                    break;
                case 5:
                    AgregarProveedor();
                    break;
                case 6:
                    EliminarProveedor();
                    break;
                case 7:
                    EditarProveedor();
                    break;
                case 8:
                    ListarProveedor();
                    break;
                case 9:
                    salir();
                    break;
                default:
                    error(1);
            }            
        } while (opcion!=9);
    }
    
    public static void main(String[] args) {
        inicio();
    }    
}