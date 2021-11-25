package dev.loja.EstoqueLoja.controller;

import dev.loja.EstoqueLoja.model.Produto;
import dev.loja.EstoqueLoja.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoControler {

    private ProdutoServiceImpl produtoService;

    @Autowired
    public ProdutoControler(ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    private ResponseEntity<Produto> save(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastrar(produto));
    }

    @GetMapping
    private ResponseEntity<List<Produto>> listarTodos(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Produto> findAll(@PathVariable long id){
        return ResponseEntity.ok(produtoService.buscarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    private void excluir(@PathVariable long id){
        produtoService.excluir(id);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.atualizar(produto));
    }
}
