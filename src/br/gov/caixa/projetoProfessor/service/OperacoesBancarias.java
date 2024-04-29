package br.gov.caixa.projetoProfessor.service;

import br.gov.caixa.projetoProfessor.exceptions.ContaNaoEncontradaException;
import br.gov.caixa.projetoProfessor.model.Cliente;
import br.gov.caixa.projetoProfessor.model.Conta;
import br.gov.caixa.projetoProfessor.model.ContaInvestimento;
import br.gov.caixa.projetoProfessor.service.factory.OperacoesBancariasFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface OperacoesBancarias<T extends Cliente> extends
        Deposito<T>, Saldo<T>, Saque<T>, Transferencia<T>, Investimento<T> {

    default Conta getContaCliente(T cliente, Integer numeroConta) {
        for (Conta conta : cliente.getContas()) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException();
    }

    default Conta getContaInvestimentoCliente(T cliente) {
        for (Conta conta : cliente.getContas()) {
            if (conta instanceof ContaInvestimento) {
                return conta;
            }
        }
        return null;
    }

    @Override
    default BigDecimal consultarSaldo(T cliente, Integer numeroConta) {
        Conta conta = getContaCliente(cliente, numeroConta);
        return conta.getSaldo().setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    default void transferir(T cliente, Integer numeroContaOrigem, Conta destino, BigDecimal valor) {
        this.sacar(cliente, numeroContaOrigem, valor);
        OperacoesBancariasFactory.getInstance().get(destino.getCliente())
                .depositar(destino.getCliente(), destino.getNumero(), valor);
    }

    default void depositar(T cliente, Integer numeroConta, BigDecimal valor) {
        Conta conta = this.getContaCliente(cliente, numeroConta);
        conta.setSaldo(conta.getSaldo().add(valor));
    }

}
