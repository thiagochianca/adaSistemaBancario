package br.gov.caixa.modulo1;

import java.util.Scanner;

public class MinhaAplicacao {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o primeiro número inteiro: ");
        int valor1 = sc.nextInt();
        System.out.println("Informe o segundo número inteiro: ");
        int valor2 = sc.nextInt();
        System.out.println("Informe a operação desejada ( + | - | * | / | ) : ");
        String operacaoDesejada = sc.next();

        switch (operacaoDesejada) {
            case "+":
                System.out.println("Resultado da operação: " + somarDoisNumeros(valor1, valor2));
                break;
            case "-":
                System.out.println("Resultado da operação: " + subtrairDoisNumeros(valor1, valor2));
                break;
            case "*":
                System.out.println("Resultado da operação: " + multiplicarDoisNumeros(valor1, valor2));
                break;
            case "/":
                if (valor2 > valor1) {
                    System.out.println("Resultado: Denominador maior que numerador");
                    break;
                } else if (valor2 == 0) {
                    System.out.println("Resultado: Não é possível dividir por zero");
                    break;
                } else {
                    System.out.println("Resultado da operação: " + dividirDoisNumeros(valor1, valor2));
                    break;
                }

        }
    }

    static int somarDoisNumeros(int valor1, int valor2) {
        return valor1 + valor2;
    }

    static int subtrairDoisNumeros(int valor1, int valor2) {
        return valor1 - valor2;
    }

    static int multiplicarDoisNumeros(int valor1, int valor2) {
        return valor1 * valor2;
    }

    static int dividirDoisNumeros(int valor1, int valor2) {
        return valor1 / valor2;
    }
}
