package com.registro.usuarios.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registro.usuarios.InterfaceService.CartillasInterfaceServicio;
import com.registro.usuarios.entity.Cartillas;
import com.registro.usuarios.service.CartillasService;


@Controller
public class CartillasController {

	@Autowired
	private CartillasService cartillasService;
	
	@Autowired 
	@Lazy
	private CartillasInterfaceServicio cartillasInterfaceServicio;
	
	@GetMapping("/ListarCartillasUser")
	public String listar2(Model model) {
		List<Cartillas>cartillas = cartillasInterfaceServicio.Listar();
		model.addAttribute("cartillas", cartillas);
		return "User/ListarCartillasUser";
	}
	
	@PostMapping("/guardarCartillas")
	public String GuardarCartillas(Cartillas cartillas, @RequestParam("cartillas") MultipartFile file,RedirectAttributes attributes) throws IOException {
		String ArchivoNombre = StringUtils.cleanPath(file.getOriginalFilename());
		cartillas.setNombre_archivo(ArchivoNombre);
		cartillas.setContenido(file.getBytes());
		cartillas.setTamanio(file.getSize());
		cartillas.setFecha_Subida(new Date());
		
		cartillasService.save(cartillas);

		attributes.addFlashAttribute("message", "El archivo se ha subido correctamente");
		return "redirect:/ListarCartillas";
	}
	
	@GetMapping("/descargar")
	public void DescargarCartilla(@Param("id") Long id,HttpServletResponse response) throws Exception {
		Optional<Cartillas> resultado = cartillasService.findById(id);
		if (!resultado.isPresent()) {
			throw new Exception("No se pudo encontrar el documento con el ID: " + id);
		}
		
		Cartillas cartillas = resultado.get();
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + cartillas.getNombre_archivo();
		
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = response.getOutputStream();
		
		outputStream.write(cartillas.getContenido());
		outputStream.close();
	}
	
	@GetMapping("Admin/Cartillas")
	public String agregar(Model model) {
		model.addAttribute("cartillas", new Cartillas());
		return "Admin/Cartillas";
	}
	
	@GetMapping("/ListarCartillas")
	public String listarCartillas(Model model) {
		List<Cartillas>cartillas= cartillasInterfaceServicio.Listar();
		model.addAttribute("cartillas", cartillas);
		return "Admin/ListarCartillas";
	}
	
	@GetMapping("/eliminarCartillas/{id}")
	public String eliminar(Model model, @PathVariable Long id) {
		cartillasInterfaceServicio.delete(id);
		return "redirect:/ListarCartillas";
	}
}
