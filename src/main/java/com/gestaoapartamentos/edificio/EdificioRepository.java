package com.gestaoapartamentos.edificio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	
	Optional<Edificio> findByNome(String nome);
	
}
