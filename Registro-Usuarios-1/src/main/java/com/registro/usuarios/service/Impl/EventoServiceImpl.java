package com.registro.usuarios.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.InterfaceService.EventosInterfaceServicio;
import com.registro.usuarios.entity.Eventos;
import com.registro.usuarios.service.EventosService;

@Service
public class EventoServiceImpl implements EventosInterfaceServicio {

	@Autowired
	private EventosService eventoService;
	
	@Override
	public List<Eventos> Listar() {
		return (List<Eventos>)eventoService.findAll();
	}

	@Override
	public Optional<Eventos> ListarId(int id) {
		return eventoService.findById(id);
	}

	@Override
	public int save(Eventos eventos) {
		int respuesta=0;
		Eventos eventos2= eventoService.save(eventos);
		if(!eventos2.equals(null)) {
			respuesta=1;
		}
		return respuesta;
	}

	@Override
	public void delete(int id) {
		eventoService.deleteById(id);
		
	}

	
	
}