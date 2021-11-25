package dev.ctd.time.time.reposytory;

import dev.ctd.time.time.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TreinadorRepository extends JpaRepository<Treinador, Long> {


    @Query("select t from Treinador t where t.nome = ?1")
    Optional<Treinador> findByNome(String nome);

    @Query("select t from Treinador t where t.nome like %?1%")
    List<Treinador> findByNomeContaining(String subString);

}
