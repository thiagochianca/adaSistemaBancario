package br.gov.caixa;

import java.util.Scanner;

public class SequenciaFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe até qual numero deseja a sequencia de Fibonacci: ");
        int valor = sc.nextInt();

        System.out.println(geraSequenciaFibonacci(valor));

    }
    public static String geraSequenciaFibonacci(int numeroFinal) {
        Integer prox = 1;
        Integer ant= 0;
        Integer aux;
        String sequencia;
        sequencia = ant.toString();
        if(numeroFinal==1) {
            return "0, 1, 1";
        } else {
            for(int i = 1; i <= numeroFinal; i++) {
                aux = prox + ant;
                prox = ant;
                ant = aux;
                if (ant>numeroFinal)
                    break;
                sequencia += ", " + ant.toString();
        }

        }
        return sequencia;
    }

}
