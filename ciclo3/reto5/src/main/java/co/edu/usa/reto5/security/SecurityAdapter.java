package co.edu.usa.reto5.security;

/**
 *
 * @author andresruedalibre
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> {
            try {
                a
                        .antMatchers("/", "/error", "/webjars/**", "/categorias.html",
                                "/api/**").permitAll()
                        .anyRequest().authenticated()
                        .and().logout().logoutSuccessUrl("/").permitAll();
            } catch (Exception ex) {
                Logger.getLogger(SecurityAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login().defaultSuccessUrl("/", true);

        http.cors().and().csrf().disable();

    }

}
