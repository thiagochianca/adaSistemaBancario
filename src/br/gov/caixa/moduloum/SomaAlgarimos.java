package br.gov.caixa.moduloum;

import java.util.Scanner;

public class SomaAlgarimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("//SOMA DE ALGARISMOS//");
        System.out.println("Informe o numero: ");
        int algarismo = sc.nextInt();

        System.out.println(somaAlgarismos(algarismo));

    }


    public static int somaAlgarismos(int algarismo) {
        if(algarismo<0) {
            return -1;
        }
        String numeroEscrito = Integer.toString(algarismo);
        int quantidadeCaracteres = numeroEscrito.length();
        int soma=0;
        for(int i = 0; i < quantidadeCaracteres ; i++){
            char valor = Integer.toString(algarismo).charAt(i);
            int auxiliar = Integer.parseInt(String.valueOf(valor));
            soma += auxiliar;
        }
        return soma;
    }
}
