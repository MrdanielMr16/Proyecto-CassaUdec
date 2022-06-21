package com.registro.usuarios.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	
	public Optional<Usuario> findByUsername(String username);

}
