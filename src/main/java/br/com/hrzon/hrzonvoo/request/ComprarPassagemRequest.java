package br.com.hrzon.hrzonvoo.request;

import java.util.UUID;

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

	private UUID vooId;

	private ComprarClasseAviaoRequest comprarClasseAviaoRequest;

}
