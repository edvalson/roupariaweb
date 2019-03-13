package br.com.rouparia.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rouparia.entities.Estoque;
import br.com.rouparia.entities.Peca;
import br.com.rouparia.services.EstoqueService;
import br.com.rouparia.services.PecaService;


@RequestMapping(value="estoque")
@Controller
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private PecaService pecaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Estoque> estoques = estoqueService.listar();
		map.addAttribute("estoques", estoques);
		map.addAttribute("filtro", new Estoque());
		return "estoque/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Estoque filtro, ModelMap map){
		
		List<Estoque> estoques = estoqueService.buscar(filtro);
		map.addAttribute("estoques", estoques);
		map.addAttribute("filtro", filtro);
		return "estoque/listar";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Estoque estoque = new Estoque();
		map.addAttribute("estoque", estoque);
		return "estoque/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("estoque") @Valid Estoque estoque,BindingResult result, ModelMap map ){
		
		if(result.hasErrors()){
			map.addAttribute("estoque", estoque);
			map.addAttribute("pecasSelect",  selectPeca());
			return "estoque/form";
			
		} 
		if(estoque.hasValidId()){
			estoqueService.atualizar(estoque);
		}
		else{
			estoqueService.inserir(estoque);
		}
		
		return "redirect:/estoque/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		estoqueService.remover(new Estoque(id));
		return "redirect:/estoque/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Estoque estoque = estoqueService.buscarPorId(id);
		map.addAttribute("estoque", estoque);
		map.addAttribute("pecasSelect",  selectPeca());
		return "estoque/form";
	}
	
	
	 public Map<Long, String> selectPeca(){
		List<Peca> pecas  = pecaService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		mapa.put(0L, "Selecione");
		for (Peca peca : pecas) {
			mapa.put(peca.getId(), peca.getNome());
		}
		return mapa;
	} 
	
	
	
	
	

}
