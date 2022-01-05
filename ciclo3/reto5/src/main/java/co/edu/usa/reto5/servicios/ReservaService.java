package co.edu.usa.reto5.servicios;

import co.edu.usa.reto5.modelo.Reserva;
import co.edu.usa.reto5.modelo.custom.CountReservasByClient;
import co.edu.usa.reto5.modelo.custom.InformeStatus;
import co.edu.usa.reto5.modelo.custom.RespuestaInformeStatus;

import co.edu.usa.reto5.repositorios.repositorios.ReservaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Reserva> getAll() {
        return reservaRepository.getAll();
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva getById(int id) {
        Optional<Reserva> reserva = reservaRepository.getById(id);
        return reserva.orElse(new Reserva());
    }

    public boolean delete(int id) {
        Boolean d = reservaRepository.getById(id).map(reserva -> {
            reservaRepository.delete(reserva);
            return true;
        }).orElse(false);
        return d;
    }

    public Reserva update(Reserva reserva) {
        if (reserva.getIdReservation() != null) {
            Optional<Reserva> res = reservaRepository.getById(reserva.getIdReservation());
            if (res.isPresent()) {
                System.out.println("si encontro la reserva con el codigo " + reserva.getIdReservation());
                if (reserva.getStartDate() != null) {
                    res.get().setStartDate(reserva.getStartDate());
                }
                if (reserva.getDevolutionDate() != null) {
                    res.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if (reserva.getOrtopedic() != null) {
                    res.get().setOrtopedic(reserva.getOrtopedic());
                }
                if (reserva.getScore() != null) {
                    res.get().setScore(reserva.getScore());
                }
                if (reserva.getStatus() != null) {
                    res.get().setStatus(reserva.getStatus());
                }
                return reservaRepository.save(res.get());
            }
        }
        return reserva;
    }

    public List<Reserva> getReservasByPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return reservaRepository.getReservasByPeriod(a, b);
        } else {
            return new ArrayList<>();
        }

    }

    public List<CountReservasByClient> getReservasByCliente() {
        return reservaRepository.getReservasByClient();
    }

    public List<InformeStatus> getReservasByStatus() {
        return reservaRepository.getReservabyStatus();
    }

    public RespuestaInformeStatus getResInSta() {
        List<Reserva> completed = reservaRepository.getReservasByDescription("completed");
        List<Reserva> cancelled = reservaRepository.getReservasByDescription("cancelled");

        RespuestaInformeStatus resp = new RespuestaInformeStatus(completed.size(), cancelled.size());
        return resp;
    }
}
