/*
 * Programadora: Rebeca Divina Paula
 */
package br.com.desafio.mirante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafio.mirante.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="Select u from Usuario u where u.login=:plogin")
	public Usuario buscarPorLogin(@Param("plogin") String login);
	
}
