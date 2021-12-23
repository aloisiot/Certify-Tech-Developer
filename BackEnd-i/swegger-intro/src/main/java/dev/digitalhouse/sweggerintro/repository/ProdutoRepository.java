package dev.digitalhouse.sweggerintro.repository;

import dev.digitalhouse.sweggerintro.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Integer> {
}
