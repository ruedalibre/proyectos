/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Calificacion;
import co.edu.usa.reto3.repositorios.repositorios.CalificacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificionRepository;
    
    public List<Calificacion> getAll(){
    return calificionRepository.getAll();
    }
    
    public Calificacion save(Calificacion calificacion){
    return calificionRepository.save(calificacion);
    }
    
    public Calificacion getById(int id){
    Optional<Calificacion> calificacion = calificionRepository.getById(id);
    return calificacion.orElse(new Calificacion());
    }
    
}
