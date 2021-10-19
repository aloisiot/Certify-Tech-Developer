public class FacadeDesconto implements IFacadeDesconto{

    public int desconto(Produto produto, Cartao cartao, int quantidade){
        int desconto = 0;

        desconto += ApiCartao.desconto(cartao);
        desconto += ApiProduto.desconto(produto);
        desconto += ApiQuantidade.desconto(quantidade);

        return desconto;
    }

}
