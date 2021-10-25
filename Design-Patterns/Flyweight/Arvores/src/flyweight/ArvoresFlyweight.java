package flyweight;

import models.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoresFlyweight {
    private Map<String, Arvore> ornamentais = new HashMap<>();
    private Map<String, Arvore> frutiferas = new HashMap<>();
    private Map<String, Arvore> floriferas = new HashMap<>();

    public Arvore getArvore(int altura, int largura, String cor){
        Arvore arvore = null;

        if(altura == 200 &&  largura == 400 && cor.equalsIgnoreCase("verde") ){
            arvore = factoryArvore(ornamentais, altura, largura, cor);
            System.out.printf("Tipo: ornamental%naltura: %s%nlargura: %s%ncor: %s%n%n", altura, largura, cor);
        } else if( altura == 500 && largura == 300 && cor.equalsIgnoreCase("vermelha")){
            arvore = factoryArvore(frutiferas, altura, largura, cor);
            System.out.printf("Tipo: frutiferas%naltura: %s%nlargura: %s%ncor: %s%n%n", altura, largura, cor);
        } else if(  altura == 100 && largura == 200 && cor.equalsIgnoreCase("azul")){
            arvore = factoryArvore(floriferas, altura, largura, cor);
            System.out.printf("Tipo: floriferas%naltura: %s%nlargura: %s%ncor: %s%n%n", altura, largura, cor);
        }

        return arvore;
    }

    private Arvore factoryArvore(Map colection, int altura, int largura, String cor){
        String key = String.format("%s-%s-%s", altura, largura, cor);
        Arvore result = null;
        if(!ornamentais.containsKey(key)){
            System.out.println("A arvore foi criada");
            result = new Arvore(altura, largura, cor);
            ornamentais.put(key, result);
        } else {
            System.out.println("A arvore ja existe");
            result = ornamentais.get(key);
        }
        return result;
    }
}
