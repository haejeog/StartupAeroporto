package br.com.hrzon.hrzonvoo.request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.hrzon.hrzonvoo.entity.Aeroporto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VooRequest {

	@JsonProperty("aeroportoOrigem")
	private Aeroporto aeroportoOrigem;

	@JsonProperty("aeroportoDestino")
	private Aeroporto aeroportoDestino;

	@JsonProperty("dataHoraPartida")
	private Date dataHoraPartida;

	@JsonProperty("classeAviaoRequest")
	private List<ClasseAviaoRequest> classeAviaoRequest;

}
