package br.gov.caixa;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ProdutoComImposto {

    public static void main(String[] args) {
        double[] valorProdutoEstado = new double[2];

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor do produto: ");
        valorProdutoEstado[0] = sc.nextDouble();
        System.out.println("Informe o estado de destino: \n 1,0 - MG / 2,0 - SP / 3,0 - RJ");
        valorProdutoEstado[1] = sc.nextDouble();

        //System.out.println(valorProdutoEstado[0] + " - " + valorProdutoEstado[1]);

    double teste = valorProdutoFinal(valorProdutoEstado);

        System.out.println("Valor do produto final: " + teste);

    }

    public static double valorProdutoFinal(double[] valorProdutoEstado) {
        double valorFormatado;
        if (valorProdutoEstado[1] == 1.0) {
            valorFormatado = Math.round((valorProdutoEstado[0] + valorProdutoEstado[0] * 0.07)*10000);
            return valorFormatado/10000;
        } else if (valorProdutoEstado[1] == 2.0) {
            valorFormatado = Math.round((valorProdutoEstado[0] + valorProdutoEstado[0] * 0.12)*10000);
            return valorFormatado/10000;
        } else if (valorProdutoEstado[1] == 3.0) {
            valorFormatado = Math.round((valorProdutoEstado[0] + valorProdutoEstado[0] * 0.15)*10000);
            return valorFormatado/10000;
        } else
            return -1.0;
    }
}