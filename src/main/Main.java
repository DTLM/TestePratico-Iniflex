package main;

import main.factory.FuncionarioFactory;
import main.model.Funcionario;
import main.service.IFuncionarioService;
import main.service.imple.FuncionarioServiceImple;

public class Main {

//	TESTE PRÁTICO PROGRAMAÇÃO.
//
//	Considerando que uma indústria possui as pessoas/funcionários abaixo:
//
//	Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:
//	 
//	1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
//
//	2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
//
//	3 – Deve conter uma classe Principal para executar as seguintes ações:
//	3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
//	3.2 – Remover o funcionário “João” da lista.
//	3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
//	    - informação de data deve ser exibido no formato dd/mm/aaaa;
//	    - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
//	3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
//	3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
//	3.6 – Imprimir os funcionários, agrupados por função.
//	3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
//	3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
//	3.10 – Imprimir a lista de funcionários por ordem alfabética.
//	3.11 – Imprimir o total dos salários dos funcionários.
//	3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
//	 
//	Orientações gerais:
//	    • você poderá utilizar a ferramenta que tem maior domínio (exemplos: eclipse, netbeans etc);
//	    • após finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa Mão na Massa. 
//	 Basta Colar o link ainda aqui nessa etapa. 
//	    • Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.
	 
	
	public static void main(String[] args) {
		
		IFuncionarioService service = new FuncionarioServiceImple();
		
		try {
			Funcionario fun = FuncionarioFactory.createFuncionario("Thales", "22/04/1997", "2015,15", "Adm");
			Funcionario fun1 = FuncionarioFactory.createFuncionario("João", "25/04/1999", "3000,15", "Programador");
			Funcionario fun2 = FuncionarioFactory.createFuncionario("Leticia", "22/10/1999", "201,15", "vendedor");
			Funcionario fun3 = FuncionarioFactory.createFuncionario("rodrigo", "20/03/1999", "205,15", "qa");
			Funcionario fun4 = FuncionarioFactory.createFuncionario("carla", "02/01/1999", "20,15", "financeiro");
			Funcionario fun5 = FuncionarioFactory.createFuncionario("andressa", "23/08/1999", "25,15", "Adm");
			Funcionario fun6 = FuncionarioFactory.createFuncionario("carlos", "22/03/1999", "2,15", "Adm");
			Funcionario fun7 = FuncionarioFactory.createFuncionario("jose", "22/09/1999", "215,15", "Adm");
			
			service.inserirNaLista(fun);
			service.inserirNaLista(fun1);
			service.inserirNaLista(fun2);
			service.inserirNaLista(fun3);
			service.inserirNaLista(fun4);
			service.inserirNaLista(fun5);
			service.inserirNaLista(fun6);
			service.inserirNaLista(fun7);
			
			service.delete("João");
			System.out.println("-------------------------------------------------------");
			service.imprimirDadosDeTodos();
			service.atualizarSalarioPor10porcento();
			service.agruparNoMap();
			
			System.out.println("-------------------------------------------------------");
			service.imprimirPorFuncao();
			System.out.println("-------------------------------------------------------");
			service.imprimirFuncionariosComAniversario10E12();
			System.out.println("-------------------------------------------------------");
			service.imprimirFuncionarioComMaiorIdade();
			System.out.println("-------------------------------------------------------");
			service.ImprimirListaEmOrdemAlfabetica();
			System.out.println("-------------------------------------------------------");
			service.imprimirTotalSalario();
			System.out.println("-------------------------------------------------------");
			service.imprimirQuantidadeSalarioMinimos();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
