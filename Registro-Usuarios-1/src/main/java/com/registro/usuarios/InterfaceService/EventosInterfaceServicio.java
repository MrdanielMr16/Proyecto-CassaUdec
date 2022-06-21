package com.registro.usuarios.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.registro.usuarios.entity.Eventos;

public interface EventosInterfaceServicio {
	public List<Eventos>Listar();
	public Optional<Eventos>ListarId(int id);
	public int save(Eventos eventos);
	public void delete(int id);
	
}
