package br.com.hrzon.hrzonvoo.mapper;

import br.com.hrzon.hrzonvoo.entity.Cidade;
import br.com.hrzon.hrzonvoo.response.CidadeResponse;

public class CidadeMapper {
	public static CidadeResponse convertToResponse(Cidade cidade) {
		return CidadeResponse.builder().id(cidade.getId()).nome(cidade.getNome())
				.unidadeFederativa(cidade.getUnidadeFederativa()).build();
	}

}
