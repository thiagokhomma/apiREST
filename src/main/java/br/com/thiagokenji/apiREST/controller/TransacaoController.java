package br.com.thiagokenji.apiREST.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {
	
	
	@PostMapping("/transacao")
	public String sayHello() {
		return "Hello  World";
	}
}
	


