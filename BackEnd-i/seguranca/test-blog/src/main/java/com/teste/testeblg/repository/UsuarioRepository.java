package com.teste.testeblg.repository;

import com.teste.testeblg.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.usuario = :usuario")
    Optional<Usuario> findByUsuario(@Param("usuario") String usuario);
}
