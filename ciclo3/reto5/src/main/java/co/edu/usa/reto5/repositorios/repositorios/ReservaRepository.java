package co.edu.usa.reto5.repositorios.repositorios;

import co.edu.usa.reto5.modelo.Reserva;
import co.edu.usa.reto5.modelo.Cliente;
import co.edu.usa.reto5.modelo.custom.CountReservasByClient;
import co.edu.usa.reto5.modelo.custom.InformeStatus;
import co.edu.usa.reto5.repositorios.crud.ReservaCrudRepository;
import java.util.ArrayList;
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

    public List<CountReservasByClient> getReservasByClient() {
        List<CountReservasByClient> res = new ArrayList<>();
        List<Object[]> report = repoReserva.countReservasByCliente();

        for (int i = 0; i < report.size(); i++) {
            Cliente reser = (Cliente) report.get(i)[0];
            Long numero = (Long) report.get(i)[1];
            CountReservasByClient cRBC = new CountReservasByClient(numero, reser);
            res.add(cRBC);
        }
        return res;
    }

    public List<InformeStatus> getReservabyStatus() {
        List<InformeStatus> res = new ArrayList<>();
        List<Object[]> report = repoReserva.countReservasByStatus();

        for (int i = 0; i < report.size(); i++) {
            Object[] linea = report.get(i);
            res.add(new InformeStatus((Long) linea[1], linea[0].toString()));

        }
        return res;
    }

    public List<Reserva> getReservasByDescription(String description) {
        return repoReserva.findAllByStatus(description);
    }

}
