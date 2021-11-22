package dev.escola.escola.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer versao;

    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

    private LocalDate data;

}
