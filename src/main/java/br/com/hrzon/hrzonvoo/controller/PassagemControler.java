package br.com.hrzon.hrzonvoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrzon.hrzonvoo.service.PassagemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
public class PassagemControler {

	@Autowired
	private PassagemService passagemService;

}
