package com.gestaoapartamentos.apartamento;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.gestaoapartamentos.edificio.Edificio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_apartamento")
public class Apartamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
		
	@Column(nullable = false)
	private int numeroApartamento;
	
	@Column(nullable = false)
	private boolean disponivel;
	
	@Column(nullable = false)
	private String tipoImovel;
	
	@Column(nullable =false)
	private double valorAluguel;
	
	@Column(nullable =false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataDisponibilidade;
	
	@ManyToOne
	@JoinColumn(name = "edificio")
	private Edificio edificio;
	

	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", edificio=" + edificio + ", numeroApartamento=" + numeroApartamento
				+ ", disponivel=" + disponivel + ", tipoImovel=" + tipoImovel + ", valorAluguel=" + valorAluguel
				+ ", dataDisponibilidade=" + dataDisponibilidade + "]";
	}
	
	

}
