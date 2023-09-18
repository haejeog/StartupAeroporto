package br.com.hrzon.hrzonvoo.response;

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
public class CidadeResponse {

	@JsonProperty("cidade_id")
	private UUID id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("unidadeFederativa")
	private String unidadeFederativa;
}
