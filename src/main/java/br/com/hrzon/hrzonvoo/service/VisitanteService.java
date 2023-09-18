package br.com.hrzon.hrzonvoo.service;

import java.util.UUID;

import br.com.hrzon.hrzonvoo.response.ListaVisitanteResponse;

public interface VisitanteService {

	ListaVisitanteResponse listarPassageiroPorVoo(UUID vooId);

}
