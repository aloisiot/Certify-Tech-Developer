package dev.escola.escola.model;

import javax.persistence.*;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "rg")
    private String rg;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;
}
