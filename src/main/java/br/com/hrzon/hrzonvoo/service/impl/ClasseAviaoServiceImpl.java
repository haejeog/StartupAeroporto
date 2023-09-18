package br.com.hrzon.hrzonvoo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.ClasseAviao;
import br.com.hrzon.hrzonvoo.entity.Voo;
import br.com.hrzon.hrzonvoo.repository.ClasseAviaoRepository;
import br.com.hrzon.hrzonvoo.request.ClasseAviaoRequest;
import br.com.hrzon.hrzonvoo.request.ClasseAviaoRequestAlterar;
import br.com.hrzon.hrzonvoo.service.ClasseAviaoService;
import br.com.hrzon.hrzonvoo.util.Util;

@Service
public class ClasseAviaoServiceImpl implements ClasseAviaoService {
	@Autowired
	private ClasseAviaoRepository classeRepository;

	@Override
	public ClasseAviao criarClasse(ClasseAviaoRequest classeRequest) {
		ClasseAviao classeAviao = new ClasseAviao();
		classeAviao.setId(Util.gerarUUID());
		classeAviao.setQuantidadeAssentos(classeRequest.getQuantidadeAssentos());
		classeAviao.setTipoClasse(classeRequest.getTipoClasse());
		classeAviao.setValorAssento(classeRequest.getValorAssento());

		return classeRepository.saveAndFlush(classeAviao);
	}

	@Override
	public ClasseAviao alterarClasse(ClasseAviaoRequestAlterar classeAviaoRequest) {
		ClasseAviao classeAviao = classeRepository.findById(classeAviaoRequest.getId()).get();
		classeAviao.setQuantidadeAssentos(classeAviaoRequest.getQuantidadeAssentos());
		classeAviao.setTipoClasse(classeAviaoRequest.getTipoClasse());
		classeAviao.setValorAssento(classeAviaoRequest.getValorAssento());
		return classeRepository.saveAndFlush(classeAviao);

	}

	@Override
	public void atualizarVooClasse(List<ClasseAviao> classeAviaoList, Voo voo) {
		for (ClasseAviao classeAviao : classeAviaoList) {
			classeAviao.setVoo(voo);
			classeRepository.saveAndFlush(classeAviao);
		}
	}

}
