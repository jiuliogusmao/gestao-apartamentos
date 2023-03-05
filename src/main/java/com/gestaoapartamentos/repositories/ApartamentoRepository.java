package com.gestaoapartamentos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoapartamentos.entities.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{
	
	Optional<Apartamento> findByNumeroApartamento(int numeroApartamento);
}
