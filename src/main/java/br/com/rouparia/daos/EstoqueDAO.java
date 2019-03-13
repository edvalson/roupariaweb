package br.com.rouparia.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Estoque;



@Repository
public class EstoqueDAO extends AbstractDAO<Estoque> {

	@Override
	public Class<Estoque> entityClass() {
		return Estoque.class;
	}
	
	public List<Estoque> buscar(Estoque filtro){
		String str = "select e from Estoque e where upper(nome) like upper(:nome)";
		
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		
		return query.getResultList();
	}

}
