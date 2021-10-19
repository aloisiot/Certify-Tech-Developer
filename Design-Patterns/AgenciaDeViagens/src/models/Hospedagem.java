package models;

public class Hospedagem {
    private String dataEntrada;
    private String dataSaida;
    private String cidade;

    public Hospedagem(String dataEntrada, String dataSaida, String cidade) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Hospedagem{" +
                "dataEntrada = '" + dataEntrada + '\'' +
                ", dataSaida = '" + dataSaida + '\'' +
                ", cidade = '" + cidade + '\'' +
                '}';
    }
}
