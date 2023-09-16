package br.com.hrzon.hrzonvoo.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassagemResponse {
	@JsonProperty("numeroIdentificacaoUnico")
	private String numeroIdentificacaoUnico;

	@JsonProperty("precoPassagem")
	private BigDecimal precoTotalPassagem;

	@JsonProperty("bagagemDespachada")
	private boolean bagagemDespachada;
}
