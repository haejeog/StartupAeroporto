package br.com.hrzon.hrzonvoo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.hrzon.hrzonvoo.entity.Visitante;
import br.com.hrzon.hrzonvoo.response.ListaVisitanteResponse;
import br.com.hrzon.hrzonvoo.response.VisitanteResponse;

@Component
public class VisitanteMapper {

	public ListaVisitanteResponse convertToList(List<Visitante> visitanteList) {
		return ListaVisitanteResponse.builder().visitanteList(convertToVisitanteList(visitanteList)).build();
	}

	public List<VisitanteResponse> convertToVisitanteList(List<Visitante> visitanteList) {

		return visitanteList.stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	public VisitanteResponse convertToResponse(Visitante visitante) {
		return VisitanteResponse.builder()
				.id(visitante.getId())
				.cpf(visitante.getCpf())
				.dataNascimento(visitante.getDataNascimento())
				.email(visitante.getEmail())
				.nome(visitante.getNome())
				.build();
	}
}
