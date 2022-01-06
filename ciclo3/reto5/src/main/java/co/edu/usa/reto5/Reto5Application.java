package co.edu.usa.reto5;

import co.edu.usa.reto5.modelo.Calificacion;
import co.edu.usa.reto5.modelo.Categoria;
import co.edu.usa.reto5.modelo.Cliente;
import co.edu.usa.reto5.modelo.Mensaje;
import co.edu.usa.reto5.modelo.Ortesis;
import co.edu.usa.reto5.modelo.Reserva;
import co.edu.usa.reto5.modelo.UsuarioAdministrador;
import co.edu.usa.reto5.repositorios.repositorios.CalificacionRepository;
import co.edu.usa.reto5.repositorios.repositorios.CategoriaRepository;
import co.edu.usa.reto5.repositorios.repositorios.ClienteRepository;
import co.edu.usa.reto5.repositorios.repositorios.MensajeRepository;
import co.edu.usa.reto5.repositorios.repositorios.OrtesisRepository;
import co.edu.usa.reto5.repositorios.repositorios.ReservaRepository;
import co.edu.usa.reto5.repositorios.repositorios.UsuarioAdministradorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.reto5"})
public class Reto5Application {

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
        SpringApplication.run(Reto5Application.class, args);
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
