package lauch;

import controlador.ControladorProducto;
import modelo.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import vista.Tienda;

/**
 * Utilizamos las anotaciones
 * @SpringBootApplication
 * @ComponentScan: Spring se encarga de instanciar todos nuestros objetos y por lo tanto actua como una super Factoria o fabrica.
 * @EnableJdbcRepositories
 * @Bean para definir los diferentes beans, Datasource EntityManagerFactory y TransactionManager
 * @author desaextremo
 */

@SpringBootApplication
@ComponentScan("modelo")
@EnableJdbcRepositories("modelo")
public class Principal {

    @Autowired
    RepositorioProducto repositorio;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Principal.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            Tienda tienda = new Tienda();
            ControladorProducto controlador = new ControladorProducto(repositorio, tienda);
            tienda.setControlador(controlador);
        };
    }

}
