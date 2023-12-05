package main.model;

import java.time.LocalDate;

import main.util.Util;

public class Pessoa {

	private String nome;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public void exibirDetalhes() {
		if(nome.isBlank() == false) {
			System.out.println("Nome: " + this.nome);
		}
		if(dataNascimento != null) {
			System.out.println("Data de nascimento: " + Util.formatDataToString(dataNascimento));
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
