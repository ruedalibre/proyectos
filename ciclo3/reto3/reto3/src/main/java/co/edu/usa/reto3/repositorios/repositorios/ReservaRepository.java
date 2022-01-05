/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.Reserva;
import co.edu.usa.reto3.repositorios.crud.ReservaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class ReservaRepository {
    @Autowired
    private ReservaCrudRepository repoReserva;
    
    public List<Reserva> getAll(){
        return (List<Reserva>)repoReserva.findAll();
    }
    
    public Optional<Reserva> getById(int id) {
        return repoReserva.findById(id);
    }
    
    public Reserva save(Reserva reserva){
        return repoReserva.save(reserva);
    }
    
}
