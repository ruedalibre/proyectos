package co.edu.usa.reto5.servicios;

import co.edu.usa.reto5.modelo.Calificacion;
import co.edu.usa.reto5.repositorios.repositorios.CalificacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificionRepository;

    public List<Calificacion> getAll() {
        return calificionRepository.getAll();
    }

    public Calificacion save(Calificacion calificacion) {
        return calificionRepository.save(calificacion);
    }

    public Calificacion getById(int id) {
        Optional<Calificacion> calificacion = calificionRepository.getById(id);
        return calificacion.orElse(new Calificacion());
    }

    public boolean delete(int id) {
        Boolean d = calificionRepository.getById(id).map(calificacion -> {
            calificionRepository.delete(calificacion);
            return true;
        }).orElse(false);
        return d;
    }

    public Calificacion update(Calificacion calificacion) {
        if (calificacion.getId() != null) {
            Optional<Calificacion> cali = calificionRepository.getById(calificacion.getId());
            if (cali.isPresent()) {
                System.out.println("si encontro la calificacion con el codigo " + calificacion.getId());
                if (calificacion.getScore() != null) {
                    cali.get().setScore(calificacion.getScore());
                }
                if (calificacion.getMessage() != null) {
                    cali.get().setMessage(calificacion.getMessage());
                }
                if (calificacion.getIdReserva() != null) {
                    cali.get().setIdReserva(calificacion.getIdReserva());
                }
                return calificionRepository.save(cali.get());
            }
        }
        return calificacion;
    }
}
