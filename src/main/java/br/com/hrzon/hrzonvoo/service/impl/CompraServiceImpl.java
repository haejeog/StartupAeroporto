package br.com.hrzon.hrzonvoo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.entity.Compra;
import br.com.hrzon.hrzonvoo.repository.CompraRepository;
import br.com.hrzon.hrzonvoo.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {
	@Autowired
	private CompraRepository compraRepository;

	

	// Implemente os métodos da interface CompraService aqui
}