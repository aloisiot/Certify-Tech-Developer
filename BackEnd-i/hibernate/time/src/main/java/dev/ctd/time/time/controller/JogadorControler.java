package dev.ctd.time.time.controller;

import dev.ctd.time.time.model.Jogador;
import dev.ctd.time.time.model.Treinador;
import dev.ctd.time.time.service.impl.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/jogador")
public class JogadorControler {

    private JogadorService jogadorService;

    public JogadorControler(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    private ResponseEntity<Map> cadastrarJogador(@RequestBody Map jogador){
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.cadastrar(jogador));
    }

    @GetMapping
    private ResponseEntity<List<Map>> listarTodosJogadores (){
        return ResponseEntity.ok(jogadorService.buscarTodos());
    }

    @GetMapping("/nome/{nome}")
    private ResponseEntity<Map> buscarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(jogadorService.buscarPorNome(nome));
    }

    @GetMapping("/nome-contem/{subString}")
    private ResponseEntity<List<Map>> listarJogadoresCujoNomeContem(@PathVariable String subString){
        return ResponseEntity.ok(jogadorService.buscarCujoNomeContem(subString));
    }

    @GetMapping("/findBytreinador")
    private ResponseEntity<List<Map>> busscarJogadoresPorTreinador(@RequestBody Treinador treinador){
        return ResponseEntity.ok(jogadorService.buscarPorTreinador(treinador.getId()));
    }
}
