package br.gov.caixa.projetoProfessor.model;

public class ContaPoupanca extends Conta {

    //apenas PF pode ter conta poupança
    public ContaPoupanca(ClientePF cliente) {
        super(cliente);
    }

}
