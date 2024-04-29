package br.gov.caixa.projetoProfessor.service;

import br.gov.caixa.projetoProfessor.model.Cliente;

import java.math.BigDecimal;

public interface Investimento<T extends Cliente> {

    void investir(T cliente, BigDecimal valor);

}
