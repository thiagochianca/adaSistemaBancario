package br.gov.caixa.projetoProfessor.service;

import br.gov.caixa.projetoProfessor.model.Cliente;

import java.math.BigDecimal;

public interface Deposito<T extends Cliente> {

    void depositar(T cliente, Integer numeroConta, BigDecimal valor);

}
