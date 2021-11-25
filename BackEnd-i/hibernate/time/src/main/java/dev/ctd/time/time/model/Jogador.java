package dev.ctd.time.time.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String timeFavorito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treinador_id")
    private Treinador treinador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTimeFavorito() {
        return timeFavorito;
    }

    public void setTimeFavorito(String timeFavorito) {
        this.timeFavorito = timeFavorito;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }
}
