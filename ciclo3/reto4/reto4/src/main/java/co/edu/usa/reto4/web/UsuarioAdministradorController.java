package co.edu.usa.reto4.web;

import co.edu.usa.reto4.modelo.UsuarioAdministrador;
import co.edu.usa.reto4.servicios.UsuarioAdministradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author andresruedalibre
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioAdministradorController {

    @Autowired
    private UsuarioAdministradorService usuAdmnService;

    @GetMapping("/all")
    public List<UsuarioAdministrador> getAll() {
        return usuAdmnService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioAdministrador save(@RequestBody UsuarioAdministrador usuAdmn) {
        return usuAdmnService.save(usuAdmn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(usuAdmnService.delete(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioAdministrador update(@RequestBody UsuarioAdministrador admin) {
        return usuAdmnService.update(admin);
    }

    @GetMapping("/get/{id}")
    public UsuarioAdministrador getById(@PathVariable("id") int id) {
        return usuAdmnService.getById(id);
    }

}
