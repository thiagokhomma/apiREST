package br.com.thiagokenji.apiREST.model;

import java.time.OffsetDateTime;

//Criação da classe Transação Model para colocar os construtuores, getters e setters.

public class Transacao {
	private  double valor;
	private OffsetDateTime  dataHora;
	
	
	public Transacao() {
		super();
	}
	
	public Transacao(Long id, float valor, OffsetDateTime dataHora) {
		super();
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
}
