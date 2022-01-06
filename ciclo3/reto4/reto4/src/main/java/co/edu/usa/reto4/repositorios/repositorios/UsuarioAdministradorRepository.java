package co.edu.usa.reto4.repositorios.repositorios;

import co.edu.usa.reto4.modelo.UsuarioAdministrador;
import co.edu.usa.reto4.repositorios.crud.UsuarioAdministradorCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class UsuarioAdministradorRepository {

    @Autowired
    private UsuarioAdministradorCrudRepository repoAdministrador;

    public List<UsuarioAdministrador> getAll() {
        return (List<UsuarioAdministrador>) repoAdministrador.findAll();
    }

    public Optional<UsuarioAdministrador> getById(int id) {
        return repoAdministrador.findById(id);
    }

    public UsuarioAdministrador save(UsuarioAdministrador administrador) {
        return repoAdministrador.save(administrador);
    }

    public void delete(UsuarioAdministrador admn) {
        repoAdministrador.delete(admn);
    }

}
