package models;

public class Mensagem {
    private String conteudo;
    private int tipo;

    public Mensagem(String conteudo, int tipo) {
        this.conteudo = conteudo;
        this.tipo = tipo;
    }

    public boolean permitirLeitura(int getGrauHierarquico){
        if(getGrauHierarquico >= this.tipo) {
            return true;
        }
        return false;
    }

    public String getConteudo() {
        return conteudo;
    }

}
