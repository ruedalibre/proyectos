package co.edu.usa.reto4.repositorios.repositorios;

import co.edu.usa.reto4.modelo.Ortesis;
import co.edu.usa.reto4.repositorios.crud.OrtesisCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class OrtesisRepository {

    @Autowired
    private OrtesisCrudRepository repoOrtesis;

    public List<Ortesis> getAll() {
        return (List<Ortesis>) repoOrtesis.findAll();
    }

    public Optional<Ortesis> getById(int id) {
        return repoOrtesis.findById(id);
    }

    public Ortesis save(Ortesis ortesis) {
        return repoOrtesis.save(ortesis);
    }

    /**
     * Actualizar hace uso del mismo método save Código nuevo
     *
     * @param ortesis
     */
    public void delete(Ortesis ortesis) {
        repoOrtesis.delete(ortesis);
    }

}
