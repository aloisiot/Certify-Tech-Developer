package models;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String RG;
    private String nomeVacina;
    private Date dataVacina;
    public Object[] dados(){
        Object[] info;
        info = new Object[2];
        info[0] = this.RG;
        info[1] = this.dataVacina;
        return info;
    }


    public Pessoa(String nome, String sobrenome, String RG, String nomeVacina, Date dataVacina) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.nomeVacina = nomeVacina;
        this.dataVacina = dataVacina;
    }
}
