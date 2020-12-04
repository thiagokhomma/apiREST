package br.com.thiagokenji.apiREST.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.thiagokenji.apiREST.model.Transacao;

@Service
public class TransacaoDAO {
	
	List <Transacao> objeto = new ArrayList<>();
	
	public Transacao createTransacao (Transacao transacao) {
		objeto.add(transacao);
		return objeto.get(0);
	}
	
	public List<Transacao> findTransacoes() {
		return objeto;
	}

}
