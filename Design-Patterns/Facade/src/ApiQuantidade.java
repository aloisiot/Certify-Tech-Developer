public class ApiQuantidade {

    public static int desconto(int quantidade){
        int desconto = 0;
        if(quantidade > 12)
            desconto += 15;
        return desconto;
    }
}
