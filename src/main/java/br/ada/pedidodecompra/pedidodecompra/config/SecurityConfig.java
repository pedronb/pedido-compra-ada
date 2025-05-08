package br.ada.pedidodecompra.pedidodecompra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        SecurityFilterChain security = http.authorizeHttpRequests(
                auth -> {
                    auth
                            .requestMatchers("/api/clientes").permitAll()
                            .requestMatchers("/api/produtos").permitAll()
                            .requestMatchers("/api/pedidos").permitAll()
                            .requestMatchers("/h2-console/**").permitAll()
                            .anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults()
        )
                .csrf().disable()
                .build();
        
        return security;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                .build();
        
        return new InMemoryUserDetailsManager(user);
    }
    
}
