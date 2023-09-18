package br.com.hrzon.hrzonvoo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.hrzon.hrzonvoo.entity.Aeroporto;
import br.com.hrzon.hrzonvoo.response.AeroportoResponse;
import br.com.hrzon.hrzonvoo.response.ListaAeroportoResponse;

@Component
public class AeroportoMapper {

	public ListaAeroportoResponse convertToList(List<Aeroporto> aeroportoList) {
		return ListaAeroportoResponse.builder().aeroportoList(convertToAeroportoList(aeroportoList)).build();
	}

	public List<AeroportoResponse> convertToAeroportoList(List<Aeroporto> aeroportoList) {

		return aeroportoList.stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	public AeroportoResponse convertToResponse(Aeroporto aeroporto) {
		return AeroportoResponse.builder().codigoIATA(aeroporto.getCodigoIATA()).nome(aeroporto.getNome())
				.cidade(CidadeMapper.convertToResponse(aeroporto.getCidade())).build();
	}

}
