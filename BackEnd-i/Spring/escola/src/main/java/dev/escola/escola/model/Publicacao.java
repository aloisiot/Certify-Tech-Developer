package dev.escola.escola.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "versao")
    private Integer versao;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

    @Column(name = "data-criacao")
    private LocalDate dataCriacao;

}
