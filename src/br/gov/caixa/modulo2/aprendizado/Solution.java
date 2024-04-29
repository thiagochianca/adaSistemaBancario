package br.gov.caixa.modulo2.aprendizado;

public class Solution {
    public static void main(String[] args) {
        Troca troca = new Troca("22", "05");
        troca.trocar();

        System.out.print(troca.getValor1());
        System.out.print("-");
        System.out.print(troca.getValor2());
    }
}
