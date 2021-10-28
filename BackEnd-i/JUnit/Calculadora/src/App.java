public class App {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int result = calculadora.somar(2,4);
        System.out.printf("Resultado: %s", result);
    }
}
