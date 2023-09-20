package br.com.hrzon.hrzonvoo.service;

import java.util.List;
import java.util.UUID;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.request.VooRequest;
import br.com.hrzon.hrzonvoo.request.VooRequestAlterar;
import br.com.hrzon.hrzonvoo.response.ListaVooResponse;

public interface VooService {
	ListaVooResponse listarVoos();

	void alterarVoo(VooRequestAlterar vooRequest);

	void cadastrarVoo(VooRequest voo);

	void cancelarVoo(UUID vooId);

	Voo buscarVoo(UUID vooId);

	void atualizarQuantAssentoVoo(Voo voo, List<ClasseAviao> classeAviao);

}
