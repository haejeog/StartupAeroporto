package br.com.hrzon.hrzonvoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrzon.hrzonvoo.request.VooRequest;
import br.com.hrzon.hrzonvoo.request.VooRequestAlterar;
import br.com.hrzon.hrzonvoo.response.ListaVooResponse;
import br.com.hrzon.hrzonvoo.service.VooService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("voo")
public class VooController {

	@Autowired
	private VooService vooService;

	@PostMapping(path = "/cadastrar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> cadastrar(@RequestBody VooRequest vooRequest) {
		try {
			vooService.cadastrarVoo(vooRequest);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/listar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ListaVooResponse> listar() {
		try {
			return ResponseEntity.ok().body(vooService.listarVoos());
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PutMapping(path = "/alterar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> alterar(@RequestBody VooRequestAlterar vooRequestAlterar) {
		try {
			vooService.alterarVoo(vooRequestAlterar);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/cancelar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> cancelar(@RequestParam Long vooId) {
		try {
			vooService.cancelarVoo(vooId);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

}
