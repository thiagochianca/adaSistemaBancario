package br.gov.caixa.projetoProfessor.service;

import br.gov.caixa.projetoProfessor.model.Cliente;

import java.math.BigDecimal;

public interface Saldo<T extends Cliente> {

    BigDecimal consultarSaldo(T cliente, Integer numeroConta);

}
