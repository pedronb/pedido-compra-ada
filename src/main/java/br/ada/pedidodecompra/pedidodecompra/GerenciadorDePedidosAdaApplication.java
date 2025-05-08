package br.ada.pedidodecompra.pedidodecompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class GerenciadorDePedidosAdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDePedidosAdaApplication.class, args);
	}

}
