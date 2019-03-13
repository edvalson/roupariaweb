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

import br.com.rouparia.services.PecaService;
//import br.com.rouparia.services.CategoriaService;
import br.com.rouparia.entities.Peca;
//import br.com.rouparia.entities.Categoria;

@RequestMapping(value="peca")
@Controller
public class PecaController {
	
	@Autowired
	private PecaService pecaService;
	
	//@Autowired
	//private CategoriaService categoriaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Peca> pecas = pecaService.listar();
		map.addAttribute("pecas", pecas);
		map.addAttribute("filtro", new Peca());
		return "peca/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Peca filtro, ModelMap map){
		
		List<Peca> pecas = pecaService.buscar(filtro);
		map.addAttribute("pecas", pecas);
		map.addAttribute("filtro", filtro);
		return "peca/listar";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Peca peca = new Peca();
		map.addAttribute("peca", peca);
		return "peca/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("peca") @Valid Peca peca,BindingResult result, ModelMap map ){
		
		/*if(result.hasErrors()){
			map.addAttribute("cardapio", cardapio);
			map.addAttribute("categoriasSelect",  selectCategoria());
			return "cardapio/form";
			
		} */
		if(peca.hasValidId()){
			pecaService.atualizar(peca);
		}
		else{
			pecaService.inserir(peca);
		}
		
		return "redirect:/peca/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		pecaService.remover(new Peca(id));
		return "redirect:/peca/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Peca peca = pecaService.buscarPorId(id);
		//cardapio.setCategorias(new ArrayList<Long>());
		//cardapio.getCategorias().add(1L);
		map.addAttribute("peca", peca);
		//map.addAttribute("categoriasSelect",  selectCategoria());
		return "peca/form";
	}
	
	
	/* public Map<Long, String> selectCategoria(){
		List<Categoria> categorias  = categoriaService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		mapa.put(0L, "Selecione");
		for (Categoria categoria : categorias) {
			mapa.put(categoria.getId(), categoria.getNome());
		}
		return mapa;
	} */
	
	
	
	
	

}
