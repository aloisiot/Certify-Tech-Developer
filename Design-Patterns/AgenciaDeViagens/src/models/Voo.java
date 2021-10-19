package models;

public class Voo {
    private String dataPartida;
    private String dataRetorno;
    private String cidade;

    public Voo(String dataPartida, String dataRetorno, String cidade) {
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "dataPartida = '" + dataPartida + '\'' +
                ", dataRetorno = '" + dataRetorno + '\'' +
                ", cidade = '" + cidade + '\'' +
                '}';
    }
}
