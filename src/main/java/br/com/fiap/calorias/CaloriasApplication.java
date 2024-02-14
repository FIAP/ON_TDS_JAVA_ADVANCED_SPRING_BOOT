package br.com.fiap.calorias;

import br.com.fiap.calorias.model.UsuarioRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CaloriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaloriasApplication.class, args);
		//teste();
	}

	public static void teste(){

		String x = UsuarioRole.ADMIN.getRole();
	}

}
