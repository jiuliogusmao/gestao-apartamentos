package com.gestaoapartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoapartamentos.entities.Edificio;

public interface LocadorRepository extends JpaRepository<Edificio, Long>{

}
