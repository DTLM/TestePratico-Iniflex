package main.exceptions;

public class FuncionarioNaoEncontradoException extends Exception{
	public FuncionarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
