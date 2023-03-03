package com.gestaoapartamentos.dto;

import java.util.Date;
import java.util.UUID;

import com.gestaoapartamentos.entities.Apartamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDto {

	private UUID id;
	private int numeroApartamento;
	private boolean disponivel;
	private String tipoImovel;
	private double valorAluguel;
	private Date dataVencimento;
	private Date dataDisponibilidade;
	
	public ApartamentoDto(Apartamento apartamento) {
		this.id = apartamento.getId();
		this.numeroApartamento = apartamento.getNumeroApartamento();
		this.disponivel = apartamento.isDisponivel();
		this.tipoImovel = apartamento.getTipoImovel();
		this.dataVencimento = apartamento.getDataVencimento();
		this.dataDisponibilidade = apartamento.getDataDisponibilidade();
	}
	
}
