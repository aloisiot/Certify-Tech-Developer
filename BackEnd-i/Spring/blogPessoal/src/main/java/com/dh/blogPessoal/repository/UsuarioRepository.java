package com.dh.blogPessoal.repository;

import com.dh.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    Usuario findByUsuario(String nome);
}
