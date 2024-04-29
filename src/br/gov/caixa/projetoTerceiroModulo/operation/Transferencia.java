package br.gov.caixa.projetoTerceiroModulo.operation;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;

import java.math.BigDecimal;

public class Transferencia implements Operacao {
    private Conta contaDestino;

    public Transferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        Saque saque = new Saque();
        Deposito deposito = new Deposito();
        saque.executar(conta,valor);
        deposito.executar(contaDestino,valor);
    }

}
