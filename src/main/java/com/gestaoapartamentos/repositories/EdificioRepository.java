package com.gestaoapartamentos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoapartamentos.entities.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	
	Optional<Edificio> findByNome(String nome);
	
}
