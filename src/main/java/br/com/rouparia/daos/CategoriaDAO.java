package br.com.rouparia.daos;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Categoria;

@Repository
public class CategoriaDAO extends AbstractDAO<Categoria> {

	@Override
	public Class<Categoria> entityClass() {
		return Categoria.class;
	}
	
	

}
