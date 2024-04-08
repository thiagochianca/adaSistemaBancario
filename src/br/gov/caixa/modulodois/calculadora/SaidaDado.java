package br.gov.caixa.modulodois.calculadora;

public class SaidaDado {

    public static void escreveSaida(int [] dados, String operacao, int resultado) {
        System.out.println();
        System.out.println(":::RESULTADO:::");
        System.out.println("[ "+ dados[0] +" ]  " + operacao + "  [ "+ dados[1] +" ]  =  " + resultado);
    }
}
