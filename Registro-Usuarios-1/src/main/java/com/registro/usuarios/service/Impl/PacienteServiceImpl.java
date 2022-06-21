package com.registro.usuarios.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.InterfaceService.PacientesInterfaceService;
import com.registro.usuarios.entity.Pacientes;
import com.registro.usuarios.service.PacientesService;

@Service
public class PacienteServiceImpl implements PacientesInterfaceService {
	
	@Autowired
	private PacientesService service;

	@Override
	public List<Pacientes> Listar() {
		return (List<Pacientes>)service.findAll();
	}

	@Override
	public Optional<Pacientes> ListarId(int id) {
		return service.findById(id);
	}

	@Override
	public int save(Pacientes pacientes) {
		int respuesta=0;
		Pacientes pacientes2= service.save(pacientes);
		if(!pacientes2.equals(null)) {
			respuesta=1;
		}
		return respuesta;
	}

	@Override
	public void delete(int id) {
		service.deleteById(id);
		
	}
	
}
