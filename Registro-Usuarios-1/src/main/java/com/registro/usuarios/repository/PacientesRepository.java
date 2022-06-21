package com.registro.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.entity.Pacientes;

public interface PacientesRepository extends JpaRepository<Pacientes, Integer>{

}
