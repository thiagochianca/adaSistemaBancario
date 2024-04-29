package br.gov.caixa.projetoSegundoModulo.operation;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.model.Historico;

import java.math.BigDecimal;

public interface Operacao {
    public abstract void executar(Conta conta, BigDecimal valor);
    public abstract Historico gerarHistorico(Conta conta, BigDecimal valor);
}
