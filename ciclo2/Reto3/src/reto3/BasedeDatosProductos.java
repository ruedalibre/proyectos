import java.util.HashMap;

class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;
    private static int cantidadProductos;

    public Producto() {
        cantidadProductos++;
        this.codigo = codigo;
    }
    
    public Producto(String nombre, double precio, int inventario) {
        this();
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
    

    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.precio + " " + this.inventario;
    }
    
    public String[] registroProducto(){
        String datos[] = new String[4];
        
        datos[0] = String.valueOf(this.codigo);
        datos[1] = String.valueOf(this.nombre);
        datos[2] = String.valueOf(this.precio);
        datos[3] = String.valueOf(this.inventario);
        
        return datos;
    }

}

/**
 *
 * @author desaextremo
 */
public class BasedeDatosProductos {

    private HashMap<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    public BasedeDatosProductos() {

        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }

    public HashMap<Integer, Producto> getListaProductos() {
        return listaProductos;
    }
    

    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }
    
    public void borrar(int codigoProducto) {
        listaProductos.remove(codigoProducto);
    }

    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);
    }

    public Producto productosPrecioMayor() {
        Producto producto = listaProductos.values().iterator().next();
        for (Producto p : listaProductos.values()) {
            if (p.getPrecio() > producto.getPrecio()) {
                producto = p;
            }
        }
        return producto;
    }

    public boolean verificarExistencia(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());
    }

    public void generarInforme() {
        String[] productos = new String[3];

        for (int i = 0; i < 3; i++) {
            Producto p = productosPrecioMayor();
            productos[i] = p.getNombre();
            listaProductos.remove(p.getCodigo());
        }
        System.out.println(productos[0] + " " + productos[1] + " " + productos[2]);
    }
}
