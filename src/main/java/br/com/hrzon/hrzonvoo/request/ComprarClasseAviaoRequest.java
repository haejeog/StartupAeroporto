package br.com.hrzon.hrzonvoo.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComprarClasseAviaoRequest {

	@JsonProperty("tipoClasse")
	private String tipoClasse;

	@JsonProperty("quantidadeAssentos")
	private int quantidadeAssentos;

	private List<ComprarVisitanteRequest> passageiros;

}
