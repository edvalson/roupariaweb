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

import br.com.rouparia.entities.Funcionario;
import br.com.rouparia.services.FuncionarioService;

@RequestMapping(value="funcionario")
@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Funcionario> funcionarios = funcionarioService.listar();
		map.addAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", new Funcionario());
		return "funcionario/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Funcionario filtro, ModelMap map){
		
		List<Funcionario> funcionarios = funcionarioService.buscar(filtro);
		map.addAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", filtro);
		return "funcionario/listar";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Funcionario funcionario = new Funcionario();
		map.addAttribute("funcionario", funcionario);
		return "funcionario/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("funcionario") @Valid Funcionario funcionario,BindingResult result, ModelMap map ){
		
		if(funcionario.hasValidId()){
			funcionarioService.atualizar(funcionario);
		}
		else{
			funcionarioService.inserir(funcionario);
		}
		
		return "redirect:/funcionario/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		funcionarioService.remover(new Funcionario(id));
		return "redirect:/funcionario/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		map.addAttribute("funcionario", funcionario);
		return "funcionario/form";
	}
	

}
