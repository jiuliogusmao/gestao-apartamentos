package com.gestaoapartamentos.apartamento;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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


@Entity
@Table(name = "tb_apartamento")
public class Apartamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Apartamento() {}
	
	public Apartamento(Long id, int numeroApartamento, boolean disponivel, String tipoImovel, double valorAluguel,
			Date dataDisponibilidade, Edificio edificio) {
		super();
		this.id = id;
		this.numeroApartamento = numeroApartamento;
		this.disponivel = disponivel;
		this.tipoImovel = tipoImovel;
		this.valorAluguel = valorAluguel;
		this.dataDisponibilidade = dataDisponibilidade;
		this.edificio = edificio;
	}


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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(int numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Date getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	public void setDataDisponibilidade(Date dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
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
		Apartamento other = (Apartamento) obj;
		return Objects.equals(id, other.id);
	}



}
