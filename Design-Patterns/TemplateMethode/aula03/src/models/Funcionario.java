package models;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Vendedor{
    private int anosAntiguidade;
    private List<Afiliado> afiliados = new ArrayList<>();
    protected final int PONTOS_POR_AFILIADO = 10;

    public Funcionario(int anosAntiguidade, String nome){
        super(nome);
        this.anosAntiguidade = anosAntiguidade;
    }

    public boolean addAfiliado(Afiliado afiliado){
        if(afiliado != null){
            this.afiliados.add(afiliado);
            return true;
        }
        return false;
    }

    @Override
    public int calcPontuacao(){
        return super.getVendas() * super.PONTOS_POR_VENDA
               + this.afiliados.size() * this.PONTOS_POR_AFILIADO
               + this.anosAntiguidade * super.PONTOS_POR_ANO_ANTIGUIDADE;
    }
}