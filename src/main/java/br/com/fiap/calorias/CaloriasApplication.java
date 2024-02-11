package br.com.fiap.calorias;

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
		List<String> frutas = Arrays.asList("Maçã", "Pêra", "Uva", "Banana", "Melancia", "Jabuticaba", "Manga");
		var fruta = frutas.stream();
		System.out.println(frutas);
		System.out.println(fruta.map(String::new).toList());
	}

}
