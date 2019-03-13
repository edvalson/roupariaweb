package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.FuncionarioDAO;
import br.com.rouparia.entities.Funcionario;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FuncionarioService {

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	public void inserir(Funcionario funcionario) {
		funcionarioDAO.inserir(funcionario);
	}

	public void atualizar(Funcionario funcionario) {
		funcionarioDAO.atualizar(funcionario);
	}

	public List<Funcionario> listar() {
		return funcionarioDAO.listar();
	}

	public void remover(Funcionario funcionario) {
		funcionarioDAO.remover(funcionario);
	}

	public Funcionario buscarPorId(Long id) {

		return funcionarioDAO.buscarPorId(id);
	}

	public List<Funcionario> buscar(Funcionario filtro) {

		return funcionarioDAO.buscar(filtro);

	}

}
