package br.com.rouparia.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rouparia.services.UsuarioService;
import br.com.rouparia.entities.Usuario;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "loginForm"}, method=RequestMethod.GET)
	public String form(ModelMap map){
		map.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession sessao, ModelMap map){
		if(result.hasErrors() ){
			map.addAttribute("usuario", usuario);
			return  "login";
		}
		Usuario usuarioBD = usuarioService.logar(usuario.getLogin(), usuario.getSenha()); 
		if(usuarioBD == null){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			return  "login";
		}
		sessao.setAttribute("usuario", usuario);
		return "redirect:/atendimento/listar";
	}
	
	
}
