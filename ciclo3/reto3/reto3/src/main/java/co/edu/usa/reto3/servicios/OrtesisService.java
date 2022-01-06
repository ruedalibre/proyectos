/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Ortesis;
import co.edu.usa.reto3.repositorios.repositorios.OrtesisRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class OrtesisService {
    @Autowired
    private OrtesisRepository ortesisRepository;
    
    public List<Ortesis> getAll(){
    return ortesisRepository.getAll();
    }
    
    public Ortesis save(Ortesis ortesis){
    return ortesisRepository.save(ortesis);
    }
    
    public Ortesis getById(int id){
    Optional<Ortesis> ortesis = ortesisRepository.getById(id);
    return ortesis.orElse(new Ortesis());
    }
}
