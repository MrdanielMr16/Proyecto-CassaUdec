package com.registro.usuarios.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.entity.Pacientes;



@Repository
public interface PacientesService extends JpaRepository<Pacientes, Integer>{

}
