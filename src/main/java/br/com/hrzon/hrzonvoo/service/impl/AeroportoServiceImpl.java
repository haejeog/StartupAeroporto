package br.com.hrzon.hrzonvoo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.mapper.AeroportoMapper;
import br.com.hrzon.hrzonvoo.repository.AeroportoRepository;
import br.com.hrzon.hrzonvoo.response.ListaAeroportoResponse;
import br.com.hrzon.hrzonvoo.service.AeroportoService;

@Service
public class AeroportoServiceImpl implements AeroportoService {
	@Autowired
	private AeroportoRepository aeroportoRepository;

	@Autowired
	private AeroportoMapper aeroportoMapper;

	@Override
	public ListaAeroportoResponse listarAeroportos() {

		return aeroportoMapper.convertToList(aeroportoRepository.findAll());
	}

}
