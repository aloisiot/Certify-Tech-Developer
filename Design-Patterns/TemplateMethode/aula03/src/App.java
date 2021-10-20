import models.*;

public class App {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario(12, "Alan");
        Afiliado afiliado1 = new Afiliado("Davi");
        Afiliado afiliado2 = new Afiliado("Alana");
        Afiliado afiliado3 = new Afiliado("Marcia");
        Estagiario estagiario = new Estagiario("Luiza");

        funcionario.addAfiliado(afiliado1);
        funcionario.addAfiliado(afiliado2);
        funcionario.addAfiliado(afiliado3);

        funcionario.vender(9);
        afiliado1.vender(3);
        afiliado2.vender(10);
        afiliado3.vender(15);
        estagiario.vender(60);

        System.out.println(funcionario.mostrarCategoria());
        System.out.println(afiliado1.mostrarCategoria());
        System.out.println(afiliado2.mostrarCategoria());
        System.out.println(afiliado3.mostrarCategoria());
        System.out.println(estagiario.mostrarCategoria());

    }
}
