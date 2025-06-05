package calculadora.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalculadoraPosOrdem {
    public double calcularExpressao(String expressao) throws Exception {
        Queue<String> fila = new LinkedList<>();
        Stack<Double> pilha = new Stack<>();

        for (String token : expressao.trim().split("\s+")) {
            fila.add(token);
        }

        while (!fila.isEmpty()) {
            String token = fila.poll();

            if (isOperador(token)) {
                if (pilha.size() < 2)
                    throw new Exception("Expressão inválida: operandos insuficientes.");

                double b = pilha.pop();
                double a = pilha.pop();
                pilha.push(executarOperacao(token, a, b));
            } else {
                try {
                    pilha.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new Exception("Token inválido: " + token);
                }
            }
        }

        if (pilha.size() != 1)
            throw new Exception("Expressão inválida: operandos excedentes.");

        return pilha.pop();
    }

    private boolean isOperador(String s) {
        return s.matches("[+\-*/%]");
    }

    private double executarOperacao(String op, double a, double b) throws Exception {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new Exception("Divisão por zero.");
                return a / b;
            case "%":
                if (b == 0) throw new Exception("Módulo por zero.");
                return a % b;
            default:
                throw new Exception("Operador inválido: " + op);
        }
    }
}