package co.edu.usa.reto4.web;

import co.edu.usa.reto4.modelo.Calificacion;
import co.edu.usa.reto4.servicios.CalificacionService;
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
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/all")
    public List<Calificacion> getAll() {
        return calificacionService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion save(@RequestBody Calificacion calificacion) {
        return calificacionService.save(calificacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(calificacionService.delete(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion update(@RequestBody Calificacion calificacion) {
        return calificacionService.update(calificacion);
    }

    @GetMapping("/get/{id}")
    public Calificacion getById(@PathVariable("id") int id) {
        return calificacionService.getById(id);
    }
}
