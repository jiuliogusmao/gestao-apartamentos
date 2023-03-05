package com.gestaoapartamentos.dto;

import com.gestaoapartamentos.entities.Locador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocadorDto {
	
	private Long id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	
	public LocadorDto(Locador locador) {
		this.id = locador.getId();
		this.nome = locador.getNome();
		this.cnpj = locador.getCnpj();
		this.endereco = locador.getEndereco();
		this.telefone = locador.getTelefone();
	}
}
