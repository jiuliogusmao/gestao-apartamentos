package com.gestaoapartamentos.apartamento;

import java.util.Date;

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

	public Long getId() {
		return id;
	}

	public String getEdificio() {
		return edificio;
	}

	public int getNumeroApartamento() {
		return numeroApartamento;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public Date getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	
}
