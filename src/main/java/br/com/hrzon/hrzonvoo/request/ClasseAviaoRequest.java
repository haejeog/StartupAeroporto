package br.com.hrzon.hrzonvoo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseAviaoRequest {

	@JsonProperty("tipoClasse")
	private String tipoClasse;

	@JsonProperty("quantidadeAssentos")
	private int quantidadeAssentos;

	@JsonProperty("valorAssento")
	private double valorAssento;
}
