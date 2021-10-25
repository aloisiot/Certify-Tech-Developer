import flyweight.ArvoresFlyweight;
import models.Arvore;

public class App {
    public static void main(String[] args) {
        ArvoresFlyweight floresta = new ArvoresFlyweight();
        floresta.getArvore(200, 400, "verde");
        floresta.getArvore(200, 400, "verde");
        floresta.getArvore(500, 300, "vermelha");
        floresta.getArvore(500, 300, "vermelha");
        floresta.getArvore(100, 200, "azul");
        floresta.getArvore(100, 200, "azul");

        System.out.printf("Total de arvores criadas: %s", Arvore.getCount());
    }
}
