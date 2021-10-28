package model;

public class Pessoa {
    private int idade;
    private String nome, sobrenome;

    public Pessoa(int idade, String nome, String sobrenome) {
        this.idade = idade;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCOmpleto(){
        return String.format("%s %s",this.nome, this.sobrenome);
    }

    public boolean eAdulto(){
        return this.idade >= 18;
    }
}
