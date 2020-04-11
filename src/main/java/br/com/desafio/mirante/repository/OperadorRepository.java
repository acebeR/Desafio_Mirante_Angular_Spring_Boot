/*
 * Programadora: Rebeca Divina Paula
 */
package br.com.desafio.mirante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.desafio.mirante.model.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador,Integer> {

	@Query(value="Select op from Operador op join op.usuario u where u.login=:plogin")
	public Operador buscarPorUsuario(@Param("plogin") String login);
}
	