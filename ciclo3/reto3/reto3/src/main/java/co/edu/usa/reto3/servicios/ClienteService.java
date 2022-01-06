/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Cliente;
import co.edu.usa.reto3.repositorios.repositorios.ClienteRepository;
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
    
    public List<Cliente> getAll(){
    return clienteRepository.getAll();
    }
    
    public Cliente save(Cliente cliente){
        if ((cliente.getEmail().length()>45) || (cliente.getPassword().length()>450)||(cliente.getName().length()>250)){
        return cliente;
                } else {
    return clienteRepository.save(cliente);
    }
    }
    
    public Cliente getById(int id){
    Optional<Cliente> cliente = clienteRepository.getById(id);
    return cliente.orElse(new Cliente());
    }
}
