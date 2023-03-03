package com.gestaoapartamentos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "apartamento")
public class Apartamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	
	@Column(nullable = false)
	private int numeroApartamento;
	
	@Column(nullable = false)
	private boolean disponivel;
	
	@Column(nullable = false)
	private String tipoImovel;
	
	@Column(nullable =false)
	private double valorAluguel;
	
	@Column(nullable =false)
	private Date dataVencimento;
	
	@Column(nullable =false)
	private Date dataDisponibilidade;
	
	
	
}
