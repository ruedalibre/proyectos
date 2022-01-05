/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.UsuarioAdministrador;
import co.edu.usa.reto3.repositorios.crud.UsuarioAdministradorCrudRepository;
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
    
    public List<UsuarioAdministrador> getAll(){
        return (List<UsuarioAdministrador>)repoAdministrador.findAll();
    }
    
    public Optional<UsuarioAdministrador> getById(int id) {
        return repoAdministrador.findById(id);
    }
    
    public UsuarioAdministrador save(UsuarioAdministrador administrador){
        return repoAdministrador.save(administrador);
    }
    
}
