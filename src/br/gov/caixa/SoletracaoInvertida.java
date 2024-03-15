package br.gov.caixa;

import java.util.Scanner;

public class SoletracaoInvertida {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("//SOLETRAÇÃO//");
        System.out.println("Informe a palavra que deseja soletrar invertido: ");
        String suaString = sc.next();
        soletrandoInvertidoStr(suaString);

    }


    public static String[] soletrandoInvertidoStr(String suaString) {

        char[] arrayDeChar = suaString.toCharArray();
        String[] stringSoletrada = new String[arrayDeChar.length];
        int j = arrayDeChar.length - 1;
        for (int i = 0; i < stringSoletrada.length; i++) {
            stringSoletrada[i] = String.valueOf(arrayDeChar[j]);
            j--;
        }
        return stringSoletrada;

    }
}