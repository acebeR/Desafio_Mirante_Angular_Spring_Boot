package br.com.desafio.mirante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.mirante.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer>{

}
