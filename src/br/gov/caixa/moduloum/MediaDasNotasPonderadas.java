package br.gov.caixa.moduloum;

public class MediaDasNotasPonderadas {

    public static void main(String[] args) {
        double [] notas = {5.0, 4.3, 8.0, 7.0};
        System.out.println(mediaAproveitamento(notas));

    }

    public static String mediaAproveitamento (double[] notas) {
        double nota1 = notas[0];
        double nota2 = notas[1];
        double nota3 = notas[2];
        double exercicio = notas[3];
        double mediaAproveitamento = (nota1+(nota2*2)+(nota3*3)+exercicio)/7;
        if(mediaAproveitamento>=9) {
            return "A";
        } else if (mediaAproveitamento>=7.5) {
            return "B";
        } else if (mediaAproveitamento>=6) {
            return "C";
        } else {
            return "D";
        }


    }
}
