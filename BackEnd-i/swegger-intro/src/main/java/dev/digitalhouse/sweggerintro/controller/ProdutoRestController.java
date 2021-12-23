package dev.digitalhouse.sweggerintro.controller;

import dev.digitalhouse.sweggerintro.model.Produto;
import dev.digitalhouse.sweggerintro.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoRestController {

    // URL para visualizar o Swagger
    // http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

    private ProdutoService service;

    @Autowired
    public ProdutoRestController(ProdutoService service) {
        this.service = service;
    }

    @Operation(summary = "Registrar novo produto")
    @PostMapping
    public Produto save(@RequestBody Produto produto){
        return service.save(produto);
    }

    @Operation(summary = "Lista todos os produtos registrados")
    @GetMapping
    public List<Produto> listAll(){
        return service.listAll();
    }

    @Operation(summary = "Busca um produto com base no ID")
    @GetMapping("/{id}")
    public Produto findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @Operation(summary = "Deleta um produto com base no ID")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return "Produto deletado";
    }


}
