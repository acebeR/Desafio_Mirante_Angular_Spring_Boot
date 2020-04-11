package br.com.desafio.mirante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.mirante.model.Pessoa;
import br.com.desafio.mirante.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository; 
	
	public Pessoa cadastrar(Pessoa pessoa){
		return pessoaRepository.save(pessoa);
	}
	
	public Collection<Pessoa> buscarTodos(){
		return pessoaRepository.findAll();
	}
	
	public void excluir(Pessoa pessoa){
		pessoaRepository.delete(pessoa);
	}
	
	public Pessoa buscaPorId(Integer id){
		return pessoaRepository.findOne(id);
	}
	
	public Pessoa alterar(Pessoa pessoa){
		return  pessoaRepository.save(pessoa);
	}
}
