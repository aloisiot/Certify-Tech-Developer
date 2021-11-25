package dev.loja.EstoqueLoja.repository;

import dev.loja.EstoqueLoja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
