package models;

public class Estagiario extends Vendedor{

    public Estagiario(String nome){
        super(nome);
    }

    @Override
    public int calcPontuacao(){
        return super.getVendas() * super.PONTOS_POR_VENDA;
    }

    @Override
    protected String getCategoria(){
        int pontos = calcPontuacao();
        if(pontos < 50){
            return "novato";
        }
        return "experiente";
    }
}
