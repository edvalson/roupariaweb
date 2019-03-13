package br.com.rouparia.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Atendimento;

@Repository
public class AtendimentoDAO extends AbstractDAO<Atendimento> {

	@Override
	public Class<Atendimento> entityClass() {
		return Atendimento.class;
	}
	
	public List<Atendimento> buscar(Atendimento filtro){
		String str = "select a from Atendimento a where id = :id";
		
		if(filtro.getId() == null){
			filtro.setId(null);
		}
				
		Query query=manager.createQuery(str);   
		
		 query.setParameter("id", filtro.getId());
		//query.setParameter("id", "%"+filtro.getId()+"%");
		
		return query.getResultList();
	}

}
