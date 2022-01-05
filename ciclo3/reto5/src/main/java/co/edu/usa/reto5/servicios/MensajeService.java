package co.edu.usa.reto5.servicios;

import co.edu.usa.reto5.modelo.Mensaje;
import co.edu.usa.reto5.repositorios.repositorios.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author andresruedalibre
 */
@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> getAll() {
        return mensajeRepository.getAll();
    }

    public Mensaje save(Mensaje mensaje) {
        if ((mensaje.getMessageText().length() > 250)) {
            return mensaje;
        } else {
            return mensajeRepository.save(mensaje);
        }

    }

    public Mensaje getById(int id) {
        Optional<Mensaje> mensaje = mensajeRepository.getById(id);
        return mensaje.orElse(new Mensaje());
    }

    public boolean delete(int id) {
        Boolean d = mensajeRepository.getById(id).map(mensaje -> {
            mensajeRepository.delete(mensaje);
            return true;
        }).orElse(false);
        return d;
    }

    public Mensaje update(Mensaje mensaje) {
        if (mensaje.getIdMessage() != null) {
            Optional<Mensaje> mens = mensajeRepository.getById(mensaje.getIdMessage());
            if (mens.isPresent()) {
                System.out.println("si encontro el mensaje con el codigo " + mensaje.getIdMessage());
                if (mensaje.getMessageText() != null) {
                    mens.get().setMessageText(mensaje.getMessageText());
                }
                return mensajeRepository.save(mens.get());
            }
        }
        return mensaje;
    }

}
