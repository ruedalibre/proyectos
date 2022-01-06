/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.UsuarioAdministrador;
import co.edu.usa.reto3.repositorios.repositorios.UsuarioAdministradorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class UsuarioAdministradorService {
    @Autowired
    private UsuarioAdministradorRepository usuarioAdmRepository;
    
    public List<UsuarioAdministrador> getAll(){
    return usuarioAdmRepository.getAll();
    }
    
    public UsuarioAdministrador save(UsuarioAdministrador usuarioAdmn){
    return usuarioAdmRepository.save(usuarioAdmn);
    }
    
    public UsuarioAdministrador getById(int id){
    Optional<UsuarioAdministrador> usuAdmn = usuarioAdmRepository.getById(id);
    return usuAdmn.orElse(new UsuarioAdministrador());
    }
}
