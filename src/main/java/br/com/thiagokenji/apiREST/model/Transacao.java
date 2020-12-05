package br.com.thiagokenji.apiREST.model;

import java.sql.Date;
import java.time.OffsetDateTime;

public class Transacao {
	//private Long id;
	private  float valor;
	private OffsetDateTime  dataHora;
	
	
	public Transacao() {}
	
	public Transacao(Long id, float valor, OffsetDateTime dataHora) {
		super();
		//this.id = id;
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
	//public Long getId() {
		//return id;
	//}
	//public void setId(Long id) {
	//	this.id = id;
	//}
	public float getValor() {
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
