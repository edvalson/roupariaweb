package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.LeitoDAO;
import br.com.rouparia.entities.Leito;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LeitoService {

	@Autowired
	private LeitoDAO leitoDAO;

	public void inserir(Leito leito) {
		leitoDAO.inserir(leito);
	}

	public void atualizar(Leito leito) {
		leitoDAO.atualizar(leito);
	}

	public List<Leito> listar() {
		return leitoDAO.listar();
	}

	public void remover(Leito leito) {
		leitoDAO.remover(leito);
	}

	public Leito buscarPorId(Long id) {

		return leitoDAO.buscarPorId(id);
	}

	public List<Leito> buscar(Leito filtro) {

		return leitoDAO.buscar(filtro);

	}

}
