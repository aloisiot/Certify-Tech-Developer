package Flyweight;

import models.Computador;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {
    private static Map<String, Computador> macFyweight = new HashMap<>();

    public Computador getComputador(int ram, int hd){
        String key = String.format("%d : %d", ram, hd);

        if(!macFyweight.containsKey(key)){
            Computador computador = new Computador(ram, hd);
            macFyweight.put(key, computador);
            System.out.printf("%nComputador criado:%nram: %s%nHd: %s%n", ram, hd);
            return computador;
        }

        System.out.printf("%nComputador ja existente:%nram: %s%nHd: %s%n", ram, hd);
        return (Computador) macFyweight.get(key);
    }
}
