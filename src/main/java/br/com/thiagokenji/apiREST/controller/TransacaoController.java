package br.com.thiagokenji.apiREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagokenji.apiREST.dao.TransacaoDAO;
import br.com.thiagokenji.apiREST.model.Transacao;

@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoDAO transacaoDAO;
	
	@PostMapping("/transacao")
	public Transacao createTransacao(@RequestBody Transacao transacao) {
		return transacaoDAO.createTransacao(transacao);
	}
	
	@GetMapping("/todos")
	public List<Transacao> findAllTransacao() {
		return transacaoDAO.findTransacoes();
	}
	
	@DeleteMapping("/transacao")
	public void deleteTransacao () {
		transacaoDAO.deleteTransacoes();
	}
}
	


