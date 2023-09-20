package br.com.hrzon.hrzonvoo.service;

import java.util.List;

import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.request.CadastrarPassagemRequest;
import br.com.hrzon.hrzonvoo.request.ComprarPassagemRequest;
import br.com.hrzon.hrzonvoo.response.ListaVisitanteResponse;

public interface PassagemService {

	List<Passagem> listarPassagemPorCPF(String cpf);

	void cadastrarPassagem(CadastrarPassagemRequest cadastrarPassagemRequest);

	ListaVisitanteResponse listarPassageiroIdPorVoo(Long voo);

	void alterarPreco(Long idPassagem, Double precoTotal);

	void comprarPassagem(ComprarPassagemRequest request);

}
