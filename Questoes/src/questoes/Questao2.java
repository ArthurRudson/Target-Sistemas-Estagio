package questoes;

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero = sc.nextInt();

        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

        sc.close();
    }
    
    public static boolean isFibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true; // 0 e 1 pertencem à sequência de Fibonacci
        }

        int a = 0;
        int b = 1;
        int fib = 0;

        // Calcula os números de Fibonacci até que o valor seja maior ou igual ao número informado
        while (fib < numero) {
            fib = a + b;
            a = b;
            b = fib;
        }

        // Verifica se o número calculado é igual ao número informado
        return fib == numero;
    }
}

