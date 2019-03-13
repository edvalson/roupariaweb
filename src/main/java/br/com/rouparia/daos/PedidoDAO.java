package br.com.rouparia.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.Pedido;



@Repository
public class PedidoDAO extends AbstractDAO<Pedido> {

	@Override
	public Class<Pedido> entityClass() {
		return Pedido.class;
	}
	
	public List<Pedido> buscarPedidoPorPaciente(Pedido filtro){
		String str = "select p from Pedido p where id = :id";
		if(filtro.getId() == null){
			filtro.setId(null);
		}
		
		Query query=manager.createQuery(str);   
		
		query.setParameter("id", filtro.getId());
		
				return query.getResultList();
	}

}
