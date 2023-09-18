package br.com.hrzon.hrzonvoo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.response.ListaVooResponse;
import br.com.hrzon.hrzonvoo.response.VooResponse;

@Component
public class VooMapper {
	public ListaVooResponse convertToList(List<Voo> vooList) {
		return ListaVooResponse.builder().vooResponseList(convertToVooList(vooList)).build();
	}

	public List<VooResponse> convertToVooList(List<Voo> vooList) {

		return vooList.stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	public VooResponse convertToResponse(Voo voo) {
		return VooResponse.builder().capacidadeMaximaPassageiros(voo.getCapacidadeMaximaPassageiros())
				.dataHoraPartida(voo.getDataHoraPartida()).aeroportoOrigem(null).aeroportoDestino(null).build();
	}

}
