package com.registro.usuarios.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.entity.Cartillas;

@Repository
public interface CartillasService extends JpaRepository<Cartillas, Long>{
	
	@Query("Select new Cartillas(c.id, c.nombre_archivo, c.tamanio, c.nombre_Cartilla, c.descripcion) FROM Cartillas c ORDER BY c.fecha_Subida DESC")
	List<Cartillas> findAll();
}
