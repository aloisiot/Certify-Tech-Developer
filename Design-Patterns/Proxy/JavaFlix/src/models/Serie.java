package models;

import java.util.Locale;

public class Serie {
    private final String HOSTNAME = "www.javaflix.com";
    private String nome;
    private String link;

    public Serie(String nome) {
        this.nome = nome;
        this.link = String.format("%s/%s", this.HOSTNAME, nome).replace(" ", "").toLowerCase(Locale.ROOT);
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }
}
