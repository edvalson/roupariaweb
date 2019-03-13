package br.com.rouparia.daos;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Funcionario;;

@Repository
public class FuncionarioDAO extends AbstractDAO<Funcionario> {

	@Override
	public Class<Funcionario> entityClass() {
		return Funcionario.class;
	}
	
	public List<Funcionario> buscar(Funcionario filtro){
		String str = "select f from Funcionario f where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getMatricula() != null && !filtro.getMatricula().isEmpty()){
			str+=" and f.matricula = :matricula";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getMatricula() != null && !filtro.getMatricula().isEmpty()){
			query.setParameter("matricula", filtro.getMatricula());
		}
		return query.getResultList();
	}

}
