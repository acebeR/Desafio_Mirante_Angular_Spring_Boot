package br.com.desafio.mirante.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.mirante.model.Telefone;
import br.com.desafio.mirante.repository.TelefoneRepository;
@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepository;
	
	public Telefone cadastrar(Telefone telefone){
		return telefoneRepository.save(telefone);
	}

	public Telefone alterar(Telefone telefone){
		return telefoneRepository.save(telefone);
	}
	
	public Collection<Telefone> buscarTodos(){
		return telefoneRepository.findAll();
	}
	
	public Telefone buscarPorId(Integer id){
		return telefoneRepository.findOne(id);
	}
	
	public Collection<Telefone> buscarPorPessoa(Integer id_pessoa){
		return telefoneRepository.buscarPorIdPessoa(id_pessoa);
	}
	
	public void excluir(Telefone telefone){
		telefoneRepository.delete(telefone);
	}
	
}
