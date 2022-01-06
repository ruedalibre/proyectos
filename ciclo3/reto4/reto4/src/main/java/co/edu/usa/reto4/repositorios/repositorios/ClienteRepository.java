package co.edu.usa.reto4.repositorios.repositorios;

import co.edu.usa.reto4.modelo.Cliente;
import co.edu.usa.reto4.repositorios.crud.ClienteCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository repoCliente;

    public List<Cliente> getAll() {
        return (List<Cliente>) repoCliente.findAll();
    }

    public Optional<Cliente> getById(int id) {
        return repoCliente.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return repoCliente.save(cliente);
    }

    public void delete(Cliente cliente) {
        repoCliente.delete(cliente);
    }

}
