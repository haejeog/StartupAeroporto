package br.com.hrzon.hrzonvoo.service;

import java.util.List;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.request.ClasseAviaoRequest;
import br.com.hrzon.hrzonvoo.request.ClasseAviaoRequestAlterar;

public interface ClasseAviaoService {

	ClasseAviao criarClasse(ClasseAviaoRequest classeRequest);

	void atualizarVooClasse(List<ClasseAviao> classeAviaoList, Voo voo);

	ClasseAviao alterarClasse(ClasseAviaoRequestAlterar classeAviaoRequest);

	ClasseAviao buscarClassesPorVoo(Voo voo);

}
