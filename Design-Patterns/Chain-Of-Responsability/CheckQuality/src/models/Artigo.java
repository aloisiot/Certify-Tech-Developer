package models;

public class Artigo {
    private int lote;
    private int peso;
    private String nome;
    private String embalagem;

    public Artigo(int lote, int peso, String nome, String embalagem) {
        this.lote = lote;
        this.peso = peso;
        this.nome = nome;
        this.embalagem = embalagem;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
}
