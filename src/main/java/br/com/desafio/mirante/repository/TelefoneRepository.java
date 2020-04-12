package br.com.desafio.mirante.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafio.mirante.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Integer>{

	@Query(value = " SELECT T FROM Telefone T join T.pessoa P WHERE P.id_pessoa = :id_pessoa")
	public Collection<Telefone> buscarPorIdPessoa(@Param("id_pessoa") Integer id_pessoa);
	
	
}
