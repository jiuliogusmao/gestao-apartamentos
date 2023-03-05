package com.gestaoapartamentos.dto;

import java.util.Date;

import com.gestaoapartamentos.entities.Locatario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocatarioDto {
	
	private Long id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String Endereco;
	private String email;
	private String telefone;
	private String estadoCivil;
	private String profissao;
	private Double renda;
	
	public LocatarioDto(Locatario locatario) {
		this.id = locatario.getId();
		this.nome = locatario.getNome();
		this.dataNascimento = locatario.getDataNascimento();
		this.cpf = locatario.getCpf();
		this.Endereco = locatario.getEndereco();
		this.email = locatario.getEmail();
		this.telefone = locatario.getTelefone();
		this.estadoCivil = locatario.getEstadoCivil();
		this.profissao = locatario.getProfissao();
		this.renda = locatario.getRenda();
	}
}
