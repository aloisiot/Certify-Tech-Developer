package NPrimeirosPrimos;

import java.util.Arrays;
import java.util.Scanner;

public class NPrimeirosPrimos {

    public static void main(String[] args) {
        System.out.println("Digite um numero N e veja os N primeiros numeros primos");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nPrimos = nPrimeirosPrimos(n);
        System.out.println(Arrays.toString(nPrimos));
    }


    static boolean divisivel (int dividendo, int divisor){
        if(dividendo % divisor == 0){
            return true;
        }
        else {
            return false;
        }
    }


    static boolean numeroPrimo (int number){
        if(number == 1){return false;}
        boolean resultado = false;
        for (int i = 2; i<number; i++){
            resultado = divisivel (number, i);
            if(resultado){
                return false;
            }
        }
        return true;
    }


    static int[] nPrimeirosPrimos (int n){
        int totalPrimos = 0;
        int[] primos=new int[n];
        for (int i =1; totalPrimos < n; i++){
            if(numeroPrimo(i)){
                primos[totalPrimos]=i;
                totalPrimos++;
            }
        }
        return primos;
    }

}