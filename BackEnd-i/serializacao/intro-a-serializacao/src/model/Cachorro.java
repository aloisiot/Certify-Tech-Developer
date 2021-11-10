package model;

import java.io.Serializable;

public class Cachorro implements Serializable{
    private int idade;
    private String nome;

    public Cachorro(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
}
