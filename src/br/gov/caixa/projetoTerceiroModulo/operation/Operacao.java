package br.gov.caixa.projetoTerceiroModulo.operation;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;

import java.math.BigDecimal;

public interface Operacao {
    public abstract void executar(Conta conta, BigDecimal valor);
}
