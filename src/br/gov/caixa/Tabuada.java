package br.gov.caixa;

public class Tabuada {

    public static void main(String[] args) {
        double i = 10 * Math.random();
        for (int j = 0; j <= 10; j++) {
            System.out.printf("%d * %d = %d \n", (int) i, j, ((int) i) * j);
        }

    }
}
