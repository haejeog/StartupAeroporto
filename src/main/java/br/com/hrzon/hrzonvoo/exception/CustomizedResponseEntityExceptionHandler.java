package br.com.hrzon.hrzonvoo.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hrzon.hrzonvoo.ExceptionResponse;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CpfInvalidoException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(NoSuchElementException ex,
			WebRequest request) {
		String mensagem = "Nao foi encontrado no banco de dados: " + ex.getMessage();
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), mensagem,
				HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}