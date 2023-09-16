package br.com.hrzon.hrzonvoo.exception;

public class CpfInvalidoException extends RuntimeException{
	private static final long serialVersionUID = -2898023170980681756L;

	public CpfInvalidoException() {
		super("CPF INVÁLIDO!");
	}
}
