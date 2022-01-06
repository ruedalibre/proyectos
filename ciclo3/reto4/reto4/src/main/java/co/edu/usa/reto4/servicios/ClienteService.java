package co.edu.usa.reto4.servicios;

import co.edu.usa.reto4.modelo.Cliente;
import co.edu.usa.reto4.repositorios.repositorios.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.getAll();
    }

    public Cliente save(Cliente cliente) {
        if ((cliente.getEmail().length() > 45) || (cliente.getPassword().length() > 450) || (cliente.getName().length() > 250)) {
            return cliente;
        } else {
            return clienteRepository.save(cliente);
        }
    }

    public Cliente getById(int id) {
        Optional<Cliente> cliente = clienteRepository.getById(id);
        return cliente.orElse(new Cliente());
    }

    public boolean delete(int id) {
        Boolean d = clienteRepository.getById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
        return d;
    }

    public Cliente update(Cliente cliente) {
        if (cliente.getIdClient() != null) {
            Optional<Cliente> clie = clienteRepository.getById(cliente.getIdClient());
            if (clie.isPresent()) {
                System.out.println("si encontro el producto con el codigo " + cliente.getIdClient());
                if (cliente.getName() != null) {
                    clie.get().setName(cliente.getName());
                }
                if (cliente.getEmail() != null) {
                    clie.get().setEmail(cliente.getEmail());
                }
                if (cliente.getPassword() != null) {
                    clie.get().setPassword(cliente.getPassword());
                }
                if (cliente.getAge() != null) {
                    clie.get().setAge(cliente.getAge());
                }
                return clienteRepository.save(clie.get());
            }
        }
        return cliente;
    }

}
