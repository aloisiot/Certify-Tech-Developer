package dev.loja.EstoqueLoja.service.impl;

import dev.loja.EstoqueLoja.model.Produto;
import dev.loja.EstoqueLoja.repository.IProdutoRepository;
import dev.loja.EstoqueLoja.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements IService {

    private IProdutoRepository produtoRepository;

    public ProdutoServiceImpl(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void excluir(long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto atualizar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(long id) {
        return produtoRepository.findById(id);
    }
}
