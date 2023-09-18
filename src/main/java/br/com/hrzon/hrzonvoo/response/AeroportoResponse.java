package br.com.hrzon.hrzonvoo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AeroportoResponse {

	@JsonProperty("codigoIATA")
	private String codigoIATA;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cidade")
	private CidadeResponse cidade;
}
