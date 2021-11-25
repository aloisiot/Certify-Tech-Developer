package dev.loja.EstoqueLoja.service;

import dev.loja.EstoqueLoja.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService {
    List<Produto> listarTodos();
    Produto cadastrar(Produto produto);
    void excluir(long id);
    Produto atualizar(Produto produto);
    Optional<Produto> buscarPorId(long id);
}
