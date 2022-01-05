package co.edu.usa.reto4;

import co.edu.usa.reto4.modelo.Calificacion;
import co.edu.usa.reto4.modelo.Categoria;
import co.edu.usa.reto4.modelo.Cliente;
import co.edu.usa.reto4.modelo.Mensaje;
import co.edu.usa.reto4.modelo.Ortesis;
import co.edu.usa.reto4.modelo.Reserva;
import co.edu.usa.reto4.modelo.UsuarioAdministrador;
import co.edu.usa.reto4.repositorios.repositorios.CalificacionRepository;
import co.edu.usa.reto4.repositorios.repositorios.CategoriaRepository;
import co.edu.usa.reto4.repositorios.repositorios.ClienteRepository;
import co.edu.usa.reto4.repositorios.repositorios.MensajeRepository;
import co.edu.usa.reto4.repositorios.repositorios.OrtesisRepository;
import co.edu.usa.reto4.repositorios.repositorios.ReservaRepository;
import co.edu.usa.reto4.repositorios.repositorios.UsuarioAdministradorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.reto4"})
public class Reto4Application {

    @Autowired
    private CalificacionRepository repoCalificacion;
    @Autowired
    private CategoriaRepository repoCategoria;
    @Autowired
    private ClienteRepository repoCliente;
    @Autowired
    private MensajeRepository repoMensaje;
    @Autowired
    private OrtesisRepository repoOrtesis;
    @Autowired
    private ReservaRepository repoReserva;
    @Autowired
    private UsuarioAdministradorRepository repoUsuarioAdministrador;

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Calificacion> cals = repoCalificacion.getAll();
            System.out.println("Calificacion: " + cals.size());

            List<Categoria> cats = repoCategoria.getAll();
            System.out.println("Categorias: " + cats.size());

            List<Cliente> clis = repoCliente.getAll();
            System.out.println("Clientes: " + clis.size());

            List<Mensaje> mens = repoMensaje.getAll();
            System.out.println("Mensajes: " + mens.size());

            List<Ortesis> orts = repoOrtesis.getAll();
            System.out.println("Ortesis: " + orts.size());

            List<Reserva> ress = repoReserva.getAll();
            System.out.println("Reservas: " + ress.size());

            List<UsuarioAdministrador> adms = repoUsuarioAdministrador.getAll();
            System.out.println("Administradores: " + adms.size());
        };
    }

}
