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
public class AlterarPrecoPassagemRequest {

	@JsonProperty("idPassagem")
	private Long idPassagem;

	@JsonProperty("precoTotal")
	private Double precoTotal;

}
