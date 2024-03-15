package br.gov.caixa;

public class Desafio {
    public static void main(String[] args) {

        String [] entrada = {"true", "Imprimindo soma inteiros... ", "10", "15",
                "sim", "Não imprimindo... ", "7.3", "7.1",
                "true", "Imprimindo soma inteiros... ", "7.3", "7.1"};

        executaDesafio(entrada);

    }

    static void executaDesafio(String... entrada) {
        for(int i=0;i<=entrada.length-1;i += 4) {
            try {
                boolean imprimi = Boolean.valueOf(entrada[i]);

                if (imprimi) {
                    String mensagem = entrada[i+1];
                    int numero1 = Integer.parseInt(entrada[i+2]);
                    int numero2 = Integer.parseInt(entrada[i+3]);
                    System.out.print("~ "+mensagem);
                    System.out.println(numero1+numero2);
                } else {
                    System.out.print("~ Soma ignorada: não imprimir\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("~ Erro ao converter para inteiro:\n"+e.getMessage());
            }
        }
    }
}
