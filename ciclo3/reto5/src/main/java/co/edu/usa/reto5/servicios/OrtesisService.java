package co.edu.usa.reto5.servicios;

import co.edu.usa.reto5.modelo.Ortesis;
import co.edu.usa.reto5.repositorios.repositorios.OrtesisRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class OrtesisService {

    @Autowired
    private OrtesisRepository ortesisRepository;

    public List<Ortesis> getAll() {
        return ortesisRepository.getAll();
    }

    public Ortesis save(Ortesis ortesis) {
        return ortesisRepository.save(ortesis);
    }

    public Ortesis getById(int id) {
        Optional<Ortesis> ortesis = ortesisRepository.getById(id);
        return ortesis.orElse(new Ortesis());
    }

    public boolean delete(int id) {
        Boolean d = ortesisRepository.getById(id).map(ortesis -> {
            ortesisRepository.delete(ortesis);
            return true;
        }).orElse(false);
        return d;

    }

    public Ortesis update(Ortesis ortesis) {
        if (ortesis.getId() != null) {
            Optional<Ortesis> ortesisConsultada = ortesisRepository.getById(ortesis.getId());
            if (ortesisConsultada.isPresent()) {
                ortesisConsultada.get().setName(ortesis.getName());
                ortesisConsultada.get().setBrand(ortesis.getBrand());
                ortesisConsultada.get().setDescription(ortesis.getDescription());
                ortesisConsultada.get().setYear(ortesis.getYear());
            }
            return ortesisRepository.save(ortesisConsultada.get());
        }
        return ortesis;
    }

}
