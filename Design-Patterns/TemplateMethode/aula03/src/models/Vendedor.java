package models;

public abstract class Vendedor {
    private String nome;
    private int vendas;
    protected final int PONTOS_POR_VENDA = 5;
    protected final int PONTOS_POR_ANO_ANTIGUIDADE = 5;

    public Vendedor(String nome) {
        this.nome = nome;
    }

    public abstract int calcPontuacao();

    public void vender(int qtdVendas){
        this.vendas += qtdVendas;
    }

    public String mostrarCategoria() {
        return String.format("Nome: %s%nPontuação: %s%nCategoria: %s%n", getNome(), calcPontuacao(), getCategoria());
    }

    protected String getCategoria(){
        int pontos = calcPontuacao();
        String categoria;

        if(pontos < 20){
            categoria = "novato";
        } else if(pontos < 31) {
            categoria = "novato";
        } else if (pontos < 41){
            categoria = "avançado";
        } else {
            categoria = "mestre";
        }
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

}
