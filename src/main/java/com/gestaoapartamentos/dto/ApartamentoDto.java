package com.gestaoapartamentos.dto;

import java.util.Date;

import com.gestaoapartamentos.entities.Apartamento;
import com.gestaoapartamentos.entities.Edificio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDto {

	private Long id;
	String edificio;
	private int numeroApartamento;
	private boolean disponivel;
	private String tipoImovel;
	private double valorAluguel;
	private Date dataDisponibilidade;
	
	public ApartamentoDto(Apartamento apartamento) {
		this.id = apartamento.getId();
		this.edificio = apartamento.getEdificio().getNome();
		this.numeroApartamento = apartamento.getNumeroApartamento();
		this.disponivel = apartamento.isDisponivel();
		this.tipoImovel = apartamento.getTipoImovel();
		this.dataDisponibilidade = apartamento.getDataDisponibilidade();
	}

	
}
