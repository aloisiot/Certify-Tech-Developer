package br.com.alura.testjwt.controller;

import br.com.alura.testjwt.model.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@GetMapping({"/hello"})
	public String hello() {
		return "Olá mundo JWT";
	}

	@GetMapping({"/adeus"})
	public String adeus() {
		return "Adeus mundo JWT";
	}
}
