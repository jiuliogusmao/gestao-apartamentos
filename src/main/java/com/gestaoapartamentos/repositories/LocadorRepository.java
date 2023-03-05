package com.gestaoapartamentos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoapartamentos.entities.Locador;

public interface LocadorRepository extends JpaRepository<Locador, Long>{
	
	Optional<Locador> findByNome(String nome);
}
