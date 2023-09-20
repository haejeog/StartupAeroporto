package br.com.hrzon.hrzonvoo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.entity.Visitante;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.repository.PassagemRepository;
import br.com.hrzon.hrzonvoo.request.CadastrarPassagemRequest;
import br.com.hrzon.hrzonvoo.request.ComprarClasseAviaoRequest;
import br.com.hrzon.hrzonvoo.request.ComprarPassagemRequest;
import br.com.hrzon.hrzonvoo.request.ComprarVisitanteRequest;
import br.com.hrzon.hrzonvoo.response.ListaVisitanteResponse;
import br.com.hrzon.hrzonvoo.service.ClasseAviaoService;
import br.com.hrzon.hrzonvoo.service.PassagemService;
import br.com.hrzon.hrzonvoo.service.VisitanteService;
import br.com.hrzon.hrzonvoo.service.VooService;
import br.com.hrzon.hrzonvoo.util.Util;

@Service
public class PassagemServiceImpl implements PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;

	@Autowired
	private VooService vooService;

	@Autowired
	private VisitanteService visitanteService;

	@Autowired
	private ClasseAviaoService classeAviaoService;

	private int percentualAcrescimo = 10;

	@Override
	public ListaVisitanteResponse listarPassageiroIdPorVoo(Long voo) {
		List<Passagem> passagemList = listarPassagemsPorVoo(voo);
		List<Long> compradoresId = new ArrayList<>();
		for (Passagem passagem : passagemList) {
			compradoresId.add(passagem.getComprador().getId());
		}
		return visitanteService.listarPassageiroPorVoo(compradoresId);
	}

	private List<Passagem> listarPassagemsPorVoo(Long voo) {
		return passagemRepository.findByVoo(voo);

	}

	@Override
	public List<Passagem> listarPassagemPorCPF(String cpf) {
		return passagemRepository.findByCpfPassageiro(cpf);
	}

	@Override
	public void cadastrarPassagem(CadastrarPassagemRequest request) {
		Passagem passagem = new Passagem();
		passagem.setClasse(request.getClasse());
		passagem.setNumeroIdentificacaoUnico(Util.gerarUUID().toString());
		passagem.setPrecoTotalPassagem(request.getPrecoTotalPassagem());
		passagem.setVoo(request.getVoo());
		passagemRepository.saveAndFlush(passagem);

	}

	@Override
	public void alterarPreco(Long idPassagem, Double precoTotal) {
		Passagem passagemEntity = passagemRepository.findById(idPassagem).get();
		passagemEntity.setPrecoTotalPassagem(precoTotal);
		passagemRepository.save(passagemEntity);
	}

	@Override
	public void comprarPassagem(ComprarPassagemRequest request) {
		Voo voo = vooService.buscarVoo(request.getVooId());
		List<ClasseAviao> classeAviao = classeAviaoService.buscarClassesPorVoo(voo);
		if (voo.getCapacidadeMaximaPassageiros() > 0) {
			for (ComprarClasseAviaoRequest comprarClasseAviaoRequest : request.getComprarClasseAviaoRequest()) {
				verificarIsClasseExistente(classeAviao, comprarClasseAviaoRequest);
				verificarDisponibilidadeAssento(classeAviao, comprarClasseAviaoRequest);
				List<Passagem> passagemList = listarPassagemsPorVoo(voo.getId());
				for (Passagem passagem : passagemList) {
					if (passagem.getCpfPassageiro() != null
							&& passagem.getClasse().getTipoClasse().equals(comprarClasseAviaoRequest.getTipoClasse())) {
						for (ComprarVisitanteRequest visitanteReq : comprarClasseAviaoRequest.getPassageiros()) {
							passagem.setBagagemDespachada(visitanteReq.isBagagemDespachada());
							calcularValorTotal(passagem, visitanteReq);
							adicionarCompradorPassagem(passagem, visitanteReq);
							adicionarDadosPassageiro(passagem, visitanteReq);

						}
					}
				}
			}
			atualizarQuantAssentos(request, voo, classeAviao);
		}

	}

	private void atualizarQuantAssentos(ComprarPassagemRequest request, Voo voo, List<ClasseAviao> classeAviao) {
		int count = 0;
		for (ClasseAviao classeAviao2 : classeAviao) {
			for (ComprarClasseAviaoRequest comprarClasseAviaoRequest : request.getComprarClasseAviaoRequest()) {

				if (comprarClasseAviaoRequest.getTipoClasse().equals(classeAviao2.getTipoClasse())) {
					classeAviao2.setQuantidadeAssentos(
							classeAviao2.getQuantidadeAssentos() - comprarClasseAviaoRequest.getQuantidadeAssentos());
					count += classeAviao2.getQuantidadeAssentos();
				}
			}

		}
		voo.setCapacidadeMaximaPassageiros(count);
		vooService.atualizarQuantAssentoVoo(voo, classeAviao);
	}

	private void adicionarDadosPassageiro(Passagem passagem, ComprarVisitanteRequest visitanteReq) {
		passagem.setCpfPassageiro(visitanteReq.getCpf());
		passagem.setDataNascimentoPassageiro(visitanteReq.getDataNascimento());
		passagem.setNomePassageiro(visitanteReq.getNome());
	}

	private void adicionarCompradorPassagem(Passagem passagem, ComprarVisitanteRequest visitanteReq) {
		Visitante visitante = new Visitante();
		visitante.setCpf(visitanteReq.getCpf());
		visitante.setDataNascimento(visitanteReq.getDataNascimento());
		visitante.setEmail(visitanteReq.getEmail());

		passagem.setComprador(visitanteService.criarVisitante(visitante));
	}

	private void calcularValorTotal(Passagem passagem, ComprarVisitanteRequest visitanteReq) {
		passagem.setPrecoTotalPassagem(visitanteReq.isBagagemDespachada()
				? (passagem.getPrecoTotalPassagem() + (passagem.getPrecoTotalPassagem() * (percentualAcrescimo / 100)))
				: passagem.getPrecoTotalPassagem());
	}

	private void verificarDisponibilidadeAssento(List<ClasseAviao> classeAviao,
			ComprarClasseAviaoRequest comprarClasseAviaoRequest) {
		boolean isDisponivel = classeAviao.stream()
				.anyMatch(classe -> classe.getQuantidadeAssentos() > comprarClasseAviaoRequest.getQuantidadeAssentos());
		if (!isDisponivel) {
			throw new NoSuchElementException();
		}
	}

	private void verificarIsClasseExistente(List<ClasseAviao> classeAviao,
			ComprarClasseAviaoRequest comprarClasseAviaoRequest) {
		boolean isClasse = classeAviao.stream()
				.anyMatch(classe -> comprarClasseAviaoRequest.getTipoClasse().equals(classe.getTipoClasse()));
		if (!isClasse) {
			throw new NoSuchElementException();
		}
	}
}
