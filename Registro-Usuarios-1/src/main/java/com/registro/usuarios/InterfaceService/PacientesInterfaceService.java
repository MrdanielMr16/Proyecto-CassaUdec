package com.registro.usuarios.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.registro.usuarios.entity.Pacientes;

public interface PacientesInterfaceService {
	
	public List<Pacientes>Listar();
	public Optional<Pacientes>ListarId(int id);
	public int save(Pacientes pacientes);
	public void delete(int id);
	
}
