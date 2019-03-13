package br.com.rouparia.daos;

import org.springframework.stereotype.Repository;

import br.com.rouparia.entities.ItemPedido;

@Repository
public class ItemPedidoDAO extends AbstractDAO<ItemPedido>{

	
	@Override
	public Class<ItemPedido> entityClass() {
		return ItemPedido.class;
	}

}
