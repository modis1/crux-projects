package org.cruxframework.test.cruxtestwidgets.client.modelo;

public class Endereco {
	private String rua;
	private Double numero;
	private String bairro;
	private String cidade;
	
	public Endereco() {
		this.rua = new String();
		this.numero= new Double(0.0);
		this.bairro = new String();
		this.cidade = new String();
	}
	
	public Endereco( String rua, Double numero, String bairro, String cidade ){
		this.rua = rua;
		this.numero= numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Double getNumero() {
		return numero;
	}
	public void setNumero(Double numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
