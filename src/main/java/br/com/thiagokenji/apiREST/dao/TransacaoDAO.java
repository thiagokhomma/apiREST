package br.com.thiagokenji.apiREST.dao;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.thiagokenji.apiREST.model.Transacao;
import br.com.thiagokenji.apiREST.model.Estatistica;

@Service
public class TransacaoDAO {
	
	List <Transacao> objeto = new ArrayList<>();
	List <Estatistica> estatistica = new ArrayList<>();
	
	public ResponseEntity<Transacao> createTransacao (Transacao transacao) {
		if (transacao.getValor() < 0 || transacao.getDataHora() == null  ) {
			return ResponseEntity.status(422).build();
		} else if (transacao.getDataHora().compareTo(OffsetDateTime.now())>0) {
			return ResponseEntity.status(422).build();
		} else {
		objeto.add(transacao);
		return ResponseEntity.status(201).build(); 
		}
	}
	
	public List<Transacao> findTransacoes() {
		return objeto;
	}
	
	public void deleteTransacoes () {
			objeto.clear();
	}
	
	public Estatistica createEstatistica(Estatistica estatistica) {
		int i = 0;
		DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
		do {
			if (objeto.get(i).getDataHora().isAfter(OffsetDateTime.now().minusMinutes(1))) {
		doubleSummaryStatistics.accept(objeto.get(i).getValor()); 
			}
		i++;
		} while (i < objeto.size());
		if (doubleSummaryStatistics.getCount()>0) {
		estatistica.setCount(doubleSummaryStatistics.getCount());
		estatistica.setSum(doubleSummaryStatistics.getSum());
		estatistica.setAvg(doubleSummaryStatistics.getAverage());
		estatistica.setMin(doubleSummaryStatistics.getMin());
		estatistica.setMax(doubleSummaryStatistics.getMax());
		return estatistica; 
		} else {
			estatistica.setMin(0);
			estatistica.setMax(0);
			return estatistica;
		}
	}
	
	/*public String createEstatistica () {
		int i = 0;
		DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
		do {
			if (objeto.get(i).getDataHora().isAfter(OffsetDateTime.now().minusMinutes(1))) {
		doubleSummaryStatistics.accept(objeto.get(i).getValor()); 
			}
		i++;
		} while (i < objeto.size());
		
		return doubleSummaryStatistics.toString();
	}*/
	

	public int testeTransacao() {
		// TODO Auto-generated method stub
		return objeto.size();
	}


	
	
}
