package org.cruxframework.test.cruxtestwidgets.client.modelo;

public class Pessoa {
	private String nome;
	private Integer idade;
	private String cpf;
	private Endereco endereco;
	
	
	public Pessoa() {
		this.nome = new String();
		this.idade = new Integer(0);
		this.cpf = new String();
		this.endereco = new Endereco();
	}
	public Pessoa(String nome, Integer idade, String cpf,Endereco endereco) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
