package com.registro.usuarios.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.registro.usuarios.entity.Eventos;
import com.registro.usuarios.service.Impl.EventoServiceImpl;

@Controller
@RequestMapping
public class EventosController {

	@Autowired
	private EventoServiceImpl eventoServiceImpl;
	
	@GetMapping("/ListarEventosUser")
	public String listar2(Model model) {
		List<Eventos>eventos= eventoServiceImpl.Listar();
		model.addAttribute("eventos", eventos);
		return "User/ListarEventosUser";
	}
	
	@GetMapping("/ListarEventos")
	public String listar(Model model) {
		List<Eventos>eventos= eventoServiceImpl.Listar();
		model.addAttribute("eventos", eventos);
		return "Admin/ListarEventos";
	}
	@GetMapping("Admin/Eventos")
	public String agregar(Model model) {
		model.addAttribute("eventos", new Eventos());
		return "Admin/Eventos";
	}
	@PostMapping("/guardarEventos")
	public String save(@RequestParam("file") MultipartFile file,@Valid Eventos eventos, Model model) {
		
		if (!file.isEmpty()) {
			Path directorioImg = Paths.get("src//main//resources/files");
			String rutaAbsoluta = directorioImg.toFile().getAbsolutePath();
			try {
				byte[] bytesimg = file.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + file.getOriginalFilename());
				Files.write(rutaCompleta, bytesimg);
				
				eventos.setImagen(file.getOriginalFilename());
				
			} catch (Exception e) {
				
			}
		}
		eventoServiceImpl.save(eventos);	
		return "redirect:/ListarEventos";
	}
	
	@GetMapping("/editarEventos/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Eventos>eventos=eventoServiceImpl.ListarId(id);
		model.addAttribute("eventos", eventos);
		return "Admin/Eventos";
	}
	@GetMapping("/eliminarEventos/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		eventoServiceImpl.delete(id);
		return "redirect:/ListarEventos";
	}
}
