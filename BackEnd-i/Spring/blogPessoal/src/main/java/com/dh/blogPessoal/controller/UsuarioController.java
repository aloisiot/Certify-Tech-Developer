package com.dh.blogPessoal.controller;

import com.dh.blogPessoal.model.Usuario;
import com.dh.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    private ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Usuario> getById (@PathVariable Integer id){
        return usuarioRepository.findById(id).map( resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    private ResponseEntity<Usuario> getByName (@PathVariable String nome){
        return ResponseEntity.ok(usuarioRepository.findByUsuario(nome));
    }

    @PostMapping
    private ResponseEntity<Usuario> create (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping
    private ResponseEntity<Usuario> update (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        usuarioRepository.deleteById(id);
    }

}
