package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.AtendimentoDAO;
import br.com.rouparia.entities.Atendimento;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AtendimentoService {

	@Autowired
	private AtendimentoDAO atendimentoDAO;

	public void inserir(Atendimento atendimento) {
		atendimentoDAO.inserir(atendimento);
	}

	public void atualizar(Atendimento atendimento) {
		atendimentoDAO.atualizar(atendimento);
	}

	public List<Atendimento> listar() {
		return atendimentoDAO.listar();
	}

	public void remover(Atendimento atendimento) {
		atendimentoDAO.remover(atendimento);
	}

	public Atendimento buscarPorId(Long id) {

		return atendimentoDAO.buscarPorId(id);
	}

	public List<Atendimento> buscar(Atendimento filtro) {

		return atendimentoDAO.buscar(filtro);

	}

}
