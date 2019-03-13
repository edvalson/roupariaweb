package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.EstoqueDAO;
import br.com.rouparia.entities.Estoque;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EstoqueService {

	@Autowired
	private EstoqueDAO estoqueDAO;

	public void inserir(Estoque estoque) {
		estoqueDAO.inserir(estoque);
	}

	public void atualizar(Estoque estoque) {
		estoqueDAO.atualizar(estoque);
	}

	public List<Estoque> listar() {
		return estoqueDAO.listar();
	}

	public void remover(Estoque estoque) {
		estoqueDAO.remover(estoque);
	}

	public Estoque buscarPorId(Long id) {

		return estoqueDAO.buscarPorId(id);
	}

	public List<Estoque> buscar(Estoque filtro) {

		return estoqueDAO.buscar(filtro);

	}

}
