package com.registro.usuarios.service;




import com.registro.usuarios.dto.CambiarPassword;
import com.registro.usuarios.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> getAllUsuarios();

	public Usuario crearUsuario(Usuario usuario) throws Exception;
	
	public Usuario getUsuarioById(Long id) throws Exception;
	
	public Usuario ActualizarUsuario(Usuario usuario)throws Exception;
	
	public void borrarUsuario(Long id) throws Exception;
	
	public Usuario changePassword(CambiarPassword form) throws Exception;
	
	
	
 }
