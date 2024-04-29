package br.gov.caixa.projetoSegundoModulo.factory;

import br.gov.caixa.projetoSegundoModulo.model.*;



public class FabricaDeContas {

    public static ContaCorrente criarContaCorrente(Cliente cliente) {
        ContaCorrente novaConta = new ContaCorrente(cliente);
        return novaConta;
    }

    public static ContaPoupanca criarContaPoupanca(ClientePF cliente) {
            ContaPoupanca novaConta = new ContaPoupanca(cliente);
            cliente.setContaPoupanca(novaConta);
            return novaConta;
    }

    public static ContaInvestimento criarContaInvestimento(Cliente cliente) {
        ContaInvestimento novaConta = new ContaInvestimento(cliente);
        cliente.setContaInvestimento(novaConta);
        return novaConta;
    }
}
