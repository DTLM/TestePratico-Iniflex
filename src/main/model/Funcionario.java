package main.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import main.util.Util;

public class Funcionario extends Pessoa{
	
	private BigDecimal salario;
	private String funcao;

	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	@Override
	public void exibirDetalhes() {
		super.exibirDetalhes();
		if(salario != null) {
			System.out.println("Salário: " + Util.FormatSalario(this.salario));
		}
		if(funcao.isBlank() == false) {
			System.out.println("Função: " + this.funcao);
		}
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public String getSalarioFormatado() {
		return Util.FormatSalario(this.salario);
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public int getIdade() {
		return Period.between(getDataNascimento(), LocalDate.now()).getYears();
	}
	
}
