/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.Mensaje;
import co.edu.usa.reto3.repositorios.crud.MensajeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class MensajeRepository {
    @Autowired
    private MensajeCrudRepository repoMensaje;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>)repoMensaje.findAll();
    }
    
    public Optional<Mensaje> getById(int id) {
        return repoMensaje.findById(id);
    }
    
    public Mensaje save(Mensaje mensaje){
        return repoMensaje.save(mensaje);
    }
    
}
