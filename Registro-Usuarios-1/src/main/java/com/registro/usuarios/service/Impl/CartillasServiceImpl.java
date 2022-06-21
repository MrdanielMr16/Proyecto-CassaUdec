package com.registro.usuarios.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.registro.usuarios.InterfaceService.CartillasInterfaceServicio;
import com.registro.usuarios.entity.Cartillas;
import com.registro.usuarios.service.CartillasService;

@Service
public class CartillasServiceImpl implements CartillasInterfaceServicio {

	@Autowired
	@Lazy
	private CartillasService service;
	
	@Override
	public List<Cartillas> Listar() {
		return (List<Cartillas>)service.findAll();
	}
	
	@Override
	public void delete(Long id) {
		service.deleteById(id);
	}

	@Override
	public Optional<Cartillas> ListarId(Long id) {
		return service.findById(id);
	}

}
