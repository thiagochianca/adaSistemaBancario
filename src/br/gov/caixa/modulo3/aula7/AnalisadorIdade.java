package br.gov.caixa.modulo3.aula7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
class AnalisadorIdade {

    public static Predicate<Integer> criarVerificador() {
        return (numero) -> numero < 18;
    }

    public static List<Integer> remover(List<Integer> colecao, Predicate<Integer> verificador) {
//        colecao.removeIf(verificador);
//        return colecao;
        return colecao.stream().filter(verificador.negate()).toList();
    }

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>(List.of(1,2,3,25,29));
        Predicate<Integer> verificador = criarVerificador();
        List<Integer> listaNova = remover(numeros, verificador);
        System.out.println(listaNova);

    }
}