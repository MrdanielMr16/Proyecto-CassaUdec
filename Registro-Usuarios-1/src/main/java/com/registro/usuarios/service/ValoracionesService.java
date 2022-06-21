package com.registro.usuarios.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.entity.estadoSalud;

public interface ValoracionesService extends JpaRepository<estadoSalud, Integer>{

}
