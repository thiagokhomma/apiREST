package br.com.thiagokenji.apiREST.model;

//Criação da classe Estatistica Model para colocar os construtuores, getters e setters.

public class Estatistica {
	private Long count;
	private double sum;
	private double avg;
	private double min;
	private double max;
	public Estatistica(Long count, double sum, double avg, double min, double max) {
		super();
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.min = min;
		this.max = max;
	}
	public Estatistica() {
		super();
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	
	
	

}
