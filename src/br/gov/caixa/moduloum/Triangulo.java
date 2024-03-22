package br.gov.caixa.moduloum;

public class Triangulo {
    int[] input = {3, 3, 5};
    int maior = Math.max(Math.max(input[0], input[1]), input[2]);


    public static boolean eUmTriangulo(int[] input) {
        int maior = Math.max(Math.max(input[0], input[1]), input[2]);

        if ( input[0]==maior) {
            return (input[1] + input[2] > input[0]) ? true : false;
        } else if (input[1]==maior) {
            return (input[0] + input[2] > input[1]) ? true : false;
        } else {
            return (input[0] + input[1] > input[2]) ? true : false;
        }

        }
    }





