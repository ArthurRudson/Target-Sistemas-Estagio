package questoes;

import java.util.Scanner;

public class Questao5 {
     public static void main(String[] args) {
        // Captura de entrada pelo usuário
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a string que deseja inverter: ");
        String input = sc.nextLine();
        sc.close();

        // Inicializa uma variável para armazenar a string invertida
        String invertedString = "";

        // Inverte a string caractere por caractere
        for (int i = input.length() - 1; i >= 0; i--) {
            invertedString += input.charAt(i);
        }

        // Exibe o resultado
        System.out.println("String invertida: " + invertedString);
    }
}
