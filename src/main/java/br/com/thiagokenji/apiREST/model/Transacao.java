package br.com.thiagokenji.apiREST.model;

public class Transacao {
	//private Long id;
	private  float valor;
	private String  dataHora;
	
	
	public Transacao() {}
	
	public Transacao(Long id, float valor, String dataHora) {
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
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
}
