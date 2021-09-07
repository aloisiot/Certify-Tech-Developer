package NPrimeirosPrimos;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class NPrimeirosPrimos {

    // MAIN.
    public static void main(String[] args) {
        System.out.println("\nDigite um numero N maior que 0 (zero) e veja os N primeiros números primos");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if( n > 0){
            int[] nPrimos = nPrimeirosPrimos(n);
            System.out.println(Arrays.toString(nPrimos));
        } else {
            System.out.println("Numero inválido");
        }
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
        for(int i = 2; i<number; i++){
            if(divisivel(number, i)){
                return false;
            }
        }
        return true;
    }

    // Recebe um numero N como parâmetro e retorna uma sequencia dos N primeiros números primos.
    @Contract(pure = true)
    static int @NotNull [] nPrimeirosPrimos (int n){
        int[] primos = new int[n];
        primos[0] = 2;
        int totalPrimos = 1;
        for (int i = 1; totalPrimos < n; i += 2){
            if(numeroPrimo(i)){
                primos[totalPrimos] = i;
                totalPrimos++;
            }
        }
        return primos;
    }

}