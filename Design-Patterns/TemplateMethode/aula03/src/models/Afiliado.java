package models;

public class Afiliado extends Vendedor{
    protected final int PONTOS_POR_VENDA = 15;

    public Afiliado(String nome){
        super(nome);
    }

    @Override
    public int calcPontuacao() {
        return super.getVendas() * this.PONTOS_POR_VENDA;
    }

}
