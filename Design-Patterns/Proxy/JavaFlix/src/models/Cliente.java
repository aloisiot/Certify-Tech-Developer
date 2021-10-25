package models;

public class Cliente {
    private String ip;
    private String nome;

    public Cliente(String ip, String nome) {
        this.ip = ip;
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public String getNome() {
        return nome;
    }
}
