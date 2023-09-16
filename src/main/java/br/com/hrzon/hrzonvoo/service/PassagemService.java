package br.com.hrzon.hrzonvoo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.exception.CpfInvalidoException;
import br.com.hrzon.hrzonvoo.repository.PassagemRepository;
import br.com.hrzon.hrzonvoo.response.ListaPassagensResponse;
import br.com.hrzon.hrzonvoo.response.PassagemResponse;

@Service
public class PassagemService {

	@Autowired
	private PassagemRepository passagemRepository;

	public ListaPassagensResponse findByCPF(@NotBlank String cpf) {
		if (ValidationService.isCPF(cpf)) {
			List<Passagem> passagemList = passagemRepository.findByCpfPassageiro(cpf);
			return convertToList(passagemList);
		}
		throw new CpfInvalidoException();

	}

	private ListaPassagensResponse convertToList(List<Passagem> passagemList) {
		return ListaPassagensResponse.builder().nomePassageiro(passagemList.get(0).getNomePassageiro())
				.passagemList(convertToPassagemList(passagemList)).build();
	}

	private List<PassagemResponse> convertToPassagemList(List<Passagem> passagemList) {

		return passagemList.stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	private PassagemResponse convertToResponse(Passagem passagem) {
		return PassagemResponse.builder().numeroIdentificacaoUnico(passagem.getNumeroIdentificacaoUnico())
				.precoTotalPassagem(passagem.getPrecoTotalPassagem()).bagagemDespachada(passagem.isBagagemDespachada())
				.build();
	}
}
