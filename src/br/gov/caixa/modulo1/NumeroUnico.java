package br.gov.caixa.modulo1;

public class NumeroUnico {
    public static void main(String[] args) {
        int[] valores = {1,1,2,2,5,5,5,4,4,10,10,20};
        System.out.println(verificaNumeroUnico(valores));
    }
    public static int verificaNumeroUnico(int [] valores) {
        int cont = 0;
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (valores[i] == valores[j]) {
                    cont++;
                }
            }
            if (cont == 1) {
                return valores[i];
            }
            cont = 0;
        }
        return -1;
    }
}
