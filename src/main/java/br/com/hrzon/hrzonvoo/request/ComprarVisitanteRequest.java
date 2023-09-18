package br.com.hrzon.hrzonvoo.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComprarVisitanteRequest {
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("dataNascimento")
	private Date dataNascimento;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("bagagemDespachada")
	private boolean bagagemDespachada;
}
