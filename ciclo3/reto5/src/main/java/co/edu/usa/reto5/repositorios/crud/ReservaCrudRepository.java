package co.edu.usa.reto5.repositorios.crud;

import co.edu.usa.reto5.modelo.Reserva;

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

    @Query("SELECT c.client, COUNT(c.client) FROM Reserva AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countReservasByCliente();

    @Query("SELECT c.status, COUNT(c.idReservation) from Reserva AS c Group By c.status order by COUNT(c.idReservation) DESC")
    public List<Object[]> countReservasByStatus();

    public List<Reserva> findAllByStatus(String status);

}
