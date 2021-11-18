package com.dh.blogPessoal.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 255)
    private String nome;

    @Size(min = 2, max = 511)
    private String descricao;

    @OneToMany
    private List<Postagem> postagemList;

    public List<Postagem> getPostagemList() {
        return postagemList;
    }

    public void setPostagemList(List<Postagem> postagemList) {
        this.postagemList = postagemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
