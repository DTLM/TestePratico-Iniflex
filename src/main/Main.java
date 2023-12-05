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
			Funcionario fun = FuncionarioFactory.createFuncionario("Maria", "18/10/2000", "2009.44", "Operador");
			Funcionario fun1 = FuncionarioFactory.createFuncionario("Jo�o", "12/05/1990", "2284.38", "Operador");
			Funcionario fun2 = FuncionarioFactory.createFuncionario("Caio", "02/05/1961", "9836.14", "Coordenador");
			Funcionario fun3 = FuncionarioFactory.createFuncionario("Miguel", "14/10/1988", "19119.88", "Diretor");
			Funcionario fun4 = FuncionarioFactory.createFuncionario("Alice", "05/01/1995", "2234.68", "Recepcionista");
			Funcionario fun5 = FuncionarioFactory.createFuncionario("Heitor", "19/11/1999", "1582.72", "Operador");
			Funcionario fun6 = FuncionarioFactory.createFuncionario("Arthur", "31/03/1993", "4071.84", "Contador");
			Funcionario fun7 = FuncionarioFactory.createFuncionario("Laura", "08/07/1994", "3017.45", "Gerente");
			Funcionario fun8 = FuncionarioFactory.createFuncionario("Helo�sa", "24/05/2003", "1606.85", "Eletricista");
			Funcionario fun9 = FuncionarioFactory.createFuncionario("Helena", "02/09/1996", "2799.93", "Gerente");
			
			service.inserirNaLista(fun);
			service.inserirNaLista(fun1);
			service.inserirNaLista(fun2);
			service.inserirNaLista(fun3);
			service.inserirNaLista(fun4);
			service.inserirNaLista(fun5);
			service.inserirNaLista(fun6);
			service.inserirNaLista(fun7);
			service.inserirNaLista(fun8);
			service.inserirNaLista(fun9);
			
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
