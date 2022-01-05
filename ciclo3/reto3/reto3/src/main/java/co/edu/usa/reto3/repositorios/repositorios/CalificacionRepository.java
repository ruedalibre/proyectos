/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.Calificacion;
import co.edu.usa.reto3.repositorios.crud.CalificacionCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class CalificacionRepository {
    @Autowired
    private CalificacionCrudRepository repoCalificacion;
    
    public List<Calificacion> getAll(){
        return (List<Calificacion>)repoCalificacion.findAll();
    }
    
    public Optional<Calificacion> getById(int id) {
        return repoCalificacion.findById(id);
    }
    
    public Calificacion save(Calificacion calificacion){
        return repoCalificacion.save(calificacion);
    }
    
}
