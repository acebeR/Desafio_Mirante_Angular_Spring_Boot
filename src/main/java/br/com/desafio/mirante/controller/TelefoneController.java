package br.com.desafio.mirante.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.mirante.model.Telefone;
import br.com.desafio.mirante.service.TelefoneService;

@RestController
public class TelefoneController {

	@Autowired
	private TelefoneService telefoneService;
	
	@RequestMapping(method=RequestMethod.POST, value="/telefones", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> cadastrarTelefone(@RequestBody Telefone telefone){
		Telefone tCadastro = new Telefone();
		tCadastro = telefoneService.cadastrar(telefone);
		return new ResponseEntity<Telefone>(tCadastro,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaTelefones", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Telefone>> buscarTelefone(){
		Collection<Telefone> tList = telefoneService.buscarTodos();
		return new ResponseEntity<>(tList, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaTelefonespessoa/{id_pessoa}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Telefone>> buscarTelefonesPorPessoa(@PathVariable Integer id_pessoa){
		Collection<Telefone> tList = telefoneService.buscarPorPessoa(id_pessoa);
		return new ResponseEntity<>(tList, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/excluiTelefones/{id}")
	public ResponseEntity<Telefone> excluirTelefone(@PathVariable Integer id){
		
		Telefone telefoneExcluir = telefoneService.buscarPorId(id);
		if(telefoneExcluir == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		telefoneService.excluir(telefoneExcluir);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/alteraTelefones", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> alterarTelefone(@RequestBody Telefone telefone){
		Telefone tel = telefoneService.alterar(telefone);
		return new ResponseEntity<Telefone>(tel, HttpStatus.OK);
	}
}
