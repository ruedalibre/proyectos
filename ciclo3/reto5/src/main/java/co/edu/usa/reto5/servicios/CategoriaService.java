package co.edu.usa.reto5.servicios;

import co.edu.usa.reto5.modelo.Categoria;
import co.edu.usa.reto5.repositorios.repositorios.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll() {
        return categoriaRepository.getAll();
    }

    public Categoria save(Categoria categoria) {
        if ((categoria.getName().length() > 45) || (categoria.getDescription().length() > 250)) {
            return categoria;
        } else {
            return categoriaRepository.save(categoria);
        }
    }

    public Categoria getById(int id) {
        Optional<Categoria> categoria = categoriaRepository.getById(id);
        return categoria.orElse(new Categoria());
    }

    public boolean delete(int id) {
        System.out.println("Borrando categoría con  id: " + id);
        boolean del = categoriaRepository.getById(id).map(categoria -> {
            categoriaRepository.delete(categoria);
            return true;
        }).orElse(false);
        return del;
    }

    public Categoria update(Categoria categoria) {
        if (categoria.getId() != null) {
            Optional<Categoria> categoriaConsultada = categoriaRepository.getById(categoria.getId());
            if (categoriaConsultada.isPresent()) {
                categoriaConsultada.get().setName(categoria.getName());
                categoriaConsultada.get().setDescription(categoria.getDescription());
            }
            return categoriaRepository.save(categoriaConsultada.get());
        }
        return categoria;
    }
}
