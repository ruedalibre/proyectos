package co.edu.usa.reto4.servicios;

import co.edu.usa.reto4.modelo.UsuarioAdministrador;
import co.edu.usa.reto4.repositorios.repositorios.UsuarioAdministradorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class UsuarioAdministradorService {

    @Autowired
    private UsuarioAdministradorRepository usuarioAdmRepository;

    public List<UsuarioAdministrador> getAll() {
        return usuarioAdmRepository.getAll();
    }

    public UsuarioAdministrador save(UsuarioAdministrador usuarioAdmn) {
        return usuarioAdmRepository.save(usuarioAdmn);
    }

    public UsuarioAdministrador getById(int id) {
        Optional<UsuarioAdministrador> usuAdmn = usuarioAdmRepository.getById(id);
        return usuAdmn.orElse(new UsuarioAdministrador());
    }

    public boolean delete(int id) {
        Boolean d = usuarioAdmRepository.getById(id).map(admn -> {
            usuarioAdmRepository.delete(admn);
            return true;
        }).orElse(false);
        return d;
    }

    public UsuarioAdministrador update(UsuarioAdministrador admin) {
        if (admin.getId() != null) {
            Optional<UsuarioAdministrador> admn = usuarioAdmRepository.getById(admin.getId());
            if (admn.isPresent()) {
                System.out.println("si encontro el administrador con el codigo " + admin.getId());
                if (admin.getEmail() != null) {
                    admn.get().setEmail(admin.getEmail());
                }
                if (admin.getName() != null) {
                    admn.get().setName(admin.getName());
                }
                if (admin.getPassword() != null) {
                    admn.get().setPassword(admin.getPassword());
                }
                return usuarioAdmRepository.save(admn.get());
            }
        }
        return admin;
    }
}
