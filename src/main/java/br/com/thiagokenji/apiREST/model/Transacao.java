package br.com.thiagokenji.apiREST.model;

import java.time.OffsetDateTime;

public class Transacao {
	private  double valor;
	private OffsetDateTime  dataHora;
	
	
	public Transacao() {}
	
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
