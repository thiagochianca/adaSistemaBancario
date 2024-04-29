package br.gov.caixa.modulo2.calculadora;

public class Conta {

    public static int resolveConta(int[] dados, String operacao) {
        int resultado = 0;
        switch (operacao) {
            case "+":
                resultado = somarDoisNumeros(dados);
                break;
            case "-":
                resultado = subtrairDoisNumeros(dados);
                break;
            case "*":
                resultado = multiplicarDoisNumeros(dados);
                break;
            case "/":
                if (dados[1] > dados[0]) {
                    System.out.println("Resultado: Denominador maior que numerador");
                    break;
                } else if (dados[1] == 0) {
                    System.out.println("Resultado: Não é possível dividir por zero");
                    break;
                } else {
                    resultado = dividirDoisNumeros(dados);
                    break;
                }

        }
        return resultado;
    }
    static int somarDoisNumeros(int[] dados) {
        return dados[0] + dados[1];
    }

    static int subtrairDoisNumeros(int[] dados) {
        return dados[0] - dados[1];
    }

    static int multiplicarDoisNumeros(int[] dados) {
        return dados[0] * dados[1];
    }

    static int dividirDoisNumeros(int[] dados) {
        return dados[0] / dados[1];
    }
}
