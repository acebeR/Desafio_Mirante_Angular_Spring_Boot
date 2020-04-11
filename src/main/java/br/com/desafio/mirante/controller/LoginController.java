/*
 * Programadora: Rebeca Divina Paula
 */
package br.com.desafio.mirante.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.mirante.model.Usuario;
import br.com.desafio.mirante.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException{
		
		if(usuario.getLogin() == null || usuario.getSenha() == null){
			throw new ServletException("Nome e senha obrigatório");
		}
		Usuario usu = usuarioService.buscarPorNome(usuario.getLogin());
		if(usu == null){
			throw new ServletException("Usuário não encontrado");
		}
		
		if(!usu.getSenha().equals(usuario.getSenha())){
			throw new ServletException("Senha inválida");
		}
		String token = Jwts.builder().setSubject(usu.getLogin()).signWith(SignatureAlgorithm.HS512, "banana").setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)).compact();
		return new LoginResponse(token);
	}
	
	
	private class LoginResponse{
		String token;
		
		
		public String getToken() {
			return token;
		}


		public LoginResponse(String token){
			this.token = token;
		}
	}

}
