package br.com.hrzon.hrzonvoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrzon.hrzonvoo.response.ListaAeroportoResponse;
import br.com.hrzon.hrzonvoo.service.AeroportoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("aeroporto")
public class AeroportoController {

	@Autowired
	private AeroportoService aeroportoService;

	@GetMapping(path = "/listar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ListaAeroportoResponse> listarAeroportos() {
		try {

			return ResponseEntity.ok().body(aeroportoService.listarAeroportos());
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}
}
