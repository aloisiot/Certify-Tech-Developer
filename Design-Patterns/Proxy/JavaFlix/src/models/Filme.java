package models;

import java.util.Locale;

public class Filme {
    private final String HOSTNAME = "www.javaflix.com";
    private String nome;
    private String pais;
    private String link;

    public Filme(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
        this.link = String.format("%s/get-film?%s",HOSTNAME, nome).replace(" ", "").toLowerCase(Locale.ROOT);
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public String getLink() {
        return link;
    }
}
