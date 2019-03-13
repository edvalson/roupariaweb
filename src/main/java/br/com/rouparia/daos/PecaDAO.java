package br.com.rouparia.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Peca;

@Repository
public class PecaDAO extends AbstractDAO<Peca> {

	@Override
	public Class<Peca> entityClass() {
		return Peca.class;
	}
	
	public List<Peca> buscar(Peca filtro){
		String str = "select p from Peca p where upper(nome) like upper(:nome)";
		
		
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getTamanho() != null && !filtro.getTamanho().isEmpty()){
			str+=" and p.tamanho = :tamanho";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getTamanho() != null && !filtro.getTamanho().isEmpty()){
			query.setParameter("tamanho", filtro.getTamanho());
		}
		return query.getResultList();
	}

}
