package br.com.hrzon.hrzonvoo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.mapper.VooMapper;
import br.com.hrzon.hrzonvoo.repository.VooRepository;
import br.com.hrzon.hrzonvoo.request.ClasseAviaoRequest;
import br.com.hrzon.hrzonvoo.request.ClasseAviaoRequestAlterar;
import br.com.hrzon.hrzonvoo.request.VooRequest;
import br.com.hrzon.hrzonvoo.request.VooRequestAlterar;
import br.com.hrzon.hrzonvoo.response.ListaVooResponse;
import br.com.hrzon.hrzonvoo.service.ClasseAviaoService;
import br.com.hrzon.hrzonvoo.service.VooService;
import br.com.hrzon.hrzonvoo.util.Util;

@Service
public class VooServiceImpl implements VooService {
	@Autowired
	private VooRepository vooRepository;

	@Autowired
	private VooMapper vooMapper;

	@Autowired
	private ClasseAviaoService classeAviaoServiceImpl;

	@Override
	public ListaVooResponse listarVoos() {

		return vooMapper.convertToList(vooRepository.findAll());
	}

	@Override
	public void alterarVoo(VooRequestAlterar vooRequest) {
		int count = 0;
		List<ClasseAviao> classeAviaoList = new ArrayList<>();
		for (ClasseAviaoRequestAlterar classeAviaoRequest : vooRequest.getClasseAviaoRequest()) {
			classeAviaoList.add(classeAviaoServiceImpl.alterarClasse(classeAviaoRequest));
			count += classeAviaoRequest.getQuantidadeAssentos();
		}

		Voo vooEntity = vooRepository.findById(vooRequest.getId()).orElseThrow();
		vooEntity.setAeroportoDestino(vooRequest.getAeroportoDestino());
		vooEntity.setAeroportoOrigem(vooRequest.getAeroportoOrigem());
		vooEntity.setCapacidadeMaximaPassageiros(count);
		vooEntity.setDataHoraPartida(vooRequest.getDataHoraPartida());
		vooRepository.saveAndFlush(vooEntity);

	}
	@Override
	public void atualizarQuantAssentoVoo(Voo voo, List<ClasseAviao> classe) {
		classeAviaoServiceImpl.atualizarQuantAssentoClasse(classe);
		vooRepository.saveAndFlush(voo);
	}

	@Override
	public void cadastrarVoo(VooRequest vooRequest) {
		int count = 0;
		List<ClasseAviao> classeAviaoList = new ArrayList<>();
		for (ClasseAviaoRequest classeAviaoRequest : vooRequest.getClasseAviaoRequest()) {
			classeAviaoList.add(classeAviaoServiceImpl.criarClasse(classeAviaoRequest));
			count += classeAviaoRequest.getQuantidadeAssentos();
		}
		Voo vooEntity = new Voo();
		vooEntity.setId(Util.gerarUUID());
		vooEntity.setAeroportoDestino(vooRequest.getAeroportoDestino());
		vooEntity.setAeroportoOrigem(vooRequest.getAeroportoOrigem());
		vooEntity.setCapacidadeMaximaPassageiros(count);
		vooEntity.setDataHoraPartida(vooRequest.getDataHoraPartida());
		vooEntity.setNumeracaoUnica(createNumeracaoUnica(vooRequest));
		vooEntity = vooRepository.save(vooEntity);
		classeAviaoServiceImpl.atualizarVooClasse(classeAviaoList, vooEntity);

	}

	private String createNumeracaoUnica(VooRequest voo) {
		String numeracao = voo.getAeroportoOrigem().getCodigoIATA() + "001";
		return numeracao;
	}

	@Override
	public void cancelarVoo(UUID vooId) {
		vooRepository.deleteById(vooId);

	}
	
	@Override
	public Voo buscarVoo(UUID vooId) {
		return vooRepository.findById(vooId).get();
	}

}