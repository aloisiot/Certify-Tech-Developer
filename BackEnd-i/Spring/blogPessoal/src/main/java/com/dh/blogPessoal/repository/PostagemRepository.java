package com.dh.blogPessoal.repository;

import com.dh.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
    Postagem findByTitulo(String titulo);
}
