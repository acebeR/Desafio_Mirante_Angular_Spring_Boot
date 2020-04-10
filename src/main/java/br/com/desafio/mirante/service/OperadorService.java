package br.com.desafio.mirante.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.mirante.model.Operador;
import br.com.desafio.mirante.repository.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	OperadorRepository operadorRepository; 

	
	public Operador cadastrar(Operador operador){
		return operadorRepository.save(operador);
	}
	
	public Collection<Operador> buscarTodos(){
		return operadorRepository.findAll();
	}
	
	public void excluir(Operador operador){
		operadorRepository.delete(operador);
	}
	
	public Operador buscaPorId(Integer id){
		return operadorRepository.findOne(id);
	}
	
	public Operador alterar(Operador operador){
		return  operadorRepository.save(operador);
	}

}
