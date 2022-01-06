package co.edu.usa.reto4.repositorios.repositorios;

import co.edu.usa.reto4.modelo.Reserva;
import co.edu.usa.reto4.repositorios.crud.ReservaCrudRepository;
import java.util.Date;
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

    public List<Reserva> getAll() {
        return (List<Reserva>) repoReserva.findAll();
    }

    public Optional<Reserva> getById(int id) {
        return repoReserva.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return repoReserva.save(reserva);
    }

    public void delete(Reserva reserva) {
        repoReserva.delete(reserva);
    }

    public List<Reserva> getReservasByPeriod(Date a, Date b) {
        return repoReserva.findAllByFechaReservaAfterAndFechaReservaBefore(a, b);
    }

}
