package br.gov.caixa.modulo2.calculadora;


import java.util.Scanner;

public class EntradaDado {
    public static int[]  dados = new int[2];
    public static String operacaoDesejada;
    public static int[] solicitarDadosNumericos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o primeiro número inteiro: ");
        dados[0] = sc.nextInt();
        System.out.println("Informe o segundo número inteiro: ");
        dados[1] = sc.nextInt();
        return dados;
    }

    public static String solicitarOperacao() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a operação desejada ( + | - | * | / | ) : ");
        operacaoDesejada = sc.next();
        return operacaoDesejada;
    }
}
