package main;

import main.factory.FuncionarioFactory;
import main.model.Funcionario;
import main.service.IFuncionarioService;
import main.service.imple.FuncionarioServiceImple;

public class Main {

//	TESTE PR�TICO PROGRAMA��O.
//
//	Considerando que uma ind�stria possui as pessoas/funcion�rios abaixo:
//
//	Diante disso, voc� deve desenvolver um projeto java, com os seguintes requisitos:
//	 
//	1� Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
//
//	2 � Classe Funcion�rio que estenda a classe Pessoa, com os atributos: sal�rio (BigDecimal) e fun��o (String).
//
//	3 � Deve conter uma classe Principal para executar as seguintes a��es:
//	3.1 � Inserir todos os funcion�rios, na mesma ordem e informa��es da tabela acima.
//	3.2 � Remover o funcion�rio �Jo�o� da lista.
//	3.3 � Imprimir todos os funcion�rios com todas suas informa��es, sendo que:
//	    - informa��o de data deve ser exibido no formato dd/mm/aaaa;
//	    - informa��o de valor num�rico deve ser exibida no formatado com separador de milhar como ponto e decimal como v�rgula.
//	3.4 � Os funcion�rios receberam 10% de aumento de sal�rio, atualizar a lista de funcion�rios com novo valor.
//	3.5 � Agrupar os funcion�rios por fun��o em um MAP, sendo a chave a �fun��o� e o valor a �lista de funcion�rios�.
//	3.6 � Imprimir os funcion�rios, agrupados por fun��o.
//	3.8 � Imprimir os funcion�rios que fazem anivers�rio no m�s 10 e 12.
//	3.9 � Imprimir o funcion�rio com a maior idade, exibir os atributos: nome e idade.
//	3.10 � Imprimir a lista de funcion�rios por ordem alfab�tica.
//	3.11 � Imprimir o total dos sal�rios dos funcion�rios.
//	3.12 � Imprimir quantos sal�rios m�nimos ganha cada funcion�rio, considerando que o sal�rio m�nimo � R$1212.00.
//	 
//	Orienta��es gerais:
//	    � voc� poder� utilizar a ferramenta que tem maior dom�nio (exemplos: eclipse, netbeans etc);
//	    � ap�s finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa M�o na Massa. 
//	 Basta Colar o link ainda aqui nessa etapa. 
//	    � Assim que recebermos seu projeto desenvolvido, ser� agendada uma entrevista com nosso time t�cnico para avalia��o.
	 
	
	public static void main(String[] args) {
		
		IFuncionarioService service = new FuncionarioServiceImple();
		
		try {
			Funcionario fun = FuncionarioFactory.createFuncionario("Thales", "22/04/1997", "2015,15", "Adm");
			Funcionario fun1 = FuncionarioFactory.createFuncionario("Jo�o", "25/04/1999", "3000,15", "Programador");
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
			
			service.delete("Jo�o");
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
