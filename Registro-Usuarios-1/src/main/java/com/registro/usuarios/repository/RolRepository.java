package com.registro.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.entity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

	public Rol findByNombre(String nombre);
}
