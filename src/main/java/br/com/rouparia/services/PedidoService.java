package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.PedidoDAO;
import br.com.rouparia.entities.Pedido;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PedidoService {

	@Autowired
	private PedidoDAO pedidoDAO;

	public void inserir(Pedido pedido) {
		pedidoDAO.inserir(pedido);
	}

	public void atualizar(Pedido pedido) {
		pedidoDAO.atualizar(pedido);
	}

	public List<Pedido> listar() {
		return pedidoDAO.listar();
	}

	public void remover(Pedido pedido) {
		pedidoDAO.remover(pedido);
	}

	public Pedido buscarPorId(Long id) {

		return pedidoDAO.buscarPorId(id);
	}

	public List<Pedido> buscarPedidoPorPaciente(Pedido filtro) {

		return pedidoDAO.buscarPedidoPorPaciente(filtro);

	}

}
