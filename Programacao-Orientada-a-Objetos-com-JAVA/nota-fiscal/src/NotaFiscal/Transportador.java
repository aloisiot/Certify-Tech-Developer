package NotaFiscal;

public class Transportador {

    private String nome;
    private String placaVeiculo;
    private int antt;

    public Transportador(String nome, String placaVeiculo, int antt) {
        this.nome = nome;
        this.placaVeiculo = placaVeiculo;
        this.antt = antt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public int getAntt() {
        return antt;
    }

    public void setAntt(int antt) {
        this.antt = antt;
    }
}
