package main.service.imple;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import main.exceptions.AumentoException;
import main.exceptions.FuncionarioNaoEncontradoException;
import main.model.Funcionario;
import main.service.IFuncionarioService;
import main.util.Util;

/**
 * Classe de implementação das funções
 * 
 * @author Thiago Leal Martins
 *
 */
public class FuncionarioServiceImple implements IFuncionarioService {

	private List<Funcionario> funcionarios;
	private HashMap<String, List<Funcionario>> map;

	/**
	 * Construtor de serviços de funcionario. Inicializa a lista de funcionarios
	 */
	public FuncionarioServiceImple() {
		funcionarios = new ArrayList();
		map = new HashMap();
	}

	@Override
	public void inserirNaLista(Funcionario funcionario) throws Exception {
		if (funcionario == null) {
			throw new Exception("Funcionario vazio.");
		}
		this.funcionarios.add(funcionario);
	}

	@Override
	public void inserirMap(Funcionario funcionario) throws Exception {
		if (funcionario != null) {
			List<Funcionario> funcionariosAux = map.get(funcionario.getFuncao());
			if (funcionariosAux != null && funcionariosAux.contains(funcionario) == false) {
				funcionariosAux.add(funcionario);
			} else if (funcionariosAux == null) {
				funcionariosAux = new ArrayList();
				funcionariosAux.add(funcionario);
				map.put(funcionario.getFuncao(), funcionariosAux);
			} else {
				throw new Exception("Funcionario: " + funcionario.getNome() + " Já inserido.");
			}
		} else {
			throw new Exception("Funcionario vazio.");
		}
	}

	@Override
	public void delete(String nome) throws FuncionarioNaoEncontradoException {
		if (funcionarios == null || funcionarios.isEmpty()) {
			throw new FuncionarioNaoEncontradoException("Funcionario: " + nome + " não encontrado.");
		}
		funcionarios.removeIf(fun -> fun.getNome().equalsIgnoreCase(nome));
	}

	@Override
	public void imprimirDadosDeTodos() throws Exception {
		if (funcionarios == null || funcionarios.isEmpty()) {
			throw new Exception("Lista de funcionarios vazia.");
		}
		funcionarios.forEach(fun -> {
			fun.exibirDetalhes(); 
			System.out.println();
		});
	}

	@Override
	public void atualizarSalarioPor10porcento() throws AumentoException {
		for (Funcionario fun : funcionarios) {
			fun.setSalario(Util.calcularAumento(fun.getSalario(), BigDecimal.TEN));
		}
	}

	@Override
	public void imprimirFuncionariosComAniversario10E12() {
		List<Funcionario> funcionariosAux = funcionarios.stream().filter(
				fun -> fun.getDataNascimento().getMonthValue() == 10 || fun.getDataNascimento().getMonthValue() == 12)
				.collect(Collectors.toList());
		funcionariosAux.forEach(fun -> {
			System.out.println(fun.getNome());
		});
	}

	@Override
	public void agruparNoMap() {
		if(funcionarios.isEmpty() == false) {
			for(Funcionario fun: funcionarios) {
				try {
					this.inserirMap(fun);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		}
	}

	@Override
	public void imprimirFuncionarioComMaiorIdade() {
		if(funcionarios.isEmpty() == false) {
			Funcionario funcionarioMaisVelho = funcionarios.stream().max(Comparator.comparingInt(Funcionario::getIdade)).get();
			System.out.println("Nome: " + funcionarioMaisVelho.getNome());
			System.out.println("Idade: " +funcionarioMaisVelho.getIdade());
		}
	}

	@Override
	public void ImprimirListaEmOrdemAlfabetica() {
		if(funcionarios.isEmpty() == false) {
			List<Funcionario> aux = funcionarios;
			List<String> result = aux.stream().map(Funcionario::getNome).sorted((a,b) -> a.compareToIgnoreCase(b)).collect(Collectors.toList());
			result.forEach(name ->{
				System.out.println("Nome: "+name);
			});
//			Collections.sort(aux, (a,b) -> a.getNome().compareToIgnoreCase(b.getNome()));
//			aux.forEach(fun -> {
//				System.out.println(fun.getNome());
//			});
		}
	}

	@Override
	public void imprimirTotalSalario() {
		if(funcionarios.isEmpty() == false){
			BigDecimal somaTotal = BigDecimal.ZERO;
//			for(Funcionario fun: funcionarios) {
//				somaTotal = somaTotal.add(fun.getSalario());
//			}
			somaTotal = funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
			System.out.println(Util.FormatSalario(somaTotal));
		}
	}

	@Override
	public void imprimirQuantidadeSalarioMinimos() {
		if(funcionarios.isEmpty() == false) {
			funcionarios.forEach(fun ->{
				BigDecimal total = fun.getSalario().divide(new BigDecimal(1212), 2, RoundingMode.HALF_DOWN);
				System.out.println("Funcionario: " + fun.getNome() + " ganha " + total + " salarios minimos.");
			});
		}
	}

	@Override
	public void imprimirPorFuncao() {
		if(map.isEmpty() == false) {
			Set<String> funcoes = map.keySet();
			funcoes.forEach(funcao ->{
				List<Funcionario> aux = map.get(funcao);
				System.out.println("Função: "+ funcao);
				aux.forEach(fun ->{
					System.out.println("Funcionario: " + fun.getNome());
				});
				System.out.println();
			});
		}
	}
}
