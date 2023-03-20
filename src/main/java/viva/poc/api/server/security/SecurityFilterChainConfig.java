package viva.poc.api.server.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> authorize
                
                .requestMatchers("/health", "/status").permitAll()            
                
                //.requestMatchers("/api/**").hasAuthority("SCOPE_message:read")
                .requestMatchers("/api/**").authenticated()


            )
            //.httpBasic().disable()
            //.and()
            .csrf().disable();
            //.cors().disable();    

        http
            .oauth2ResourceServer()
            .jwt();
            
        return http.build();

    }   
}
