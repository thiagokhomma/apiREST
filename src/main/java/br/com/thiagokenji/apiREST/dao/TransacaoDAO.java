package br.com.thiagokenji.apiREST.dao;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.thiagokenji.apiREST.model.Transacao;
import br.com.thiagokenji.apiREST.model.Estatistica;

@Service //Anotation usado para marcar a classe que executa o serviço, a lógica, os cálculos, etc...
public class TransacaoDAO {
	
	List <Transacao> objeto = new ArrayList<>();
	
	//Método responsável por adicionar uma transação na lista seguindo as condições exigidas (endpoint: POST /transacao)
	public ResponseEntity<Transacao> createTransacao (Transacao transacao) { 
		if (transacao.getValor() < 0 || transacao.getDataHora() == null  ) { //condição utilido para nao deixar colocar valores negativos e nem o campo dataHora nulo
			return ResponseEntity.status(422).build();
		} else if (transacao.getDataHora().compareTo(OffsetDateTime.now())>0) { //utilizado os métodos do  DoubleSummaryStatistics para verificar se o horário da transação não é do futuro
			return ResponseEntity.status(422).build();
		} else {
		objeto.add(transacao);
		return ResponseEntity.status(201).build(); 
		}
	}
	
	//Método responsável por me retornar todas as transações da lista. Criado apenas para efeito de testes
	public List<Transacao> findTransacoes() {
		return objeto;
	}
	
	//Método criado para deletar todas as transações da fila (endpoint: DELETE /transacao)
	public void deleteTransacoes () {
			objeto.clear();
	}
	
	//Método criado para calcular as estatíticas exigidas para o terceiro endpoint e retornar um JSON(GET /estatistica)
	public Estatistica createEstatistica(Estatistica estatistica) {
		int i = 0;
		DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
		do {
			if (objeto.get(i).getDataHora().isAfter(OffsetDateTime.now().minusMinutes(1))) {    //utilizado os métodos do OffsetDateTime para verificar se o 
		doubleSummaryStatistics.accept(objeto.get(i).getValor());                               //horário da transação está dentro do período de 1min para atrás do horário atual
			}
		i++;
		} while (i < objeto.size());
		if (doubleSummaryStatistics.getCount()>0) {                   //Antes de retornar o objeto estatistica, verifico se
		estatistica.setCount(doubleSummaryStatistics.getCount());    // o objeto não está nulo para representar adequadamente
		estatistica.setSum(doubleSummaryStatistics.getSum());       //os valores solicitados (sem isso o Min e Max estavam
		estatistica.setAvg(doubleSummaryStatistics.getAverage());   //tendendo ao infinito.
		estatistica.setMin(doubleSummaryStatistics.getMin());
		estatistica.setMax(doubleSummaryStatistics.getMax());
		return estatistica; 
		} else {
			estatistica.setMin(0);
			estatistica.setMax(0);
			return estatistica;
		}
	}


	
	
}
