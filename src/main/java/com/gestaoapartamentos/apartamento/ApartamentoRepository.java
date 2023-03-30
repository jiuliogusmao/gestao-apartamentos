package com.gestaoapartamentos.apartamento;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{
	
	Optional<Apartamento> findByNumeroApartamento(int numeroApartamento);
	List<Apartamento> findByDisponivelTrue();
}
