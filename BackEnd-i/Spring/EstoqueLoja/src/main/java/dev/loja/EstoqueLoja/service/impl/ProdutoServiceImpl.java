package dev.loja.EstoqueLoja.service.impl;

import dev.loja.EstoqueLoja.model.Produto;
import dev.loja.EstoqueLoja.repository.IProdutoRepository;
import dev.loja.EstoqueLoja.service.IService;

import java.util.List;

public class ServiceImpl implements IService {

    private IProdutoRepository IProdutoRepository;

    public ServiceImpl(IProdutoRepository IProdutoRepository) {
        this.IProdutoRepository = IProdutoRepository;
    }

    @Override
    public List<Produto> listarTodos() {
        return IProdutoRepository.findAll();
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return IProdutoRepository.save(produto);
    }

    @Override
    public void excluir(long id) {
        IProdutoRepository.deleteById(id);
    }

    @Override
    public Produto atualizar(Produto produto) {
        return IProdutoRepository.save(produto);
    }
}
