package com.gestaoapartamentos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoapartamentos.entities.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Long>{
	
	Optional<Locatario> findByNome(String nome);
}
