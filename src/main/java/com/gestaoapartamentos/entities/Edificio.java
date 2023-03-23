package com.gestaoapartamentos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_edificio")
public class Edificio implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	
	
}
