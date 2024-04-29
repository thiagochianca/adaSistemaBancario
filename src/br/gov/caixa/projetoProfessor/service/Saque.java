package br.gov.caixa.projetoProfessor.service;


import br.gov.caixa.projetoProfessor.exceptions.SaldoInsuficienteException;
import br.gov.caixa.projetoProfessor.model.Cliente;
import br.gov.caixa.projetoProfessor.model.Conta;

import java.math.BigDecimal;

public interface Saque<T extends Cliente> {

    void sacar(T cliente, Integer numeroConta, BigDecimal valor);

    default void verificarSaldo(Conta conta, BigDecimal valor) {
        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new SaldoInsuficienteException();
        }
    }

    default BigDecimal getTaxaSaque() {
        return BigDecimal.valueOf(1);
    }

}
