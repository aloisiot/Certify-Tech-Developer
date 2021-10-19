public class Main {
    public static void main(String[] args){
        FacadeDesconto facade = new FacadeDesconto();
        Produto p = new Produto("Leite condensado", "lata");
        Cartao c = new Cartao("6846841814643", "StarBank");

        int desconto = facade.desconto(p, c, 13);

        System.out.printf("Desconto total: %d", desconto);
    }
}
