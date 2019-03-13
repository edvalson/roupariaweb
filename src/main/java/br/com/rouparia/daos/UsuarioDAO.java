package br.com.rouparia.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Usuario;

@Repository
public class UsuarioDAO extends AbstractDAO<Usuario> {

	@Override
	public Class<Usuario> entityClass() {
		return Usuario.class;
	}
	
	public Usuario logar(String login, String senha){
		
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios =  query.getResultList();
		
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
	
	
}
