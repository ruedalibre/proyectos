/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.Cliente;
import co.edu.usa.reto3.repositorios.crud.ClienteCrudRepository;
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
    
    public List<Cliente> getAll(){
        return (List<Cliente>)repoCliente.findAll();
    }
    
    public Optional<Cliente> getById(int id) {
        return repoCliente.findById(id);
    }
    
    public Cliente save(Cliente cliente){
        return repoCliente.save(cliente);
    }
    
}
