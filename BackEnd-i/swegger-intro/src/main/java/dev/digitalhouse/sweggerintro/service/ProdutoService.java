package dev.digitalhouse.sweggerintro.service;

import dev.digitalhouse.sweggerintro.model.Produto;
import dev.digitalhouse.sweggerintro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto save(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> listAll(){
        return repository.findAll();
    }

    public Produto findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
