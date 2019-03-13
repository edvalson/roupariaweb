package br.com.rouparia.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.rouparia.entities.AbstractEntity;
import br.com.rouparia.entities.Pedido;

public abstract class AbstractDAO<T extends AbstractEntity> {

	@PersistenceContext
	protected EntityManager manager;

	

	public void inserir(T entity) {
		manager.persist(entity);
	}

	public void atualizar(T entity) {
		manager.merge(entity);
	}

	public void remover(T entity) {
		entity = manager.find(entityClass(), entity.getId());
		manager.remove(entity);

	}

	public T buscarPorId(Long id) {
		return manager.find(entityClass(), id);
	}

	public List<T> listar() {
		Query query = manager.createQuery("select p from "
				+ entityClass().getSimpleName() + " p");
		return  query.getResultList();
	}

	public abstract Class<T> entityClass();

}
