package dev.digitalhouse.testeintegracao.repository;

import dev.digitalhouse.testeintegracao.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    @Query("select j from Jogador j where j.nome = :nome")
    Optional<Jogador> findByNome(@Param("nome") String nome);
}
