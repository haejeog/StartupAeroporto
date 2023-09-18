package br.com.hrzon.hrzonvoo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.repository.PassagemRepository;
import br.com.hrzon.hrzonvoo.request.CadastrarPassagemRequest;
import br.com.hrzon.hrzonvoo.request.ComprarPassagemRequest;
import br.com.hrzon.hrzonvoo.service.ClasseAviaoService;
import br.com.hrzon.hrzonvoo.service.PassagemService;
import br.com.hrzon.hrzonvoo.service.VooService;
import br.com.hrzon.hrzonvoo.util.Util;

@Service
public class PassagemServiceImpl implements PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;

	@Autowired
	private VooService vooService;

	@Autowired
	private ClasseAviaoService classeAviaoService;

	@Override
	public List<UUID> listarPassageiroPorVoo(Voo voo) {
		List<Passagem> passagemList = passagemRepository.findByVoo(voo);
		List<UUID> compradoresId = new ArrayList<>();
		for (Passagem passagem : passagemList) {
			compradoresId.add(passagem.getComprador().getId());
		}
		return compradoresId;
	}

	@Override
	public List<Passagem> listarPassagemPorCPF(String cpf) {
		return passagemRepository.findByCpfPassageiro(cpf);
	}

	@Override
	public void cadastrarPassagem(CadastrarPassagemRequest request) {
		Passagem passagem = new Passagem();
		passagem.setClasse(request.getClasse());
		passagem.setId(Util.gerarUUID());
		passagem.setNumeroIdentificacaoUnico(Util.gerarUUID().toString());
		passagem.setPrecoTotalPassagem(request.getPrecoTotalPassagem());
		passagem.setVoo(request.getVoo());
		passagemRepository.saveAndFlush(passagem);

	}

	@Override
	public void alterarPreco(UUID idPassagem, Double precoTotal) {
		Passagem passagemEntity = passagemRepository.findById(idPassagem).get();
		passagemEntity.setPrecoTotalPassagem(precoTotal);
		passagemRepository.save(passagemEntity);
	}

	public void comprarPassagem(ComprarPassagemRequest request) {
		Voo voo = vooService.buscarVoo(request.getVooId());
		ClasseAviao classeAviao = classeAviaoService.buscarClassesPorVoo(voo);
	}
}
