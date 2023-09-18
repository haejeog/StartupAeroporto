package br.com.hrzon.hrzonvoo.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseAviaoRequestAlterar {

	@JsonProperty("classeAviao_id")
	private UUID id;

	@JsonProperty("aeroportoOrigem")
	private String tipoClasse;

	@JsonProperty("quantidadeAssentos")
	private int quantidadeAssentos;

	@JsonProperty("valorAssento")
	private double valorAssento;
}