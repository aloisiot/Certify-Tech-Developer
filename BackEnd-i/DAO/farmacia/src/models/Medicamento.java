package models;

public class Medicamento {
    private int id, quantidade;
    private String nome, laboratorio;
    private double preco;

    public Medicamento(int quantidade, String nome, String laboratorio, double preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.preco = preco;
    }

    public Medicamento(int id, int quantidade, String nome, String laboratorio, double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
