package co.edu.usa.reto4.repositorios.crud;

import co.edu.usa.reto4.modelo.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author andresruedalibre
 */
public interface ReservaCrudRepository extends CrudRepository<Reserva, Integer> {

    @Query("Select r from Reserva AS r where r.startDate >?1 AND r.devolutionDate <?2")
    public List<Reserva> findAllByFechaReservaAfterAndFechaReservaBefore(Date dateOne, Date dateTwo);
}
