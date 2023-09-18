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
public class VisitanteResponse {
	@JsonProperty("id")
	private UUID id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("dataNascimento")
	private Date dataNascimento;

	@JsonProperty("email")
	private String email;
}
