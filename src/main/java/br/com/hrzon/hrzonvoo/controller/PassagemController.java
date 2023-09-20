package br.com.hrzon.hrzonvoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrzon.hrzonvoo.entity.Passagem;
import br.com.hrzon.hrzonvoo.request.AlterarPrecoPassagemRequest;
import br.com.hrzon.hrzonvoo.request.CadastrarPassagemRequest;
import br.com.hrzon.hrzonvoo.request.ComprarPassagemRequest;
import br.com.hrzon.hrzonvoo.request.ListarPassageiroRequest;
import br.com.hrzon.hrzonvoo.request.RequestCPF;
import br.com.hrzon.hrzonvoo.service.PassagemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("passagem")
public class PassagemController {

	@Autowired
	private PassagemService passagemService;

	@GetMapping(path = "/listarPorPessoa", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Passagem>> listarPorCPF(@RequestBody RequestCPF requestCPF) {
		try {

			return ResponseEntity.ok().body(passagemService.listarPassagemPorCPF(requestCPF.getCpf()));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PostMapping(path = "/cadastrar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> cadastrar(@RequestBody CadastrarPassagemRequest request) {
		try {
			passagemService.cadastrarPassagem(request);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PutMapping(path = "/alterar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> alterarPreco(@RequestBody AlterarPrecoPassagemRequest request) {
		try {
			passagemService.alterarPreco(request.getIdPassagem(), request.getPrecoTotal());
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/listarPassageiro", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> listarPassageiro(@RequestBody ListarPassageiroRequest request) {
		try {
			return ResponseEntity.ok().body(passagemService.listarPassageiroIdPorVoo(request.getIdVoo()));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PostMapping(path = "/comprar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> comprar(@RequestBody ComprarPassagemRequest request) {
		try {
			passagemService.comprarPassagem(request);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

}
