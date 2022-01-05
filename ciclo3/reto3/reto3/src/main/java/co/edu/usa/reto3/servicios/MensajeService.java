/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Mensaje;
import co.edu.usa.reto3.repositorios.repositorios.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author andresruedalibre
 */
@Service
public class MensajeService {
    @Autowired
    private MensajeRepository mensajeRepository;
    
    public List<Mensaje> getAll(){
    return mensajeRepository.getAll();
    }
    
    public Mensaje save(Mensaje mensaje){
        if ((mensaje.getMessageText().length()>250)){
            return mensaje;
        }else{
      return mensajeRepository.save(mensaje);
        }
    
    }
    
    public Mensaje getById(int id){
    Optional<Mensaje> mensaje = mensajeRepository.getById(id);
    return mensaje.orElse(new Mensaje());
    }
    
}
