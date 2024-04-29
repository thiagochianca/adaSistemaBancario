package br.gov.caixa.modulo2.ExercicioSeis;

import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Saldo saldo1 = new Saldo();
        Saldo saldo2 = new Saldo();

        saldo1.setValor(90.0);
        saldo2.setValor(100.0);


        ContaDevedora c1 = new ContaDevedora();
        ContaDevedora c2 = new ContaDevedora();

        c1.setSaldo(saldo1);
        c2.setSaldo(saldo2);

    }

}

class Saldo {
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

class ContaDevedora {
    private Saldo saldo;

    public Saldo getSaldo() {
        return saldo;
    }
    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

}

class ContaDevedoraComparator implements Comparator<ContaDevedora> {


    @Override
    public int compare(ContaDevedora c1, ContaDevedora c2) {
        return c1.getSaldo().getValor().compareTo(c2.getSaldo().getValor());
    }

}

