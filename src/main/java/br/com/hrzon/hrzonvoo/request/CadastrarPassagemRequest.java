package br.com.hrzon.hrzonvoo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarPassagemRequest {

	@JsonProperty("precoTotalPassagem")
	private Double precoTotalPassagem;

	@JsonProperty("bagagemDespachada")
	private boolean bagagemDespachada;

	@JsonProperty("classe")
	private ClasseAviao classe;

	@JsonProperty("voo")
	private Voo voo;

}
