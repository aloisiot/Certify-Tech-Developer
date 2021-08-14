package NPrimeirosPrimos;

import java.util.Arrays;
import java.util.Scanner;

public class NPrimeirosPrimos {

    // Método principal.
    public static void main(String[] args) {
        System.out.println("Digite um numero N e veja os N primeiros numeros primos");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nPrimos = nPrimeirosPrimos(n);
        System.out.println(Arrays.toString(nPrimos));
    }

    // Avalia se o resto de uma operação de divisão é zero.
    static boolean divisivel (int dividendo, int divisor){
        if(dividendo % divisor == 0){
            return true;
        }
        else {
            return false;
        }
    }

    // Avalia se um número é primo ou não.
    static boolean numeroPrimo (int number){
        if(number == 1 || number == 0){return false;}
        for (int i = 2; i<number; i++){
            if(divisivel(number, i)){
                return false;
            }
        }
        return true;
    }

    // Recebe um numero N como parâmetro e retorna uma sequencia dos N primeiros números primos.
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