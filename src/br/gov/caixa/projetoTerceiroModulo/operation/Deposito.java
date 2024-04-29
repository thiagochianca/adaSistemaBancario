package br.gov.caixa.projetoTerceiroModulo.operation;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;

import java.math.BigDecimal;

public class Deposito implements Operacao {

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        conta.setSaldo(conta.consultarSaldo().add(valor));
    }

}
