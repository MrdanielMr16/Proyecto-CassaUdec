package com.registro.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.entity.Pacientes;
import com.registro.usuarios.entity.estadoSalud;
import com.registro.usuarios.service.PacientesService;
import com.registro.usuarios.service.ValoracionesService;

@Controller
public class ValoracionesController {
	
	@Autowired
	private ValoracionesService service;
	
	@Autowired
	private PacientesService pacientesService;
	
	@GetMapping("Admin/ListarValoraciones")
	public String ListarValoraciones(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarValoraciones";
	}
	
	@GetMapping("/ListarEstadoSalud")
	public String EstadoSalud(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarEstadoSalud";
	}
	
	@GetMapping("/ListarFactoresFamiliar")
	public String FactoresFamiliar(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarFactoresFamiliar";
	}
	
	@GetMapping("/ListarPatron")
	public String PatronVida(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarPatron";
	}
	
	@GetMapping("/ListarFactoresAmbientales")
	public String FactoresAmbientales(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarFactoresAmbientales";
	}
	
	@GetMapping("/ListarOrientacion")
	public String OrientacionSociocultural(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarOrientacion";
	}
	
	@GetMapping("/ListarRecursos")
	public String Recursos(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarRecursos";
	}
	
	@GetMapping("/ListarRequisitosDesarrollo")
	public String RequisitosDesarrollo(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarRequisitosDesarrollo";
	}
	
	@GetMapping("/ListarRequisitosAutocuidado")
	public String RequisitosAutocuidado(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarRequisitosAutocuidado";
	}
	@GetMapping("/ListarNanda")
	public String Nanda(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarNanda";
	}
	
	@GetMapping("/ListarNoc")
	public String Noc(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarNoc";
	}
	
	@GetMapping("/ListarNic")
	public String Nic(Model model) {
		List<estadoSalud> listavaloraciones = service.findAll();
		model.addAttribute("valoraciones", listavaloraciones);
		return "Admin/ListarNic";
	}
	
	@GetMapping("/nuevaValoracion")
	public String nuevaValoracion(Model model) {
		List<Pacientes> listaPacientes = pacientesService.findAll();
		model.addAttribute("valoraciones", new estadoSalud());
		model.addAttribute("listaPacientes", listaPacientes);
		return "Admin/nuevaValoracion";
	}
	
	@PostMapping("/guardarValoracion")
	public String guardarValoracion(estadoSalud estadoSalud) {
		service.save(estadoSalud);
		return "redirect:Admin/ListarValoraciones";
	}
	
	
	
	

}
