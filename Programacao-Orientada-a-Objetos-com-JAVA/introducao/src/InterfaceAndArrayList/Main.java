package InterfaceAndArrayList;

public class Main {

    public static void main(String[] args) {
        Pessoa p = new Pessoa("Paula", "Santana", 27);

        p.novaConta(12, 4390.00);
        p.novaConta(13, 1456.00);
        p.novaConta(14, 920.00);

        System.out.println("\n");
        System.out.printf("Saldo total de %s: %s\n\n", p.getNomeCompleto(), p.getSaldoTotal());
        System.out.println("Informações de todas as contas: " + p.mostrarContas());

    }
}
