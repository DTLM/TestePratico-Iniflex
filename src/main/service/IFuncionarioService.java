package main.service;

import main.exceptions.AumentoException;
import main.exceptions.FuncionarioNaoEncontradoException;
import main.model.Funcionario;

public interface IFuncionarioService {

	void inserirNaLista(Funcionario funcionario) throws Exception;
	
	void inserirMap(Funcionario funcionario) throws Exception;
	
	void delete(String nome) throws FuncionarioNaoEncontradoException;
	
	void imprimirDadosDeTodos() throws Exception;
	
	void atualizarSalarioPor10porcento() throws AumentoException;
	
	void imprimirFuncionariosComAniversario10E12();
	
	void agruparNoMap();
	
	void imprimirFuncionarioComMaiorIdade();
	
	void ImprimirListaEmOrdemAlfabetica();
	
	void imprimirTotalSalario();
	
	void imprimirQuantidadeSalarioMinimos();
	
	void imprimirPorFuncao();
}
