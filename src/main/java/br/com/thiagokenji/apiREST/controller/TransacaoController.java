package br.com.thiagokenji.apiREST.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagokenji.apiREST.dao.TransacaoDAO;
import br.com.thiagokenji.apiREST.model.Estatistica;
import br.com.thiagokenji.apiREST.model.Transacao;

@RestController //Anotation para marcar a classe como um controlador
public class TransacaoController {
	
	@Autowired //Anotation usada para marcar o ponto de injeção na classe TransacaoController
	private TransacaoDAO transacaoDAO;
	
	@PostMapping("/transacao") //Anotation usado para mapear a solicitação HTTP POST em /transação
	public ResponseEntity<Transacao> createTransacao(@RequestBody Transacao transacao) {
		return transacaoDAO.createTransacao(transacao);
	}
	
	@GetMapping("/todos") //Transação para solicitação http GET para receber a lista de todas as transações
	public List<Transacao> findAllTransacao() {
		return transacaoDAO.findTransacoes();
	}
	
	@DeleteMapping("/transacao") //Anotation para solicitações http Delete em /transacao para apagar todas as transações
	public void deleteTransacao () {
		transacaoDAO.deleteTransacoes();
	}
	
	@GetMapping ("/estatistica") //Anotation para solicitação http GET em /estatisca para calcular e receber as estaticas das transações de 1 min atrás
	public Estatistica createEstatistica (Estatistica estatistica) {
		return transacaoDAO.createEstatistica(estatistica);
	}
	
	 
}
	


