package br.gov.caixa;

import java.util.Scanner;

public class Soletracao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("//SOLETRAÇÃO//");
        System.out.println("Informe a palavra que deseja soletrar: ");
        String suaString = sc.next();
        soletrandoStr(suaString);

    }

    public static String[] soletrandoStr(String suaString) {

        char[] arrayDeChar = suaString.toCharArray();
        String [] stringSoletrada = new String[arrayDeChar.length];
        for (int i = 0; i < arrayDeChar.length; i++) {
            stringSoletrada[i] = String.valueOf(arrayDeChar[i]);
        }

        return stringSoletrada;
    }


}
