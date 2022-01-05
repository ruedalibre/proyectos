package modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author desaextremo
 */
@Table("Productos")
public class Producto {

    /**
     * codigo del producto, valor autoincrementable que depende del valor del
     * atributo de clase o estático cantidadProductos
     */
    @Id
    @Column("codigo")
    private Long codigo;

    /**
     * Nombre del producto
     */
    @Column("nombre")
    private String nombre;

    /**
     * Precio del producto
     */
    @Column("precio")
    private Double precio;

    /**
     * Cantidad del producto en el inventario
     */
    @Column("inventario")
    private Long inventario;

    /**
     * Constructor que recibe todos los atributos requeridos por el producto. Se
     * utilizará cuando esta clase se use en los retos de MasterTech 2 y 3 (mas
     * no en el reto de la iterfaz)
     *
     * @param codigo codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param inventario Cantidad del producto en el inventario
     */
    private Producto(Long codigo, String nombre, Double precio, Long inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;

    }
    
    /**
     * Método de utilidad para instanciar el "agregado" Producto
     * @param codigo
     * @param nombre
     * @param precio
     * @param inventario
     * @return 
     */
    public static Producto crearProducto(Long codigo, String nombre, Double precio, Long inventario){
        return new Producto(codigo,nombre,precio,inventario);
    }
    
    /**
     * Método de utilidad para instanciar el "agregado" Producto
     * @param nombre
     * @param precio
     * @param inventario
     * @return 
     */
    public static Producto crearProducto(String nombre, Double precio, Long inventario){
        return new Producto(null,nombre,precio,inventario);
    }
    
    /**
     * Método de utilidad para instanciar el "agregado" Producto
     * @return 
     */
    public static Producto crearProducto(){
        return new Producto(null,null,null,null);
    }
    
    /**
     * Retorna el código del producto
     *
     * @return
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * Asigna el código del producto
     *
     * @param codigo Valor del código del producto
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre del producto
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actauliza el nombre del producto
     *
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el precio del producto
     *
     * @return
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Actualiza el precio del producto
     *
     * @param precio Precio del producto
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Retorna la cantidad del producto en el inventario
     *
     * @return
     */
    public Long getInventario() {
        return inventario;
    }

    /**
     * Actualiza la cantidad del producto en el inventario
     *
     * @param inventario cantidad de producto en inventario
     */
    public void setInventario(Long inventario) {
        this.inventario = inventario;
    }

    /**
     * Retorna el estado del objeto
     *
     * @return Cadena de caracteresc con los datos del objeto
     */
    @Override
    public String toString() {
        return "Código:" + codigo + "\nNombre:" + this.nombre + "\nPrecio:" + this.precio + "\nInventario:" + this.inventario;
    }

    /**
     * Se utiliza para agregar registros a la tabla de datos en la Longerfaz
     * grafica
     *
     * @return arreglo de cadenas de caracteres
     */
    public String[] registroProducto() {
        String datos[] = new String[4];

        datos[0] = String.valueOf(this.codigo);
        datos[1] = String.valueOf(this.nombre);
        datos[2] = String.valueOf(this.precio);
        datos[3] = String.valueOf(this.inventario);

        return datos;
    }
}
