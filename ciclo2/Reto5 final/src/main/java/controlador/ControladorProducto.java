package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Producto;
import modelo.RepositorioProducto;
import vista.Tienda;

/**
 *
 * @author andresruedalibre
 */
public class ControladorProducto implements ActionListener {

    /**
     * Nos permite interactuar con el modelo e invocar operaciones crud(leer,
     * insertar, actualizar y borrar)
     */
    private RepositorioProducto repositorio;

    /**
     * Nos permite interactuar con la clase de tipo agregfado de SPringFramework
     */
    private Producto producto;

    /**
     * Para administrar el modelo de datos de la tabla (JTable)
     */
    private DefaultTableModel modeloTabla;

    /**
     * Para tener acceso a la vista
     */
    private Tienda vista;

    /**
     * Listado de todos los productos
     */
    private List<Producto> listadoProductos;

    /**
     * Constructor por defecto sin argumentos
     */
    public ControladorProducto() {
        super();
    }

    /**
     *
     * @param repositorio recibe referencia al modelo (repositorio)
     * @param vista recibe referencia a la vista o interfaz grafica
     */
    public ControladorProducto(RepositorioProducto repositorio, Tienda vista) {
        super();
        this.repositorio = repositorio;
        this.vista = vista;
        //instancio el agregado
        producto = Producto.crearProducto();
        registrarEventos();
        armarModelo();
    }

    /**
     * Registra el oyente de los eventos de clic
     */
    public void registrarEventos() {
        vista.getBotonActualizarProducto().addActionListener(this);
        vista.getBotonAgregarProducto().addActionListener(this);
        vista.getBotonBorrarProducto().addActionListener(this);
        vista.getBotonInformes().addActionListener(this);
    }

