package br.com.hrzon.hrzonvoo.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComprarPassagemRequest {

	private VisitanteRequest visitanteRequest;

	private Long vooId;

	private List<ComprarClasseAviaoRequest> comprarClasseAviaoRequest;

}
