import models.Artigo;
import models.HandlerCheckQuality;

public class App {
    public static void main(String[] args) {
        Artigo artigo = new Artigo(1250, 1230, "Cafe", "saudavel");
        Artigo artigo1 = new Artigo(100, 50, "Leite", "saudavel");
        Artigo artigo2 = new Artigo(1250, 1500, "Cocacola", "quase-saudavel");
        Artigo artigo3 = new Artigo(10, 5, "Linguiça", "saudavel");
        Artigo artigo4 = new Artigo(1250, 1230, "Arroz", "quase-saudavel");

        HandlerCheckQuality h = new HandlerCheckQuality();

        System.out.printf("%s: %s%n",artigo.getNome(), h.check(artigo));
        System.out.printf("%s: %s%n",artigo1.getNome(), h.check(artigo1));
        System.out.printf("%s: %s%n",artigo2.getNome(), h.check(artigo2));
        System.out.printf("%s: %s%n",artigo3.getNome(), h.check(artigo3));
        System.out.printf("%s: %s%n",artigo4.getNome(), h.check(artigo4));
    }
}
