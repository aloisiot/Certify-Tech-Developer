package dev.digitalhouse.testeintegracao.controller;

import dev.digitalhouse.testeintegracao.model.Jogador;
import dev.digitalhouse.testeintegracao.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping("/{nome}")
    public ResponseEntity<Jogador> findByNome(@PathVariable String nome){
        Optional<Jogador> jogador = jogadorService.findByNome(nome);

        if(!jogador.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(jogador.get());
    }
}
