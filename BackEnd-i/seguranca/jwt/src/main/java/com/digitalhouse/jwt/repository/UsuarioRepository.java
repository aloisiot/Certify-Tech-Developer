package com.digitalhouse.jwt.repository;

import com.digitalhouse.jwt.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.email = :email")
    Optional<Usuario> findByEmail(@Param("email") String email);
}
