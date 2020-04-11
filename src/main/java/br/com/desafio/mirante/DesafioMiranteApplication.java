package br.com.desafio.mirante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.desafio.mirante.controller.TokenFilter;

@SpringBootApplication
@EnableJpaRepositories
public class DesafioMiranteApplication {
	@Bean
	public FilterRegistrationBean filtroJwt(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioMiranteApplication.class, args);
		
	}

}
