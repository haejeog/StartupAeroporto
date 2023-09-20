package br.com.hrzon.hrzonvoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.Visitante;
import br.com.hrzon.hrzonvoo.mapper.VisitanteMapper;
import br.com.hrzon.hrzonvoo.repository.VisitanteRepository;
import br.com.hrzon.hrzonvoo.response.ListaVisitanteResponse;
import br.com.hrzon.hrzonvoo.service.VisitanteService;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteRepository visitanteRepository;

	@Autowired
	private VisitanteMapper visitanteMapper;

	@Override
	public ListaVisitanteResponse listarPassageiroPorVoo(List<Long> visitanteListId) {
		List<Visitante> visitanteList = new ArrayList<>();
		for (Long visitanteId : visitanteListId) {
			visitanteList.add(visitanteRepository.findById(visitanteId).get());
		}
		return visitanteMapper.convertToList(visitanteList);

	}

	@Override
	public Visitante criarVisitante(Visitante visitante) {
		return visitanteRepository.saveAndFlush(visitante);
	}

}
