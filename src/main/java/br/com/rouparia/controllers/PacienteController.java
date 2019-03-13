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

import br.com.rouparia.entities.Paciente;
import br.com.rouparia.services.PacienteService;

@RequestMapping(value="paciente")
@Controller
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Paciente> pacientes = pacienteService.listar();
		map.addAttribute("pacientes", pacientes);
		map.addAttribute("filtro", new Paciente());
		return "paciente/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Paciente filtro, ModelMap map){
		
		List<Paciente> pacientes = pacienteService.buscar(filtro);
		map.addAttribute("pacientes", pacientes);
		map.addAttribute("filtro", filtro);
		return "paciente/listar";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Paciente paciente = new Paciente();
		map.addAttribute("paciente", paciente);
		return "paciente/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("paciente") @Valid Paciente paciente,BindingResult result, ModelMap map ){
		
		if(paciente.hasValidId()){
			pacienteService.atualizar(paciente);
		}
		else{
			pacienteService.inserir(paciente);
		}
		
		return "redirect:/paciente/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		pacienteService.remover(new Paciente(id));
		return "redirect:/paciente/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Paciente paciente = pacienteService.buscarPorId(id);
		map.addAttribute("paciente", paciente);
		return "paciente/form";
	}
	

}
