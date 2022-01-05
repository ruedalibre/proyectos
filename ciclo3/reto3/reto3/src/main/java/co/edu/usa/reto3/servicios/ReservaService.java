/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;


import co.edu.usa.reto3.modelo.Reserva;
import co.edu.usa.reto3.repositorios.repositorios.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    
    public List<Reserva> getAll(){
    return reservaRepository.getAll();
    }
    
    public Reserva save(Reserva reserva){
    return reservaRepository.save(reserva);
    }
    
    public Reserva getById(int id){
    Optional<Reserva> reserva = reservaRepository.getById(id);
    return reserva.orElse(new Reserva());
    }
}
