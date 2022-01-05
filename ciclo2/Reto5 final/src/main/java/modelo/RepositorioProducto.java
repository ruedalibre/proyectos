package modelo;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author desaextremo
 */
public interface RepositorioProducto extends CrudRepository<Producto, Long> {
    
}
