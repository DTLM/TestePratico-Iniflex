package main.factory;

import main.exceptions.CreateFuncionarioException;
import main.model.Funcionario;
import main.util.Util;

public class FuncionarioFactory {

	public static Funcionario createFuncionario(String nome, String dataNascimento, String salario, String funcao) throws Exception {
		if(nome.isBlank() || dataNascimento.isBlank() || salario.isBlank() || funcao.isBlank()) {
			throw new CreateFuncionarioException("Dado/os não encontrado. Verifique os dados e tente novamente.");
		}
		return new Funcionario(nome, Util.StringToLocalDate(dataNascimento), Util.stringToBigDecimal(salario), funcao);
	}
}
