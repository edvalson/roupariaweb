package br.com.rouparia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.CategoriaDAO;
import br.com.rouparia.entities.Categoria;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	public void inserir(Categoria categoria) {
		categoriaDAO.inserir(categoria);
	}

	public void atualizar(Categoria categoria) {
		categoriaDAO.atualizar(categoria);
	}

	public List<Categoria> listar() {
		return categoriaDAO.listar();
	}

	public void remover(Categoria categoria) {
		categoriaDAO.remover(categoria);
	}

	public Categoria buscarPorId(Long id) {

		return categoriaDAO.buscarPorId(id);
	}
}
