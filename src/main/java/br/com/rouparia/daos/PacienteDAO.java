package br.com.rouparia.daos;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Paciente;

@Repository
public class PacienteDAO extends AbstractDAO<Paciente> {

	@Override
	public Class<Paciente> entityClass() {
		return Paciente.class;
	}
	
	public List<Paciente> buscar(Paciente filtro){
		String str = "select p from Paciente p where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getSobrenome() != null && !filtro.getSobrenome().isEmpty()){
			str+=" and p.sobrenome = :sobrenome";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getSobrenome() != null && !filtro.getSobrenome().isEmpty()){
			query.setParameter("sobrenome", filtro.getSobrenome());
		}
		return query.getResultList();
	}

}
