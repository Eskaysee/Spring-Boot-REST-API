package SpringBootFramwork.RESTAPI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //authenticate all requests
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        //Enable basic authentication
        http.httpBasic(withDefaults());
        //Disabled as stateless AuthN are generally not vulnerable to CSRF attacks
        //CSRF exploit browser session cookies maintained by a server. For state-
        //less AuthN tokens are sent with each & every request.
        http.csrf().disable();
        return http.build();
    }
}
