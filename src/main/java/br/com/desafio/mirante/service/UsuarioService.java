package br.com.desafio.mirante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.mirante.model.Usuario;
import br.com.desafio.mirante.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorNome(String login){
		return usuarioRepository.buscarPorLogin(login);
	}
}
