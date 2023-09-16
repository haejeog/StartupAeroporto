package br.com.hrzon.hrzonvoo.response;

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
public class ListaPassagensResponse {
	@JsonProperty("passagemList")
	private List<PassagemResponse> passagemList;

	@JsonProperty("passagemList")
	private String nomePassageiro;

}
