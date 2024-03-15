package br.gov.caixa;

public class ValoresDecimaisRepetidos {

    public static void main(String[] args) {
        double[] valores = {2.5, 3.2, 4.5, 5, 6};

        if (elementosRepetidos(valores))
            System.out.println(1);
        else
            System.out.println(0);

    }

    public static boolean elementosRepetidos(double[] valores) {
        int cont = 0;
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (valores[i] == valores[j]) {
                    cont++;
                }
            }
            if (cont >= 2) {
                return true;
            }
            cont = 0;
        }
        return false;
    }
}
