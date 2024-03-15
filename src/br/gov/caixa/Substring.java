package br.gov.caixa;

public class Substring {
    public static void main(String[] args) {
        String[] lista = {"lovour",
                "ovo",
                "lov",
                "paixão",
                "caixão",
                "xão"};
        String[] substringsLista = substringStr(lista);
    }

    public static String[] substringStr(String[] lista) {
        String [] substrings = new String[lista.length];
        int aux = 0;
        for (int i = 0; i < lista.length; i++) {
            String alvo = lista[i];
            for (int j = 0; j < lista.length; j++) {
                if (lista[j].equals(alvo)) {
                    continue;
                } else if (lista[j].contains(alvo)) {
                    substrings[aux] = alvo;
                    aux++;
                    break;

                }
            }

        }
    String [] novoArray = new String[aux];
        for (int i = 0; i < novoArray.length; i++) {
            novoArray[i]=substrings[i];

        }
     return novoArray;
    }


}

