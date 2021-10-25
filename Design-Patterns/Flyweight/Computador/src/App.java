import Flyweight.ComputadorFactory;
import models.Computador;

public class App {
    public static void main(String[] args) {
        ComputadorFactory computadores = new ComputadorFactory();
        computadores.getComputador(16, 256);
        computadores.getComputador(16, 256);
        computadores.getComputador(8, 512);
        computadores.getComputador(4, 256);
        computadores.getComputador(32, 1024);
        computadores.getComputador(32, 1024);

        int r = Computador.getContador();
        System.out.println("\nTotal de computadores criados: " + r);    }
}
