package br.com.desafio.mirante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DesafioMiranteApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioMiranteApplication.class, args);
		
	}

}
