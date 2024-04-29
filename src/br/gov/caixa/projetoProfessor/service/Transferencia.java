package br.gov.caixa.projetoProfessor.service;

import br.gov.caixa.projetoProfessor.model.Cliente;
import br.gov.caixa.projetoProfessor.model.Conta;

import java.math.BigDecimal;

public interface Transferencia<T extends Cliente> {

    void transferir(T cliente, Integer numeroContaOrigem, Conta destino, BigDecimal valor);

}
