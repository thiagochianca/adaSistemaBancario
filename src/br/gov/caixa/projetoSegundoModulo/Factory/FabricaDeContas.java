package br.gov.caixa.projetoSegundoModulo.Factory;

import br.gov.caixa.projetoSegundoModulo.Model.*;

import java.util.Date;

public class FabricaDeContas {

    public static ContaCorrente criarContaCorrente(Cliente cliente) {
        ContaCorrente novaConta = new ContaCorrente(Conta.getProximoIdConta(),0,new Date(),Status.ATIVADO,cliente);
        return novaConta;
    }

    public static ContaPoupanca criarContaPoupanca(Cliente cliente) {
        if(cliente.getClassificacao() == Classificacao.PF) {
            ContaPoupanca novaConta = new ContaPoupanca(Conta.getProximoIdConta(),0,new Date(),Status.ATIVADO,cliente);
            cliente.setContaPoupanca(novaConta);
            return novaConta;
        }
        return null;
    }

    public static ContaInvestimento criarContaInvestimento(Cliente cliente) {
        ContaInvestimento novaConta = new ContaInvestimento(Conta.getProximoIdConta(),0,new Date(),Status.ATIVADO,cliente);
        cliente.setContaInvestimento(novaConta);
        return novaConta;
    }
}
