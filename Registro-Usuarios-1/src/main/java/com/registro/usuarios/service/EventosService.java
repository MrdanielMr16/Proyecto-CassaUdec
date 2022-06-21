package com.registro.usuarios.service;

import org.springframework.data.repository.CrudRepository;

import com.registro.usuarios.entity.Eventos;


public interface EventosService extends CrudRepository<Eventos, Integer>{

}
