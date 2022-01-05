package co.edu.usa.reto5.web;

import co.edu.usa.reto5.modelo.Reserva;
import co.edu.usa.reto5.modelo.custom.CountReservasByClient;
import co.edu.usa.reto5.modelo.custom.RespuestaInformeStatus;

import co.edu.usa.reto5.servicios.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andresruedalibre
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/all")
    public List<Reserva> getAll() {
        return reservaService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(reservaService.delete(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva reserva) {
        return reservaService.update(reserva);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reserva> getReservasPorFechas(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return reservaService.getReservasByPeriod(dateOne, dateTwo);
    }

    @GetMapping("/get/{id}")
    public Reserva getById(@PathVariable("id") int id) {
        return reservaService.getById(id);
    }

    @GetMapping("/report-clients")
    public List<CountReservasByClient> getReservasPorCliente() {
        return reservaService.getReservasByCliente();
    }

    @GetMapping("/report-status")
    public RespuestaInformeStatus getReservasByStatus() {
        return reservaService.getResInSta();
    }
}
