package dev.ctd.time.time.reposytory;

import dev.ctd.time.time.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    @Query("select j from Jogador j where j.nome = ?1")
    Optional<Jogador> findByNome(String nome);

    @Query("select j from Jogador j where j.nome like %?1%")
    List<Jogador> findByNomeContaining(String subString);
}
