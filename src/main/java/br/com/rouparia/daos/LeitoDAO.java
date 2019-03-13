package br.com.rouparia.daos;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Leito;

@Repository
public class LeitoDAO extends AbstractDAO<Leito> {

	@Override
	public Class<Leito> entityClass() {
		return Leito.class;
	}
	
	public List<Leito> buscar(Leito filtro){
		String str = "select l from Leito l where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getLocalizacao() != null && !filtro.getLocalizacao().isEmpty()){
			str+=" and l.localizacao = :localizacao";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getLocalizacao() != null && !filtro.getLocalizacao().isEmpty()){
			query.setParameter("localizacao", filtro.getLocalizacao());
		}
		return query.getResultList();
	}

}
