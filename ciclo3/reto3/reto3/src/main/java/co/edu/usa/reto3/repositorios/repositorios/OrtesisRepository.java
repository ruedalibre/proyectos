/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.Ortesis;
import co.edu.usa.reto3.repositorios.crud.OrtesisCrudRepository;
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
    
    public List<Ortesis> getAll(){
        return (List<Ortesis>)repoOrtesis.findAll();
    }
    
    public Optional<Ortesis> getById(int id) {
        return repoOrtesis.findById(id);
    }
    
    public Ortesis save(Ortesis ortesis){
        return repoOrtesis.save(ortesis);
    }
}
