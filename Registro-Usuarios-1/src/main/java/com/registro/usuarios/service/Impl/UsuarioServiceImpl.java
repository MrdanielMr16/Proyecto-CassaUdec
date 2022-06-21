package com.registro.usuarios.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.dto.CambiarPassword;
import com.registro.usuarios.entity.Usuario;
import com.registro.usuarios.repository.UsuarioRepositorio;
import com.registro.usuarios.service.UsuarioService;

@Service

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepositorio repositorio;
	
	private final BCryptPasswordEncoder encoder;
	
	public UsuarioServiceImpl(UsuarioRepositorio repositorio) {
		this.encoder = new BCryptPasswordEncoder();
		this.repositorio = repositorio;
	}
	
	
	
	
	@Override
	public Iterable<Usuario> getAllUsuarios() {
		return repositorio.findAll();
	}

	private boolean checkUsuarioDisponible(Usuario usuario) throws Exception {
			Optional<Usuario> UsuarioEncontrado = repositorio.findByUsername(usuario.getUsername());
			if (UsuarioEncontrado.isPresent()) {
				throw new Exception("Usuario no disponible");
			}
			return true;
	}
	
	private boolean checkPasswordValid(Usuario usuario) throws Exception {
		if ( !usuario.getPassword().equals(usuario.getConfirmPassword())) {
			throw new Exception("Contraseña y confirmar contraseña no son iguales");
		}
		return true;
	}



	@Override
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		
		if(checkUsuarioDisponible(usuario) && checkPasswordValid(usuario)) {
			String encodePassword = encoder.encode(usuario.getPassword());
			usuario.setPassword(encodePassword);
			usuario = repositorio.save(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return repositorio.findById(id).orElseThrow(() -> new Exception("El usuario no existe."));
	}

	@Override
	public Usuario ActualizarUsuario(Usuario fromusuario) throws Exception {
		Usuario EncontrarUsuario = getUsuarioById(fromusuario.getId());
		mapUser(fromusuario, EncontrarUsuario);
		return repositorio.save(EncontrarUsuario);
	}
	protected void mapUser(Usuario from,Usuario to) {
		to.setUsername(from.getUsername());
		to.setNombre(from.getNombre());
		to.setApellido(from.getApellido());
		to.setEmail(from.getEmail());
		to.setPais(from.getPais());
		to.setCiudad(from.getCiudad());
		to.setRoles(from.getRoles());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void borrarUsuario(Long id) throws Exception {
		
		Usuario usuario = getUsuarioById(id);
		repositorio.delete(usuario);
	}

	@Override
	public Usuario changePassword(CambiarPassword form) throws Exception {
		 Usuario usuario = getUsuarioById(form.getId());
		 Usuario storedUser = repositorio
					.findById( form.getId() )
					.orElseThrow(() -> new Exception("UsernotFound in ChangePassword."));
		 
		 if( !isLoggedUserADMIN() && form.getCurrentPassword().equals(storedUser.getPassword())) {
				throw new Exception ("AYUDA Password invalido.");
			}
			
			if( usuario.getPassword().equals(form.getNewPassword())) {
				throw new Exception ("Nuevo password debe ser diferente al password actual.");
			}
			
			if( !form.getNewPassword().equals(form.getConfirmPassword())) {
				throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
			}
		String encodePassword = encoder.encode(form.getNewPassword());
		usuario.setPassword(encodePassword);
		return repositorio.save(usuario);
	}
	
	public boolean isLoggedUserADMIN(){
		 return loggedUserHasRole("ROLE_ADMIN");
		}

		public boolean loggedUserHasRole(String role) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails loggedUser = null;
			Object roles = null; 
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;
			
				roles = loggedUser.getAuthorities().stream()
						.filter(x -> role.equals(x.getAuthority() ))      
						.findFirst().orElse(null); //loggedUser = null;
			}
			return roles != null ?true :false;
		}
		public Usuario getLoggedUser() throws Exception {
			//Obtener el usuario logeado
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			UserDetails loggedUser = null;

			//Verificar que ese objeto traido de sesion es el usuario
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;
			}
			
			Usuario myUser = repositorio
					.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Problema al obtener usuario de sesion"));
			
			return myUser;
		}
			
}
