package br.com.hrzon.hrzonvoo.response;

import java.util.Date;
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
public class VooResponse {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("aeroportoOrigem")
	private AeroportoResponse aeroportoOrigem;

	@JsonProperty("aeroportoDestino")
	private AeroportoResponse aeroportoDestino;

	@JsonProperty("numeracaoUnica")
	private String numeracaoUnica;

	@JsonProperty("dataHoraPartida")
	private Date dataHoraPartida;

	@JsonProperty("capacidadeMaximaPassageiros")
	private int capacidadeMaximaPassageiros;
}
