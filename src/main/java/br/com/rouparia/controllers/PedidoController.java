package br.com.rouparia.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rouparia.entities.Paciente;
import br.com.rouparia.entities.Peca;
import br.com.rouparia.entities.Pedido;
import br.com.rouparia.services.PacienteService;
import br.com.rouparia.services.PecaService;
import br.com.rouparia.services.PedidoService;

@Controller
@RequestMapping(value="pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private PecaService pecaService;

	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map) {
		
		List<Pedido> pedidos = pedidoService.listar();
				
		map.addAttribute("pedidos", pedidos);
		map.addAttribute("selectPacientes", selectPacientes());
		map.addAttribute("selectPecas", selectPecas());
		map.addAttribute("filtro", new Pedido());
		return "/pedido/listar";
	}
	
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map) {
		Pedido pedido = new Pedido();
		pedido.setPaciente(new Paciente());
		map.addAttribute("pedido", pedido );
		map.addAttribute("selectPacientes", selectPacientes());
		map.addAttribute("selectPecas", selectPecas());
		return "/pedido/form";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable("id") Long id, ModelMap map) {
		Pedido pedido = pedidoService.buscarPorId(id);
		map.addAttribute("pedido", pedido );
		map.addAttribute("selectPacientes", selectPacientes());
		map.addAttribute("selectPecas", selectPecas());
		return "/pedido/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("pedido") @Valid Pedido pedido, ModelMap map) {
		try {
			if(pedido.hasValidId()){
				pedidoService.atualizar(pedido);
			}else{
				pedidoService.inserir(pedido);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/pedido/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable("id") Long id){
		Pedido pedido = pedidoService.buscarPorId(id);
		if(pedido != null){
			try {
				pedidoService.remover(pedido);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/pedido/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Pedido filtro, ModelMap map) {
		try {
			if(!filtro.getPaciente().hasValidId()){
				return "redirect:/pedido/listar";
			}

			List<Pedido> pedidos = pedidoService.buscarPedidoPorPaciente(filtro);
			
			map.addAttribute("pedidos", pedidos);
			map.addAttribute("selectPacientes", selectPacientes());
			map.addAttribute("selectPecas", selectPecas());
			map.addAttribute("filtro", filtro);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/pedido/listar";
	}
	
	
	public Map<Long, String> selectPacientes(){
		List<Paciente> pacientes = pacienteService.listar();
		Map<Long, String> mapa = new HashMap<Long, String>();
		mapa.put(0L, "selecione");
		for(Paciente paciente:pacientes){
			
			mapa.put(paciente.getId(), paciente.getNome());
		}
		
		return mapa;
	}
	
	public Map<Long, String> selectPecas(){
		List<Peca> pecas = pecaService.listar();
		Map<Long, String> mapa = new HashMap<Long, String>();
		mapa.put(0L, "selecione");
		for(Peca peca:pecas){	
		mapa.put(peca.getId(), peca.getNome());
		}
		return mapa;
	}
}
