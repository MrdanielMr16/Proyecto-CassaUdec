package com.registro.usuarios.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.entity.Pacientes;
import com.registro.usuarios.service.Impl.PacienteServiceImpl;



@Controller
@RequestMapping
public class PacientesController {

	@Autowired
	private PacienteServiceImpl pacientesService;
	
	@GetMapping("/ListarPacientes")
	public String listar(Model model) {
		List<Pacientes>pacientes= pacientesService.Listar();
		model.addAttribute("pacientes", pacientes);
		return "Admin/ListarPacientes";
	}
	
	@GetMapping("/RPacientes")
	public String agregar(Model model) {
		
		model.addAttribute("paciente", new Pacientes());
		return "Admin/RPacientes";
	}
	@PostMapping("/guardar")
	public String save(@Valid Pacientes pacientes, Model model) {
		pacientesService.save(pacientes);
		return "redirect:/ListarPacientes";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Pacientes>paciente=pacientesService.ListarId(id);
		model.addAttribute("paciente", paciente);
		return "Admin/RPacientes";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		pacientesService.delete(id);
		return "redirect:/ListarPacientes";
	}
	
	
	
	@GetMapping("Cartillas")
	public String VerPaginaDeCartillas() {
		return "Admin/Cartillas";
	}
}
