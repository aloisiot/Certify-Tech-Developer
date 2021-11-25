package dev.escola.escola.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @OneToMany(mappedBy = "autor")
    private List<Publicacao> publicacaos = new ArrayList<>();
}
