package br.gov.caixa.moduloum;

import java.util.Scanner;

public class PrimeiroCaractereUnico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("//PRIMEIRO CARATERE UNICO//");
        System.out.println("Informe a palavra que deseja verificar: ");
        String suaString = sc.next();



        System.out.println(primeiroCaractereUnico(suaString));


    }

    public static int primeiroCaractereUnico(String suaString) {
        char[] arrayDeChar = suaString.toCharArray();
        int cont = 0;
        if(arrayDeChar.length == 1) {
            return -1;
        }
        for (int i = 0; i < arrayDeChar.length; i++) {
            for (int j = 0; j < arrayDeChar.length; j++) {
                if (arrayDeChar[i] == arrayDeChar[j]) {
                    cont++;

                }
            }
            if (cont == 1) {
                return i;
            } else {
                cont = 0;
            }

        }
        return -1;
    }
}
