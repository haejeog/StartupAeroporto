package br.com.hrzon.hrzonvoo.service;

import java.util.List;

import br.com.hrzon.hrzonvoo.entity.Visitante;
import br.com.hrzon.hrzonvoo.response.ListaVisitanteResponse;

public interface VisitanteService {

	ListaVisitanteResponse listarPassageiroPorVoo(List<Long> compradoresId);

	Visitante criarVisitante(Visitante visitante);

}
