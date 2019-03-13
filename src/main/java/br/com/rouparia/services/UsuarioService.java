package br.com.rouparia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rouparia.daos.UsuarioDAO;
import br.com.rouparia.entities.Usuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario logar(String login, String senha) {
		return usuarioDAO.logar(login, senha);
	}

}
