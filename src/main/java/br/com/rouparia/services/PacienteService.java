package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.PacienteDAO;
import br.com.rouparia.entities.Paciente;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PacienteService {

	@Autowired
	private PacienteDAO pacienteDAO;

	public void inserir(Paciente paciente) {
		pacienteDAO.inserir(paciente);
	}

	public void atualizar(Paciente paciente) {
		pacienteDAO.atualizar(paciente);
	}

	public List<Paciente> listar() {
		return pacienteDAO.listar();
	}

	public void remover(Paciente paciente) {
		pacienteDAO.remover(paciente);
	}

	public Paciente buscarPorId(Long id) {

		return pacienteDAO.buscarPorId(id);
	}

	public List<Paciente> buscar(Paciente filtro) {

		return pacienteDAO.buscar(filtro);

	}

}
