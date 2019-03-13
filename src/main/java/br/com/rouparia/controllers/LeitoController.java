package br.com.rouparia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rouparia.entities.Leito;
import br.com.rouparia.services.LeitoService;

@RequestMapping(value="leito")
@Controller
public class LeitoController {
	
	@Autowired
	private LeitoService leitoService;
	
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Leito> leitos = leitoService.listar();
		map.addAttribute("leitos", leitos);
		map.addAttribute("filtro", new Leito());
		return "leito/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Leito filtro, ModelMap map){
		
		List<Leito> leitos = leitoService.buscar(filtro);
		map.addAttribute("leitos", leitos);
		map.addAttribute("filtro", filtro);
		return "leito/listar";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Leito leito = new Leito();
		map.addAttribute("leito", leito);
		return "leito/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("leito") @Valid Leito leito,BindingResult result, ModelMap map ){
		
		
		if(leito.hasValidId()){
			leitoService.atualizar(leito);
		}
		else{
			leitoService.inserir(leito);
		}
		
		return "redirect:/leito/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		leitoService.remover(new Leito(id));
		return "redirect:/leito/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Leito leito = leitoService.buscarPorId(id);
		map.addAttribute("leito", leito);
		return "leito/form";
	}
	
	
	
}
