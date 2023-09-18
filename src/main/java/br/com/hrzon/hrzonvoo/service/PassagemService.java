package br.com.hrzon.hrzonvoo.service;

import java.util.List;
import java.util.UUID;

import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.request.CadastrarPassagemRequest;

public interface PassagemService {

	List<UUID> listarPassageiroPorVoo(Voo voo);

	List<Passagem> listarPassagemPorCPF(String cpf);

	void cadastrarPassagem(CadastrarPassagemRequest cadastrarPassagemRequest);

	void alterarPreco(UUID idPassagem, Double precoTotal);

}
