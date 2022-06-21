package com.registro.usuarios.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.dto.CambiarPassword;
import com.registro.usuarios.entity.Rol;
import com.registro.usuarios.entity.Usuario;
import com.registro.usuarios.repository.RolRepository;
import com.registro.usuarios.service.UsuarioService;

@Controller
public class UsuarioController {

	
	@Autowired
	UsuarioService service;
	
	@Autowired
	RolRepository repository;
	
	@GetMapping({"/","/login"})
	public String index(){
	return "Index";
	}
	
	
	@RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {
        
        String roles =  authResult.getAuthorities().toString();
        
        if(roles.contains("ADMIN")){
         response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/InicioAdmin"));                            
         }
         else if(roles.contains("USER")) {
             response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/indexUser"));
         }
    }
	
	@GetMapping("/InicioAdmin")
	public String InicioAdmin() {
		return "Usuario-Form/InicioAdmin";
	}
	
	@GetMapping("/indexUser")
	public String PaginaUsuario() {
		return "User/indexUser";
	}
	
	@GetMapping("User/ListarCartillasUser")
	public String PaginaDeCartillas() {
		return "User/ListarCartillasUser";
	}
	
	@GetMapping("User/ListarEventosUser")
	public String PaginaDeEventos() {
		return "User/ListarEventosUser";
	}
	
	@GetMapping("/Jmemoriad")
	public String PaginaDeMemoriaad() {
		return "User/Jmemoriad";
	}
	
	@GetMapping("/Jmemoriaa")
	public String PaginaDeMemoriaaa() {
		return "User/Jmemoriaa";
	}
	
	@GetMapping("/Jmemoriah")
	public String PaginaDeMemoriaah() {
		return "User/Jmemoriah";
	}
	
	@GetMapping("/Sopaa")
	public String PaginaDeSopaa() {
		return "User/Sopaa";
	}
	
	@GetMapping("/Sopah")
	public String PaginaDeSopah() {
		return "User/Sopah";
	}
	
	@GetMapping("/Sopaletrasd")
	public String PaginaDeSopad() {
		return "User/Sopaletrasd";
	}
	
	@GetMapping("/Actividades")
	public String PaginaDeActividades() {
		return "User/Actividades";
	}
	
	@GetMapping("/Valoracion")
	public String PaginaDeValoracion() {
		return "Admin/Valoracion";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		Rol UsuarioRol = repository.findByNombre("USER");
		List<Rol> roles = Arrays.asList(UsuarioRol);
		model.addAttribute("FormularioUsuarios", new Usuario());
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		return "Usuario-Form/user-signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@Valid @ModelAttribute("FormularioUsuarios")Usuario usuario,BindingResult result,Model model) {
		Rol UsuarioRol = repository.findByNombre("USER");
		List<Rol> roles = Arrays.asList(UsuarioRol);
		model.addAttribute("FormularioUsuarios", usuario);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if (result.hasErrors()) {
			return "Usuario-Form/user-signup";
			
		}else {
			try {
				service.crearUsuario(usuario);
				
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		model.addAttribute("UsuariosList", service.getAllUsuarios());
		model.addAttribute("roles",repository.findAll());
		
		return index();
	}
	
	
	@GetMapping("/FormUsuario")
	public String FormUsuario(Model model) {
		model.addAttribute("FormularioUsuarios", new Usuario());
		model.addAttribute("roles",repository.findAll());
		model.addAttribute("UsuariosList", service.getAllUsuarios());
		model.addAttribute("listTab","active");
		return "Usuario-Form/Usuario-View";
	}
	
	
	@PostMapping("/FormUsuario")
	public String CrearUsuario(@Valid @ModelAttribute("FormularioUsuarios")Usuario usuario,BindingResult result,ModelMap model) {
	
		if (result.hasErrors()) {
			model.addAttribute("FormularioUsuarios", usuario);
			model.addAttribute("formTab","active");
			
		}else {
			try {
				service.crearUsuario(usuario);
				model.addAttribute("FormularioUsuarios", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("FormularioUsuarios", usuario);
				model.addAttribute("formTab","active");
				model.addAttribute("UsuariosList", service.getAllUsuarios());
				model.addAttribute("roles",repository.findAll());
			}
		}
		model.addAttribute("UsuariosList", service.getAllUsuarios());
		model.addAttribute("roles",repository.findAll());
		
		return "Usuario-Form/Usuario-View";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String getEditarUsuarioForm(Model model,@PathVariable(name = "id")Long id)throws Exception{
		Usuario UsuarioToEdit = service.getUsuarioById(id);
		model.addAttribute("FormularioUsuarios",  UsuarioToEdit);
		model.addAttribute("roles",repository.findAll());
		model.addAttribute("UsuariosList", service.getAllUsuarios());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new CambiarPassword(id));
		return "Usuario-Form/Usuario-View";
	}
	
	@PostMapping("/editarUsuario")
	public String postEditarUsuarioForm(@Valid @ModelAttribute("FormularioUsuarios")Usuario usuario,BindingResult result,ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("FormularioUsuarios", usuario);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new CambiarPassword(usuario.getId()));

		}else {
			try {
				service.ActualizarUsuario(usuario);
				model.addAttribute("FormularioUsuarios", new Usuario());
				model.addAttribute("listTab","active");
				model.addAttribute("editMode","false");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("FormularioUsuarios", usuario);
				model.addAttribute("formTab","active");
				model.addAttribute("UsuariosList", service.getAllUsuarios());
				model.addAttribute("roles",repository.findAll());
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new CambiarPassword(usuario.getId()));

			}
		}
		model.addAttribute("UsuariosList", service.getAllUsuarios());
		model.addAttribute("roles",repository.findAll());
		
		return "Usuario-Form/Usuario-View";
	}
	
	@GetMapping("/FormUsuario/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/FormUsuario";
	}
	
	@GetMapping("/BorrarUsuario/{id}")
	public String borrarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			service.borrarUsuario(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return "redirect:/FormUsuario";
	}
	
	@PostMapping("/editarUsuario/cambiarPassword")
	public ResponseEntity<String> postEditUseChangePassword(@Valid @RequestBody CambiarPassword form, Errors errors) {
		try {
			if (errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

            throw new Exception(result);
			}
			service.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
}
