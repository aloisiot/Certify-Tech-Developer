package dev.loja.EstoqueLoja.repository;

import dev.loja.EstoqueLoja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
