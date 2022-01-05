package reto2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Defino la clase principal del programa
 *
 * @author andresruedalibre
 */
public class Reto2 {

    /**
     * Este método recibe el input de entrada de usuario
     *
     * @author andresruedalibre
     */
    public static void main(String[] args) {

        BaseDatosProductos listaProductos = new BaseDatosProductos();

        Scanner sc = new Scanner(System.in);
        String operacion = sc.nextLine();
        String[] input = sc.nextLine().split(" ");

        Producto producto = new Producto(Integer.parseInt(input[0]),
                input[1],
                Double.parseDouble(input[2]),
                Integer.parseInt(input[3]));

        if ("AGREGAR".equals(operacion) && !listaProductos.verificarExistencia(producto)) {
            listaProductos.agregar(producto);
            listaProductos.generarInforme();

        } else if ("BORRAR".equals(operacion) && listaProductos.verificarExistencia(producto)) {
            listaProductos.borrar(producto);
            listaProductos.generarInforme();

        } else if ("ACTUALIZAR".equals(operacion) && listaProductos.verificarExistencia(producto)) {
            listaProductos.actualizar(producto);
            listaProductos.generarInforme();

        } else {
            System.out.println("ERROR");
        }
    }
}

/**
 * Esta clase determina la estructura general de la base de datos que contiene
 * los productos. La llave tendrá un valor entero y el producto se reutiliza de
 * la clase creada más abajo. Implementamos Map para la construcción de la tabla
 * de productos y luego se llama Hashmap que llamar la llave con valor único
 * para la lista de productos. Luego debo crear la tabla de de productos con
 * base los 4 valores predeterminados por los requerimientos de la tienda.
 *
 * @author andresruedalibre
 */
class BaseDatosProductos {

    /**
     * Creo el Map que contiene la lista de productos
     *
     * @author andresruedalibre
     */
    private Map<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    /**
     * Aquí va la tabla de productos como tal.
     *
     * @author andresruedalibre
     */
    public BaseDatosProductos() {

        listaProductos.put(1, new Producto(1, "Mango", 7000.0, 99));
        listaProductos.put(2, new Producto(2, "Limones", 3600.0, 95));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 85));
        listaProductos.put(4, new Producto(4, "Arandanos", 8300.0, 74));
        listaProductos.put(5, new Producto(5, "Tomates", 8100.0, 44));
        listaProductos.put(6, new Producto(6, "Fresas", 7100.0, 99));
        listaProductos.put(7, new Producto(7, "Helado", 4400.0, 98));
        listaProductos.put(8, new Producto(8, "Galletas", 400.0, 99));
        listaProductos.put(9, new Producto(9, "Chocolates", 4500.0, 90));
        listaProductos.put(10, new Producto(10, "Jamon", 17000.0, 89));

    }

    /**
     * Ahora procedo a crear los métodos para generar las acciones sobre la
     * lista de productos En los casos de agregar, borrar y actualizar no
     * necesito retornar nada, entonces puedo dejar el método vacío
     *
     * @author andresruedalibre
     */
    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    /**
     * @author andresruedalibre
     */
    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }

    /**
     * @author andresruedalibre
     */
    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);
    }

    /**
     * En el caso de la verificación, necesito emplear un método booleano que me
     * retorne si un producto ya está creado en la lista de productos
     *
     * @author andresruedalibre
     */
    public boolean verificarExistencia(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());
    }

    /**
     * Con este método calculo la totalidad del inventario al iterar sobre los
     * valores de la lista de productos
     *
     * @author andresruedalibre
     */
    public double totalInventario() {

        double total = 0;

        /**
         * Aquí comienzo a iterar sobre la lista de productos para obtener cada
         * valor o leerlo cuando lo necesite
         *
         * @author andresruedalibre
         */
        for (Producto producto : listaProductos.values()) {
            total += producto.getPrecio() * producto.getInventario();
        }
        return total;
    }

    /**
     * Establezco las condiciones para arrojar por pantalla al valor del
     * producto con el precio mayor
     *
     * @author andresruedalibre
     */
    public String productoPrecioMayor() {
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();
        /**
         * @author andresruedalibre
         */
        for (Producto producto : listaProductos.values()) {
            if (producto.getPrecio() > precio) {
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }

    /**
     * Establezco las condiciones para arrojar por pantalla al valor del
     * producto con el precio menor
     *
     * @author andresruedalibre
     */
    public String productoPrecioMenor() {
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();

        /**
         * @author andresruedalibre
         */
        for (Producto producto : listaProductos.values()) {
            if (producto.getPrecio() < precio) {
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }

    /**
     * Establezco las condiciones para arrojar por pantalla al valor del
     * producto con el promdio de precios
     *
     * @author andresruedalibre
     */
    public Double promedioPrecios() {
        double suma = 0;
        /**
         * @author andresruedalibre
         */
        for (Producto producto : listaProductos.values()) {
            suma += producto.getPrecio();
        }
        return suma / (listaProductos.size());

    }

    /**
     * Genero el informe indicando el número de decimales requeridos por el
     * sistema
     *
     * @author andresruedalibre
     */
    public void generarInforme() {
        System.out.println(productoPrecioMayor() + " " + productoPrecioMenor() + " " + String.format("%.1f", promedioPrecios()) + " " + String.format("%.1f", totalInventario()));
    }

}

/**
 * Creo la clase Producto que contiene las variables de llave y sus
 * correspondientes valores
 *
 * @author andresruedalibre
 */
class Producto {

    /**
     * codigo del producto, valor autoincrementable que depende del valor del
     * atributo de clase o estático cantidadProductos
     */
    private int codigo;

    /**
     * Nombre del producto
     */
    private String nombre;

    /**
     * Precio del producto
     */
    private double precio;

    /**
     * Cantidad del producto en el inventario
     */
    private int inventario;

    /**
     * Instancio los argumentos de producto
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param inventario
     */
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    /**
     * Metodo get
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo set
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo get
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set
     *
     * @return
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo set
     *
     * @return
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo get
     *
     * @return
     */
    public int getInventario() {
        return inventario;
    }

    /**
     * Metodo set
     *
     * @return
     */
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

}
