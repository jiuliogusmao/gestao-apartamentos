package com.gestaoapartamentos.edificio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaoapartamentos.apartamento.Apartamento;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_edificio")
public class Edificio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Edificio() {}
	
	public Edificio(Long id, String nome, String endereco, int numeroApartamentos, int numeroAndares,
			List<Apartamento> apartamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numeroApartamentos = numeroApartamentos;
		this.numeroAndares = numeroAndares;
		this.apartamentos = apartamentos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private int numeroApartamentos;
	
	@Column(nullable = false)
	private int numeroAndares;
	
	@JsonIgnore
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Apartamento> apartamentos = new ArrayList<>();
	
	public void addApartamento(Apartamento apartamento) {
		this.apartamentos.add(apartamento);
	}
	
	public void removeApartamento(Apartamento apartamento) {
		this.apartamentos.remove(apartamento);
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", nome=" + nome + ", endereco=" + endereco
				+ ", numeroApartamentos=" + numeroApartamentos + ", numeroAndares=" + numeroAndares + " , apartamentos=" + apartamentos + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumeroApartamentos() {
		return numeroApartamentos;
	}

	public void setNumeroApartamentos(int numeroApartamentos) {
		this.numeroApartamentos = numeroApartamentos;
	}

	public int getNumeroAndares() {
		return numeroAndares;
	}

	public void setNumeroAndares(int numeroAndares) {
		this.numeroAndares = numeroAndares;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edificio other = (Edificio) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
