package calculadora;

import calculadora.controller.CalculadoraPosOrdem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraPosOrdem calculadora = new CalculadoraPosOrdem();

        System.out.println("Digite a expressão em notação pós-fixada (ex: 5 1 2 + 4 * + 3 -):");
        String input = scanner.nextLine();

        try {
            double resultado = calculadora.calcularExpressao(input);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}