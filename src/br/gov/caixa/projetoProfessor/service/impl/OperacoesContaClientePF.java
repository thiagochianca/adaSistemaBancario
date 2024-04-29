package br.gov.caixa.projetoProfessor.service.impl;


import br.gov.caixa.projetoProfessor.model.ClientePF;
import br.gov.caixa.projetoProfessor.model.Conta;
import br.gov.caixa.projetoProfessor.model.ContaInvestimento;
import br.gov.caixa.projetoProfessor.service.OperacoesBancarias;

import java.math.BigDecimal;

public class OperacoesContaClientePF implements OperacoesBancarias<ClientePF> {

    private static final BigDecimal RENDIMENTO_INVESTIMENTO = BigDecimal.valueOf(1.01);

    @Override
    public void sacar(ClientePF cliente, Integer numeroConta, BigDecimal valor) {
        Conta conta = OperacoesBancarias.super.getContaCliente(cliente, numeroConta);
        OperacoesBancarias.super.verificarSaldo(conta, valor);
        conta.setSaldo(conta.getSaldo().subtract(valor));
    }

    @Override
    public void investir(ClientePF cliente, BigDecimal valor) {
        Conta conta = OperacoesBancarias.super.getContaInvestimentoCliente(cliente);
        if (conta == null) {
            conta = new ContaInvestimento(cliente);
            cliente.getContas().add(conta);
        }
        valor = valor.multiply(RENDIMENTO_INVESTIMENTO);
        conta.setSaldo(conta.getSaldo().add(valor));
    }

}
