package br.com.desafio.mirante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.desafio.mirante.model.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador,Integer> {

}
		