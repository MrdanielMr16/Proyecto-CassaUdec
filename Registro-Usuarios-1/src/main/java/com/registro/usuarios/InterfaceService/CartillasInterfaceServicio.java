package com.registro.usuarios.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.registro.usuarios.entity.Cartillas;

public interface CartillasInterfaceServicio {
	
	public List<Cartillas>Listar();
	public Optional<Cartillas>ListarId(Long id);
	public void delete(Long id);
}
