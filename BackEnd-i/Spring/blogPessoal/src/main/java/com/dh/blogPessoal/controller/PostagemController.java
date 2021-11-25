package com.dh.blogPessoal.controller;

import com.dh.blogPessoal.model.Postagem;
import com.dh.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    private ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Postagem> getById(@PathVariable Integer id){
        return postagemRepository.findById(id).map( resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    private ResponseEntity<Postagem> getByTitle(@PathVariable String titulo){
        return ResponseEntity.ok(postagemRepository.findByTitulo(titulo));
    }

    @PostMapping
    private ResponseEntity<Postagem> create(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }

    @PutMapping
    private ResponseEntity<Postagem> update(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        postagemRepository.deleteById(id);
    }

}
