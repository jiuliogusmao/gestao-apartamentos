package com.gestaoapartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestaoapartamentos.dto.ApartamentoDto;
import com.gestaoapartamentos.entities.Apartamento;
import com.gestaoapartamentos.repositories.ApartamentoRepository;
import com.gestaoapartamentos.repositories.EdificioRepository;

@Service
public class ApartamentoService {
	
	
	private final ApartamentoRepository apartamentoRepository;
	private final EdificioRepository edificioRepository;
	public ApartamentoService(ApartamentoRepository apartamentoRepository, EdificioRepository edificioRepository) {
		this.apartamentoRepository = apartamentoRepository;
		this.edificioRepository = edificioRepository;
	}
	
	public ResponseEntity<Object> cadastrarApartamento(ApartamentoDto apartamentoDto){
		Optional<Apartamento> apartamentoOptional = apartamentoRepository.findByNumeroApartamento(apartamentoDto.getNumeroApartamento()); 
		
		if (apartamentoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Este apartamento já está cadastrado.");
		}
	    
		Apartamento apartamento = new Apartamento();
		BeanUtils.copyProperties(apartamentoDto, apartamento);
		apartamentoRepository.save(apartamento);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Apartamento cadastrado com sucesso!");
		
	}
	public ResponseEntity<Object> visualizarApartamentosDisponiveis(){
		List<Apartamento> apartamentosDisponiveis = apartamentoRepository.findByDisponivelTrue();
		return ResponseEntity.status(HttpStatus.OK).body(apartamentosDisponiveis);
	}
	
	public ResponseEntity<Object> visualizarApartamentos(){
		List<Apartamento> apartamentos = apartamentoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(apartamentos);
	}
	
	public ResponseEntity<Object> atualizarApartamento(ApartamentoDto apartamentoDto){
		Optional<Apartamento> apartamentoOptional = apartamentoRepository.findByNumeroApartamento(apartamentoDto.getNumeroApartamento());
		if(apartamentoOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(apartamentoDto.getNumeroApartamento() + " não cadastrado!");
		}
		BeanUtils.copyProperties(apartamentoDto, apartamentoOptional);
		
		apartamentoOptional.get().setEdificio(apartamentoDto.getEdificio());
		apartamentoOptional.get().setNumeroApartamento(apartamentoDto.getNumeroApartamento());
		apartamentoOptional.get().setDisponivel(apartamentoDto.isDisponivel());
		apartamentoOptional.get().setTipoImovel(apartamentoDto.getTipoImovel());
		apartamentoOptional.get().setValorAluguel(apartamentoDto.getValorAluguel());
		apartamentoOptional.get().setDataDisponibilidade(apartamentoDto.getDataDisponibilidade());
		
		apartamentoRepository.save(apartamentoOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("Apartamento " + apartamentoDto.getNumeroApartamento() + " atualizado com sucesso!");
	}
	
}
