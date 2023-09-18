package br.com.hrzon.hrzonvoo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.EtiquetaBagagem;
import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.repository.EtiquetaBagagemRepository;
import br.com.hrzon.hrzonvoo.service.EtiquetaBagagemService;

@Service
public class EtiquetaBagagemServiceImpl implements EtiquetaBagagemService {
	@Autowired
	private EtiquetaBagagemRepository etiquetaBagagemRepository;

	
}