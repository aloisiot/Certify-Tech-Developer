public class ApiProduto {

    public static int desconto(Produto produto){
        int desconto = 0;
        if(produto.getTipo().compareTo("lata") == 0){
            desconto += 10;
        }
        return desconto;
    }
}
