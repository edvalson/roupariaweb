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

import br.com.rouparia.entities.Atendimento;
import br.com.rouparia.entities.Leito;
import br.com.rouparia.entities.Paciente;
import br.com.rouparia.services.AtendimentoService;
import br.com.rouparia.services.LeitoService;
import br.com.rouparia.services.PacienteService;


@RequestMapping(value="atendimento")
@Controller
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private LeitoService leitoService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Atendimento> atendimentos = atendimentoService.listar();
		map.addAttribute("atendimentos", atendimentos);
		map.addAttribute("filtro", new Atendimento());
		return "atendimento/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Atendimento filtro, ModelMap map){
		
		List<Atendimento> atendimentos = atendimentoService.buscar(filtro);
		map.addAttribute("atendimentos", atendimentos);
		map.addAttribute("filtro", filtro);
		return "atendimento/listar";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Atendimento atendimento = new Atendimento();
		map.addAttribute("atendimento", atendimento);
		map.addAttribute("pacientesSelect", selectPaciente());
		map.addAttribute("leitosSelect", selectLeito());
		return "atendimento/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("atendimento") @Valid Atendimento atendimento,BindingResult result, ModelMap map ){
		
		if(result.hasErrors()){
			map.addAttribute("atendimento", atendimento);
			map.addAttribute("pacientesSelect",  selectPaciente());
			map.addAttribute("leitosSelect",  selectLeito());
			return "atendimento/form";
			
		}
		
		if(atendimento.hasValidId()){
			atendimentoService.atualizar(atendimento);
		}
		else{
			atendimentoService.inserir(atendimento);
		}
		
		return "redirect:/atendimento/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		atendimentoService.remover(new Atendimento(id));
		return "redirect:/atendimento/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Atendimento atendimento = atendimentoService.buscarPorId(id);
		atendimento.setPacientes(new ArrayList<Long>());
		atendimento.getPacientes().add(1L);
		map.addAttribute("atendimento", atendimento);
		map.addAttribute("pacientesSelect",  selectPaciente());
		map.addAttribute("leitosSelect",  selectLeito());
		
		return "atendimento/form";
	}
	
	public Map<Long, String> selectPaciente(){
		List<Paciente> pacientes  = pacienteService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		mapa.put(0L, "Selecione");
		for (Paciente paciente : pacientes) {
			mapa.put(paciente.getId(), paciente.getNome());
		}
		return mapa;
	}
	
	
	public Map<Long, String> selectLeito(){
		List<Leito> leitos  = leitoService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		mapa.put(0L, "Selecione");
		for (Leito leito : leitos) {
			mapa.put(leito.getId(), leito.getNome());
		}
		return mapa;
	}
	
}
