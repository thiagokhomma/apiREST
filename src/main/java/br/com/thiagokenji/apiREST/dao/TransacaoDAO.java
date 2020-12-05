package br.com.thiagokenji.apiREST.dao;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.thiagokenji.apiREST.model.Transacao;
import br.com.thiagokenji.apiREST.model.Estatistica;

@Service
public class TransacaoDAO {
	
	List <Transacao> objeto = new ArrayList<>();
	DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
	
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
	
	public String createEstatistica () {
		//for (int i = 0; i== objeto.size()-1; i++) {
		int i = 0;
		do {
		doubleSummaryStatistics.accept(objeto.get(i).getValor());
		i++;
		} while (i < objeto.size());
		return doubleSummaryStatistics.toString();
	}

	public int testeTransacao() {
		// TODO Auto-generated method stub
		return objeto.size();
	}

	
	
}
