public class ApiCartao {

    public static int desconto(Cartao cartao){
        int desconto = 0;
        if(cartao.getBanco().compareTo("StarBank") == 0){
            desconto += 20;
        }
        return desconto;
    }

}