    /**
     * Configura aspecto de la tabla, evento de clic sobre los registros de la
     * tabla hace que las filas no sean editables usa el metodo findAll() del
     * repositorio para obtener la información de la base de dtos y mostrarla
     * sobre la tabla
     */
    public void armarModelo() {
        /**
         * Agrega evento para el manejo de clic
         */
        vista.getTablaDatos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evMouse) {
                Long idBusqueda = null;
                if (evMouse.getClickCount() == 1) {     // to detect doble click events
                    JTable target = (JTable) evMouse.getSource();
                    int fila = target.getSelectedRow(); // Fila seleccionada
                    idBusqueda = Long.valueOf((String) vista.getTablaDatos().getValueAt(fila, 0));

                    if (repositorio.existsById(idBusqueda)) {
                        //interactuo con el repositorio para valdiar si existe un agregado ccoincidente por id
                        producto = repositorio.findById(idBusqueda).get();
                        vista.getCajaCodigo().setText(producto.getCodigo().toString());
                        vista.getCajaNombre().setText(producto.getNombre());
                        vista.getCajaPrecio().setText(producto.getPrecio().toString());
                        vista.getCajaInventario().setText(producto.getInventario().toString());

                    } else {
                        JOptionPane.showMessageDialog(vista, "No existe un Producto con el ID: " + idBusqueda + "\nVerifique...", "Producto no encontrado", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        //instancio el modelo de la tabla y hago que nos e puedan editar los registros
        modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //asignar modelo de datos
        vista.getTablaDatos().setModel(modeloTabla);

        //configuro columnas de la tabla
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Inventario");

        //configuro el encabezado de la tabla
        JTableHeader encabezado = vista.getTablaDatos().getTableHeader();
        encabezado.setFont(new Font("Tahome", Font.BOLD, 16));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) encabezado.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        vista.getTablaDatos().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        vista.getTablaDatos().getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        vista.getTablaDatos().getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        vista.getTablaDatos().getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        List<Producto> listaProductos = (List<Producto>) repositorio.findAll();

        //Cargar los datos de la tabla 
        if (!listaProductos.isEmpty()) {
            for (Producto producto : listaProductos) {
                modeloTabla.addRow(producto.registroProducto());
            }
        }
    }

    /**
     * Borrar producto
     */
    public void borrarProducto() {
        int filaSeleccionada = vista.getTablaDatos().getSelectedRow();
        Long idBusqueda = null;

        if (filaSeleccionada >= 0) {
            idBusqueda = Long.valueOf(modeloTabla.getValueAt(filaSeleccionada, 0).toString());

            if (repositorio.existsById(idBusqueda)) {
                producto = repositorio.findById(idBusqueda).get();
                repositorio.deleteById(idBusqueda);
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(vista, producto, "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "No existe un Producto con el ID: " + idBusqueda + "\nVerifique...", "Producto no encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar el producto que desea Borrar :" + filaSeleccionada, "Borrar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Agrega un registro a la tabla producto
     */
    public void agregarProducto() {
        String nombre;
        double precio;
        Long inventario;

        try {
            //obtengo datos de las cajas de texto y los convierto a
            //sus respectivos tipos de datos
            nombre = vista.getCajaNombre().getText().trim();
            precio = Double.parseDouble(vista.getCajaPrecio().getText());
            inventario = Long.valueOf(vista.getCajaInventario().getText());

            //instancio un agregado o Producto
            producto = Producto.crearProducto(nombre, precio, inventario);
            //llamo al metodo save del repositorio para insertar
            repositorio.save(producto);
            //modifico la talba de la interfaz grafica para agregar un registro
            modeloTabla.addRow(producto.registroProducto());

            //limpio el contenido de las cajas de texto
            vista.getCajaNombre().setText("");
            vista.getCajaPrecio().setText("");
            vista.getCajaInventario().setText("");
            JOptionPane.showMessageDialog(vista, "Producto Agregado correctamentent\n" + producto, "Agregar Producto", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Por favor verifique los datos del producto", "Agregar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Actualiza un registro en la tabla producto
     */
    public void actualizarProducto() {
        Long idBusqueda = null;
        String nombre;
        double precio;
        Long inventario;

        int filaSeleccionada = vista.getTablaDatos().getSelectedRow();

        try {
            //lee informacion de las cajas de texto
            JTextField idField = vista.getCajaCodigo();
            idBusqueda = Long.valueOf(idField.getText());
            nombre = vista.getCajaNombre().getText().trim();
            precio = Double.parseDouble(vista.getCajaPrecio().getText());
            inventario = Long.valueOf(vista.getCajaInventario().getText());

            //obtiene un agregado a partir de su id
            producto = repositorio.findById(idBusqueda).get();
            //asigna a los atributos del agregado la informaciòn
            //registrada en las cajas de datos
            producto.setCodigo(idBusqueda);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setInventario(inventario);
            //uso el metodo save del repositorio
            repositorio.save(producto);

            //limpio el contenido de las cajas de texto
            vista.getCajaCodigo().setText("");
            vista.getCajaNombre().setText("");
            vista.getCajaPrecio().setText("");
            vista.getCajaInventario().setText("");

            //actualiza los datos en la tabla
            modeloTabla.setValueAt(producto.getNombre(), filaSeleccionada, 1);
            modeloTabla.setValueAt(producto.getPrecio(), filaSeleccionada, 2);
            modeloTabla.setValueAt(producto.getInventario(), filaSeleccionada, 3);
            JOptionPane.showMessageDialog(vista, "Producto Actualizado correctamentent\n" + producto, "Actualizar Producto", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Por favor verifique los datos del producto", "Actualizar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retorna un listado con los 3 productos de mayor Precio: Crea una lista
     * vacia Y realiza la siguientes acciones 3 veces: 1 Pregunta por el
     * producto mas costoso invocando al método 'productosPrecioMayor', 2 Lo
     * agrega al listado 'listaMayores' 3 Elimina del listado general de
     * prodcutos 'listaProductos'
     *
     * @return List de 3 posiciones con los productos mas costosos
     */
    private List<Producto> obtenerMayores() {
        List<Producto> listaMayores = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Producto productoMayor = productosPrecioMayor();
            listadoProductos.remove(productoMayor);
            listaMayores.add(productoMayor);
        }

        return listaMayores;
    }

    /**
     * Retorna el producto de mayor valor
     *
     * @return producto
     */
    private Producto productosPrecioMayor() {

        Producto producto = listadoProductos.iterator().next();
        for (Producto prodTemp : listadoProductos) {
            if (prodTemp.getPrecio() > producto.getPrecio()) {
                producto = prodTemp;
            }
        }
        return producto;
    }

    /**
     * Genera el informa con los 3 productos mas costosos
     */
    public void generarInforme() {
        //obtiene el listado de todos los productos existentes en la base de datos
        listadoProductos = (List<Producto>) repositorio.findAll();

        //obtiene listado de los 3 productos de mayor precio
        List<Producto> listaM = obtenerMayores();

        //configura y presenta mensaje
        JOptionPane.showMessageDialog(vista, listaM.get(0).getNombre() + " " + listaM.get(1).getNombre() + " " + listaM.get(2).getNombre(), "Informe de los 3 productos más costosos", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Gestiona eventos de clic sobre los botones validando el botón sobre el
     * que se hace clic y ejecutando el respectivo método de negocio segun el
     * caso:
     *
     * Si se hace clic sobre el botón 'botonActualizar' se ejecuta el método
     * 'actualizarProducto' Si se hace clic sobre el botón
     * 'botonAgregarProducto' se ejecuta el método 'agregarProducto' Si se hace
     * clic sobre el botón 'botonBorrar' se ejecuta el método 'borrarProducto'
     * Si se hace clic sobre el botón 'botonInformes' se ejecuta el método
     * 'generarInforme'
     *
     * @param e Información del evento
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == vista.getBotonActualizarProducto()) {
            actualizarProducto();
        } else if (evento.getSource() == vista.getBotonAgregarProducto()) {
            agregarProducto();
        } else if (evento.getSource() == vista.getBotonBorrarProducto()) {
            borrarProducto();
        } else if (evento.getSource() == vista.getBotonInformes()) {
            generarInforme();
        }
    }
}
