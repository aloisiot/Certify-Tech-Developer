package dev.loja.EstoqueLoja.service;

import dev.loja.EstoqueLoja.model.Produto;

import java.util.List;

public interface IProdutoService {
    List<Produto> listarTodos();
    Produto cadastrar(Produto produto);
    void excluir(long id);
    Produto atualizar(Produto produto);
}
