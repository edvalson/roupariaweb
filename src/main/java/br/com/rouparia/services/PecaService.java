package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.PecaDAO;
import br.com.rouparia.entities.Peca;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PecaService {

	@Autowired
	private PecaDAO pecaDAO;

	public void inserir(Peca peca) {
		pecaDAO.inserir(peca);
	}

	public void atualizar(Peca peca) {
		pecaDAO.atualizar(peca);
	}

	public List<Peca> listar() {
		return pecaDAO.listar();
	}

	public void remover(Peca peca) {
		pecaDAO.remover(peca);
	}

	public Peca buscarPorId(Long id) {

		return pecaDAO.buscarPorId(id);
	}

	public List<Peca> buscar(Peca filtro) {

		return pecaDAO.buscar(filtro);

	}

}
