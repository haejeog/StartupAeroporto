package br.com.hrzon.hrzonvoo.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisitanteRequest {

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("dataNascimento")
	private Date dataNascimento;

	@JsonProperty("email")
	private String email;
}
