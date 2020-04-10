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

import br.com.desafio.mirante.model.Operador;
import br.com.desafio.mirante.service.OperadorService;

@RestController
public class OperadorController {
	
	@Autowired(required=true)
	OperadorService operadorService;
	
	@RequestMapping(method=RequestMethod.POST, value="/operadores", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Operador> cadastrarOperador(@RequestBody Operador operador){
		Operador opCadastro = new Operador();
		opCadastro = operadorService.cadastrar(operador);
		return new ResponseEntity<Operador>(opCadastro,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listaoperadores", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Operador>> buscarOperador(){
		Collection<Operador> opList = operadorService.buscarTodos();
		return new ResponseEntity<>(opList, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/excluioperadores/{id}")
	public ResponseEntity<Operador> excluirOperador(@PathVariable Integer id){
		
		Operador operadorExcluir = operadorService.buscaPorId(id);
		if(operadorExcluir == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		operadorService.excluir(operadorExcluir);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/alteraoperadores", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Operador> alterarOperador(@RequestBody Operador operador){
		Operador op = operadorService.alterar(operador);
		return new ResponseEntity<Operador>(op, HttpStatus.OK);
	}
}
