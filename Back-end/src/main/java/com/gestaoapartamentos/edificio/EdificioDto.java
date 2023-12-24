package com.gestaoapartamentos.edificio;

import java.util.List;

import com.gestaoapartamentos.apartamento.Apartamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EdificioDto {

	private Long id;
	private String nome;
	private String endereco;
	private int numeroApartamentos;
	private int numeroAndares;
	private List<Apartamento> apartamentos;
	
	public EdificioDto(Edificio edificio) {
		this.id = edificio.getId();
		this.nome = edificio.getNome();
		this.endereco = edificio.getEndereco();
		this.numeroApartamentos = edificio.getNumeroApartamentos();
		this.numeroAndares = edificio.getNumeroAndares();
		this.apartamentos = edificio.getApartamentos();
		}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getNumeroApartamentos() {
		return numeroApartamentos;
	}

	public int getNumeroAndares() {
		return numeroAndares;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}


	
}
