package br.com.desafio.mirante.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.mirante.model.Pessoa;
import br.com.desafio.mirante.service.PessoaService;

@RestController
public class PessoaController {
	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(method=RequestMethod.POST, value="/pessoas", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa Pessoa){
		Pessoa opCadastro = new Pessoa();
		opCadastro = pessoaService.cadastrar(Pessoa);
		return new ResponseEntity<Pessoa>(opCadastro,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaPessoas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pessoa>> buscarPessoa(){
		Collection<Pessoa> opList = pessoaService.buscarTodos();
		return new ResponseEntity<>(opList, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaPessoasPorId/{id_pessoa}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> buscarPessoaPorID(@PathVariable Integer id_pessoa){
		Pessoa pessoa = pessoaService.buscaPorId(id_pessoa);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/excluiPessoa/{id}")
	public ResponseEntity<Pessoa> excluirPessoa(@PathVariable Integer id){
		
		Pessoa PessoaExcluir = pessoaService.buscaPorId(id);
		if(PessoaExcluir == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		pessoaService.excluir(PessoaExcluir);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/alteraPessoa", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> alterarPessoa(@RequestBody Pessoa Pessoa){
		Pessoa op = pessoaService.alterar(Pessoa);
		return new ResponseEntity<Pessoa>(op, HttpStatus.OK);
	}

}
